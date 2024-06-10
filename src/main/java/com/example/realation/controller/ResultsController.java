package com.example.realation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.realation.modal.Results;
import com.example.realation.service.ResultsService;

@RestController
@RequestMapping("/results")
public class ResultsController {
	private final ResultsService resultsService;

	@Autowired
	public ResultsController(ResultsService resultsService) {
		super();
		this.resultsService = resultsService;
	}

	@GetMapping("/")
	public List<Results> sendResult() {
		return resultsService.getAllResult();
	}
}
