package com.example.realation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.realation.modal.ExcelDataMistakes;
import com.example.realation.service.ExcelDataMistakeService;

@RestController
@RequestMapping("/mistake")
public class ExcelDataMistakesController {
	private final ExcelDataMistakeService excelDataMistakeService;

	@Autowired
	public ExcelDataMistakesController(ExcelDataMistakeService excelDataMistakeService) {
		super();
		this.excelDataMistakeService = excelDataMistakeService;
	}

	@GetMapping("all")
	public List<ExcelDataMistakes> getAllExcelDataMistakes() {
		return excelDataMistakeService.getAllMistake();
	}
}
