package com.hit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hit.DataControllor.DBControllor;
import com.hit.Entity.Student;

/**
 * Servlet implementation class Comment
 */
public class Comment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Comment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Tempid = request.getParameter("Tempid0");
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("USER");
		String Sid = student.getID();
		String result = request.getParameter("re0");
		for(int i=1; i<10; i++){
			result+="#"+request.getParameter("re"+i);
		}
		String info = new String(request.getParameter("info").getBytes("ISO-8859-1"),"utf-8");
		String sql = String.format("insert into Comment(Tempid,result,info,Sid) values('%s','%s','%s','%s')", Tempid,result,info,Sid);
		DBControllor.excuteUpdate(sql);
		sql = String.format("update SC set flag='1' where Tempid='%s'and Sid='%s'", Tempid,Sid);
		DBControllor.excuteUpdate(sql);
		response.sendRedirect("comment.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
