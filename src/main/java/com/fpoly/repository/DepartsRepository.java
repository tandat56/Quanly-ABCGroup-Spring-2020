package com.fpoly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.entity.DepartsEntity;

public interface DepartsRepository extends JpaRepository<DepartsEntity, Long> {

	DepartsEntity findOneByCode(String code);
	
}
