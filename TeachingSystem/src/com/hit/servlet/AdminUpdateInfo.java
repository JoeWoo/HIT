package com.hit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.DataControllor.DBControllor;

/**
 * Servlet implementation class AdminUpdateInfo
 */
@WebServlet("/AdminUpdateInfo")
public class AdminUpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateInfo() {
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
		String Atelephone = new String (request.getParameter("telephone").getBytes("ISO-8859-1"),"utf-8");
		String Aemail = new String (request.getParameter("email").getBytes("ISO-8859-1"),"utf-8");
		//String Taddress = new String (request.getParameter("address").getBytes("ISO-8859-1"),"utf-8");
		String Aid = new String (request.getParameter("Aid").getBytes("ISO-8859-1"),"utf-8"); 
		String sql = String.format("update Administrator set Atelephone='%s',Aemail='%s' where Aid='%s'"
				,Atelephone,Aemail,Aid);
		System.out.print(sql);
		DBControllor.excuteUpdate(sql);
		response.sendRedirect("login.html");
	}

}
