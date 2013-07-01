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
 * Servlet implementation class GetDeptCourse
 */
public class GetDeptCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDeptCourse() {
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
		String Mid = request.getParameter("Mid");
		String sql = String.format("select TempCourse.Term,Major.Mname, TempCourse.Mid,TempCourse.Cid,Dept.Dname,Course.Cname,Course.Ctype,Course.Chour,Course.Ccredit,Course.Cproperty from TempCourse inner join Course on TempCourse.Cid=Course.Cid inner join Major on Major.Mid=TempCourse.Mid inner join Dept on Major.Did=Dept.Did inner join SC on TempCourse.Tempid=SC.Tempid where Term='%s' and TempCourse.Mid='%s' and Tid='%s'", Term,Mid,Tid);
		System.out.print(sql);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String s="<tr bgcolor='#CCCCCC'><td height='28'><div><strong>学期</strong></div></td><td ><div><strong>课程号</strong></div></td><td ><div><strong>课程名</strong></div></td><td ><div><strong>院系</strong></div></td><td >" +
				"<div><strong>专业</strong></div></td><td><div><strong>类型</strong></div></td><td><div><strong>学时</strong></div>"+
"<td><div><strong>学分</strong></div></td><td><div><strong>备注</strong></div></td>" +
" </tr>";
		out.print(s);
		String[] sssStrings={"必修","全校任选","英语","体育"};
		ResultSet rs = DBControllor.excuteQuery(sql);
		try {
			while(rs.next()){
				String s0 = String.format("<tr bgcolor='#C8D6FF'><td height='25'>%s</td>" +
						"<td>%s</td><td>%s</td><td>%s</td>" +
						"<td>%s</td><td>%s</td> <td>%s</td><td>%s</td><td>%s</td>" +
						"</tr>", DataManager.getTermString(rs.getString("Term")),rs.getString("Cid"),
						rs.getString("Cname"),rs.getString("Dname"),rs.getString("Mname"),sssStrings[Integer.parseInt(rs.getString("Ctype"))-1],
						rs.getString("Chour"),rs.getString("Ccredit"),rs.getString("Cproperty").equals("1")?"考试":"考察"
								);
				out.print(s0);
				
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
