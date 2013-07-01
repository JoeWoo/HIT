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

/**
 * Servlet implementation class HasCourse
 */
public class HasCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HasCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Rname = new String(request.getParameter("Rname").getBytes("ISO-8859-1"),"utf-8");
		String Cweek = request.getParameter("Cweek");
		if(!DBControllor.isConnected())
			DBControllor.connctTo("TeachingDB");
		ArrayList<String> aList = DataManager.getCourseTimeList(Rname, Cweek);
		PrintWriter out = response.getWriter();
		if(aList.size()!=0){
			out.print(aList.get(0));
			for(int i=1; i<aList.size(); i++){
				out.print("#"+aList.get(i));
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
