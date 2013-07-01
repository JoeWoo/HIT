package com.hit.Entity;

public class Student extends User{
	private String Saddress;
	private String Mid;
	private String Did;
	private String Sclass;
	private String Syear;
	
	public Student(String ID, String password, String name, String email,
			String telephone, String personID, String photo, String sex,
			String birthday, String saddress, String mid, String did,
			String sclass, String syear) {
		super(ID, password, name, email, telephone, personID, photo, sex,
				birthday);
		Saddress = saddress;
		Mid = mid;
		Did = did;
		this.Sclass = sclass;
		Syear = syear;
	}
	public Student() {
		super();
	}
	public String getSaddress() {
		return Saddress;
	}
	public void setSaddress(String saddress) {
		Saddress = saddress;
	}
	public String getMid() {
		return Mid;
	}
	public void setMid(String mid) {
		Mid = mid;
	}
	public String getDid() {
		return Did;
	}
	public void setDid(String did) {
		Did = did;
	}
	public String getSclass() {
		return Sclass;
	}
	public void setSclass(String sclass) {
		this.Sclass = sclass;
	}
	public String getSyear() {
		return Syear;
	}
	
}
