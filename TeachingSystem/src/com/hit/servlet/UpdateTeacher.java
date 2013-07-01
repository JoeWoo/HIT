package com.hit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.DataControllor.DBControllor;
import com.hit.DataControllor.DBDeliver;

/**
 * Servlet implementation class UpdateTeacher
 */
@WebServlet("/UpdateTeacher")
public class UpdateTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Did = new String(request.getParameter("Did").getBytes("ISO-8859-1"),"utf-8");
		String Tid = new String(request.getParameter("Tid").getBytes("ISO-8859-1"),"utf-8");
		String Ttelephone = new String(request.getParameter("tel").getBytes("ISO-8859-1"),"utf-8");
		String Tname = new String(request.getParameter("name").getBytes("ISO-8859-1"),"utf-8");
		String TpersonID = new String(request.getParameter("personid").getBytes("ISO-8859-1"),"utf-8");
		String Temail = new String(request.getParameter("email").getBytes("ISO-8859-1"),"utf-8");
		String Ttitle = new String(request.getParameter("title").getBytes("ISO-8859-1"),"utf-8");
		String Tbirthday = new String(request.getParameter("bir").getBytes("ISO-8859-1"),"utf-8");
		String Tsex = new String(request.getParameter("sex").getBytes("ISO-8859-1"),"utf-8");
		String sql = String.format("update Teacher set Did='%s',Ttelephone='%s',Tname='%s',TpersonID='%s',Temail='%s',Ttitle='%s',Tsex='%s',Tbirthday='%s' where Tid='%s';", 
				Did,Ttelephone,Tname,TpersonID,Temail,Ttitle,Tsex,Tbirthday,Tid);
		System.out.print(sql);
		DBControllor.excuteUpdate(sql);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
