package com.example.realation.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.realation.modal.Chips;

public interface ChipsService {
	public Chips createChips(Chips chips);

	public Chips getChipById(String chip);

	public Chips getChipByPid(String pid);

	public List<Chips> getAllChips();

	public Page<Chips> getChipsByPagination(int pageNo, int pageSize);

	public long totalChips();

	public List<Chips> getChipsByGender(String gender);

	public List<Chips> getChipsByName(String name);
}
