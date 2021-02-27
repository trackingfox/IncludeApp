package com.abc.service;

import java.util.List;

import com.abc.beans.Student;
import com.abc.dao.StudentDao;
import com.abc.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService {

	@Override
	public void save(Student student) {

		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		studentDao.save(student);

	}

	@Override
	public List<Student> getAllStudents() {
		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		List<Student> students = studentDao.getAllStudents();
		return students;
	}

}
