package com.fpoly.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fpoly.converter.StaffConverter;
import com.fpoly.dto.StaffDTO;
import com.fpoly.entity.DepartsEntity;
import com.fpoly.entity.StaffsEntity;
import com.fpoly.repository.DepartsRepository;
import com.fpoly.repository.StaffRepository;
import com.fpoly.service.IStaffService;

@Service
public class StaffService implements IStaffService {

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StaffConverter staffConverter;

	@Autowired
	private DepartsRepository departsRepository;

	@Override
	// lấy toàn bộ
	// convert dữ liệu từ entity qua dto
	public List<StaffDTO> findAll(Pageable pageable) {
		List<StaffDTO> models = new ArrayList<>();
		List<StaffsEntity> entities = staffRepository.findAll(pageable).getContent();
		for (StaffsEntity item : entities) {
			StaffDTO staffDTO = staffConverter.toDTO(item);
			models.add(staffDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) staffRepository.count();
	}

	@Override
	public StaffDTO findById(long id) {
		StaffsEntity entity = staffRepository.findOne(id);
		return staffConverter.toDTO(entity);
	}

	@Override
	@Transactional
	public StaffDTO save(StaffDTO dto) {
		//tìm phòng ban theo cái code của nó
		DepartsEntity departs = departsRepository.findOneByCode(dto.getDepartCode());
		StaffsEntity staffEntity = new StaffsEntity();
		//nếu mà id khác null thì cập nhật
		if (dto.getId() != null) {
			//lấy thằng nhân viên cũ lên
			StaffsEntity oldStaff = staffRepository.findOne(dto.getId());
			//set cái phòng ban vào thằng cũ
			oldStaff.setDeparts(departs);
			//convert thằng cũ sang thằng mới
			staffEntity = staffConverter.toEntity(oldStaff, dto);
		} else {
			//đây là id null là nó thêm mới
			//convert dữ liệu mà thằng dto gửi lên 
			staffEntity = staffConverter.toEntity(dto);
			//set thêm phòng ban vào
			staffEntity.setDeparts(departs);
		}
		//xong thì lưu xuống và return lại thằng DTO từ thằng entity
		return staffConverter.toDTO(staffRepository.save(staffEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for(long id: ids) {
			staffRepository.delete(id);
		}
	}
}




















