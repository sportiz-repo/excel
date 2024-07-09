package com.example.realation.batch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.batch.item.ItemReader;

import com.example.realation.modal.Participant;

public class ExcelParticipantReader implements ItemReader<Participant> {

	private final String filePath;
	private Iterator<Sheet> sheetIterator;
	private Iterator<Row> rowIterator;
	private int sheetNumber = -1;

	public ExcelParticipantReader(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public Participant read() throws Exception {
		if (sheetIterator == null) {
			sheetNumber = -1;
			initialize();
		}

		while (true) {
			if (rowIterator != null && rowIterator.hasNext()) {
				Row row = rowIterator.next();
				return mapRowToParticipant(row);
			} else if (sheetIterator.hasNext()) {
				Sheet sheet = sheetIterator.next();
				rowIterator = sheet.iterator();
				sheetNumber++;
				// Skip header row
				if (rowIterator.hasNext()) {
					rowIterator.next();
				}
			} else {
				return null;
			}
		}
	}

	private void initialize() throws IOException {
		FileInputStream fis = new FileInputStream(new File(filePath));
		Workbook workbook = WorkbookFactory.create(fis);
		sheetIterator = workbook.iterator();
	}

	private Participant mapRowToParticipant(Row row) {
		Participant participant = new Participant();
		participant.setChip(row.getCell(0).getStringCellValue());
		participant.setPid(String.valueOf(row.getCell(1).getNumericCellValue()));
		participant.setFirstName(row.getCell(2).getStringCellValue());
		participant.setLastName(row.getCell(3).getStringCellValue());
		participant.setBirthdate(
				row.getCell(4).getLocalDateTimeCellValue().toLocalDate()	);
		participant.setAge((int) row.getCell(5).getNumericCellValue());
		participant.setGender(row.getCell(6).getStringCellValue());
		participant.setCity(row.getCell(7).getStringCellValue());
		participant.setRace(row.getCell(8).getStringCellValue());
		participant.setCategory(row.getCell(9).getStringCellValue());
		participant.setPhone(row.getCell(10).getStringCellValue());
		participant.setEmail(row.getCell(11).getStringCellValue());
		participant.setTshirtSize(row.getCell(12).getStringCellValue());
		participant.setCountry(row.getCell(13).getStringCellValue());
		participant.setRowNumber(row.getRowNum());
		participant.setSheetNumber(sheetNumber);
		return participant;
	}
}
