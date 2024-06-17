package com.example.realation.service;

import java.util.List;

import com.example.realation.modal.ExcelDataMistakes;

public interface ExcelDataMistakeService {
	public List<ExcelDataMistakes> getAllMistake();

	public ExcelDataMistakes saveExcelDataMistake(ExcelDataMistakes excelDataMistake);

	public List<ExcelDataMistakes> saveAllExcelDataMistakes(List<ExcelDataMistakes> excelDataMistakesList);
}
