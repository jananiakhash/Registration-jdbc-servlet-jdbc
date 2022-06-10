package com.n2s.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.n2s.registration.dao.StudentDao;
import com.n2s.registration.model.Student;

/**
 * Servlet implementation class StudentServelet
 */
@WebServlet("/register")
public class StudentServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDao dao=new StudentDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   public StudentServelet() {
	   super();
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/view/studentregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
	       String Username = request.getParameter("0");
	       String password = request.getParameter("password");
	       
	       Student student = new Student();
	     
	       student.setId(id);
	       student.setUser_name(Username);
	       student.setPassword(password);
	       try {
	            dao.registerStudent(student);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	       RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/view/studentdetails.jsp");
			dispatcher.forward(request, response);
	}

}
