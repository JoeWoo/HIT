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
 * Servlet implementation class GetStudentandScores
 */
public class GetStudentandScores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStudentandScores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Term = request.getParameter("Term");
		String Tid = request.getParameter("Tid");
		String Cid = request.getParameter("Cid");
		String sql = String.format("select Student.Sid,Student.Sname,Dept.Dname,Major.Mname,Score,T1.Tempid " +
				"from (select * from TempCourse where TempCourse.Cid='%s' and TempCourse.Term='%s' " +
				"and TempCourse.Tid='%s') as T1 inner join  (SC inner join Student on SC.Sid=Student.Sid) on " +
				"SC.Tempid=T1.Tempid inner join (Major inner join Dept on Major.Did=Dept.Did) on T1.Mid=Major.Mid", Cid,Term,Tid);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ResultSet rs = DBControllor.excuteQuery(sql);
		String s  = "<tr bgcolor='#CCCCCC'><td height='28'><div><strong>编号</strong></div></td>" +
				"<td ><div><strong>学号</strong></div></td><td ><div><strong>姓名</strong></div></td>" +
				"<td ><div><strong>院系</strong></div></td> <td ><div><strong>专业</strong></div></td> " +
				"<td ><div><strong>成绩</strong></div></td> </tr>";
		out.print(s);
		String Tempid = "";
		try { 
			int cnt = 1;
			while(rs.next()){
				String s0 = String.format("<tr id='tr%d' bgcolor='#C8D6FF'><td height='25'>%d</td>" +
						"<td name='Sid%d' value='%s'>%s</td><td>%s</td><td>%s</td><td>%s</td>" +
						"<td><input name='text%d'  type='text' style='width:22px;' onkeyup='check(\"tr%d\",\"text%d\")' value='%s'/></td></tr>"+
						"<input type='hidden' value='%s' name='Sid%d'/>", 
						cnt,cnt,cnt,rs.getString("Sid"),rs.getString("Sid"),rs.getString("Sname"),rs.getString("Dname"),rs.getString("Mname"),cnt,cnt,cnt,rs.getString("Score"),rs.getString("Sid"),cnt);
				cnt++;
				out.print(s0);
				Tempid = rs.getString("Tempid");
			}
			out.print(String.format(("<input name='Tempid' type='hidden' value='%s'>"),Tempid));
			out.print(String.format(("<input name='lines' type='hidden' value='%d'>"),cnt));
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
