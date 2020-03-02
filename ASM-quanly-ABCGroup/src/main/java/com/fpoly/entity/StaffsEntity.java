package com.fpoly.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "staffs")
public class StaffsEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "gender")
	private Boolean gender;

	@Column(name = "brithday")
	private Date brithday;

	@Column(name = "photo")
	private String photo;

	@Column(name = "email", columnDefinition = "TEXT")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "salary")
	private Double salary;

	@Column(name = "note", columnDefinition = "TEXT")
	private String note;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departid")
	private DepartsEntity departs;

	@OneToMany(mappedBy = "staffs")
	private List<RecordsEntity> records = new ArrayList<>();

	public List<RecordsEntity> getRecords() {
		return records;
	}

	public void setRecords(List<RecordsEntity> records) {
		this.records = records;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Date getBrithday() {
		return brithday;
	}

	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public DepartsEntity getDeparts() {
		return departs;
	}

	public void setDeparts(DepartsEntity departs) {
		this.departs = departs;
	}

}
