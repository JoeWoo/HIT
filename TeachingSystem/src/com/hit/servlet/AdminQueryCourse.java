package com.hit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hit.DataControllor.DBControllor;
import com.hit.DataControllor.DBDeliver;
import com.hit.Entity.Administrator;

/**
 * Servlet implementation class AdminQueryCourse
 */
public class AdminQueryCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQueryCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.print("aaaaa");
		String[] types = {"必修","全校任选","英语","体育"};
		String Ctype = request.getParameter("Ctype");
		String Mid = request.getParameter("Mid");
		String Did = request.getParameter("Did");
		String Term = request.getParameter("Term");
		String sql = String.format("select Course.Cid,Cname,Dname,Mname,Dept.Did,Major.Mid,Tname,Teacher.Tid,Ctype,Chour,Ccredit,Cproperty,Tempid " +
		"from(select * from TempCourse where TempCourse.Term='%s') " +
		"as T1 inner join Teacher on T1.Tid = Teacher.Tid inner join " +
		"(Major inner join Dept on Major.Did=Dept.Did) on T1.Mid = Major.Mid inner join Course on " +
		"T1.Cid = Course.Cid where",Term);
		boolean flag = false;
		if(!Ctype.equals("0")){
			sql+=String.format("Ctype='%s'",Ctype);
			flag = true;
		}
		if(!Mid.equals("000")){
			if(flag) sql+=" and ";
			sql+=String.format(" T1.Mid = '%s'",Mid);
			flag = true;
		}
		if(flag) sql+=" and ";
		sql+=String.format(" T1.Term='%s'",Term);
		System.out.print(sql);
		ResultSet rs = DBControllor.excuteQuery(sql);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String s0 = "<tr bgcolor='#CCCCCC'> <td height='28'><div><strong>课程号</strong></div></td>"+
		"<td ><div><strong>课程名</strong></div></td>"+"<td ><div><strong>院系</strong></div></td>"+
		" <td ><div><strong>专业</strong></div></td>"+" <td ><div><strong>授课教师</strong></div></td>"+
		"<td><div><strong>类型</strong></div></td>"+	"<td><div><strong>学时</strong></div></td>"+
		"<td><div><strong>学分</strong></div></td>"+"<td><div><strong>备注</strong></div></td>"+
		"<td><div><strong>操作</strong></div></td></tr>";
		out.print(s0);
		HttpSession session = request.getSession();
		Administrator administrator = (Administrator)session.getAttribute("USER");
		boolean ff = false;
		if(administrator.getDid().equals("00"))
			ff = true;
		try {
			int row = 0;
			while(rs.next()){
			s0 = String.format("<tr bgcolor='#C8D6FF' id='%d'><td height='25'>%s</td><td>%s</td><td>%s</td><td>%s</td>"+
			"<td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>",row,rs.getString("Cid"),rs.getString("Cname"),rs.getString("Dname"),rs.getString("Mname"),
			rs.getString("Tname"),types[Integer.parseInt(rs.getString("Ctype"))-1],rs.getString("Chour"),rs.getString("Ccredit"),
			rs.getString("Cproperty"));
			if(ff)
				s0+=String.format("<a href='' onclick='edit(\"%d\"); return false;'>编辑</a>&nbsp;"+
			"&nbsp;</td> </tr><input id='info%d' type='hidden' value='%s#%s#%s#%s#%s'/>",
			row,row++,rs.getString("Tid"),rs.getString("Ctype"),rs.getString("Did"),rs.getString("Mid"),rs.getString("Tempid"));
			else 
				s0+=String.format("<a href='setTimetable.jsp?Tempid=%s&Cid=%s&Cname=%s&Tid=%s' return false;'>排课</a>&nbsp;"+
						"&nbsp;</td> </tr><input id='info%d' type='hidden' value='%s#%s#%s#%s#%s'/>",
						rs.getString("Tempid"),rs.getString("Cid"),rs.getString("Cname"),rs.getString("Tid"),row++,rs.getString("Tid"),rs.getString("Ctype"),rs.getString("Did"),rs.getString("Mid"),rs.getString("Tempid"));
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
