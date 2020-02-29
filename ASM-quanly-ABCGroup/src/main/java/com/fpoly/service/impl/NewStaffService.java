package com.fpoly.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fpoly.dto.StaffDTO;
import com.fpoly.entity.StaffsEntity;
import com.fpoly.repository.StaffRepository;
import com.fpoly.service.INewStaffService;

@Service
public class NewStaffService implements INewStaffService {

	@Autowired
	private StaffRepository staffRepository;

	@Override
	//lấy toàn bộ
	//convert dữ liệu từ entity qua dto
	public List<StaffDTO> findAll(Pageable pageable) {
		List<StaffDTO> models = new ArrayList<>();
		List<StaffsEntity> entities = staffRepository.findAll(pageable).getContent();
		for(StaffsEntity item: entities ) {
			StaffDTO staffDTO = new StaffDTO();
			staffDTO.setName(item.getName());
			staffDTO.setEmail(item.getEmail());
			staffDTO.setNote(item.getNote());
			models.add(staffDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int)staffRepository.count();
	}
}
