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

import com.example.realation.modal.Participant;
import com.example.realation.service.ParticipantService;
import com.example.realation.util.ExcelUtil;

@RestController
@RequestMapping("/participant")
public class ParticipantController {
	private final ParticipantService participantService;
	private final ExcelUtil excelUtil;

	@Autowired
	public ParticipantController(ParticipantService participantService, ExcelUtil excelUtil) {
		super();
		this.participantService = participantService;
		this.excelUtil = excelUtil;
	}

	@PostMapping("/create")
	public Participant createChips(@RequestBody Participant participant) {
		return this.participantService.createParticipant(participant);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Participant>> getAllParticipants() {
		List<Participant> participants = this.participantService.getAllParticipant();
		return ResponseEntity.status(HttpStatus.OK).body(participants);
	}

	@GetMapping("/bypage")
	public Page<Participant> getParticipantsByPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
		return this.participantService.getParticipantByPagination(pageNo, pageSize);
	}

	@GetMapping("/byname")
	public List<Participant> getParticipantByName(@RequestParam String name) {
		return this.participantService.getParticipantByName(name);
	}

	@GetMapping("/bygender")
	public List<Participant> getParticipantsByGender(@RequestParam String gender) {
		return this.participantService.getParticipantByGender(gender);
	}

	@GetMapping("/totalparticipantcount")
	public long totalParticipant() {
		return this.participantService.totalParticipantsCount();
	}

	@GetMapping("/countbygender")
	public long getCountByGender(@RequestParam String gender) {
		return this.participantService.getCountByGender(gender);
	}

	@PostMapping("/upload")
	public ResponseEntity<List<Participant>> upload(@RequestParam("file") MultipartFile file) {
		if (excelUtil.isExcelFormat(file)) {
			List<Participant> participants = this.participantService.saveAllFromExcel(file);
			return ResponseEntity.status(HttpStatus.OK).body(participants);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}

}
