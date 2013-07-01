package com.hit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.DataControllor.DBControllor;

/**
 * Servlet implementation class UpdateScores
 */
public class UpdateScores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateScores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int lines = Integer.parseInt(request.getParameter("lines"));
		String Tempid = request.getParameter("Tempid");
		
		
		for(int i=1; i<lines; i++){
			String Sid = request.getParameter("Sid"+i);
			System.out.print(Sid);
			float Score = Float.parseFloat(request.getParameter("text"+i));
			String sql = String.format("update SC set Score=%f where Tempid='%s' and Sid='%s'", Score,Tempid,Sid);
			DBControllor.excuteUpdate(sql);
		}
	//	response.sendRedirect("setScores.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int lines = Integer.parseInt(request.getParameter("lines"));
		String Tempid = request.getParameter("Tempid");
		System.out.print(Tempid);
		
		for(int i=1; i<lines; i++){
			String Sid = request.getParameter("Sid"+i);
			System.out.print(Sid);
			float Score = Float.parseFloat(request.getParameter("text"+i));
			System.out.print(Score);
			String sql = String.format("update SC set Score=%f where Tempid='%s' and Sid='%s'", Score,Tempid,Sid);
			DBControllor.excuteUpdate(sql);
		}
		response.sendRedirect("setScores.jsp");
	}

}
