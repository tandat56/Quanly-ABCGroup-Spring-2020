package com.fpoly.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.dto.StaffDTO;
import com.fpoly.service.IStaffService;;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {
	
	@Autowired
	private IStaffService staffService;	
	
	@PostMapping("/api/new")
	public StaffDTO createStaff(@RequestBody StaffDTO StaffDTO) {
		return staffService.save(StaffDTO);
	}
	
	@PutMapping("/api/new")
	public StaffDTO updateStaff(@RequestBody StaffDTO updateStaff) {
		return staffService.save(updateStaff);
	}
	
	@DeleteMapping("/api/new")
	public void deleteStaff(@RequestBody long[] ids) {
		staffService.delete(ids);
	}
}







