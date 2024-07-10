package com.example.realation.batch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
		try {
			participant.setChip(row.getCell(0).getStringCellValue());
		} catch (Exception e) {
			System.out.println(participant);
		}
		try {
			participant.setPid(String.valueOf((int) row.getCell(1).getNumericCellValue()));
		} catch (Exception e) {
		}
		try {
			participant.setFirstName(row.getCell(2).getStringCellValue());
		} catch (Exception e) {
		}
		try {
			participant.setLastName(row.getCell(3).getStringCellValue());
		} catch (Exception e) {
		}
		try {
			participant.setBirthdate(row.getCell(4).getLocalDateTimeCellValue().toLocalDate());
		} catch (Exception e) {
		}
		try {
			participant.setAge((int) row.getCell(5).getNumericCellValue());
		} catch (Exception e) {
		}
		try {
			participant.setGender(row.getCell(6).getStringCellValue());
		} catch (Exception e) {
		}
		try {
			participant.setCity(row.getCell(7).getStringCellValue());
		} catch (Exception e) {
		}
		try {
			participant.setRace(String.valueOf(row.getCell(8).getStringCellValue()));
		} catch (Exception e) {
		}
		try {
			participant.setCategory(row.getCell(9).getStringCellValue());
		} catch (Exception e) {
		}
		try {
			participant.setEmail(row.getCell(10).getStringCellValue());
		} catch (Exception e) {
		}
		try {
			participant.setPhone(row.getCell(11).getStringCellValue());
		} catch (Exception e) {
			try {
				participant.setPhone(String.valueOf((long) row.getCell(11).getNumericCellValue()));
			} catch (Exception e1) {}
		}
		try {
			participant.setTshirtSize(row.getCell(12).getStringCellValue());
		} catch (Exception e) {
		}
		try {
			participant.setCountry(row.getCell(13).getStringCellValue());
		} catch (Exception e) {}
		participant.setRowNumber(row.getRowNum());
		participant.setSheetNumber(sheetNumber);
		return participant;
	}
}
