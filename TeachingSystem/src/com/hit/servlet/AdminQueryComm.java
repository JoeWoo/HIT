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
 * Servlet implementation class AdminQueryComm
 */
public class AdminQueryComm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQueryComm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Did = request.getParameter("Did");
		String Tid = request.getParameter("Tid");
		String Term = request.getParameter("Term");
		String sql = "select Tempid,Tname,Course.Cid,Cname,Ctype,Ccredit,Chour from TempCourse inner join Teacher on " +
				"Teacher.Tid=TempCourse.Tid inner join Course on Course.Cid=TempCourse.Cid " +
				String.format("where Teacher.Tid='%s' and Term='%s'", Tid,Term);
		System.out.print(sql);
		ResultSet rs = DBControllor.excuteQuery(sql);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<tr bgcolor='#CCCCCC'><td height='28'><div><strong>学期</strong></div></td>" +
				"<td><div><strong>课程号</strong></div></td><td width='25%'><div><strong>课程名</strong>" +
				"</div></td><td width='10%'><div><strong>授课教师</strong></div></td> <td><div><strong>" +
				"类别</strong></div></td><td><div><strong>学分</strong></div></td><td><div><strong>学时" +
				"</strong></div></td><td><div><strong>教学评价</strong></div></td><td><div><strong>备注" +
				"</strong></div></td></tr>");
		try {
			String[] types = {"必修","全校任选","英语","体育"};
			while(rs.next()){
				String tmp = String.format("<tr bgcolor='#C8D6FF'> <td height='25'>%s</td><td>" +
						"%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s" +
						"</td><td>%s</td><td></td></tr>", DataManager.getTermString(Term),rs.getString("Cid"),rs.getString("Cname"),
						rs.getString("Tname"),types[Integer.parseInt(rs.getString("Ctype"))-1],rs.getString("Ccredit"),
						rs.getString("Chour"),DataManager.getLevel(Tid, Term, rs.getString("Tempid")));
				out.print(tmp);
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
