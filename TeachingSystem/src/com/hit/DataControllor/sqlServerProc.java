package com.hit.DataControllor;

import java.sql.CallableStatement;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Types;  

import javax.xml.transform.Result;

 
public class sqlServerProc {  
 
    public static void main(String[] args) {  
        insertStudentByProcedure("123", "123", "123", "123", "123", "123", "123", "010", "123", "ÄÐ", "2010-9-9", "123", "123");
        
    }  
    public static int insertStudentByProcedure(String ID, String password, String name, String email,
			String telephone, String personID, String saddress, String mid,
			String sclass, String sex, String birthday,
			String syear, String photo){
    	int result = 0;
    	Connection conn = null;  
        CallableStatement call = null;  
        conn = DBConn.getConnection();  
        try {  
            call = conn.prepareCall("{call proc_insertStudent(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");  
            call.setString(1, ID);  
            call.setString(2, password);  
            call.setString(3, name);  
    	    call.setString(4,email);
		    call.setString(5,telephone);
		    call.setString(6,personID);
		    call.setString(7,saddress);
		    call.setString(8,mid);
		    call.setString(9,sclass);
		    call.setString(10,sex);		
		    call.setString(11,birthday);
		    call.setString(12,syear);
		    call.setString(13,photo);
		    call.setString(14, "1");
            call.registerOutParameter(14, Types.INTEGER);  
            result = call.executeUpdate();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }finally{  
            try {  
                if(call != null)call.close();  
                if(conn != null)conn.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
        return result;
    }
}  

