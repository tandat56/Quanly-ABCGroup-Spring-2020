package com.fpoly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.entity.StaffsEntity;

public interface StaffRepository extends JpaRepository<StaffsEntity, Long> {
	
}
