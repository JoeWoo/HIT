package com.hit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.DataControllor.DBDeliver;

/**
 * Servlet implementation class AddAdmin
 */
@WebServlet("/AddAdmin")
public class AddAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String did = new String(request.getParameter("Did").getBytes("ISO-8859-1"),"utf-8");
		String ID = new String(request.getParameter("Aid").getBytes("ISO-8859-1"),"utf-8");
		String telephone = new String(request.getParameter("tel").getBytes("ISO-8859-1"),"utf-8");
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"utf-8");
		String personID = new String(request.getParameter("personid").getBytes("ISO-8859-1"),"utf-8");
		String email = new String(request.getParameter("email").getBytes("ISO-8859-1"),"utf-8");
		//String ttitle = new String(request.getParameter("title").getBytes("ISO-8859-1"),"utf-8");
		String birthday = new String(request.getParameter("bir").getBytes("ISO-8859-1"),"utf-8");
		String sex = new String(request.getParameter("sex").getBytes("ISO-8859-1"),"utf-8");
		DBDeliver.insertAdministrator(ID, "123456", name, email, telephone, personID, "asd", sex, birthday, did);
		//DBDeliver.insertTeacher(ID, "123456", name, email, telephone, personID, "", sex, birthday, did, ttitle);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
