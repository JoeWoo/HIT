package com.hit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.DataControllor.DBDeliver;
import com.hit.DataControllor.DataManager;

/**
 * Servlet implementation class AddCourse
 */
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String cid = DataManager.getCid();
		//request.setCharacterEncoding("utf-8");
		String cid = new String(request.getParameter("Cid").getBytes("ISO-8859-1"),"utf-8");
		System.out.print(request.getParameter("Cname"));
		String cname = new String(request.getParameter("Cname").getBytes("ISO-8859-1"),"utf-8");
		cname = cname.replace("��", "+");
		//cname.re
		System.out.print("\n##"+cname+"##\n");
		
		String ctype = new String(request.getParameter("Ctype").getBytes("ISO-8859-1"),"utf-8");
		//System.out.print(request.getParameter("Chour"));
		int chour = Integer.parseInt(request.getParameter("Chour"));
		float ccredit = Float.parseFloat(request.getParameter("Ccredit"));
		String cproperty = request.getParameter("Cproperty");
		String Mid = request.getParameter("Major");
		String Tid = request.getParameter("Teacher");
		String term = DataManager.getTerm();
		String Syear = new String(request.getParameter("Syear").getBytes("ISO-8859-1"),"utf-8");
		if(!DataManager.judgeCourseInDB(cid, cname, ccredit+"", chour+"", ctype, cproperty)){
			System.out.print("asddsada");
			cid = DataManager.getCid();
			DBDeliver.insertCourse(cid, cname, ctype, chour, ccredit, cproperty);
		}
		DataManager.putIntoTempCourse(cid, Mid, Tid,term,Syear);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
