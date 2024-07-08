package com.example.realation.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "results")
@AllArgsConstructor
@NoArgsConstructor
public class Results {
	@Id
	private String pid;
	@Column(name = "cp1_time", columnDefinition = "integer default 0")
	private int startTime;
	@Column(columnDefinition = "integer default 0")
	private int cp2_time;
	@Column(columnDefinition = "integer default 0")
	private int cp3_time;
	@Column(columnDefinition = "integer default 0")
	private int cp4_time;
	@Column(columnDefinition = "integer default 0")
	private int cp5_time;
	@Column(columnDefinition = "integer default 0")
	private int cp6_time;
	@Column(columnDefinition = "integer default 0")
	private int cp7_time;
	@Column(columnDefinition = "integer default 0")
	private int cp8_time;
	@Column(columnDefinition = "integer default 0")
	private int cp9_time;
	@Column(name = "cp99_time", columnDefinition = "integer default 0")
	private int finishTime;

	private int total = -1;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getCp2_time() {
		return cp2_time;
	}

	public void setCp2_time(int cp2_time) {
		this.cp2_time = cp2_time;
	}

	public int getCp3_time() {
		return cp3_time;
	}

	public void setCp3_time(int cp3_time) {
		this.cp3_time = cp3_time;
	}

	public int getCp4_time() {
		return cp4_time;
	}

	public void setCp4_time(int cp4_time) {
		this.cp4_time = cp4_time;
	}

	public int getCp5_time() {
		return cp5_time;
	}

	public void setCp5_time(int cp5_time) {
		this.cp5_time = cp5_time;
	}

	public int getCp6_time() {
		return cp6_time;
	}

	public void setCp6_time(int cp6_time) {
		this.cp6_time = cp6_time;
	}

	public int getCp7_time() {
		return cp7_time;
	}

	public void setCp7_time(int cp7_time) {
		this.cp7_time = cp7_time;
	}

	public int getCp8_time() {
		return cp8_time;
	}

	public void setCp8_time(int cp8_time) {
		this.cp8_time = cp8_time;
	}

	public int getCp9_time() {
		return cp9_time;
	}

	public void setCp9_time(int cp9_time) {
		this.cp9_time = cp9_time;
	}

	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
