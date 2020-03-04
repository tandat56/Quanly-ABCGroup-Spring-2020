package com.fpoly.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.fpoly.dto.StaffDTO;
public interface IStaffService {
	List<StaffDTO> findAll(Pageable pageable);
	int getTotalItem();
	StaffDTO findById(long id);
	StaffDTO save(StaffDTO dto);
	void delete(long[] ids);
	List<StaffDTO> findAll();
}
