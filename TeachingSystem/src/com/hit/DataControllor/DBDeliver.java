package com.hit.DataControllor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBDeliver {
	public static boolean insertStudent(String ID, String password, String name, String email,
			String telephone, String personID, String photo, String sex,
			String birthday, String saddress, String mid, String did,
			String sclass, String syear){
		String sql = String.format("insert into Student(Sid,Sname,Spassword,Semail,Stelephone,SpersonID,Sphoto,Ssex,Sbirthday,Saddress,Mid,Did,Sclass,Syear) values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')", 
				ID,name,password,email,telephone,personID,photo,sex,birthday,saddress,mid,did,sclass,syear);
		return printSql(sql)||DBControllor.excuteUpdate(sql);
	}
	public static boolean insertTeacher(String ID, String password, String name, String email,String telephone, String personID, String photo, String sex,
			String birthday, String did, String ttitle){
		String sql = String.format("insert into Teacher(Tid,Tpassword,Tname,Temail,Ttelephone,TpersonID,Tphoto,Tsex,Tbirthday,Did,Ttitle) values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
				ID,password,name,email,telephone,personID,photo,sex,birthday,did,ttitle);
		return printSql(sql)||DBControllor.excuteUpdate(sql);
	}
	public static boolean insertAdministrator(String ID, String password, String name, String email,
			String telephone, String personID, String photo, String sex,
			String birthday, String did){
		String sql = String.format("insert into Administrator(Aid,Apassword,Aname,Aemail,Atelephone,ApersonID,Aphoto,Asex,Abirthday,Did) values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
				ID,password,name,email,telephone,personID,photo,sex,birthday,did);
		return printSql(sql)||DBControllor.excuteUpdate(sql);
	}
	public static boolean insertCourse(String cid, String cname, String ctype, int chour,
			float ccredit, String cproperty) {
		String sql = String.format("insert into Course(Cid,Cname,Ctype,Chour,Ccredit,Cproperty) values('%s','%s','%s',%d,%f,'%s')",
				cid,cname,ctype,chour,ccredit,cproperty);
		return printSql(sql)||DBControllor.excuteUpdate(sql);
	}
	public static boolean deleteStudent(String ID) {
		String sql = "delete from Student where Sid='"+ID+"'";
		return printSql(sql)||DBControllor.excuteUpdate(sql);
	}
	public static boolean deleteTeacher(String ID) {
		String sql = "delete from Teacher where Tid='"+ID+"'";
		return printSql(sql)||DBControllor.excuteUpdate(sql);
	}
	public static boolean deleteAdministrator(String ID) {
		String sql = "delete from Administrator where Aid='"+ID+"'";
		return printSql(sql)||DBControllor.excuteUpdate(sql);
	}
	public static boolean deleteCourse(String ID) {
		String sql = "delete from Course where Cid='"+ID+"'";
		return printSql(sql)||DBControllor.excuteUpdate(sql);
	}
	public static boolean updateStudent(String initID,String ID, String password, String name, String email,
			String telephone, String personID, String photo, String sex,
			String birthday, String saddress, String mid, String did,
			String sclass, String syear) {
		String sql = String.format("update Student set Sid='%s',Spassword='%s',Sname='%s',Semail='%s',Stelephone='%s',SpersonID='%s',Sphoto='%s',Ssex='%s',"+
				"Sbirthday='%s',Saddress='%s',Mid='%s',Did='%s',Sclass='%s',Syear=%s where Sid='%s'",ID,password,name,email,
				telephone,personID,photo,sex,birthday,saddress,mid,did,sclass,syear,initID);
		return printSql(sql)||DBControllor.excuteUpdate(sql);
	}
	public static boolean updateTeacher(String initID,String ID, String password, 
			String name, String email,String telephone, String personID, String photo,
			String sex,String birthday, String did, String ttitle){
		String sql = String.format("update Teacher set Tid='%s',Tpassword='%s',Tname='%s',Temail='%s',Ttelephone='%s',TpersonID='%s',Tphoto='%s',Tsex='%s',Tbirthday='%s',Did='%s',Ttitle='%s' where Tid='%s'",
				ID,password,name,email,telephone,personID,photo,sex,birthday,did,ttitle,initID);
		return printSql(sql)||DBControllor.excuteUpdate(sql);
	}
	public static boolean updateTempCourse(String Tempid,String Cid,String Mid,String Tid,String Term,String Syear){
		String sql = String.format("update TempCourse set Cid='%s',Mid='%s',Tid='%s',Term='%s',Syear='%s' where Tempid='%s'",Cid,Mid,Tid,Term,Syear,Tempid);
		System.out.println(sql);
		return printSql(sql)||DBControllor.excuteUpdate(sql);
	}
	public static ResultSet getStudentSet(String ID){
		return DBControllor.excuteQuery("select * from Student where Sid='"+ID+"'");
	}
	public static ResultSet getTeacherSet(String ID){
		return DBControllor.excuteQuery("select * from Teacher where Tid='"+ID+"'");
	}
	public static ResultSet getAdministratorSet(String ID){
		return DBControllor.excuteQuery("select * from Administrator where Aid='"+ID+"'");
	}
	public static ResultSet getMajorSet(String ID){
		return DBControllor.excuteQuery("select * from Major where Mid='"+ID+"'");
	}
	public static ResultSet getDeptSet(String ID) {
		return DBControllor.excuteQuery("select * from Dept where Did='"+ID+"'");
	}
	public static ResultSet getCourseSet(String ID){
		return DBControllor.excuteQuery("select * from Course where Cid='"+ID+"'");
	}
	public static ResultSet getChoosedCourseSet(String ID){
		return DBControllor.excuteQuery("select * from SC inner join Course on SC.Cid=Course.Cid where SC.Sid='"+ID+"'");
	}
	public static ResultSet getMajorCourse(String Mid){
		return DBControllor.excuteQuery("select * from Course inner join CM on Course.Cid=CM.Cid where Mid='"+Mid+"'");
	}
	public static ResultSet getCourseInRoom(String Rname,String day,String num,String week){
		String sql = String.format("select * from Cweek,Ctime,SCT,TempCourse,Course,Teacher " +
				"where SCT.SCTid in (select Cweek.SCTid from CRoomArrange inner join Cweek on Cweek.CweekID=CRoomArrange.CweekID where CRoomArrange.Rname='%s')" +
				" and SCT.SCTid=Cweek.SCTid and Cweek.CweekID=Ctime.CweekID and Cweek.Cstart<='%s' and Cweek.Cend>='%s' " +
				"and TempCourse.Tempid=SCT.Tempid and Course.Cid=TempCourse.Cid and Teacher.Tid=TempCourse.Tid " +
				"and Cnum='%s' and Cday='%s' ", Rname,week,week,num,day);
		return DBControllor.excuteQuery(sql);
	}
	public static boolean insertSC(String Sid,String Cid,String Term){
		String sql = String.format("insert into SC(Sid,Cid,Term,Score) values('%s','%s','%s',0)", Sid,Cid,Term);
		return DBControllor.excuteUpdate(sql);
	}
	public static ResultSet getCourseTimeSet(String Rname,String Cweek){
		String sql = String.format("select Cday,Cnum from Ctime inner join CRoomArrange on Ctime.CweekID = CRoomArrange.CweekID inner join Cweek on Ctime.CweekID = Cweek.CweekID where Rname='%s' and Cstart<=%s and Cend>=%s",Rname,Cweek,Cweek);
		return DBControllor.excuteQuery(sql);
	}
	public static ResultSet getCourseOfTeacher(String Tid){
		String sql = String.format("select Course.Cid,Course.Cname from (Teacher inner join TC on TC.Tid=Teacher.Tid) inner join (Course inner join SCT on Course.Cid=SCT.Cid) on TC.SCTid=SCT.SCTid where Teacher.Tid='%s'",Tid);
		return DBControllor.excuteQuery(sql);
	}
	public static ResultSet getCourseInfosSet(String Term,String Tid){
		//String sql = String.format("select Cnum,Cday,Cstart,Cend,Tname,Rname,Cname from (select * from TempCourse where Term='%s' ) as T1 inner join (select * from Teacher where Teacher.Tid='%s') as TT on TT.Tid=T1.Tid " +
			//	"inner join (Cweek inner join CRoomArrange on Cweek.CweekID=CRoomArrange.CweekID) on Cweek.SCTid=SCT.SCTid,Ctime,Course where Cweek.SCTid=SCT.SCTid and Course.Cid=T1.Cid and Ctime.CweekID=Cweek.CweekID ",Term, Tid);
		String sql = String.format("select Cnum,Cday,Cstart,Cend,Tname,Rname,Cname from TempCourse inner join SCT on " +
				"TempCourse.Tempid=SCT.Tempid inner join Cweek on Cweek.SCTid=SCT.SCTid inner join Ctime on " +
				"Ctime.CweekID=Cweek.CweekID inner join CRoomArrange on Cweek.CweekID=CRoomArrange.CweekID" +
				" inner join Teacher on Teacher.Tid=TempCourse.Tid inner join Course on Course.Cid=TempCourse.Cid " +
				"where Teacher.Tid='%s' and Term='%s'", Tid,Term);
		printSql(sql);
		return DBControllor.excuteQuery(sql);
	}
	public static boolean updatePwd(String ID, String password, String type) {
		String temp = type.substring(0,1);
		String sql = String.format("update " + type +" set " + temp +"password ='%s' where " + temp +"id = '%s'",password,ID);
		System.out.println(sql);
		return printSql(sql)||DBControllor.excuteUpdate(sql);
	}
	public static void updateInfo(String email,String telephone,String ID,String table) {
		String sql = String.format("update %s set %semail='%s',%stelephone='%s' where %sid='%s'",table,table.charAt(0),email,table.charAt(0),telephone,table.charAt(0),ID);
		DBControllor.excuteUpdate(sql);
	}
//	public static ResultSet getStuRecordSet(String Tid,String Term,String Cid){
//		String sql = String.format("select Student.Sid,Student.Sname,Dname,Mname,Score,Cproperty from Student", arg1)
//	}
	public static boolean checkLogin(String ID,String password,String status){
		String sql = "select * from "+status+" where "+status.charAt(0)+"id='"+ID+"'and "+status.charAt(0)+"password='"+password+"'";
		ResultSet rs = DBControllor.excuteQuery(sql);
		
		try {
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("登录检测出错");
			return false;
		}
	}
	public static ResultSet getYearsSet() {
		String sql = "select distinct Syear from Student order by Syear desc";
		return DBControllor.excuteQuery(sql);
	}
	public static ResultSet getSyear() {
		String sql = "select distinct top 5  Syear from Student order by Syear desc";
		return DBControllor.excuteQuery(sql);
	}
	public static ResultSet getCourseListSet(String Clid,String Term){
		String sql = String.format("select Cnum,Cday,Cstart,Cend,Tname,Rname,Cname from" +
				" (select * from SCT where SCT.Clid='%s') as S1 inner join (select * from TempCourse where TempCourse.Term='%s') " +
				"as T1 on S1.Tempid = T1.Tempid inner join Course on T1.Cid=Course.Cid inner join Teacher " +
				"on T1.Tid=Teacher.Tid ,Cweek,Ctime,CRoomArrange where S1.SCTid=Cweek.SCTid and Cweek.CweekID=Ctime.CweekID " +
				"and Cweek.CweekID=CRoomArrange.CweekID ", Clid,Term);
		printSql(sql);
		return DBControllor.excuteQuery(sql);
	}
	public static ResultSet getSpecialCourseListSet(String Term){
		String sql = String.format("select Cnum,Cday,Cstart,Cend,Tname,Rname,Cname from" +
				" (select * from SCT where SCT.Clid='0000') as S1 inner join (select * from TempCourse where TempCourse.Term='%s') " +
				"as T1 on S1.Tempid = T1.Tempid inner join Course on T1.Cid=Course.Cid inner join Teacher " +
				"on T1.Tid=Teacher.Tid ,Cweek,Ctime,CRoomArrange where S1.SCTid=Cweek.SCTid and Cweek.CweekID=Ctime.CweekID " +
				"and Cweek.CweekID=CRoomArrange.CweekID ",Term);
		printSql(sql);
		return DBControllor.excuteQuery(sql);
	}
	public static ResultSet getTeacherOfCourse(String ID){
		String sql = String.format("select * from TempCourse inner join Teacher on Teacher.Tid = TempCourse.Tid where TempCourse.Cid = '%s'", ID);
		return DBControllor.excuteQuery(sql);
	}
	public static ResultSet getAllDeptSet(){
		String sql = "select * from Dept";
		return DBControllor.excuteQuery(sql);
	}
	public static ResultSet getDeptByID(String ID) {
		String sql = String.format("select * from Dept where Did='%s'", ID);
		return DBControllor.excuteQuery(sql);
	}
	public static ResultSet getMajorSetOfDept(String Did){
		String sql = String.format("select * from Major where Did='%s'", Did);
		return DBControllor.excuteQuery(sql);
	}
	public static ResultSet getMaxCid() {
		String sql = "select top 1 Cid from Course order by Cid desc";
		return DBControllor.excuteQuery(sql);
	}
	public static boolean insertTempCourse(String Cid,String Mid,String Tid,String Term,String Syear){
		String sql = String.format("insert into TempCourse(Cid,Mid,Tid,Term,Syear) values('%s','%s','%s','%s','%s')",Cid,Mid,Tid,Term,Syear);
		return DBControllor.excuteUpdate(sql);
	}
	public static  boolean judgeCommented(String Tempid,String Sid) throws SQLException{
		String sql = String.format("select * from Comment where Tempid='%s' and Sid='%s'", Tempid,Sid);
		ResultSet rs = DBControllor.excuteQuery(sql);
		if(rs.next()) return true;
		
			return false;
		
	}
	public static ResultSet getTermSet() {
		String sql = "select distinct Term from TermList order by Term";
		return DBControllor.excuteQuery(sql);
	}
	public static void main(String[] args){
		String ID="123";
		String password="123";
		String name="asd";
		String email="asd@123.com";
		String telephone="123123";
		String personID="330282";
		String photo="asd/image";
		String sex="男";
		String birthday="19911102";
		String did="软件";
		String saddress = "浙江";
		String mid="数学";
		String sclass="1037103";
		String syear="2010";
		String ttitle = "教授";
		String initID="123123123";
		insertAdministrator(ID, password, name, email, telephone, personID, photo, sex, birthday, did);
		insertCourse("123", "c++", "aa", 100, 5.5f, "x");
		insertStudent(ID, password, name, email, telephone, personID, photo, sex, birthday, saddress, mid, did, sclass, syear);
		insertTeacher(ID, password, name, email, telephone, personID, photo, sex, birthday, did, ttitle);
		updateStudent(initID, ID, password, name, email, telephone, personID, photo, sex, birthday, saddress, mid, did, sclass, syear);
		updateTeacher(initID, mid, password, name, email, telephone, personID, photo, sex, birthday, did, ttitle);
	}
	private static boolean printSql(String sql){
		System.out.println(sql);
		return false;
	}
	public static ResultSet getAdminOfDept(String Did) {
		String sql = String.format("select Aid from Administrator");
		if(!Did.equals("00"))
			sql+=String.format(" where Did='%s'", Did);
		return DBControllor.excuteQuery(sql);
	}
	public static ResultSet getAdminInfos(String did,String aid){
		String sql = "select * from Administrator inner join Dept on Administrator.Did=Dept.Did";
		if(!did.equals("00")) sql+=String.format(" where Dept.Did='%s'",did);
		if(!aid.equals("00")) sql+=String.format(" and Administrator.Aid='%s'", aid);
		printSql(sql);
		return DBControllor.excuteQuery(sql);
	}
	public static ResultSet getCoursesOfClass(String Class,String term) {
		String sql = "select Tempid,Cname,Chour from TempCourse inner join Course on TempCourse.Cid=Course.Cid";
		String Mid = Class.substring(2,5);
		sql+=String.format(" where Mid='%s' and Term='%s' and Syear='%s'", Mid,term,"20"+Class.substring(0,2));
		printSql(sql);
		return DBControllor.excuteQuery(sql);
	}
	public static ResultSet getCoursesOfType(String type,String term) {
		String sql = "select Tempid,Cname,Chour from TempCourse inner join Course on TempCourse.Cid=Course.Cid";
		//String Mid = Class.substring(2,5);
		sql+=String.format(" where Ctype='%s' and Term='%s'", type,term,"20");
		printSql(sql);
		return DBControllor.excuteQuery(sql);
	}
	public static void cancelChoosedCourse(String sid,String tempid) {
		String sql = String.format("delete from SC where SC.Sid='%s' and Tempid='%s'",sid,tempid);
		printSql(sql);
		DBControllor.excuteUpdate(sql);
	}
	public static boolean judgeConfirmBixu(String sid,String term,String tempid) throws SQLException{
		String sql = String.format("select * from SC inner join TempCourse on SC.Tempid=" +
				"TempCourse.Tempid where SC.Sid='%s' and TempCourse.Term='%s' and SC.Tempid='%s'", sid,term,tempid);
		ResultSet rs = DBControllor.excuteQuery(sql);
		return rs.next();
	}
}
