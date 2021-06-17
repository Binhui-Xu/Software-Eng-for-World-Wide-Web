/**
 * 
 */
package com.swe642.studentSurvey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author xubinhui
 *
 */
@WebServlet("/survey")
public class surveyServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		//get data from the 10 numbers input field
		String data =request.getParameter("ten_numbers");
		String[] numString=data.split(",");
		//put 10 input integers in an array
		int[] numArray=new int[numString.length];
		for(int i =0;i<numString.length;i++) {
			numArray[i]=Integer.parseInt(numString[i]);
		}
		DataProcessor dp=new DataProcessor();
		dp.computation(numArray);
		DataBean databean=new DataBean();
		databean.setMean(dp.mean);
		databean.setStandDev(dp.standDev);
		request.setAttribute("databean",databean);
		
		//save data entered in the student survey form
		String fullname=request.getParameter("full_name");
		int studentID=Integer.parseInt(request.getParameter("sid"));
		String sAddress=request.getParameter("streeAddress");
		String zipcode=request.getParameter("zip_code");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String phoneNum=request.getParameter("phone_num");
		String email=request.getParameter("email");
		String url=request.getParameter("URL");
		String likeMost[]=request.getParameterValues("likeMost[]");
		String knowMethod=request.getParameter("method");
		String recommend=request.getParameter("likely");
		String message=request.getParameter("message");
		String gradData=request.getParameter("DOBMonth");
		String gradYear=request.getParameter("graduateYear");
		String filldata=request.getParameter("date");
		Date today=new Date();
		SimpleDateFormat dataFormat=new SimpleDateFormat("yyyy-MM-dd");
		try {
			today=dataFormat.parse(filldata);
		}catch(ParseException e1) {
			e1.printStackTrace();
		}
		StudentBean sbean=new StudentBean(fullname,studentID,sAddress,zipcode,city,state,phoneNum,email,url,likeMost,knowMethod,recommend,message,gradData,gradYear,today);
		int status=StudentDAO.saveDataToDB(sbean);
		if (status>=0) {
			ArrayList<StudentBean> studentList=new ArrayList<StudentBean>();
			try {
				studentList=StudentDAO.retrieveDataFromDB();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HttpSession session=request.getSession();
			session.setAttribute("studentList",studentList);
			HttpSession session2=request.getSession();
			session2.setAttribute("studentList",studentList);
			if(dp.mean>=90.0) {
				RequestDispatcher rd1=request.getRequestDispatcher("WinnerAcknowledgement.jsp");
				rd1.forward(request,response);
			}else {
				RequestDispatcher rd2=request.getRequestDispatcher("SimpleAcknowledgement.jsp");
				rd2.forward(request,response);
			}
			RequestDispatcher rd3 = request.getRequestDispatcher("Student.jsp");
			rd3.forward(request, response);
		}else {
			System.out.println("failed to saved student survey!");
		}
	}
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {	
		PrintWriter out = response.getWriter();
        out.write("this is doGet method");
	}
}

