package com.hit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hit.DataControllor.DBControllor;
import com.hit.DataControllor.DBDeliver;
import com.hit.DataControllor.DataManager;
import com.hit.Entity.Administrator;
import com.hit.Entity.Student;
import com.hit.Entity.Teacher;
import com.hit.Entity.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(!DBControllor.isConnected())
        	DBControllor.connctTo("TeachingDB");
		String table = request.getParameter("type");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(DBDeliver.checkLogin(username, password, table)){
			HttpSession session = request.getSession();
			if(table.equals("Student")){
				User student = DataManager.getStudentByID(username);
				session.setAttribute("USER", student);
				session.setAttribute("type", "Student");
				response.sendRedirect("student.jsp");
			}else if(table.equals("Teacher")){
				User teacher = DataManager.getTeacherByID(username);
				session.setAttribute("USER", teacher);
				session.setAttribute("type", "Teacher");
				response.sendRedirect("teacher.jsp");
			}else {
				User administrator = DataManager.getAdministratorByID(username);
				session.setAttribute("USER", administrator);
				session.setAttribute("type", "Administrator");
				response.sendRedirect("admin.jsp");
			}
		}else {
			response.sendRedirect("login.html");
		}
	}

}
