package com.hit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.DataControllor.DBControllor;
import com.hit.DataControllor.DataManager;

/**
 * Servlet implementation class GetScores
 */
public class GetScores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetScores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		String info = request.getParameter("info");
		String Sid = request.getParameter("Sid");
		String[] sList;
		sList = info.split("AAA");
		
		//System.out.print(Sid);
		boolean ff = false;
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String head ="<tr bgcolor='#CCCCCC'><td height='28'><div>" +
				"<strong>学期</strong></div></td><td><div><strong>课程号</strong></div></td>" +
				" <td width='25%'><div><strong>课程名</strong></div></td> <td width='10%'><div>" +
				"<strong>授课教师</strong></div></td><td><div><strong>类别</strong></div></td><td><div><strong>学分</strong></div></td><td><div><strong>学时</strong></div></td><td><div><strong>成绩</strong></div></td><td><div><strong>备注</strong></div></td> </tr>";
		out.print(head);
		for(String s:sList){
			String sql = String.format("select Cproperty,Course.Cid,Cname,Tname,Ctype,Ccredit,Chour,Score from TempCourse inner join " +
					"(select * from SC where SC.Sid='%s') as SC1 on TempCourse.Tempid=SC1.Tempid inner join Course on " +
					"TempCourse.Cid=Course.Cid inner join Teacher on TempCourse.Tid=Teacher.Tid where TempCourse.Term='%s'", Sid,s);
			//System.out.print(sql);
			ResultSet rs = DBControllor.excuteQuery(sql);
			try {
				if(ff)
					out.print(" <tr><td colspan='10' height='10'>&nbsp;</td></tr>");
				while(rs.next()){
					String s1 = String.format("<tr bgcolor='#C8D6FF'><td height='25'>%s</td><td>%s</td>" +
							"<td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td> </tr>", 
							DataManager.getTermString(s),rs.getString("Cid"),rs.getString("Cname"),rs.getString("Tname"),rs.getString("Ctype"),rs.getString("Ccredit"),rs.getString("Chour"),rs.getString("Score"),rs.getString("Cproperty").equals("1")?"考试":"考察");
					out.print(s1);
				}
				ff = true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
