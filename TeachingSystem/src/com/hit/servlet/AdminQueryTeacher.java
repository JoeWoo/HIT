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
 * Servlet implementation class AdminQueryTeacher
 */
public class AdminQueryTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQueryTeacher() {
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
		String sql = "select *  from Teacher inner join Dept on Teacher.Did=Dept.Did where ";
		if(!Tid.equals("nochoose")){
			sql+=String.format(" Tid='%s'", Tid);
		}
		else {
			sql+= String.format(" Dept.Did='%s'", Did);
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ResultSet rs = DBControllor.excuteQuery(sql);
		out.print("<tr bgcolor='#CCCCCC'><td height='28'><div><strong>教师编号</strong></div>" +
				"</td><td width='10%'><div><strong>姓名</strong></div></td><td ><div>" +
				"<strong>性别</strong></div></td><td ><div><strong>院系</strong></div>" +
				"</td><td ><div><strong>职称</strong></div></td><td ><div><strong>联系电话</strong></div>" +
				"</td><td><div><strong>电子邮件</strong></div></td><td><div><strong>操作</strong></div></td>" +
				"</tr>");
		try {
			int row = 0;
			while(rs.next()){
				String s = String.format("<tr id='row%d' bgcolor='#C8D6FF'><td height='25'>%s</td>" +
						"<td>%s</td><td>%s</td><td>%s</td><td>%s</td>" +
						"<td>%s</td><td>%s</td><td><a href='#' onclick='edit1(\"row%d\");return false;'>查看</a>&nbsp;" +
						"<a href='#'>评教结果</a></td> </tr><input id='inforow%d' type='hidden' value='%s#%s#%s'>", row,
						rs.getString("Tid"),rs.getString("Tname"),rs.getString("Tsex"),rs.getString("Dname"),rs.getString("Ttitle"),
						rs.getString("Ttelephone"),rs.getString("Temail"),row,row,rs.getString("Tbirthday"),rs.getString("TpersonID"),rs.getString("Did"));
				row++;
				
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
