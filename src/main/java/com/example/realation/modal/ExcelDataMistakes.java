package com.example.realation.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class ExcelDataMistakes {
	@Id
	private int rowNumber;
	@Column(columnDefinition = "String default correct")
	private String chipNumber;
	@Column(columnDefinition = "String default correct")
	private String bibNumber;
	@Column(columnDefinition = "String default correct")
	private String name;
	@Column(columnDefinition = "String default correct")
	private String birthdate;
	@Column(columnDefinition = "String default correct")
	private String gender;
	@Column(columnDefinition = "String default correct")
	private String city;
	@Column(columnDefinition = "String default correct")
	private String email;
	@Column(columnDefinition = "String default correct")
	private String phone;
	@Column(columnDefinition = "String default correct")
	private String race;

	public ExcelDataMistakes(int rowNumber, String chipNumber, String bibNumber, String name, String birthdate,
			String gender, String city, String email, String phone, String race) {
		super();
		this.rowNumber = rowNumber;
		this.chipNumber = chipNumber;
		this.bibNumber = bibNumber;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.city = city;
		this.email = email;
		this.phone = phone;
		this.race = race;
	}

	public ExcelDataMistakes() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public String getBibNumber() {
		return bibNumber;
	}

	public void setBibNumber(String bibNumber) {
		this.bibNumber = bibNumber;
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

}
