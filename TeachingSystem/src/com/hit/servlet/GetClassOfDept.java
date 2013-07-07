package com.hit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.DataControllor.DBControllor;

/**
 * Servlet implementation class GetClassOfDept
 */
public class GetClassOfDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetClassOfDept() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Did = request.getParameter("Did");
		String Mid = request.getParameter("Mid");
		String Syear = request.getParameter("Syear");
		String sql=new String("select distinct Sclass from Student where ");
		if(Did!=null && !Did.equals("nochoose"))
		{
			sql += ("Did='"+Did+"' ");
		}
		if(Mid!=null && !Mid.equals("nochoose"))
		{
			sql += ("and Mid='"+Mid+"' ");
		}
		if(Syear!=null && !Syear.equals("nochoose"))
		{
			sql += ("and Syear='"+Syear+"' ");
		}
		System.out.print(sql);
		ResultSet rs = DBControllor.excuteQuery(sql);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			while(rs.next()){
				String s = String.format("<option value='%s'>%s</option>", rs.getString("Sclass"),rs.getString("Sclass"));
				out.print(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
