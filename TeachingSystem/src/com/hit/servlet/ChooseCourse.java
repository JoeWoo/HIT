package com.hit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hit.DataControllor.DBControllor;
import com.hit.Entity.Student;

/**
 * Servlet implementation class ChooseCourse
 */
public class ChooseCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Tempid = request.getParameter("Tempid");
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("USER");
		String sql = String.format("insert into SC (Tempid,Sid,flag,Score)values('%s','%s','0',0)", Tempid,student.getID());
		DBControllor.excuteUpdate(sql);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
