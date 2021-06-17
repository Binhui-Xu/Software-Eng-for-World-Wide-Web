<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>NoSuchStudent</title>
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
<body>
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
        <p class="w3-large">Sorry! Cannot Find the Student!</p>
      </div>
      <br>
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
