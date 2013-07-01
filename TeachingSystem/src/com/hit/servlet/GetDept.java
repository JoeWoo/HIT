package com.hit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.DataControllor.DataManager;
import com.hit.Entity.Dept;

/**
 * Servlet implementation class GetDept
 */
public class GetDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDept() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/javascript; charset=utf-8");
		PrintWriter out = response.getWriter();
		String Did = request.getParameter("Did");
		//out.print("<option value='nochoose'>-Î´Ñ¡Ôñ-</option>");
		if(Did.equals("00")){
			ArrayList<Dept> dList = DataManager.getAllDepts();
			for(Dept dept:dList){
				String s = String.format("<option value='%s'>%s</option>", dept.getDid(),dept.getDname());
				out.print(s);
			}
		}else {
			Dept dept = DataManager.getDeptByID(Did);
			String s = String.format("<option value='%s'>%s</option>", dept.getDid(),dept.getDname());
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
