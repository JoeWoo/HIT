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
 * Servlet implementation class GetComments
 */
public class GetComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetComments() {
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
		String Cid = request.getParameter("Cid");
		//System.out.print(Term+" "+Tid+" ");
		int[] scores = new int[10];
		for(int i=0; i<10; i++)
			scores[i] = 0;
		String sql = String.format("select Result,Info from Comment inner join TempCourse on Comment.Tempid=TempCourse.Tempid where Tid='%s' and Cid='%s' and Term='%s'", Tid,Cid,Term);
		System.out.print(sql);
		ResultSet rs = DBControllor.excuteQuery(sql);
		String infoString="";
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		int cnt = 0;
		try {
			
			while(rs.next()){
				cnt++;
				String result = rs.getString("Result");
				String[] results = result.split("#");
				for(int i=0; i<results.length; i++)
					scores[i]+=Integer.parseInt(results[i]);
				if(cnt>0)infoString+="$$$";
				if(!rs.getString("Info").equals("")) infoString+=rs.getString("Info");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<10; i++)
			if(cnt!=0)
			scores[i] /= cnt;
		String ss=scores[0]+"";
		for(int i=1; i<10; i++)
			ss+="###"+scores[i];
		ss+="&&&"+infoString;
		out.print(ss);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
