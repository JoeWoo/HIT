package com.hit.Entity;

public class AdminInfo {
	private String Aid;
	private String Aname;
	private String Asex;
	private String Dname;
	private String telephone;
	private String email;
	private String Did;
	private String personID;
	private String photo;
	private String birthday;
	public String getPersonID() {
		return personID;
	}
	public void setPersonID(String personID) {
		this.personID = personID;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public AdminInfo(String aid, String aname, String asex, String dname,
			String telephone, String email, String did, String personID,
			String photo, String birthday) {
		super();
		Aid = aid;
		Aname = aname;
		Asex = asex;
		Dname = dname;
		this.telephone = telephone;
		this.email = email;
		Did = did;
		this.personID = personID;
		this.photo = photo;
		this.birthday = birthday;
	}
	public AdminInfo(String aid, String aname, String asex, String dname,
			String telephone, String email, String did) {
		super();
		Aid = aid;
		Aname = aname;
		Asex = asex;
		Dname = dname;
		this.telephone = telephone;
		this.email = email;
		Did = did;
	}
	public String getAid() {
		return Aid;
	}
	public void setAid(String aid) {
		Aid = aid;
	}
	public String getAname() {
		return Aname;
	}
	public void setAname(String aname) {
		Aname = aname;
	}
	public String getAsex() {
		return Asex;
	}
	public void setAsex(String asex) {
		Asex = asex;
	}
	public String getDname() {
		return Dname;
	}
	public void setDname(String dname) {
		Dname = dname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDid() {
		return Did;
	}
	public void setDid(String did) {
		Did = did;
	}
	
}
