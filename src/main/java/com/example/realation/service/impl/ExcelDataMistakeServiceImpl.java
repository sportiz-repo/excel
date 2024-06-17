package com.example.realation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.realation.modal.ExcelDataMistakes;
import com.example.realation.repo.ExcelDataMistakeRepo;
import com.example.realation.service.ExcelDataMistakeService;

@Service
public class ExcelDataMistakeServiceImpl implements ExcelDataMistakeService {
	private final ExcelDataMistakeRepo excelDataMistakeRepo;

	@Autowired
	public ExcelDataMistakeServiceImpl(ExcelDataMistakeRepo excelDataMistakeRepo) {
		super();
		this.excelDataMistakeRepo = excelDataMistakeRepo;
	}

	@Override
	public List<ExcelDataMistakes> getAllMistake() {
		return excelDataMistakeRepo.findAll();
	}

	@Override
	public ExcelDataMistakes saveExcelDataMistake(ExcelDataMistakes excelDataMistake) {
		return excelDataMistakeRepo.save(excelDataMistake);
	}

	@Override
	public List<ExcelDataMistakes> saveAllExcelDataMistakes(List<ExcelDataMistakes> excelDataMistakesList) {
		return excelDataMistakeRepo.saveAll(excelDataMistakesList);
	}

}
