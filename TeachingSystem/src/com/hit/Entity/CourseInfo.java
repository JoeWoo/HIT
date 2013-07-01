package com.hit.Entity;

public class CourseInfo {
	private String Cname;
	private String Tname;
	private String Rname;
	private int Cstart;
	private int Cend;
	private int Cday;
	private int Cnum;
	public CourseInfo(String cname, String tname, String rname, int cstart,
			int cend, int cday, int cnum) {
		super();
		Cname = cname;
		Tname = tname;
		Rname = rname;
		Cstart = cstart;
		Cend = cend;
		Cday = cday;
		Cnum = cnum;
	}
	public String getCname() {
		return Cname;
	}
	public String getTname() {
		return Tname;
	}
	public String getRname() {
		return Rname;
	}
	public int getCstart() {
		return Cstart;
	}
	public int getCend() {
		return Cend;
	}
	public int getCday() {
		return Cday;
	}
	public int getCnum() {
		return Cnum;
	}
	
}
