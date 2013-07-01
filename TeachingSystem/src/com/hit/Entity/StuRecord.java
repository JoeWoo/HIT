package com.hit.Entity;

public class StuRecord {
	private String Sid;
	private String Sname;
	private String Dname;
	private String Mname;
	private float score;
	private String info;
	public String getSid() {
		return Sid;
	}
	public String getSname() {
		return Sname;
	}
	public String getDname() {
		return Dname;
	}
	public String getMname() {
		return Mname;
	}
	public float getScore() {
		return score;
	}
	public String getInfo() {
		return info;
	}
	public StuRecord(String sid, String sname, String dname, String mname,
			float score, String info) {
		super();
		Sid = sid;
		Sname = sname;
		Dname = dname;
		Mname = mname;
		this.score = score;
		this.info = info;
	}
	
}
