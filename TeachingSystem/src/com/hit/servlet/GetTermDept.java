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
 * Servlet implementation class GetTermDept
 */
public class GetTermDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTermDept() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Tid = request.getParameter("Tid");
		String Term = request.getParameter("Term");
		String sql = String.format("select distinct Major.Mid,Major.Mname,Dept.Did,Dept.Dname from (select * from TempCourse where TempCourse.Term='%s' and TempCourse.Tid='%s')" +
				" as T1 inner join (Major inner join Dept on Major.Did=Dept.Did) on T1.Mid=Major.Mid", Term,Tid);
		ResultSet rs = DBControllor.excuteQuery(sql);
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		try {
			//out.print("<option value='nochoose'>-Î´Ñ¡Ôñ-</option>");
			while(rs.next()){
				String s = String.format("<option value='%s'>%s</option>", rs.getString("Mid"),rs.getString("Mname"));
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
