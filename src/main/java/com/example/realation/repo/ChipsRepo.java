package com.example.realation.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.realation.modal.Chips;

public interface ChipsRepo extends JpaRepository<Chips, String> {
	public Optional<Chips> findByPid(int pid);

	public List<Chips> getByGender(String gender);

	public List<Chips> getByName(String name);
}
