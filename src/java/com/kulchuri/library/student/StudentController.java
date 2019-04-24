package com.kulchuri.library.student;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "StudentController", urlPatterns = { "/StudentController" })

@MultipartConfig(maxFileSize = 16177215)

public class StudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			StudentDto dto = new StudentDto();
			dto.setSname(request.getParameter("sname"));
			dto.setDob(request.getParameter("dob"));
			dto.setEmail(request.getParameter("email"));
			dto.setPwd(request.getParameter("pwd"));
			dto.setGender(request.getParameter("gender"));
			dto.setMno(request.getParameter("mno"));
			Part filePart = request.getPart("image");
			InputStream inputStream = null;
			if (filePart != null) {
				inputStream = filePart.getInputStream();
			}
			StudentDao dao = new StudentDao();
			if (dao.addStudent(dto, inputStream)) {
				RequestDispatcher rd = request.getRequestDispatcher("student/login.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("student/addStudent.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
