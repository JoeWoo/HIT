package com.hit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hit.DataControllor.DataManager;
import com.hit.Entity.CourseInfo;
import com.hit.Entity.Teacher;

/**
 * Servlet implementation class CourseListOfTeacher
 */
public class CourseListOfTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseListOfTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Term = request.getParameter("Term");
		response.setContentType("application/javascript; charset=utf-8");
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("USER");
		ArrayList<CourseInfo> cList = DataManager.getCourseInfosOfTeacher( Term,teacher.getID());
		PrintWriter out = response.getWriter();
		//out.print("<script type='text/javascript'>");
		for(CourseInfo cInfo:cList){
			String ID = cInfo.getCday()+""+cInfo.getCnum();
			String value = cInfo.getCname()+"#--#"+cInfo.getTname()+"#--#"+cInfo.getRname()+"#--#"+cInfo.getCstart()+"#--#"+cInfo.getCend()+"#--#÷‹";
			out.print("setCourse('"+ID+"','"+value+"');");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
