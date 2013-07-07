package com.hit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.DataControllor.DataManager;
import com.hit.Entity.AdminInfo;

/**
 * Servlet implementation class GetAdmin
 */
@WebServlet("/GetAdmin")
public class GetAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String did = new String(request.getParameter("did").getBytes("ISO-8859-1"),"utf-8");
		String aid = new String(request.getParameter("aid").getBytes("ISO-8859-1"),"utf-8");
		
		//response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(" <tbody> <tr bgcolor='#CCCCCC'> <td height='28'><div><strong>账号</strong></div></td> " +
				"<td width='10%'><div><strong>姓名</strong></div></td><td ><div><strong>性别</strong></div></td>" +
				"<td ><div><strong>院系</strong></div></td><td ><div><strong>联系电话</strong></div></td> " +
				"<td><div><strong>电子邮件</strong></div></td><td><div><strong>操作</strong></div></td></tr>");
		try {
			ArrayList<AdminInfo> result = DataManager.getAdminInfos(did, aid);
			int row=0;
			for(AdminInfo ai:result){
				
				String tmp = String.format("<tr bgcolor='#C8D6FF' id='row%d'><td height='25'>%s</td><td>%s</td>" +
						"<td>%s</td><td>%s</td> <td>%s</td><td>%s</td>" +
						"<td><a href='#' onclick='edit1(\"%s\");'>编辑</a>&nbsp;<a href='#' onclick='deleteAdmin(\"%s\");'>删除</a></td></tr>"+
						"<input id='inforow%d' type='hidden' value='%s#%s#%s'/>",row, ai.getAid(),ai.getAname(),
						ai.getAsex(),ai.getDname(),ai.getTelephone(),ai.getEmail(),"row"+row,"row"+row,row,ai.getBirthday().toString().split(" ")[0],ai.getPersonID(),ai.getDid());
				row++;
				out.print(tmp);
			}
			out.print("</tbody>");
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
