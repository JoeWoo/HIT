package com.hit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.DataControllor.DBControllor;
import com.hit.DataControllor.DataManager;
import com.hit.Entity.CourseInfo;

/**
 * Servlet implementation class CourseList
 */
public class CourseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(!DBControllor.isConnected())
			DBControllor.connctTo("TeachingDB");
		response.setContentType("application/javascript; charset=utf-8");
		String Major = request.getParameter("major");
		String Class = request.getParameter("class");
		String Term = DataManager.getTerm();
		ArrayList<CourseInfo> cList = DataManager.getCourseInfos(Class, Term);
		PrintWriter out = response.getWriter();
		//out.print("<script type='text/javascript'>");
		for(CourseInfo cInfo:cList){
			String ID = cInfo.getCday()+""+cInfo.getCnum();
			String value = cInfo.getCname()+"#--#"+cInfo.getTname()+"#--#"+cInfo.getRname()+"#--#"+cInfo.getCstart()+"#--#"+cInfo.getCend()+"#--#÷‹";
			out.print("setCourse('"+ID+"','"+value+"');");
		}
		//out.print("</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
