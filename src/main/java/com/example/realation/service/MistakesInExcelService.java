package com.example.realation.service;

import java.util.List;

import com.example.realation.modal.MistakesInExcel;

public interface MistakesInExcelService {
	public List<MistakesInExcel> getAllMistake();

	public MistakesInExcel saveExcelDataMistake(MistakesInExcel mistakesInExcel);

	public List<MistakesInExcel> saveAllExcelDataMistakes(List<MistakesInExcel> mistakesInExcelsList);

	public void deleteAll();
}
