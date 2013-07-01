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
 * Servlet implementation class GetStudentOfTeacher
 */
public class GetStudentOfTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStudentOfTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Tid = request.getParameter("Tid");
		String Cid = request.getParameter("Cid");
		String Term = request.getParameter("Term");
		String sql = String.format("select Student.Sid,Student.Sname,Dept.Dname,Major.Mname,Score " +
				"from (select * from TempCourse where TempCourse.Cid='%s' and TempCourse.Term='%s' " +
				"and TempCourse.Tid='%s') as T1 inner join  (SC inner join Student on SC.Sid=Student.Sid) on " +
				"SC.Tempid=T1.Tempid inner join (Major inner join Dept on Major.Did=Dept.Did) on T1.Mid=Major.Mid", Cid,Term,Tid);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ResultSet rs = DBControllor.excuteQuery(sql);
		String s0="<tr bgcolor='#CCCCCC'><td height='28'><div><strong>���</strong></div></td>" +
				"<td ><div><strong>ѧ��</strong></div></td><td ><div><strong>����</strong></div></td>" +
				"<td ><div><strong>Ժϵ</strong></div></td> <td ><div><strong>רҵ</strong></div></td> " +
				"<td ><div><strong>�ɼ�</strong></div></td>" +
				" <td><div><strong>����</strong></div></td></tr>";
		out.print(s0);
		try {
			int cnt = 1;
			while(rs.next()){
				String s = String.format("<tr bgcolor='#C8D6FF'> <td height='25'>%d</td><td>%s</td>" +
						"<td>%s</td> <td>%s</td> <td>%s</td>  <td>%s</td>" +
						"<td>&nbsp;<a href=''>���ѡ��</a> </td></tr>", 
						cnt++,rs.getString("Sid"),rs.getString("Sname"),rs.getString("Dname"),rs.getString("Mname"),rs.getString("Score"));
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
