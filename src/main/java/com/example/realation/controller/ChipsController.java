package com.example.realation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.realation.modal.Chips;
import com.example.realation.service.ChipsService;
import com.example.realation.util.ExcelUtil;

@RestController
@RequestMapping("/chips")
public class ChipsController {
	private final ChipsService chipsService;
	private final ExcelUtil excelUtil;

	@Autowired
	public ChipsController(ChipsService chipsService, ExcelUtil excelUtil) {
		this.chipsService = chipsService;
		this.excelUtil = excelUtil;
	}

	@PostMapping("/create")
	public Chips createChips(@RequestBody Chips chips) {
		return this.chipsService.createChips(chips);
	}

	@GetMapping("/")
	public ResponseEntity<List<Chips>> getAll() {
		List<Chips> chips = this.chipsService.getAllChips();
		chips.forEach(e -> System.out.println(e));
		return ResponseEntity.status(HttpStatus.OK).body(chips);
	}

	@GetMapping("/page")
	public Page<Chips> getChipsByPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
		return this.chipsService.getChipsByPagination(pageNo, pageSize);
	}

	@GetMapping("/totalchips")
	public long totalChips() {
		return this.chipsService.totalChips();
	}

	@GetMapping("/bygender")
	public List<Chips> getChipsByGender(@RequestParam String gender) {
		return this.chipsService.getChipsByGender(gender);
	}
	@GetMapping("/byname")
	public List<Chips> getChipsByName(@RequestParam String name) {
		return this.chipsService.getChipsByName(name);
	}

	@PostMapping("/upload")
	public ResponseEntity<List<Chips>> upload(@RequestParam("file") MultipartFile file) {
		if (excelUtil.isExcelFormat(file)) {
			List<Chips> chips = this.chipsService.saveAllFromExcel(file);
			return ResponseEntity.status(HttpStatus.OK).body(chips);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}

}
