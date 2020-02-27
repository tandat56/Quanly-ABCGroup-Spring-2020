package com.fpoly.api.admin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.dto.StaffDTO;;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {
	
	@PostMapping("/api/new")
	public StaffDTO createStaff(@RequestBody StaffDTO staffDTO) {
		return staffDTO;
	}
	
	@PutMapping("/api/new")
	public StaffDTO updateStaff(@RequestBody StaffDTO staffDTO) {
		return staffDTO;
	}
	
	@DeleteMapping("/api/new")
	public void deleteStaff(@RequestBody long[] ids) {
		System.out.println("ok");
	}
}
