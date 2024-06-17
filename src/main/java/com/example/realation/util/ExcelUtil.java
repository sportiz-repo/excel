package com.example.realation.util;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.realation.modal.Chips;
import com.example.realation.modal.ExcelDataMistakes;

@Component
public class ExcelUtil {

	List<Chips> chipsList = new ArrayList<>();
	List<ExcelDataMistakes> excelDataMistakesList = new ArrayList<>();

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
						Iterator<Cell> cells = row.iterator();
//						while (cells.hasNext()) {
//							Cell cell = cells.next();
//						}
						rowNumber += 2;
						continue;
					}
					Iterator<Cell> cells = row.iterator();
					int cid = 0;
					Chips chips = new Chips();
					ExcelDataMistakes excelDataMistakes = new ExcelDataMistakes();
					boolean excelDataMistakesFlag = false;
					while (cells.hasNext()) {

						Cell cell = cells.next();

						switch (cid) {
						case 0:
							if (cell.getCellType().toString().equals("STRING")) {
								String chipNumber = cell.getStringCellValue().toString().trim();
								if (Validate.idChipValide(chipNumber)) {
									chips.setChip(cell.getStringCellValue());
								} else {
									System.out.println("Row " + rowNumber + " Column " + cid
											+ " Is not a valid chip number " + chipNumber);
									excelDataMistakesFlag = true;
									excelDataMistakes.setChipNumber("incorrect" + chipNumber);
								}
							} else {
								System.out.println("Row " + rowNumber + " Column " + cid + " Is not a string cell");
								excelDataMistakesFlag = true;
								excelDataMistakes.setChipNumber("incorrect");
							}
							break;
						case 1:
							if (cell.getCellType().toString().equals("STRING")) {
								chips.setPid(cell.getStringCellValue().toString().trim());
							} else {
								System.out.println("Row " + rowNumber + " Column " + cid + " Is not a string cell");
								excelDataMistakesFlag = true;
								excelDataMistakes.setPid(cell.getStringCellValue().toString().trim());
							}
							break;
						case 2:
							if (cell.getCellType().toString().equals("STRING")) {
								String name = cell.getStringCellValue().toString().trim();
								if (Validate.validateName(name))
									chips.setName(name);
								else {
									System.out.println(
											"Row " + rowNumber + " Column " + cid + " Is not a valid name " + name);
									excelDataMistakesFlag = true;
									excelDataMistakes.setName("incorrect" + name);
								}
							} else {
								System.out.println("Row " + rowNumber + " Column " + cid + " Is not a string cell");
								excelDataMistakesFlag = true;
								excelDataMistakes.setName("incorrect");
							}
							break;
						case 3:
							if (cell.getCellType().toString().equals("NUMERIC")) {
								LocalDateTime birthDate = cell.getLocalDateTimeCellValue();
								if (Validate.isBirthdateValid(birthDate.getYear(), birthDate.getMonthValue(),
										birthDate.getDayOfMonth()))
									chips.setBirthdate(new Date(birthDate.getYear(), birthDate.getMonthValue(),
											birthDate.getDayOfMonth()));
								else {
									System.out.println("Row " + rowNumber + " Column " + cid
											+ " Is not a valid birthdate " + birthDate);
									excelDataMistakesFlag = true;
									excelDataMistakes.setBirthdate("incorrect");
								}
							} else {
								System.out.println("Row " + rowNumber + " Column " + cid + " Is not a numeric cell");
								excelDataMistakesFlag = true;
								excelDataMistakes.setBirthdate("incorrect");
							}
							break;
						case 4:
							if (cell.getCellType().toString().equals("STRING")) {
								String gender = Validate.validateGender(cell.getStringCellValue().toString().trim());
								chips.setGender(gender);
							} else {
								System.out.println("Row " + rowNumber + " Column " + cid + " Is not a string cell");
								excelDataMistakesFlag = true;
								excelDataMistakes.setGender("incorrect");
							}
							break;
						case 5:
							if (cell.getCellType().toString().equals("STRING")) {
								String city = cell.getStringCellValue().toString().trim();
								if (Validate.validateCityFormat(city))
									chips.setCity(city);
								else {
									System.out.println("Row " + rowNumber + " Column " + cid + " Is not a valid city");
									excelDataMistakesFlag = true;
									excelDataMistakes.setCity("incorrect");
								}
							} else {
								System.out.println("Row " + rowNumber + " Column " + cid + " Is not a string cell");
								excelDataMistakesFlag = true;
								excelDataMistakes.setCity("incorrect");
							}
							break;
						case 6:
							if (cell.getCellType().toString().equals("STRING")) {
								String email = cell.getStringCellValue().toString().trim();
								if (Validate.isEmailValid(email))
									chips.setEmail(email);
								else {
									System.out.println(
											"Row " + rowNumber + " Column " + cid + " Is not a valid email " + email);
									excelDataMistakesFlag = true;
									excelDataMistakes.setEmail("incorrect");
								}
							} else {
								System.out.println("Row " + rowNumber + " Column " + cid + " Is not a string cell");
								excelDataMistakesFlag = true;
								excelDataMistakes.setEmail("incorrect");
							}
							break;
						case 7:
							if (cell.getCellType().toString().equals("NUMERIC")) {
								String phone = String.valueOf((long) cell.getNumericCellValue());
								if (Validate.isValidIndianMobileNumber(phone))
									chips.setPhone(phone);
								else {
									System.out.println("Row " + rowNumber + " Column " + cid
											+ " Is not a valid phone number " + phone);
									excelDataMistakesFlag = true;
									excelDataMistakes.setPhone("incorrect");
								}
							} else {
								System.out.println("Row " + rowNumber + " Column " + cid + " Is not a numeric cell");
								excelDataMistakesFlag = true;
								excelDataMistakes.setPhone("incorrect");
							}
							break;
						case 8:
							if (cell.getCellType().toString().equals("STRING")) {
								String race = cell.getStringCellValue().toString().trim();
								chips.setRace(race);
							} else {
								System.out.println("Row " + rowNumber + " Column " + cid + " Is not a string cell");
								excelDataMistakesFlag = true;
								excelDataMistakes.setRace("incorrect");
							}
							break;
						default:
							break;
						}
						cid++;
					}
					excelDataMistakes.setRowNumber(rowNumber);
					if (excelDataMistakesFlag)
						excelDataMistakesList.add(excelDataMistakes);
					else
						chipsList.add(chips);
					rowNumber++;
//					break;
//					list.add(chips);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Chips> getChipsList() {
		return chipsList;
	}

	public List<ExcelDataMistakes> getExcelDataMistakesList() {
		return excelDataMistakesList;
	}
}
