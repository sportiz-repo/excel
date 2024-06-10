package com.example.realation.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.realation.modal.Chips;
import com.example.realation.repo.ChipsRepo;
import com.example.realation.service.ChipsService;
import com.example.realation.util.ExcelUtil;

@Service

public class ChipsServiceImpl implements ChipsService {
	private final ChipsRepo chipsRepo;

	@Autowired
	public ChipsServiceImpl(ChipsRepo chipsRepo) {
		super();
		this.chipsRepo = chipsRepo;
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
	public List<Chips> saveAllFromExcel(MultipartFile file) {
		List<Chips> chips = null;
		try {
			chips = ExcelUtil.convertExcelToListOfProduct(file.getInputStream());
			chips = this.chipsRepo.saveAll(chips);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return chips;
	}

}
