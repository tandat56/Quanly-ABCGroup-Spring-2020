package com.fpoly.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fpoly.dto.StaffDTO;

public class NewStaffsMapper implements RowMapper<StaffDTO> {

	@Override
	public StaffDTO mapRow(ResultSet resultSet) {
		try {
			StaffDTO staffDTO = new StaffDTO();
			staffDTO.setId(resultSet.getLong("id"));
			staffDTO.setName(resultSet.getString("name"));
			staffDTO.setGender(resultSet.getBoolean("gender"));
			staffDTO.setBrithday(resultSet.getString("brithday"));
			staffDTO.setPhoto(resultSet.getString("photo"));
			staffDTO.setEmail(resultSet.getString("email"));
			staffDTO.setPhone(resultSet.getString("phone"));
			staffDTO.setSalary(resultSet.getString("salary"));
			staffDTO.setNote(resultSet.getString("note"));
			staffDTO.setCreatedDate(resultSet.getTimestamp("createddate"));
			staffDTO.setCreatedBy(resultSet.getString("createdby"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				staffDTO.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if (resultSet.getString("modifiedby") != null) {
				staffDTO.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return staffDTO;
		} catch (SQLException e) {
			return null;
		}
	}
}
