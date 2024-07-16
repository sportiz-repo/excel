package com.example.realation.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.realation.modal.Chips;
import com.example.realation.modal.MistakesInExcel;
import com.example.realation.repo.ChipsRepo;
import com.example.realation.service.ChipsService;
import com.example.realation.service.MistakesInExcelService;
import com.example.realation.util.ExcelUtil;

import jakarta.transaction.Transactional;

@Service

public class ChipsServiceImpl implements ChipsService {
	private final ChipsRepo chipsRepo;
	private final ExcelUtil excelUtil;
	private final MistakesInExcelService mistakesInExcelService;

	@Autowired
	public ChipsServiceImpl(ChipsRepo chipsRepo, ExcelUtil excelUtil, MistakesInExcelService mistakesInExcelService) {
		super();
		this.chipsRepo = chipsRepo;
		this.excelUtil = excelUtil;
		this.mistakesInExcelService = mistakesInExcelService;
	}

	@Override
	public Chips getChipById(String chip) {
		Optional<Chips> optionChips = chipsRepo.findById(chip);
		if (optionChips.isPresent())
			return optionChips.get();
		else
			throw new RuntimeException();
	}

	@Override
	public Chips getChipByPid(int pid) {
		Optional<Chips> optionChips = chipsRepo.findByPid(pid);
		if (optionChips.isPresent())
			return optionChips.get();
		else
			throw new RuntimeException();
	}

	@Override
	public List<Chips> getAllChips() {
		List<Chips> chips = chipsRepo.findAll();
		return chips;
	}

	@Override
	public Chips createChips(Chips chips) {
		return this.chipsRepo.save(chips);
	}

	@Override
	@Transactional
	public List<Chips> saveAllFromExcel(MultipartFile file) {
		List<Chips> chips = null;
		List<MistakesInExcel> excelDataMistakesList = null;
		try {
			excelUtil.convertExcelToListOfProduct(file.getInputStream());
			chips = this.excelUtil.getChipsList();
			excelDataMistakesList = this.excelUtil.getExcelDataMistakesList();
			this.mistakesInExcelService.deleteAll();
			excelDataMistakesList = this.mistakesInExcelService.saveAllExcelDataMistakes(excelDataMistakesList);
			try {
				chips = this.chipsRepo.saveAll(chips);
			} catch (Exception de) {
				chips.forEach(chip -> {
					try {
						this.chipsRepo.save(chip);
					} catch (Exception dex) {
						dex.getMessage();
					}
				});
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return chips;
	}

	@Override
	public Page<Chips> getChipsByPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return this.chipsRepo.findAll(pageable);
	}

	@Override
	public long totalChips() {
		return this.chipsRepo.count();
	}

	@Override
	public List<Chips> getChipsByGender(String gender) {
		return this.chipsRepo.getByGender(gender);
	}

	@Override
	public List<Chips> getChipsByName(String name) {
		return this.chipsRepo.getByName(name);
	}

}
