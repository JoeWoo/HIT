package com.hit.Entity;

public class Course {
	private String Cid;
	private String Cname;
	private String Ctype; 
	private int Chour;
	private float Ccredit;
	private String Cproperty;
	
	public Course(String cid, String cname, String ctype, int chour,
			float ccredit, String cproperty) {
		super();
		Cid = cid;
		Cname = cname;
		Ctype = ctype;
		Chour = chour;
		Ccredit = ccredit;
		Cproperty = cproperty;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	
	public String getCtype() {
		return Ctype;
	}
	public void setCtype(String ctype) {
		Ctype = ctype;
	}
	public int getChour() {
		return Chour;
	}
	public void setChour(int chour) {
		Chour = chour;
	}
	public float getCcredit() {
		return Ccredit;
	}
	public void setCcredit(float ccredit) {
		Ccredit = ccredit;
	}
	public String getCproperty() {
		return Cproperty;
	}
	public void setCproperty(String cproperty) {
		Cproperty = cproperty;
	}
	public String getCid() {
		return Cid;
	}
	
}
