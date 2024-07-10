package com.example.realation.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.example.realation.modal.Participant;

public interface ParticipantService {
	public Participant createParticipant(Participant participant);

	public Participant getParticipantByChip(String chip);

	public Participant getParticipantByPid(String pid);

	public List<Participant> getAllParticipant();

	public String saveAllFromExcel(MultipartFile file);

	public Page<Participant> getParticipantByPagination(int pageNo, int pageSize);

	public long totalParticipantsCount();

	public List<Participant> getParticipantByGender(String gender);

	public List<Participant> getParticipantByFirstName(String firstName);
	
	public long getCountByGender(String gender);
	
	public void deleteAll();
}
