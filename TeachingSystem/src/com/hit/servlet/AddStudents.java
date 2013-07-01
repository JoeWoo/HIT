package com.hit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.DataControllor.DBControllor;
import com.hit.Entity.Student;

/**
 * Servlet implementation class AddStudents
 */
public class AddStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Sid = new String(request.getParameter("Sid").getBytes("ISO-8859-1"),"utf-8");
		String Mid = new String(request.getParameter("Mid").getBytes("ISO-8859-1"),"utf-8");
		String Did = new String(request.getParameter("Did").getBytes("ISO-8859-1"),"utf-8");
		String Sclass = new String(request.getParameter("Sclass").getBytes("ISO-8859-1"),"utf-8");
		String Semail = new String(request.getParameter("Semail").getBytes("ISO-8859-1"),"utf-8");
		String Stelephone = new String( request.getParameter("Stelephone").getBytes("ISO-8859-1"),"utf-8");
		String Ssex = new String( request.getParameter("Ssex").getBytes("ISO-8859-1"),"utf-8");
		String Sname = new String( request.getParameter("Sname").getBytes("ISO-8859-1"),"utf-8");
		String Sbirthday =  new String(request.getParameter("Sbirthday").getBytes("ISO-8859-1"),"utf-8");
		String Saddress =  new String(request.getParameter("Saddress").getBytes("ISO-8859-1"),"utf-8");
		String Syear =  new String(request.getParameter("Syear").getBytes("ISO-8859-1"),"utf-8");
		String SpersonID =  new String(request.getParameter("SpersonID").getBytes("ISO-8859-1"),"utf-8");
		
		String Spassword = new String(Sid);
		String sql = String.format("insert into Student(Sid,Spassword,Sname,Mid,Did,Sclass,Semail,Stelephone,Ssex,Sbirthday,Saddress,Syear,SpersonID)values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')", 
				Sid,Spassword,Sname,Mid,Did,Sclass,Semail,Stelephone,Ssex,Sbirthday,Saddress,Syear,SpersonID);
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
