package com.hit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.DataControllor.DataManager;
import com.hit.Entity.Major;

/**
 * Servlet implementation class GetMajorOfDept
 */
public class GetMajorOfDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMajorOfDept() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Did = request.getParameter("Did");
		ArrayList<Major> mList = DataManager.getMajorOfDept(Did);
		response.setContentType("application/javascript; charset=utf-8");
		PrintWriter out = response.getWriter();
		for(Major major:mList){
			String s = String.format("<option value='%s'>%s</option>", major.getMid(),major.getMname());
			out.print(s);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
