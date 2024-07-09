package com.example.realation.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.realation.modal.Participant;

@Repository
public interface ParticipantRepo extends JpaRepository<Participant, Long> {
	public Optional<Participant> findByChip(String chip);

	public Optional<Participant> findByPid(String pid);

	public List<Participant> getByGender(String gender);

	public List<Participant> getByFirstName(String firstName);

	@Query("SELECT COUNT(u) FROM Participant u WHERE u.gender = :gender")
	long getCountByGender(@Param("gender") String gender);
}
