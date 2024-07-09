package com.example.realation.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaverUtil {
	public boolean participantExcelSaver(MultipartFile file) {
		try {
			Files.copy(
					file.getInputStream(), Paths.get(Paths.get("").toAbsolutePath() + 
							File.separator + "src" + 
							File.separator + "main"+ 
							File.separator + "resources" + 
							File.separator + "static" + 
							File.separator + "excel" +
							File.separator +
							"participants.xlsx"),
					StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
