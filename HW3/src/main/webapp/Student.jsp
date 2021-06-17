<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
	import="java.util.*"  import= "java.text.SimpleDateFormat" import="com.swe642.studentSurvey.StudentDAO" import = "com.swe642.studentSurvey.StudentBean"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Information</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
body {font-family: "Times New Roman", Georgia, Serif;}
h1, h2, h3, h4, h5, h6 {
  font-family: "Playfair Display";
  letter-spacing: 5px;
}
</style>
</head>

<body>
	
	<%! String id=""; %>
	<%! int sid = 0; %>
	<%! List<Integer> ids = new ArrayList<Integer>(); %>
  	<%! String[] likemost = new String[6]; %>
  	<% id=request.getParameter("SID");%>
  <%
    StudentBean sb=new StudentBean();
    StudentDAO sdao=new StudentDAO();
    ArrayList<StudentBean> stdList=new ArrayList<StudentBean>();
    stdList=sdao.retrieveDataFromDB();
    for(StudentBean student:stdList){
    	ids.add(student.getStudentID());
    	if(student.getStudentID()==Integer.parseInt(id)){
    		sb=student;
    	}
    }
    if(!ids.contains(Integer.parseInt(id))){
        response.sendRedirect("NoSuchStudent.jsp");
    }
    likemost=sb.getLikeMost();
    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	String filldate=df.format(sb.getFillDate());
  	%> 


<!-- Navbar (sit on top) -->
<nav class="w3-top">
    <div>
      <a href="https://www2.gmu.edu/"><img src="pictures/biglogo.jpg" alt="gmuLogo" id="bigLogo"></a>
    </div>
    <div>
      <a href="#home" class="w3-bar-item w3-button" id="titleBox"><h1>Department of Computer Science</h1></a>
    </div>  
    <!-- Right-sided navbar links. Hide them on small screens -->
    <div class="w3-right w3-hide-small" id="navButton" style="color: white">
      <a href="surveypage3.html" class="w3-bar-item w3-button">Go Back to Survey Page</a>
    </div>
</nav>

<!-- Header -->
<header class="w3-display-container w3-content w3-wide" style="max-width:1600px;min-width:500px" id="home">
  <img class="w3-image" src="pictures/csdeptpic5.jpg" alt="VSE Building1" width="1600" height="800">
  <div class="w3-display-bottomleft w3-padding-large w3-opacity">
    <h2 class="w3-xxlarge">CS DEPARTMENT</h2>
  </div>
</header>


<!-- Page content -->
<div class="w3-content" style="max-width:1100px">

  <!-- Congratulation -->
  <div class="w3-row w3-padding-64" id="about">
      <div id="congtitle">
        <!-- <h1 class="w3-center">CONGRATULATIONS</h1> -->
        <p class="w3-large">Here Is The Detail Information of Student whose ID is <%= id%></p>
      </div>
      <br>
      <!-- Student Detailed Information-->
      <div id="showDetails">
        <table border="1">
        	<tr>
        		<th>Student ID:</th>
        		<th>Full Name:</th>
        		<th>Street Address:</th>
        		<th>City:</th>
        		<th>State:</th>
        		<th>ZipCode:</th>
        		<th>Phone Number:</th>
        		<th>Email:</th>
        		<th>URL:</th>
        		<th>How to Known the University:</th>
        		<th>Recommend Intention:</th>
        		<th>Message:</th>
        		<th>Most liked part of the University:</th>
        		<th>Date of Fill the Form:</th>
        		<th>High School Graduation Time:</th>
        	</tr>
        	<tr>
        		<td><%= sb.getStudentID() %></td>
        		<td><%= sb.getFullName() %></td>
        		<td><%= sb.getStreetAdd() %></td>
        		<td><%= sb.getCity() %></td>
        		<td><%= sb.getState() %></td>
        		<td><%= sb.getZip() %></td>
        		<td><%= sb.getPhone() %></td>
        		<td><%= sb.getEmail() %></td>
        		<td><%= sb.getUrl() %></td>
        		<td><%= sb.getKnowMethod() %></td>
        		<td><%= sb.getRecommend() %></td>
        		<td><%= sb.getMessage() %></td>
        		<td><% for(String like:likemost){%>
	               <ul>
	                 <li><%= like%></li>
	               </ul>
	          	<%} %>
        		</td>
        		<td><%= filldate %></td>
        		<td><%= sb.getGradMonth() %>/<%= sb.getGradYear() %></td>
        	</tr>
        </table>
      </div>
  </div>
<hr>
<!-- End page content -->
</div>

<!-- Footer -->
<footer class="footer">
  <div>
    <button id="homePageButton"><a href="index.html" class="w3-bar-item w3-button">Back to Binhui Xu's Homepage</a></button>
  </div>
  <div style="color: white;">
    <p>Department of Computer Science</p>
    <p>Nguyen Engineering Building</p>
    <p>4400 University Drive</p>
    <p>Fairfax, VA 22030</p>
  </div>
  <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-text-green">w3.css</a></p>
  <div id="footerLogo">
      <a href="https://www2.gmu.edu/"><img src="pictures/biglogo.jpg" alt="GMULogo" id="bigLogo"></a>
  </div>
</footer>

</body>
</html>
