package com.example.realation.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.realation.modal.Results;
import com.example.realation.repo.ResultsRepo;
import com.example.realation.service.ChipsService;
import com.example.realation.service.ResultsService;

@Service
public class ResultsServiceImpl implements ResultsService {
	private final ResultsRepo resultsRepo;
	private final ChipsService chipsService;

	@Autowired
	public ResultsServiceImpl(ResultsRepo resultsRepo, ChipsService chipsService) {
		super();
		this.resultsRepo = resultsRepo;
		this.chipsService = chipsService;
	}

	@Override
	public Results getResultByPid(int pid) {
		Optional<Results> optionalResults = resultsRepo.findById(pid);
		if (optionalResults.isPresent())
			return optionalResults.get();
		else
			throw new RuntimeException();
	}

	@Override
	public List<Results> getAllResult() {
		List<Results> results = resultsRepo.findAll();

		return results;
	}

}
