package com.example.realation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.realation.modal.ExcelDataMistakes;

public interface ExcelDataMistakeRepo extends JpaRepository<ExcelDataMistakes, Integer> {

}
