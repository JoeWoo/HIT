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
import com.hit.DataControllor.DataManager;

/**
 * Servlet implementation class GetCourseOfDept
 */
public class GetCourseOfDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCourseOfDept() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Did = request.getParameter("Did");
		String sql = String.format("select Tempid,Cname from TempCourse inner join Course on TempCourse.Cid=Course.Cid inner join (select * from Major where Major.Did='%s') as M1 on M1.Mid=TempCourse.Mid where TempCourse.Term='%s'", Did,DataManager.getTerm());
		ResultSet rs = DBControllor.excuteQuery(sql);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			while(rs.next()){
				String s = String.format("<option value='%s'>%s</option>",rs.getString("Tempid"),rs.getString("Cname") );
				out.print(s);
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
