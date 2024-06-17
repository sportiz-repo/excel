package com.example.realation.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "excel_data_mistakes")
public class ExcelDataMistakes {
	@Id
	private int rowNumber;
//	@Column(columnDefinition = "varchar(255) default 'correct'")
	private String chipNumber;
//	@Column(columnDefinition = "varchar(255) default 'correct'")
	private String pid;
//	@Column(columnDefinition = "varchar(255) default 'correct'")
	private String name;
//	@Column(columnDefinition = "varchar(255) default 'correct'")
	private String birthdate;
//	@Column(columnDefinition = "varchar(255) default 'correct'")
	private String gender;
//	@Column(columnDefinition = "varchar(255) default 'correct'")
	private String city;
//	@Column(columnDefinition = "varchar(255) default 'correct'")
	private String email;
//	@Column(columnDefinition = "varchar(255) default 'correct'")
	private String phone;
//	@Column(columnDefinition = "varchar(255) default 'correct'")
	private String race;

//	public ExcelDataMistakes(int rowNumber, String chipNumber, String pid, String name, String birthdate,
//			String gender, String city, String email, String phone, String race) {
//		super();
//		this.rowNumber = rowNumber;
//		this.chipNumber = chipNumber;
//		this.pid = pid;
//		this.name = name;
//		this.birthdate = birthdate;
//		this.gender = gender;
//		this.city = city;
//		this.email = email;
//		this.phone = phone;
//		this.race = race;
//	}
//
//	public ExcelDataMistakes() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getChipNumber() {
		return chipNumber;
	}

	public void setChipNumber(String chipNumber) {
		this.chipNumber = chipNumber;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	@Override
	public String toString() {
		return "ExcelDataMistakes [rowNumber=" + rowNumber + ", chipNumber=" + chipNumber + ", pid=" + pid + ", name="
				+ name + ", birthdate=" + birthdate + ", gender=" + gender + ", city=" + city + ", email=" + email
				+ ", phone=" + phone + ", race=" + race + "]";
	}

}
