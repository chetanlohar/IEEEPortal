package com.ieeeportal.service;

import java.util.ArrayList;
import java.util.List;

import com.ieeeportal.entity.StudentDetailsEntity;

public interface StudentDetailsService {
	public List<StudentDetailsEntity> getallStudent();
	public List<StudentDetailsEntity> getStudent(String name);

}
