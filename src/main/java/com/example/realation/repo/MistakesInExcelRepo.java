package com.example.realation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.realation.modal.MistakesInExcel;

@Repository
public interface MistakesInExcelRepo extends JpaRepository<MistakesInExcel, Long> {

}
