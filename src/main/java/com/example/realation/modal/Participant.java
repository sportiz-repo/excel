package com.example.realation.modal;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Participant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false, unique = true)
	private String chip;
	@Column(nullable = false, unique = true)
	private String pid;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private LocalDate birthdate;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false)
	private String gender;
	private String city;
	private String country;
	@Column(nullable = false)
	private String race;
	@Column(nullable = false)
	private String category;
	private String email;
	private String phone;
	@Column(nullable = false)
	private String tshirtSize;
	@Column(columnDefinition = "boolean default true")
	private boolean smsSent;

	@Transient
	private int rowNumber;
	@Transient
	private int sheetNumber;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
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

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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

	public boolean isSmsSent() {
		return smsSent;
	}

	public void setSmsSent(boolean smsSent) {
		this.smsSent = smsSent;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public int getSheetNumber() {
		return sheetNumber;
	}

	public void setSheetNumber(int sheetNumber) {
		this.sheetNumber = sheetNumber;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", chip=" + chip + ", pid=" + pid + ", firstName=" + firstName + ", lastName="
				+ lastName + ", birthdate=" + birthdate + ", age=" + age + ", gender=" + gender + ", city=" + city
				+ ", country=" + country + ", race=" + race + ", category=" + category + ", email=" + email + ", phone="
				+ phone + ", tshirtSize=" + tshirtSize + ", smsSent=" + smsSent + ", rowNumber=" + rowNumber
				+ ", sheetNumber=" + sheetNumber + "]";
	}
	
	

}
