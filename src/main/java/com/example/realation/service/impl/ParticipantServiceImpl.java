package com.example.realation.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.realation.modal.MistakesInExcel;
import com.example.realation.modal.Participant;
import com.example.realation.repo.MistakesInExcelRepo;
import com.example.realation.repo.ParticipantRepo;
import com.example.realation.service.MistakesInExcelService;
import com.example.realation.service.ParticipantService;
import com.example.realation.util.ExcelUtil;

@Service
public class ParticipantServiceImpl implements ParticipantService {
	private final ParticipantRepo participantRepo;
	private final ExcelUtil excelUtil;
	private final MistakesInExcelService mistakesInExcelService;
	private final MistakesInExcelRepo mistakesInExcelRepo;

	@Autowired
	public ParticipantServiceImpl(ParticipantRepo participantRepo, ExcelUtil excelUtil,
			MistakesInExcelService mistakesInExcelService, MistakesInExcelRepo mistakesInExcelRepo) {
		super();
		this.participantRepo = participantRepo;
		this.excelUtil = excelUtil;
		this.mistakesInExcelService = mistakesInExcelService;
		this.mistakesInExcelRepo = mistakesInExcelRepo;
	}

	@Override
	public Participant getParticipantByChip(String chip) {
		Optional<Participant> optionChips = participantRepo.findByChip(chip);
		if (optionChips.isPresent())
			return optionChips.get();
		else
			throw new RuntimeException();
	}

	@Override
	public Participant getParticipantByPid(String pid) {
		Optional<Participant> optionChips = participantRepo.findByPid(pid);
		if (optionChips.isPresent())
			return optionChips.get();
		else
			throw new RuntimeException();
	}

	@Override
	public List<Participant> getAllParticipant() {
		List<Participant> chips = participantRepo.findAll();
		return chips;
	}

	@Override
	public Participant createParticipant(Participant participant) {
		return this.participantRepo.save(participant);
	}

	@Override
//	@Transactional
	public String saveAllFromExcel(MultipartFile file) {
		List<Participant> participant = null;
		List<MistakesInExcel> excelDataMistakesList = null;
		try {
			excelUtil.convertExcelToListOfProduct(file.getInputStream());
			participant = this.excelUtil.getParticipantList();
			excelDataMistakesList = this.excelUtil.getExcelDataMistakesList();
			this.participantRepo.deleteAll();
			this.mistakesInExcelRepo.deleteAll();
			excelDataMistakesList = this.mistakesInExcelService.saveAllExcelDataMistakes(excelDataMistakesList);

			participant.forEach(chip -> {
				try {
					this.participantRepo.save(chip);
				} catch (Exception dex) {
					System.out.println(dex.getMessage());;
					MistakesInExcel mistakesInExcel = new MistakesInExcel();
					mistakesInExcel.setDuplicate(extractDuplicateEntry(dex.getMessage()));
					mistakesInExcelService.saveExcelDataMistake(mistakesInExcel);
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Done";
	}

	@Override
	public Page<Participant> getParticipantByPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return this.participantRepo.findAll(pageable);
	}

	@Override
	public long totalParticipantsCount() {
		return this.participantRepo.count();
	}

	@Override
	public List<Participant> getParticipantByGender(String gender) {
		return this.participantRepo.getByGender(gender);
	}

	@Override
	public List<Participant> getParticipantByName(String name) {
		return this.participantRepo.getByName(name);
	}

	@Override
	public long getCountByGender(String gender) {
		return this.participantRepo.getCountByGender(gender);
	}
	
	public static String extractDuplicateEntry(String exceptionMessage) {
        // Define the regular expression pattern
        Pattern pattern = Pattern.compile("Duplicate entry '.*?'");

        // Create a matcher for the input string
        Matcher matcher = pattern.matcher(exceptionMessage);

        // Find and return the matching substring
        if (matcher.find()) {
            return matcher.group(0);
        } else {
            return "No duplicate entry found";
        }
    }

}
