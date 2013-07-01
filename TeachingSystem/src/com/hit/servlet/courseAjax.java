package com.hit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.DataControllor.DBControllor;
import com.hit.DataControllor.DataManager;
import com.hit.Entity.Course;
import com.hit.Entity.Teacher;

/**
 * Servlet implementation class courseAjax
 */
public class courseAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public courseAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Cday = new String(request.getParameter("day").getBytes("ISO-8859-1"),"utf-8");
		String Cnum = new String(request.getParameter("num").getBytes("ISO-8859-1"),"utf-8");
		String Rname = new String(request.getParameter("classroom").getBytes("ISO-8859-1"),"utf-8");
		String week = new String(request.getParameter("week").getBytes("ISO-8859-1"),"utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(!DBControllor.isConnected())
			DBControllor.connctTo("TeachingDB");
		Course course = DataManager.getCourseInRoom(Rname, Cday, Cnum,week);
		Teacher teacher = DataManager.getTeacherOfCourseByCid(course.getCid());
		
		String Tid = "";
		String Tname = "";
		String Ttitle = "";
		String Ttelephone = "";
		String Temail = "";
		if(teacher!=null)
		{
			Tid = teacher.getID();
			Tname = teacher.getName();
			Ttitle = teacher.getTtitle();
			Ttelephone = teacher.getTelephone();
			Temail = teacher.getEmail();
		}
		String result = String.format("%s#%s#%s#%s#%s#%s#%s#%s#%s", course.getCname(),course.getCid(),course.getCcredit(),course.getChour(),Tid,Tname,Ttitle,Ttelephone,Temail);
		out.print(result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
