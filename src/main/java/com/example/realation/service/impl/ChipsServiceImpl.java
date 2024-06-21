package com.example.realation.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.realation.modal.Chips;
import com.example.realation.repo.ChipsRepo;
import com.example.realation.service.ChipsService;

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
	public Chips getChipByPid(String pid) {
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
	public Page<Chips> getChipsByPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return this.chipsRepo.findAll(pageable);
	}

	@Override
	public long totalChips() {
		return this.chipsRepo.count();
	}

	@Override
	public List<Chips> getChipsByGender(String gender) {
		return this.chipsRepo.getByGender(gender);
	}

	@Override
	public List<Chips> getChipsByName(String name) {
		return this.chipsRepo.getByName(name);
	}

}
