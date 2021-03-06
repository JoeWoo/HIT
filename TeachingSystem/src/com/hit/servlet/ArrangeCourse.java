package com.hit.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.DataControllor.DBControllor;

/**
 * Servlet implementation class ArrangeCourse
 */
public class ArrangeCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArrangeCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("\nbegin to arrange\n");
		String Tempid = request.getParameter("Tempid");
		String Clid = request.getParameter("Class");
		String Cstart = request.getParameter("Cstart");
		String Cend = request.getParameter("Cend");
		String Rname = new String(request.getParameter("Rname").getBytes("ISO-8859-1"),"utf-8");
		String Ctime = request.getParameter("Ctime");
		String sql = String.format("insert into SCT (Tempid,Clid)values('%s','%s')", Tempid,Clid);
		System.out.print(sql);
		DBControllor.excuteUpdate(sql);
		sql = String.format("select SCTid from SCT where Tempid='%s' and Clid='%s'", Tempid,Clid);
		ResultSet rs = DBControllor.excuteQuery(sql);
		int SCTid=-1;
		try {
			rs.next();
			SCTid = rs.getInt("SCTid");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = String.format("insert into Cweek (SCTid,Cstart,Cend) values(%d,%s,%s)", SCTid,Cstart,Cend);
		DBControllor.excuteUpdate(sql);
		sql = "select max(CweekID) tmp from Cweek";
		ResultSet rs1 = DBControllor.excuteQuery(sql);
		int cweekid = 0;
		try {
			rs1.next();
			cweekid = rs1.getInt("tmp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sql = String.format("insert into Ctime (CweekID,Cday,Cnum)values(%d,%s,%s)", cweekid,Ctime.charAt(0),Ctime.charAt(1));
		DBControllor.excuteUpdate(sql);
		sql = String.format("insert into CRoomArrange (CweekID,Rname)values(%d,'%s')", cweekid,Rname);
		DBControllor.excuteUpdate(sql);
		System.out.print("\nend to arrange\n");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
