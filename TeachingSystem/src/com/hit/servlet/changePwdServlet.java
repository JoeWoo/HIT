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

/**
 * Servlet implementation class changePwdServlet
 */
public class changePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changePwdServlet() {
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
        HttpSession session = request.getSession();
		String type = session.getAttribute("type").toString();
		String id = session.getAttribute("type").toString();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String password3 = request.getParameter("password3");
		if(!password2.equals(password3)){
			
			
		}
//		if(DBDeliver.checkLogin(username, password, table)){
//			if(table.equals("Student")){
//				Student student = DataManager.getStudentByID(username);
//				session.setAttribute("USER", "Student");
//			}else if(table.equals("Teacher")){
//				Teacher teacher = DataManager.getTeacherByID(username);
//				session.setAttribute("USER", "Teacher");
//			}else {
//				Administrator administrator = DataManager.getAdministratorByID(username);
//				session.setAttribute("USER", "Administrator");
//			}
//		}else {
//			
//		}
//		boolean result = DBDeliver.updatePwd(id, password2, type);
//		if(!result){
//			
//		}

	}

}
