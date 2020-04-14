package com.fpoly.converter;

import org.springframework.stereotype.Component;
import com.fpoly.dto.StaffDTO;
import com.fpoly.entity.StaffsEntity;

@Component
public class StaffConverter {

	public StaffDTO toDTO(StaffsEntity entity) {
		StaffDTO result = new StaffDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		if (entity.getGender()) {
			result.setSex("MALE");
		} else {
			result.setSex("FEMALE");
		}
		//result.setGender(entity.getGender());
		result.setBrithday(entity.getBrithday());
		result.setPhoto(entity.getPhoto());
		result.setEmail(entity.getEmail());
		result.setPhone(entity.getPhone());
		result.setSalary(entity.getSalary());
		result.setNote(entity.getNote());
		result.setDepartCode(entity.getDeparts().getCode());
		return result;
	}

	public StaffsEntity toEntity(StaffDTO dto) {
		StaffsEntity result = new StaffsEntity();
		result.setName(dto.getName());
		result.setGender(dto.getGender());
		result.setBrithday(dto.getBrithday());
		result.setPhoto(dto.getPhoto());
		result.setEmail(dto.getEmail());
		result.setPhone(dto.getPhone());
		result.setSalary(dto.getSalary());
		result.setNote(dto.getNote());
	
		return result;
	}
	public StaffsEntity toEntity(StaffsEntity result,StaffDTO dto) {
		
		result.setName(dto.getName());
		result.setGender(dto.getGender());
		result.setBrithday(dto.getBrithday());
		result.setPhoto(dto.getPhoto());
		result.setEmail(dto.getEmail());
		result.setPhone(dto.getPhone());
		result.setSalary(dto.getSalary());
		result.setNote(dto.getNote());
		return result;
	}
}











