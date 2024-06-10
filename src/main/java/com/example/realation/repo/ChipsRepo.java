package com.example.realation.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.realation.modal.Chips;

public interface ChipsRepo extends JpaRepository<Chips, String> {
	public Optional<Chips> findByPid(int pid);
}
