package com.hit.Entity;

public class User {
	private String ID;
	private String password;
	private String name;
	private String email;
	private String telephone;
	private String personID;
	private String photo;
	private String sex;
	private String birthday;
	public  User() {
		
	}
	public User(String ID, String password, String name, String email,
			String telephone, String personID, String photo, String sex,
			String birthday) {
		super();
		this.ID = ID;
		this.password = password;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.personID = personID;
		this.photo = photo;
		this.sex = sex;
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getID() {
		return ID;
	}
	public String getPersonID() {
		return personID;
	}
	
}
