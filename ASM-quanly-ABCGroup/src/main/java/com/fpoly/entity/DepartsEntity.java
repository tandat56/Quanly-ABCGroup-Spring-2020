package com.fpoly.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departs")
public class DepartsEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "departs")
	private List<StaffsEntity> staffs = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StaffsEntity> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<StaffsEntity> staffs) {
		this.staffs = staffs;
	}

}
