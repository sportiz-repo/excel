package com.example.realation.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.realation.modal.Participant;

public interface ParticipantRepo extends JpaRepository<Participant, Long> {
	public Optional<Participant> findByChip(String chip);

	public Optional<Participant> findByPid(String pid);

	public List<Participant> getByGender(String gender);

	public List<Participant> getByName(String name);

	@Query("SELECT COUNT(u) FROM Participant u WHERE u.gender = :gender")
	long getCountByGender(@Param("gender") String gender);
}
