package com.example.realation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.realation.modal.MistakesInExcel;
import com.example.realation.repo.MistakesInExcelRepo;
import com.example.realation.service.MistakesInExcelService;

@Service
public class MistakesInExcelImpl implements MistakesInExcelService {
	private final MistakesInExcelRepo mistakesInExcelRepo;

	@Autowired
	public MistakesInExcelImpl(MistakesInExcelRepo mistakesInExcelRepo) {
		super();
		this.mistakesInExcelRepo = mistakesInExcelRepo;
	}

	@Override
	public List<MistakesInExcel> getAllMistake() {
		return mistakesInExcelRepo.findAll();
	}

	@Override
	public MistakesInExcel saveExcelDataMistake(MistakesInExcel mistakesInExcel) {
		return mistakesInExcelRepo.save(mistakesInExcel);
	}

	@Override
	public List<MistakesInExcel> saveAllExcelDataMistakes(List<MistakesInExcel> mistakesInExcelsList) {
		return mistakesInExcelRepo.saveAll(mistakesInExcelsList);
	}

	@Override
	public void deleteAll() {
		mistakesInExcelRepo.deleteAll();
	}

}
