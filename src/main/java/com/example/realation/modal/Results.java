package com.example.realation.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "results")
public class Results {
	@Id
	private int pid;
	@Column(columnDefinition = "integer default 0")
	private int startTime;
	@Column(columnDefinition = "integer default 0")
	private int cp1_time;
	@Column(columnDefinition = "integer default 0")
	private int cp2_time;
	@Column(columnDefinition = "integer default 0")
	private int cp3_time;
	@Column(columnDefinition = "integer default 0")
	private int cp4_time;
	@Column(columnDefinition = "integer default 0")
	private int cp5_time;
	@Column(columnDefinition = "integer default 0")
	private int finishTime;

//	@OneToOne(mappedBy = "results", cascade = CascadeType.ALL, fetch = FetchType.EAGER) // One-to-One relationship with
//	@JoinColumn(name = "pid", referencedColumnName = "pid") // Foreign key based on pid referencing chips
//	private Chips chips;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getCp1_time() {
		return cp1_time;
	}

	public void setCp1_time(int cp1_time) {
		this.cp1_time = cp1_time;
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

	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}

//	public Chips getChips() {
//		return chips;
//	}
//
//	public void setChips(Chips chips) {
//		this.chips = chips;
//	}

}
