/**
 * 
 */
package com.swe642.studentSurvey;

import java.util.Date;

/**
 * @author xubinhui
 *
 */
public class StudentBean {
	private String fullName, streetAdd, city, state, zip, phone, email, url, knowMethod,recommend, message, gradMonth, gradYear;
	private int studentID;
	private Date fillDate = new Date();
	private String[] likeMost = new String[6];
	
	public StudentBean( String fullName,int studentID, String streetAdd, String zip,String city, String state, 
			String phone, String email, String url,String[] likeMost,String knowMethod, String recommend, String message,String gradMonth, String gradYear,Date fillDate){
		this.studentID = studentID;
		this.fullName = fullName;
		this.streetAdd = streetAdd;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
		this.url = url;
		this.knowMethod = knowMethod;
		this.recommend = recommend;
		this.message = message;
		this.likeMost = likeMost;
		this.fillDate = fillDate;
		this.gradMonth = gradMonth;
		this.gradYear = gradYear;
	}
	public StudentBean() {
		// TODO Auto-generated constructor stub
	}
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getStreetAdd() {
		return streetAdd;
	}

	public void setStreetAdd(String streetAdd) {
		this.streetAdd = streetAdd;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getKnowMethod() {
		return knowMethod;
	}

	public void setKnowMethod(String knowMethod) {
		this.knowMethod = knowMethod;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String feedback) {
		this.message = message;
	}

	public String getGradMonth() {
		return gradMonth;
	}

	public void setGradMonth(String gradMonth) {
		this.gradMonth = gradMonth;
	}

	public String getGradYear() {
		return gradYear;
	}

	public void setGradYear(String gradYear) {
		this.gradYear = gradYear;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public Date getFillDate() {
		return fillDate;
	}

	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
	}

	public String[] getLikeMost() {
		return likeMost;
	}

	public void setLikeMost(String[] likeMost) {
		this.likeMost = likeMost;
	}
	
}
