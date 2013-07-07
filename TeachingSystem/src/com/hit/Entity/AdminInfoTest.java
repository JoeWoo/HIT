package com.hit.Entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdminInfoTest {

	AdminInfo adminInfo;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//String aid, String aname, String asex, String dname,String telephone, String email, String did, String personID,String photo, String birthday
		adminInfo = new AdminInfo("1","asd","ÄÐ","ÎÞ","1234","cwb6919@163.com","00","123","123","1991-11-02 00:00:00.000");
		assertNotNull(adminInfo);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPersonID() {
		assertNotNull(adminInfo);
		assertEquals("123", adminInfo.getPersonID());
	}

	@Test
	public void testSetPersonID() {
		
	}

	@Test
	public void testGetPhoto() {
		assertNotNull(adminInfo);
		assertEquals("123", adminInfo.getPhoto());
	}

	@Test
	public void testGetBirthday() {
		assertNotNull(adminInfo);
		assertEquals("1991-11-02 00:00:00.000", adminInfo.getBirthday());
	}

	@Test
	public void testGetAid() {
		assertNotNull(adminInfo);
		assertEquals("1", adminInfo.getAid());
	}

	@Test
	public void testGetAname() {
		assertNotNull(adminInfo);
		assertEquals("asd", adminInfo.getAname());
	}


	@Test
	public void testGetAsex() {
		assertNotNull(adminInfo);
		assertEquals("ÄÐ", adminInfo.getAsex());
	}


	@Test
	public void testGetDname() {
		assertNotNull(adminInfo);
		assertEquals("ÎÞ", adminInfo.getDname());
	}

	@Test
	public void testGetTelephone() {
		assertNotNull(adminInfo);
		assertEquals("1234", adminInfo.getTelephone());
	}

	@Test
	public void testGetEmail() {
		assertNotNull(adminInfo);
		assertEquals("cwb6919@163.com", adminInfo.getEmail());
	}


	@Test
	public void testGetDid() {
		assertEquals("00", adminInfo.getDid());
	}


}
