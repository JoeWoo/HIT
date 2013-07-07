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
 * Servlet implementation class UpdateAdmin
 */
@WebServlet("/UpdateAdmin")
public class UpdateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Did = new String(request.getParameter("Did").getBytes("ISO-8859-1"),"utf-8");
		String Aid = new String(request.getParameter("Aid").getBytes("ISO-8859-1"),"utf-8");
		String Atelephone = new String(request.getParameter("Atelephone").getBytes("ISO-8859-1"),"utf-8");
		String Aname = new String(request.getParameter("Aname").getBytes("ISO-8859-1"),"utf-8");
		String ApersonID = new String(request.getParameter("ApersonID").getBytes("ISO-8859-1"),"utf-8");
		String Aemail = new String(request.getParameter("Aemail").getBytes("ISO-8859-1"),"utf-8");
		//String ttitle = new String(request.getParameter("title").getBytes("ISO-8859-1"),"utf-8");
		String Abirthday = new String(request.getParameter("Abirthday").getBytes("ISO-8859-1"),"utf-8");
		String Asex = new String(request.getParameter("Asex").getBytes("ISO-8859-1"),"utf-8");
		String Aphoto = new String("#");
		String sql = String.format("update Administrator set Aname='%s',Aemail='%s',Atelephone='%s',ApersonID='%s',Aphoto='%s',Asex='%s',Abirthday='%s',Did='%s' where Aid='%s';", 
				Aname,Aemail,Atelephone,ApersonID,Aphoto,Asex,Abirthday,Did,Aid);
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
