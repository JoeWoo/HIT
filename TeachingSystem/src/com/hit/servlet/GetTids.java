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
 * Servlet implementation class GetTids
 */
public class GetTids extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTids() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Did = request.getParameter("Did");
		ResultSet rs = DBControllor.excuteQuery("select Tid from Teacher where Did='"+Did+"'");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			while(rs.next()){
				String s = String.format("<option value='%s'>%s</option>", rs.getString("Tid"),rs.getString("Tid"));
				out.print(s);
			}
		} catch (SQLException e) {
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
