package com.abc.dao;

import java.util.List;

import com.abc.beans.Student;

public interface StudentDao {
	public void save(Student student);

	public List<Student> getAllStudents();
}
