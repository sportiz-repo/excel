package com.example.realation.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.realation.modal.Chips;

public class ExcelUtil {
	public static boolean isExcelFormat(MultipartFile file) {
		String fileType = file.getContentType();
		System.out.println(fileType);
		if (fileType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
			return true;
		return false;
	}

	public static List<Chips> convertExcelToListOfProduct(InputStream is) {
		List<Chips> list = new ArrayList<>();
		try (XSSFWorkbook workbook = new XSSFWorkbook(is)) {
			System.out.println(workbook.getSheetName(0));
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowNumber = 0;
			Iterator<Row> iterator = sheet.iterator();
			while (iterator.hasNext()) {
				Row row = iterator.next();
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
				System.out.println(row.getLastCellNum());
				Iterator<Cell> cells = row.iterator();
				int cid = 0;
				Chips chips = new Chips();
				while (cells.hasNext()) {
					Cell cell = cells.next();

					switch (cid) {
					case 0:
						chips.setChip(cell.getStringCellValue());
						break;
					case 1:
						chips.setPid(Integer.parseInt(cell.getStringCellValue()));
						break;
					case 2:
						chips.setFirstName(cell.getStringCellValue());
						break;
					case 3:
						chips.setLastName(cell.getStringCellValue());
						break;
					case 4:
						chips.setBirthdate(cell.getDateCellValue());
						break;
					case 5:
						chips.setGender(cell.getStringCellValue());
						break;
					case 6:
						chips.setCity(cell.getStringCellValue());
						break;
					case 7:
						chips.setEmail(cell.getStringCellValue());
						break;
					case 8:
						chips.setPhone((long) cell.getNumericCellValue());
						break;
					case 9:
						chips.setRace(cell.getStringCellValue());
						break;
					case 10:
						chips.setSmsSent(cell.getBooleanCellValue());
						break;
					default:
						break;
					}
					cid++;
				}
				list.add(chips);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
