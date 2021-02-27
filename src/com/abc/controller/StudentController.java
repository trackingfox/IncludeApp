package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.beans.Student;
import com.abc.factory.StudentServiceFactory;
import com.abc.service.StudentService;

@WebServlet("/save")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String saddress = request.getParameter("saddress");

		Student student = new Student();

		student.setSid(sid);
		student.setSname(sname);
		student.setSaddress(saddress);

		StudentService studentService = StudentServiceFactory.getStudentService();
		studentService.save(student);

		List<Student> students = studentService.getAllStudents();

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1 style='color:red; text-align:center;'>Aradhya Brilliance Center</h1>");
		out.println("<h2 style='color:blue; text-align:center;'>Student Registration details</h1>");

		out.println("<table border='1' align='center'>");
		out.println("<tr><td>SID</td><td>SNAME</td><td>SADDRESS</td></tr>");

		for (Student tempStudent : students) {
			out.println("<tr>");
			out.println("<td>" + tempStudent.getSid() + "</td>");
			out.println("<td>" + tempStudent.getSname() + "</td>");
			out.println("<td>" + tempStudent.getSaddress() + "</td>");
			out.println("</tr>");

		}
		out.println("</table>");
		out.print("</body></html>");

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		dispatcher.include(request, response);

		out.close();
	}

}
