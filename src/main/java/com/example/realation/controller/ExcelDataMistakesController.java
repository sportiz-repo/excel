package com.example.realation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.realation.modal.MistakesInExcel;
import com.example.realation.service.MistakesInExcelService;

@RestController
@RequestMapping("/mistake")
public class ExcelDataMistakesController {
	private final MistakesInExcelService excelDataMistakeService;

	@Autowired
	public ExcelDataMistakesController(MistakesInExcelService excelDataMistakeService) {
		super();
		this.excelDataMistakeService = excelDataMistakeService;
	}

	@GetMapping("/all")
	public List<MistakesInExcel> getAllExcelDataMistakes() {
		return excelDataMistakeService.getAllMistake();
	}
}
