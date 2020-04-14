package com.fpoly.converter;

import org.springframework.stereotype.Component;

import com.fpoly.dto.DepartsDTO;
import com.fpoly.entity.DepartsEntity;

@Component
public class DepartsConverter {

	public DepartsDTO toDTO(DepartsEntity entity) {
		DepartsDTO result = new DepartsDTO();
		result.setId(entity.getId());
		result.setCode(entity.getCode());
		result.setName(entity.getName());

		return result;
	}

	public DepartsEntity toEntity(DepartsDTO dto) {
		DepartsEntity result = new DepartsEntity();
		result.setCode(dto.getCode());
		result.setName(dto.getName());

		return result;
	}
}
