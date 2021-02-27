package com.abc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abc.beans.Student;
import com.abc.factory.ConnectionFactory;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void save(Student student) {

		// logic for saving data in database

		Connection connection = ConnectionFactory.getConnectionObj();

		if (connection != null) {

			String sid = student.getSid();
			String sname = student.getSname();
			String saddress = student.getSaddress();

			sid = "'" + sid + "'";
			sname = "'" + sname + "'";
			saddress = "'" + saddress + "'";

			try {
				Statement statement = connection.createStatement();

				int rowAffected = statement.executeUpdate(
						"insert into student1(sid,sname,saddress) values (" + sid + "," + sname + "," + saddress + ")");

				System.out.println("No of row Affected is :: " + rowAffected);

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public List<Student> getAllStudents() {

		Connection connection = ConnectionFactory.getConnectionObj();
		List<Student> studentList = null;

		if (connection != null) {

			Statement statement;
			try {
				statement = connection.createStatement();
				if (statement != null) {

					ResultSet resultSet = statement.executeQuery("select * from student1");

					if (resultSet != null) {

						// Create the ArrayList Object
						studentList = new ArrayList<Student>();

						while (resultSet.next()) {

							Student student = new Student();
							student.setSid(resultSet.getString(1));
							student.setSname(resultSet.getString(2));
							student.setSaddress(resultSet.getString(3));

							// copy the data into List<Student> object
							studentList.add(student);
						}

					}

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return studentList;
	}

}
