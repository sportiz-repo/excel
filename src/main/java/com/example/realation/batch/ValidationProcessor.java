package com.example.realation.batch;

import org.springframework.batch.item.ItemProcessor;

import com.example.realation.modal.MistakesInExcel;
import com.example.realation.modal.Participant;
import com.example.realation.repo.MistakesInExcelRepo;
import com.example.realation.util.Validate;

public class ValidationProcessor implements ItemProcessor<Participant, Participant> {

	private final MistakesInExcelRepo mistakesInExcelRepo;

	public ValidationProcessor(MistakesInExcelRepo mistakesInExcelRepo) {
		this.mistakesInExcelRepo = mistakesInExcelRepo;
	}

	@Override
	public Participant process(Participant participant) throws Exception {
		MistakesInExcel mistake = new MistakesInExcel();
		boolean hasMistake = false;

		if (!Validate.isChipValide(participant.getChip())) {
			mistake.setChipNumber("incurrect");
			hasMistake = true;
		}
		if (participant.getPid() == null || participant.getPid().isEmpty()) {
			mistake.setPid(participant.getPid());
			hasMistake = true;
		}
		if (!Validate.isNameValide(participant.getFirstName())) {
			System.out.println(participant.getFirstName());
			mistake.setFirstName("incurrect");
			hasMistake = true;
		}
		if (!Validate.isNameValide(participant.getLastName())) {
			System.out.println(participant.getLastName());
			mistake.setLastName("incurrect");
			hasMistake = true;
		}
		if (participant.getBirthdate() == null) {
			mistake.setBirthdate(participant.getBirthdate() != null ? participant.getBirthdate().toString() : null);
			hasMistake = true;
		}
		if (participant.getGender() == null || participant.getGender().isEmpty()) {
			mistake.setGender("incurrect");
			hasMistake = true;
		} else {
			String checkForNA = Validate.validateGender(participant.getGender());
			if (checkForNA.equals("NA")) {
				mistake.setGender("incurrect");
				hasMistake = true;
			} else {
				participant.setGender(checkForNA);
			}
		}

		if (!Validate.isCityOrContryValide(participant.getCity())) {
			mistake.setCity("incurrect");
			hasMistake = true;
		}
		if (!Validate.isCityOrContryValide(participant.getCountry())) {
			mistake.setCountry("incurrect");
			hasMistake = true;
		}
		if (participant.getRace() == null || participant.getRace().isEmpty()) {
			mistake.setRace("incurrect");
			hasMistake = true;
		}
		if (participant.getCategory() == null || participant.getCategory().isEmpty()) {
			mistake.setCategory("incurrect");
			hasMistake = true;
		}
		if (!Validate.isEmailValide(participant.getEmail())) {
			mistake.setEmail("incurrect");
			hasMistake = true;
		}
		if (!Validate.isValidIndianMobileNumber(participant.getPhone())) {
			mistake.setPhone("incurrect");
			hasMistake = true;
		}
		if (participant.getTshirtSize() == null || participant.getTshirtSize().isEmpty()) {
			mistake.setTshirtSize("incurrect");
			hasMistake = true;
		}

		if (hasMistake) {
			System.out.println(mistake);
			mistake.setRowNo(participant.getRowNumber());
			mistake.setSheetNumber(participant.getSheetNumber());
			mistakesInExcelRepo.save(mistake);
			return null; // Skip this participant
		}

		return participant; // Valid participant
	}
}
