package com.hit.Entity;

public class Teacher extends User{
	private String Did;
	private String Ttitle;
	
	public Teacher() {
		super();
	}
	public Teacher(String ID, String password, String name, String email,
			String telephone, String personID, String photo, String sex,
			String birthday, String did, String ttitle) {
		super(ID, password, name, email, telephone, personID, photo, sex,
				birthday);
		Did = did;
		Ttitle = ttitle;
	}
	public String getDid() {
		return Did;
	}
	public void setDid(String did) {
		Did = did;
	}
	public String getTtitle() {
		return Ttitle;
	}
	public void setTtitle(String ttitle) {
		Ttitle = ttitle;
	}
	
	
}
