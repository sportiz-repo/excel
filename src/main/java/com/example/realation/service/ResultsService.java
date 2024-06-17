package com.example.realation.service;

import java.util.List;

import com.example.realation.modal.Results;

public interface ResultsService {
	public Results getResultByPid(int pid);

	public List<Results> getAllResult();
}
