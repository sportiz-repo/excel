package com.example.realation.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.realation.modal.Chips;

public interface ChipsService {
	public Chips createChips(Chips chips);

	public Chips getChipById(String chip);

	public Chips getChipByPid(int pid);

	public List<Chips> getAllChips();

	public List<Chips> saveAllFromExcel(MultipartFile file);
}
