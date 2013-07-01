package com.hit.DataControllor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.hit.Entity.Administrator;
import com.hit.Entity.Course;
import com.hit.Entity.CourseInfo;
import com.hit.Entity.Dept;
import com.hit.Entity.Major;
import com.hit.Entity.StuRecord;
import com.hit.Entity.Student;
import com.hit.Entity.Teacher;

public class DataManager {
	public static Student getStudentByID(String ID) {
		ResultSet rs = DBDeliver.getStudentSet(ID);
		String password;
		try {
			rs.next();
			password = rs.getString("Spassword");
			String name = rs.getString("Sname");
			String email = rs.getString("Semail");
			String telephone = rs.getString("Stelephone");
			String personID = rs.getString("SpersonID");
			String photo = rs.getString("Sphoto");
			String sex = rs.getString("Ssex");
			String birthday = rs.getString("Sbirthday");
			String saddress = rs.getString("Saddress");
			String mid = rs.getString("Mid");
			String did = rs.getString("Did");
			String sclass = rs.getString("Sclass");
			String syear = rs.getString("Syear");
			return new Student(ID, password, name, email, telephone, personID, 
					photo, sex, birthday, saddress, mid, did, sclass, syear);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			printErr("getStudentByID出错");
			e.printStackTrace();
			return null;
		}
	}
	public static String getMajorNameByID(String ID) {
		ResultSet rs = DBDeliver.getMajorSet(ID);
		try {
			rs.next();
			return rs.getString("Mname");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			printErr("getMajorNameByID出错");
			e.printStackTrace();
			return null;
		}
	}
	public static String getDeptNameByID(String ID){
		ResultSet rs = DBDeliver.getDeptSet(ID);
		try {
			rs.next();
			return rs.getString("Dname");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			printErr("getDeptNameByID出错");
			e.printStackTrace();
			return null;
		}
	}
	public static Teacher getTeacherByID(String ID){
		ResultSet rs = DBDeliver.getTeacherSet(ID);
		try {
			rs.next();
//			String password = rs.getString("Tpassword");
//			String name = rs.getString("Tname");
//			String email = rs.getString("Temail");
//			String telephone = rs.getString("Ttelephone");
//			String personID = rs.getString("TpersonID");
//			String photo = rs.getString("Tphoto");
//			String sex = rs.getString("Tsex");
//			String birthday = rs.getString("Tbirthday");
//			String did = rs.getString("Did");
//			String ttitle = rs.getString("Ttitle");
			return getTeacherFromRS(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			printErr("getTeacherByID出错");
			return null;
		}
	}
	public static Teacher getTeacherOfCourseByCid(String Cid){
		ResultSet rs = DBDeliver.getTeacherOfCourse(Cid);
		try {
			if(rs.next())
			return getTeacherFromRS(rs);
			else return null;
		} catch (SQLException e) {
			e.printStackTrace();
			printErr("getTeacherOfCourseByCid出错");
			return null;
		}
	}
	public static Administrator getAdministratorByID(String ID){
		ResultSet rs = DBDeliver.getAdministratorSet(ID);
		try {
			rs.next();
			String password = rs.getString("Apassword");
			String name = rs.getString("Aname");
			String email = rs.getString("Aemail");
			String telephone = rs.getString("Atelephone");
			String personID = rs.getString("ApersonID");
			String photo = rs.getString("Aphoto");
			String sex = rs.getString("Asex");
			String birthday = rs.getString("Abirthday");
			String did = rs.getString("Did");
			return new Administrator(ID, password, name, email, telephone, personID, photo, sex, birthday, did);
		} catch (SQLException e) {
			e.printStackTrace();
			printErr("getTeacherByID出错");
			return null;
		}
	}
	public static Course getCourseByID(String ID){
		ResultSet rs = DBDeliver.getCourseSet(ID);
		try {
			rs.next();
			return getCourseFromRS(rs);
		} catch (SQLException e) {
			printErr("getCourseByID出错");
			e.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList<Course> getChoosedCoursesByID(String ID) {
		ResultSet rs = DBDeliver.getChoosedCourseSet(ID);
		ArrayList<Course> cList = new ArrayList<Course>();
		try{
			while(rs.next()){
				cList.add(getCourseFromRS(rs));
			}
			return cList;
		}catch (SQLException e) {
			e.printStackTrace();
			printErr("getChoosedCoursesByID出错");
			return cList;
		}
	}
	public static ArrayList<Course> getMajorCoursesByMid(String Mid){
		ResultSet rs = DBDeliver.getMajorCourse(Mid);
		ArrayList<Course> cList = new ArrayList<Course>();
		try{
			while(rs.next()){
				cList.add(getCourseFromRS(rs));
			}
			return cList;
		}catch (SQLException e) {
			e.printStackTrace();
			printErr("getMajorCoursesByMid出错");
			return cList;
		}
	}
	public static Course getCourseInRoom(String Rname,String Cday,String Cnum,String week){
		ResultSet rs = DBDeliver.getCourseInRoom(Rname, Cday, Cnum,week);
		try {
			rs.next();
			return getCourseFromRS(rs);
		} catch (Exception e) {
			e.printStackTrace();
			printErr("getCourseInRoom出错");
			return null;
		}
	}
	private static Course getCourseFromRS(ResultSet rs){
		String cid;
		try {
			//rs.next();
			if(rs==null) return null;
			cid = rs.getString("Cid");
			String cname = rs.getString("Cname");
			String ctype = rs.getString("Ctype");
			int chour = rs.getInt("Chour");
			float ccredit = rs.getFloat("Ccredit");
			String cproperty = rs.getString("Cproperty");
			return new Course(cid, cname, ctype, chour, ccredit, cproperty);
		} catch (SQLException e) {
			e.printStackTrace();
			printErr("getCourseFromRS出错");
			return null;
		}
	}
	private static Teacher getTeacherFromRS(ResultSet rs){
		String ID;
		try {
			if(rs==null) return null;
			ID = rs.getString("Tid");
			String password = rs.getString("Tpassword");
			String name = rs.getString("Tname");
			String email = rs.getString("Temail");
			String telephone = rs.getString("Ttelephone");
			String personID = rs.getString("TpersonID");
			String photo = rs.getString("Tphoto");
			String sex = rs.getString("Tsex");
			String birthday = rs.getString("Tbirthday");
			String did = rs.getString("Did");
			String ttitle = rs.getString("Ttitle");
			return new Teacher(ID, password, name, email, telephone, personID, photo, sex, birthday, did, ttitle);
		} catch (SQLException e) {
			e.printStackTrace();
			printErr("getTeacherFromRS出错");
			return null;
		}
	}
	public static ArrayList<String> getCourseTimeList(String Rname,String Cweek){
		ResultSet rs = DBDeliver.getCourseTimeSet(Rname, Cweek);
		ArrayList<String> aList = new ArrayList<String>();
		try {
			while(rs.next()){
				aList.add(rs.getString("Cday")+rs.getString("Cnum"));
			}
			return aList;
		} catch (SQLException e) {
			e.printStackTrace();
			printErr("getCourseTimeList出错");
			return null;
		}
	}
	public static ArrayList<CourseInfo> getCourseInfos(String Clid,String Term){
		ResultSet rs = DBDeliver.getCourseListSet(Clid, Term);
		ArrayList<CourseInfo> cList = new ArrayList<CourseInfo>();
		try {
			while(rs.next()){
				String cname = rs.getString("Cname");
				String tname = rs.getString("Tname");
				String rname = rs.getString("Rname");
				int cstart = rs.getInt("Cstart");
				int cend = rs.getInt("Cend");
				int cday = rs.getInt("Cday");
				int cnum = rs.getInt("Cnum");
				cList.add(new CourseInfo(cname, tname, rname, cstart, cend, cday, cnum));
			}
			return cList;
		} catch (SQLException e) {
			printErr("getCourseInfos出错");
			e.printStackTrace();
			return null;
		}
	}
	private static Dept getDeptFromRS(ResultSet rs){
		try {
			
				return new Dept(rs.getString("Did"), rs.getString("Dname"));
			
		} catch (SQLException e) {
			e.printStackTrace();
			printErr("getDeptFromRS出错");
			return null;
		}
	}
	public static ArrayList<Dept> getAllDepts(){
		ResultSet rs = DBDeliver.getAllDeptSet();
		ArrayList<Dept> dList = new ArrayList<Dept>();
		try {
			while(rs.next()){
				if(!rs.getString("Did").equals("00"))
				dList.add(new Dept(rs.getString("Did"), rs.getString("Dname")));
			}
			return dList;
		} catch (SQLException e) {
			e.printStackTrace();
			printErr("getDeptFromRS出错");
			return dList;
		}
	}
	public static ArrayList<CourseInfo> getCourseInfosOfTeacher(String Term,String Tid) {
		ResultSet rs = DBDeliver.getCourseInfosSet(Term, Tid);
		System.out.print("asdsa");
		ArrayList<CourseInfo> cList = new ArrayList<CourseInfo>();
		try {
			while(rs.next()){
				String cname = rs.getString("Cname");
				String tname = rs.getString("Tname");
				String rname = rs.getString("Rname");
				int cstart = rs.getInt("Cstart");
				int cend = rs.getInt("Cend");
				int cday = rs.getInt("Cday");
				int cnum = rs.getInt("Cnum");
				cList.add(new CourseInfo(cname, tname, rname, cstart, cend, cday, cnum));
			}
			return cList;
		} catch (SQLException e) {
			e.printStackTrace();
			return cList;
		}
	}
	public static Dept getDeptByID(String ID) {
		ResultSet rs = DBDeliver.getDeptByID(ID);
		try {
			rs.next();
			return getDeptFromRS(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			printErr("getDeptByID出错");
			return null;
		}
	}
	public static ArrayList<Major> getMajorOfDept(String Did) {
		ResultSet rs = DBDeliver.getMajorSetOfDept(Did);
		ArrayList<Major> mList = new ArrayList<Major>();
		try {
			while(rs.next()){
				mList.add(new Major(rs.getString("Mid"), rs.getString("Mname")));
			}
			return mList;
		} catch (SQLException e) {
			e.printStackTrace();
			printErr("getMajorOfDept出错");
			return mList;
		}
	}
	public static String getCid(){
		ResultSet rs = DBDeliver.getMaxCid();
		String s = "";
		try {
			if(!rs.next())
				s = "1000000000";
			else {
				s = rs.getString("Cid");
				s = (Integer.parseInt(s)+1)+"";
			}
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
			printErr("getCid出错");
			return "";
		}
	}
	
	public static String getTerm(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ly_time = sdf.format(new java.util.Date());
		String result = ly_time.substring(0,4);
		int month1 = ((int) ly_time.charAt(5) - 48) * 10 + (int)ly_time.charAt(6) - 48;
		if(month1 < 8 && month1 > 1)
		result += "01";
		else
		result += "02";
		return result;
	}
	public static String termPluOne(String term){
		String year = term.substring(0, 4);
		String season = term.substring(4,6);
		if(season.equals("01"))
			season ="02";
		else{
			int y = Integer.parseInt(year);
			y ++;
			year = String.valueOf(y);
			season = "01";
		}
		return year + season;
	}

	public static String getTermString(String term){
		String year = term.substring(0, 4);
		String season = term.substring(4,6);
		if(season.equals("01"))
			season = "春";
		else {
			season = "秋";
		}
		return year + season;
	}
	public static void putIntoTempCourse(String Cid,String Mid,String Tid,String Term){
		DBDeliver.insertTempCourse(Cid, Mid, Tid,Term);
	}
	public static void updateTempCourse(String Tempid,String Cid,String Mid,String Tid,String Term){
		DBDeliver.updateTempCourse(Tempid,Cid,Mid,Tid,Term);
	}
	public static ArrayList<String> getTermList() {
		ResultSet rs = DBDeliver.getTermSet();
		ArrayList<String> tList = new ArrayList<String>();
		try {
			while(rs.next()){
				tList.add(rs.getString("Term"));
			}
			return tList;
		} catch (SQLException e) {
			e.printStackTrace();
			printErr("getTermList出错");
			return tList;
		}
	}
//	public static ArrayList<StuRecord> getStuRecords(String Tid,String Term,String Cid){
//		
//	}
	public static ArrayList<String> getYears(){
		ResultSet rs = DBDeliver.getYearsSet();
		ArrayList<String> sList = new ArrayList<String>();
		try {
			while(rs.next()){
				sList.add(rs.getString("Syear"));
			}
			return sList;
		} catch (SQLException e) {
			e.printStackTrace();
			printErr("getYears出错");
			return sList;
		}
	}
	public static boolean judgeCourseInDB(String Cid,String Cname,String Ccredit,String Chour,String Ctype,String Cproperty){
		ResultSet rs = DBDeliver.getCourseSet(Cid);
		try {
			if(!rs.next())
				return false;
			else {
				if(!Cid.equals(rs.getString("Cid"))) return false;
				if(!Cname.equals(rs.getString("Cname"))) return false;
				if(!Ccredit.equals(rs.getString("Ccredit"))) return false;
				if(!Chour.equals(rs.getString("Chour"))) return false;
				if(!Ctype.equals(rs.getString("Ctype"))) return false;
				if(!Cproperty.equals(rs.getString("Cproperty"))) return false;
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			printErr("judgeCourseInDB出错");
			return false;
		}
	}
	private static void printErr(String s){
		System.out.println(s);
	}
}
