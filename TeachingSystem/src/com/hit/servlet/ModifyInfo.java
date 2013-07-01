package com.hit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hit.DataControllor.DBDeliver;
import com.hit.Entity.User;

/**
 * Servlet implementation class ModifyInfo
 */
public class ModifyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("USER");
		String type = session.getAttribute("type").toString();
		DBDeliver.updateInfo(email, telephone, user.getID(), type);
		user.setEmail(email);
		user.setTelephone(telephone);
		session.setAttribute("USER", user);
		response.sendRedirect("TeacherInfo.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
