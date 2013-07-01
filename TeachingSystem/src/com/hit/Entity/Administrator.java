package com.hit.Entity;

public class Administrator extends User{
	private String Did;

	public Administrator(String ID, String password, String name, String email,
			String telephone, String personID, String photo, String sex,
			String birthday, String did) {
		super(ID, password, name, email, telephone, personID, photo, sex,
				birthday);
		Did = did;
	}

	public String getDid() {
		return Did;
	}

	public void setDid(String did) {
		Did = did;
	}
	
}
