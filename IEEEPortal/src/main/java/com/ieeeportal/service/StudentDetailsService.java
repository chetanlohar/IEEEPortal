package com.ieeeportal.service;

import java.util.ArrayList;

import com.ieeeportal.entity.StudentDetailsEntity;

public interface StudentDetailsService {
	public ArrayList<StudentDetailsEntity> getallStudent();
	public ArrayList<StudentDetailsEntity> getStudent(String name);

}
