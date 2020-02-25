package com.fpoly.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "records")
public class RecordsEntity extends BaseEntity {

	@Column(name = "type")
	private Long type;

	@Column(name = "reason")
	private String reason;

	@Column(name = "date")
	private Date date;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staffid")
	private StaffsEntity staffs;

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public StaffsEntity getStaffs() {
		return staffs;
	}

	public void setStaffs(StaffsEntity staffs) {
		this.staffs = staffs;
	}

}
