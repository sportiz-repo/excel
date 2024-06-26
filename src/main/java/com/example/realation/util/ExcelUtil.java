package com.example.realation.util;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.realation.modal.MistakesInExcel;
import com.example.realation.modal.Participant;

@Component
@Scope("prototype")
public class ExcelUtil {

	List<Participant> participantList = new ArrayList<>();
	List<MistakesInExcel> mistakesInExcelList = new ArrayList<>();

	public boolean isExcelFormat(MultipartFile file) {
		String fileType = file.getContentType();
		System.out.println(fileType);
		if (fileType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
			return true;
		return false;
	}

	public void convertExcelToListOfProduct(InputStream is) {
		try (XSSFWorkbook workbook = new XSSFWorkbook(is)) {
			System.out.println(workbook.getSheetName(0));
			System.out.println(workbook.getNumberOfSheets());
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowNumber = 0;
			Iterator<Row> iterator = sheet.iterator();
			try {
				while (iterator.hasNext()) {
					Row row = iterator.next();
					if (rowNumber == 0) {

						rowNumber += 2;
						continue;
					}
					Iterator<Cell> cells = row.iterator();
					int cid = 0;
					Participant participant = new Participant();
					MistakesInExcel mistakesInExcel = new MistakesInExcel();
					boolean excelDataMistakesFlag = false;
					while (cells.hasNext()) {

						Cell cell = cells.next();

						switch (cid) {
						case 0:
							if (cell.getCellType().toString().equals("STRING")) {
								String chipNumber = cell.getStringCellValue().toString().trim();
								if (Validate.idChipValide(chipNumber)) {
									participant.setChip(cell.getStringCellValue());
								} else {
									System.out.println("Row " + rowNumber + " Column " + cid
											+ " Is not a valid chip number " + chipNumber);
									excelDataMistakesFlag = true;
									mistakesInExcel.setChipNumber("incorrect");
								}
							} else {
								System.out.println("Row " + rowNumber + " Column " + cid + " Is not a string cell");
								excelDataMistakesFlag = true;
								mistakesInExcel.setChipNumber("incorrect");
							}
							break;
						case 1:
							if (cell.getCellType().toString().equals("STRING")) {
								participant.setPid(cell.getStringCellValue().toString().trim());
							} else {
								System.out.println("Row " + rowNumber + " Column " + cid + " Is not a string cell");
								excelDataMistakesFlag = true;
								mistakesInExcel.setPid(cell.getStringCellValue().toString().trim());
							}
							break;
						case 2:
							if (cell.getCellType().toString().equals("STRING")) {
								String name = cell.getStringCellValue().toString().trim();
								if (Validate.validateName(name))
									participant.setName(name);
								else {
									System.out.println(
											"Row " + rowNumber + " Column " + cid + " Is not a valid name " + name);
									excelDataMistakesFlag = true;
									mistakesInExcel.setName("incorrect");
								}
							} else {
								System.out.println("Row " + rowNumber + " Column " + cid + " Is not a string cell");
								excelDataMistakesFlag = true;
								mistakesInExcel.setName("incorrect");
							}
							break;
						case 3:
							if (cell.getCellType().toString().equals("NUMERIC")) {
								LocalDateTime birthDate = cell.getLocalDateTimeCellValue();
								if (Validate.isBirthdateValid(birthDate.getYear(), birthDate.getMonthValue(),
										birthDate.getDayOfMonth()))
									participant.setBirthdate(LocalDate.of(birthDate.getYear(),
											birthDate.getMonthValue(), birthDate.getDayOfMonth()));
								else {
									System.out.println("Row " + rowNumber + " Column " + cid
											+ " Is not a valid birthdate " + birthDate);
									excelDataMistakesFlag = true;
									mistakesInExcel.setBirthdate("incorrect");
								}
							} else {
								System.out.println("Row " + rowNumber + " Column " + cid + " Is not a numeric cell");
								excelDataMistakesFlag = true;
								mistakesInExcel.setBirthdate("incorrect");
							}
							break;
						case 4:
							if (cell.getCellType().toString().equals("STRING")) {
								String gender = Validate.validateGender(cell.getStringCellValue().toString().trim());
								participant.setGender(gender);
							} else {
								System.out.println("Row " + rowNumber + " Column " + cid + " Is not a string cell");
								excelDataMistakesFlag = true;
								mistakesInExcel.setGender("incorrect");
							}
							break;
						case 5:
							if (cell.getCellType().toString().equals("STRING")) {
								String city = cell.getStringCellValue().toString().trim();
								if (Validate.validateCityFormat(city))
									participant.setCity(city);
								else {
									System.out.println("Row " + rowNumber + " Column " + cid + " Is not a valid city");
									excelDataMistakesFlag = true;
									mistakesInExcel.setCity("incorrect");
								}
							} else {
								System.out.println("Row " + rowNumber + " Column " + cid + " Is not a string cell");
								excelDataMistakesFlag = true;
								mistakesInExcel.setCity("incorrect");
							}
							break;
						case 6:
							if (cell.getCellType().toString().equals("STRING")) {
								String email = cell.getStringCellValue().toString().trim();
								if (Validate.isEmailValid(email))
									participant.setEmail(email);
								else {
									System.out.println(
											"Row " + rowNumber + " Column " + cid + " Is not a valid email " + email);
									excelDataMistakesFlag = true;
									mistakesInExcel.setEmail("incorrect");
								}
							} else {
								System.out.println("Row " + rowNumber + " Column " + cid + " Is not a string cell");
								excelDataMistakesFlag = true;
								mistakesInExcel.setEmail("incorrect");
							}
							break;
						case 7:
							if (cell.getCellType().toString().equals("NUMERIC")) {
								String phone = String.valueOf((long) cell.getNumericCellValue());
								if (Validate.isValidIndianMobileNumber(phone))
									participant.setPhone(phone);
								else {
									System.out.println("Row " + rowNumber + " Column " + cid
											+ " Is not a valid phone number " + phone);
									excelDataMistakesFlag = true;
									mistakesInExcel.setPhone("incorrect");
								}
							} else {
								System.out.println("Row " + rowNumber + " Column " + cid + " Is not a numeric cell");
								excelDataMistakesFlag = true;
								mistakesInExcel.setPhone("incorrect");
							}
							break;
						case 8:
							if (cell.getCellType().toString().equals("STRING")) {
								String tshirtSize = cell.getStringCellValue().toString().trim();
								tshirtSize = Validate.validateTshirtSize(tshirtSize);
								participant.setTshirtSize(tshirtSize);
							} else {
								System.out.println("Row " + rowNumber + " Column " + cid + " Is not a string cell");
							}
						case 9:
							if (cell.getCellType().toString().equals("STRING")) {
								String race = cell.getStringCellValue().toString().trim();
								participant.setRace(race);
							} else {
								System.out.println("Row " + rowNumber + " Column " + cid + " Is not a string cell");
								excelDataMistakesFlag = true;
								mistakesInExcel.setRace("incorrect");
							}
							break;
						default:
							break;
						}
						cid++;
					}
					mistakesInExcel.setRowOrChipNumber(rowNumber);
					;
					if (excelDataMistakesFlag)
						mistakesInExcelList.add(mistakesInExcel);
					else
						participantList.add(participant);
					rowNumber++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Participant> getParticipantList() {
		return participantList;
	}

	public List<MistakesInExcel> getExcelDataMistakesList() {
		return mistakesInExcelList;
	}
}
