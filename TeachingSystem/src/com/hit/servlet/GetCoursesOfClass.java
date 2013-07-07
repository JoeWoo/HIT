package com.hit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.DataControllor.DataManager;

/**
 * Servlet implementation class GetCoursesOfClass
 */
@WebServlet("/GetCoursesOfClass")
public class GetCoursesOfClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCoursesOfClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Class = new String(request.getParameter("Class").getBytes("ISO-8859-1"),"utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			ArrayList<String> result = DataManager.getCoursesOfClass(Class);
			for(String info:result){
				String[] tmp = info.split("@@@");
				String tmp0 = String.format("<option value='%s'>%s<input type='hidden' id='%s' value='%s'>" +
						"</option>", tmp[0],tmp[1],tmp[0],tmp[2]);
				out.print(tmp0);
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
