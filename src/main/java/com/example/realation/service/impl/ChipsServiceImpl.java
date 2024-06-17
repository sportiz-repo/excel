package com.example.realation.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.realation.modal.Chips;
import com.example.realation.modal.ExcelDataMistakes;
import com.example.realation.repo.ChipsRepo;
import com.example.realation.service.ChipsService;
import com.example.realation.service.ExcelDataMistakeService;
import com.example.realation.util.ExcelUtil;

@Service

public class ChipsServiceImpl implements ChipsService {
	private final ChipsRepo chipsRepo;
	private final ExcelUtil excelUtil;
	private final ExcelDataMistakeService excelDataMistakeService;

	@Autowired
	public ChipsServiceImpl(ChipsRepo chipsRepo, ExcelUtil excelUtil, ExcelDataMistakeService excelDataMistakeService) {
		super();
		this.chipsRepo = chipsRepo;
		this.excelUtil = excelUtil;
		this.excelDataMistakeService = excelDataMistakeService;
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
	public Chips getChipByPid(String pid) {
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
	public List<Chips> saveAllFromExcel(MultipartFile file) {
		List<Chips> chips = null;
		List<ExcelDataMistakes> excelDataMistakesList = null;
		try {
			excelUtil.convertExcelToListOfProduct(file.getInputStream());
			chips = this.excelUtil.getChipsList();
			excelDataMistakesList = this.excelUtil.getExcelDataMistakesList();
			System.out.println(excelDataMistakesList);
			chips = this.chipsRepo.saveAll(chips);
			excelDataMistakesList = this.excelDataMistakeService.saveAllExcelDataMistakes(excelDataMistakesList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return chips;
	}

}
