/**
 * 
 */
package com.swe642.studentSurvey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * @author xubinhui
 *
 */
public class StudentDAO {
	//JDBC driver name and database URL
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
	static final String DB_URL = "jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu";
	//  Database credentials
	static final String USER = "bxu4";
	static final String PASS = "gralathe";
	//sql queries
	static final String updateSQL="UPDATE SURVEY SET FULLNAME = ?, STREETADDRESS = ?, "
			+ "CITY = ? , STATE = ?, ZIP = ?, PHONE = ?, EMAIL = ?, URL = ?, "
			+ "KNOWMETHOD = ?, RECOMMEND = ?, MESSAGE = ?, LIKEMOST = ? , FILLDATE = ?, "
			+ "GRADMONTH= ?, GRADYEAR = ? WHERE STUDENTID = ?";
	static final String insertSQL= "INSERT INTO SURVEY (STUDENTID, FULLNAME, STREETADDRESS, "
			+ "CITY, STATE, ZIP, PHONE, EMAIL, URL,KNOWMETHOD,RECOMMEND,MESSAGE, "
			+ "LIKEMOST, FILLDATE, GRADMONTH, GRADYEAR)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	static final String retriveByIdSQL = "SELECT * FROM SURVEY WHERE STUDENTID=?";
	static final String retriveAllSQL = "SELECT * FROM SURVEY";
	//save data entered in the form
	public static int saveDataToDB(StudentBean sbean){
		int status=0;
		Connection connector=null;
		
		
		try {
			Class.forName(JDBC_DRIVER);
			connector=DriverManager.getConnection(DB_URL,USER,PASS);
//			try {
//			String createTableSql= "CREATE TABLE STUDENTSURVEY "+
//					"(STUDENT_ID INTEGER NOT NULL, "+
//					"FULL_NAME VARCHAR(255), "+
//					"STREET_ADD VARCHAR(255), "+
//					"CITY VARCHAR(32), "+
//					"STATE VARCHAR(32), "+
//					"ZIP VARCHAR(10), " +
//					"PHONE VARCHAR(16), "+
//					"EMAIL VARCHAR(255), "+
//					"URL VARCHAR(255), "+
//					"HEARFROM VARCHAR(64), "+
//					"RECOMMEND VARCHAR(32), "+
//					"FEEDBACK VARCHAR(255), "+
//					"LIKEMOST VARCHAR(255), "+
//					"TODAYDATE VARCHAR(32), "+
//					"GRADMONTH VARCHAR(32), "+
//					"GRADYEAR VARCHAR(32))";
//			PreparedStatement ps=connector.prepareStatement(createTableSql);
//			ps.executeUpdate();
//		}catch(SQLException e) {
//			if(e.getErrorCode()==955) {
//				
//			}else {
//				System.err.format("SQL State: %s\n%s", e.getErrorCode(), e.getMessage());
//			}
//		}
			int sid=sbean.getStudentID();
			PreparedStatement ps=connector.prepareStatement(retriveByIdSQL);
			String[] likeMostArr;
			String checkedBox="";
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			ps.setInt(1,sid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ps.close();
				ps=connector.prepareStatement(updateSQL);
				ps.setString(1,sbean.getFullName());
				ps.setString(2,sbean.getStreetAdd());
				ps.setString(3,sbean.getCity());
				ps.setString(4,sbean.getState());
				ps.setString(5,sbean.getZip());
				ps.setString(6,sbean.getPhone());
				ps.setString(7,sbean.getEmail());
				ps.setString(8,sbean.getUrl());
				ps.setString(9,sbean.getKnowMethod());
				ps.setString(10,sbean.getRecommend());
				ps.setString(11,sbean.getMessage());
				likeMostArr=sbean.getLikeMost();
				checkedBox="";
				for(int i=0;i<likeMostArr.length;i++) {
					checkedBox+=likeMostArr[i]+",";
				}
				ps.setString(12,checkedBox);
				ps.setString(13,sdf.format(sbean.getFillDate()));
				ps.setString(14,sbean.getGradMonth());
				ps.setString(15,sbean.getGradYear());
				ps.setInt(16,sid);
				status=ps.executeUpdate();
			}else {
				ps.close();
				ps=connector.prepareStatement(insertSQL);
				ps.setInt(1,sid);
				ps.setString(2,sbean.getFullName());
				ps.setString(3,sbean.getStreetAdd());
				ps.setString(4,sbean.getCity());
				ps.setString(5,sbean.getState());
				ps.setString(6,sbean.getZip());
				ps.setString(7,sbean.getPhone());
				ps.setString(8,sbean.getEmail());
				ps.setString(9,sbean.getUrl());
				ps.setString(10,sbean.getKnowMethod());
				ps.setString(11,sbean.getRecommend());
				ps.setString(12,sbean.getMessage());
				likeMostArr=sbean.getLikeMost();
				checkedBox="";
				for(int i=0;i<likeMostArr.length;i++) {
					checkedBox+=likeMostArr[i]+",";
				}
				ps.setString(13,checkedBox);
				ps.setString(14,sdf.format(sbean.getFillDate()));
				ps.setString(15,sbean.getGradMonth());
				ps.setString(16,sbean.getGradYear());
				status=ps.executeUpdate();
			}
			rs.close();
			ps.close();
			connector.close();
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(connector!=null) {
					connector.close();
				}
			}catch(SQLException se){
		         se.printStackTrace();
		    }
		}
		return status;
	}
	
	//retrive data from the 
	public static ArrayList<StudentBean> retrieveDataFromDB() throws SQLException {
		Connection connector=null;
		Statement st=null;
		ArrayList<StudentBean> studentList=new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			connector=DriverManager.getConnection(DB_URL,USER,PASS);
			st=connector.createStatement();
			ResultSet rs=st.executeQuery(retriveAllSQL);
			while(rs.next()) {
				StudentBean sb=new StudentBean();
				sb.setStudentID(rs.getInt("STUDENTID"));
				sb.setFullName(rs.getString("FULLNAME"));
				sb.setStreetAdd(rs.getString("STREETADDRESS"));
				sb.setCity(rs.getString("CITY"));
				sb.setState(rs.getString("STATE"));
				sb.setZip(rs.getString("ZIP"));
				sb.setPhone(rs.getString("PHONE"));
				sb.setEmail(rs.getString("EMAIL"));
				sb.setUrl(rs.getString("URL"));
				sb.setKnowMethod(rs.getString("KNOWMETHOD"));
				sb.setRecommend(rs.getString("RECOMMEND"));
				sb.setMessage(rs.getString("MESSAGE"));
				String CheckedBox  = rs.getString("LIKEMOST");
				String[] likeMostArr = CheckedBox.split(",");
				sb.setLikeMost(likeMostArr);      
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");  
				Date fillFormDate= new Date();
				String date = rs.getString("FILLDATE");
				try {
					fillFormDate=dateFormat.parse(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sb.setFillDate(fillFormDate);
				sb.setGradMonth(rs.getString("GRADMONTH"));
				sb.setGradYear(rs.getString("GRADYEAR"));
				studentList.add(sb);
			}
			rs.close();
			st.close();
			connector.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connector!=null) {
					connector.close();
				}
			}catch(SQLException se){
		         se.printStackTrace();
		    }
		}
		return studentList;
	}
	
}
