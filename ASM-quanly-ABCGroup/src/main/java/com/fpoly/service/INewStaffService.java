package com.fpoly.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.fpoly.dto.StaffDTO;

public interface INewStaffService {
	List<StaffDTO> findAll(Pageable pageable);
	int getTotalItem();
}
