package com.hit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.zip.Inflater;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.DataControllor.DBControllor;
import com.hit.Entity.StudentXue;

/**
 * Servlet implementation class GetScoresOfClass
 */
@WebServlet("/GetScoresOfClass")
public class GetScoresOfClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetScoresOfClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Sclass = request.getParameter("SClass");
		String Term = request.getParameter("Term");
		
		String sql=new String("select Sid,Sname from Student where Sclass='"+Sclass+"';");
		ResultSet rs1 = DBControllor.excuteQuery(sql);
		ArrayList<String> sidList=new ArrayList<String>();
		ArrayList<String> snameList=new ArrayList<String>();
		try {
			while(rs1.next()){
					sidList.add(rs1.getString("Sid"));
					snameList.add(rs1.getString("Sname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<StudentXue> studentXueList=new ArrayList<StudentXue>();
		int j=0;
		for(String Sid:sidList)
		{
			StudentXue xue = new StudentXue();
			xue.Sid=Sid;
			xue.Sname=snameList.get(j++);
			String sql2 = String.format("select SC1.Sid,Cproperty,Course.Cid,Cname,Tname,Ctype,Ccredit,Chour,Score from TempCourse"+
					" inner join (select * from SC where SC.Sid='%s') as SC1 on TempCourse.Tempid=SC1.Tempid"+
					" inner join Course on TempCourse.Cid=Course.Cid inner join Teacher on TempCourse.Tid=Teacher.Tid where TempCourse.Term='%s' and Ctype='1'", Sid,Term);
			//System.out.print(sql2);
			ResultSet rs2 = DBControllor.excuteQuery(sql2);
			try {
				float xfjSum=0;
				float creditSum=0;
				int bujige=0;
				while(rs2.next()){
					
					if(rs2.getFloat("Score") < 60)
					{
						bujige++;
					}
					xfjSum += rs2.getFloat("Ccredit")*rs2.getFloat("Score");
					creditSum += rs2.getFloat("Ccredit");
					
				}
				if(creditSum == 0)
				{
					xue.xfj=0;
				}
				else {
					xue.xfj = xfjSum/creditSum; 
				}
				xue.bujigeNum=bujige;
				
				studentXueList.add(xue);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

			
		}
		Collections.sort(studentXueList,new Comparator <StudentXue>() {
		      @Override
		      public int compare(StudentXue o1, StudentXue o2) {
		        return (o2.getXfj()).compareTo(o1.getXfj());
		      }
		    });
		response.setContentType("text/htm; charset=utf-8");
		PrintWriter out = response.getWriter();
		int i=0;
		for(i=0;i<studentXueList.size();i++){
			StudentXue xue2=studentXueList.get(i);
			 String s = String.format("<tr bgcolor='#C8D6FF'><td height='25'>%s</td><td>%s</td><td>%s</td><td >%.2f</td><td>%d</td><td>%.2f%%</td><td></td></tr>",
					i+1,xue2.Sid,xue2.Sname,xue2.xfj,xue2.bujigeNum,100.0*i/studentXueList.size());
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


