package com.example.realation.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MistakesInExcel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int rowNo = -1;
	private int sheetNumber = 0;
	private String chipNumber = "";
	private String pid = "";
	private String firstName = "";
	private String lastName = "";
	private String birthdate = "";
	private String age = "";
	private String gender = "";
	private String city = "";
	private String country = "";
	private String race = "";
	private String category = "";
	private String email = "";
	private String phone = "";
	private String tshirtSize = "";
	private String duplicate = "";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public int getSheetNumber() {
		return sheetNumber;
	}

	public void setSheetNumber(int sheetNumber) {
		this.sheetNumber = sheetNumber;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getTshirtSize() {
		return tshirtSize;
	}

	public void setTshirtSize(String tshirtSize) {
		this.tshirtSize = tshirtSize;
	}

	public String getDuplicate() {
		return duplicate;
	}

	public void setDuplicate(String duplicate) {
		this.duplicate = duplicate;
	}

	@Override
	public String toString() {
		return "MistakesInExcel [id=" + id + ", rowNo=" + rowNo + ", sheetNumber=" + sheetNumber + ", chipNumber="
				+ chipNumber + ", pid=" + pid + ", firstName=" + firstName + ", lastName=" + lastName + ", birthdate="
				+ birthdate + ", age=" + age + ", gender=" + gender + ", city=" + city + ", country=" + country
				+ ", race=" + race + ", category=" + category + ", email=" + email + ", phone=" + phone
				+ ", tshirtSize=" + tshirtSize + ", duplicate=" + duplicate + "]";
	}
	
	

}
