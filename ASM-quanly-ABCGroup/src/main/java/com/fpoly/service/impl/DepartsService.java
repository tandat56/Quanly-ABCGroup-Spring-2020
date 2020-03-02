package com.fpoly.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.entity.DepartsEntity;
import com.fpoly.repository.DepartsRepository;
import com.fpoly.service.IDepartsService;

@Service
public class DepartsService implements IDepartsService {

	@Autowired
	private DepartsRepository departsRepository;

	@Override
	public Map<String, String> findAll() {
		Map<String, String> result = new HashMap<>();
		
		List<DepartsEntity> entities = departsRepository.findAll();
		for (DepartsEntity item : entities) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}

}
