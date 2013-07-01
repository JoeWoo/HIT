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
 * Servlet implementation class AdminQueryStudent
 */
public class AdminQueryStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQueryStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Did = request.getParameter("Did");
		String Mid = request.getParameter("Mid");
		String Syear = request.getParameter("Syear");
		String Sid  =request.getParameter("Sid");
		String sql = "select Student.Sid,Student.Sname,Student.Ssex,Dept.Did,Dept.Dname,Student.Saddress,Major.Mname,Major.Mid,Student.Sclass," +
				"Student.SpersonID,Student.Sbirthday,Student.Stelephone,Student.Semail from Student inner join Dept on Student.Did = Dept.Did inner join Major" +
				" on Student.Mid=Major.Mid where";
		
		if(Sid.equals("nochoose")){
			boolean flag = false;
			if(!Did.equals("nochoose")){
				flag = true;
				sql+=String.format(" Dept.Did='%s'",Did);
			}
			if(!Mid.equals("nochoose")){
				if(flag)sql+=" and ";
				flag = true;
				sql+=String.format(" Student.Mid='%s'", Mid);
			}
			if(flag) sql+=" and ";
			sql+=String.format(" Student.Syear='%s'",Syear);
		}else {
			sql+=String.format(" Student.Sid='%s'", Sid);
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<tr bgcolor='#CCCCCC'><td height='28'><div><strong>学号</strong></div></td>" +
				"<td width='10%'><div><strong>姓名</strong></div></td><td ><div><strong>性别</strong></div>" +
				"</td><td ><div><strong>院系</strong></div></td><td ><div><strong>专业</strong></div></td> " +
				"<td ><div><strong>班级</strong></div></td> <td><div><strong>电子邮件</strong></div></td> " +
				"<td><div><strong>操作</strong></div></td> </tr>");
		ResultSet rs = DBControllor.excuteQuery(sql);
		try {
			int row = 0;
			while(rs.next()){
				String s = String.format("<tr bgcolor='#C8D6FF' id='row%d'><td height='25'>%s</td><td>%s</td>" +
						"<td>%s</td><td>%s</td><td>%s</td><td>%s</td>" +
						"<td>%s</td><td><a href='#' onclick='edit(\"row%d\");return false;'>查看</a> </td> </tr><input id='inforow%d' type='hidden' value='%s#%s#%s#%s'>", row,
						rs.getString("Sid"),rs.getString("Sname"),rs.getString("Ssex"),rs.getString("Dname"),rs.getString("Mname"),
						rs.getString("Sclass"),rs.getString("Semail"),row,row++,rs.getString("Stelephone"),rs.getString("Saddress"),rs.getString("SpersonID"),rs.getString("Sbirthday"));
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
