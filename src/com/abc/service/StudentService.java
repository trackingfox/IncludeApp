package com.abc.service;

import java.util.List;

import com.abc.beans.Student;

public interface StudentService {
	
	public void save(Student student);
	
	public List<Student> getAllStudents();

}
