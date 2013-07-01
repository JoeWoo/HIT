package com.hit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hit.DataControllor.DBControllor;
import com.hit.Entity.Teacher;

/**
 * Servlet implementation class GetCourseOfTerm
 */
public class GetCourseOfTerm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCourseOfTerm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.print("sadas");
		String Term = request.getParameter("Term");
		String Tid = request.getParameter("Tid");
		String sql = String.format("select TempCourse.Cid,Cname from TempCourse inner join Course on TempCourse.Cid=Course.Cid " +
				"where TempCourse.Term='%s' and TempCourse.Tid='%s'", Term,Tid);
		ResultSet rs = DBControllor.excuteQuery(sql);
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		try {
			//out.print("<option value='nochoose'>-Î´Ñ¡Ôñ-</option>");
			while(rs.next()){
				String s = String.format("<option value='%s'>%s</option>", rs.getString("Cid"),rs.getString("Cname"));
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
