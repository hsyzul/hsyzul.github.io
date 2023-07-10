<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
response.addHeader("Pragma", "no-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.addHeader("Cache-Control", "pre-check=0, post-check=0");
response.setDateHeader("Expires", 0);

if (session.getAttribute("sessionEmail") == null)
	response.sendRedirect("loginMem.jsp");

if(session.getAttribute("sessionRole") != null){
	String sesRol = (String)session.getAttribute("sessionRole");
	if (sesRol.equalsIgnoreCase("admin"))
		response.sendRedirect("loginAd.jsp");
}
int sessionId = (Integer)session.getAttribute("sessionId");
String sesEmail = (String)session.getAttribute("sessionEmail");
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<title>Admin</title>
	<link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
	<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminlayout.css">
</head>

<header>

 <div class="logo-wrapper">
    <img src="${pageContext.request.contextPath}/images/logo.png" alt="" class="logo-image"/>
     <h2 class="Header-title">GPBS</h2>
  </div>
  
  <div class="user-wrapper">
    <div class="dropdown">
      <button class="dropbtn">
        <img src="${pageContext.request.contextPath}/images/profile.png" width="40" height="40" alt="logo" />
        <i class="fa fa-caret-down"></i>
      </button>
      <div class="dropdown-content">
        <a href="#">My Profile</a>
        <a href="#">Logout</a>
      </div>
    </div>
  </div>
</header>
<body>

	<nav>
 
  		<div class="brand">
  		<ul>
  		
  		 <li >
			
  	
  		<li>
  		<a href="memberNoti.jsp">
  				<i class="fas fa-bell  "></i>
  				<span class="nav-item  ">Notification</span>
  			</a></li>
  			<li><a href="profile.jsp">
  				<i class="fas fa-user-circle"></i>
  				<span class="nav-item">Profile</span>
  			</a></li>
  		<li><a href="payment.jsp">
  				<i class="fas fa-receipt"></i>
  				<span class="nav-item">Payment</span>
  			</a></li>
  		
  		<li><a href="#" class="logout">
  				<i class="fas fa-sign-out-alt"></i>
  				<span class="nav-item">Log Out</span>
  			</a></li>
  		</ul>
  		</div>
  		  	
  </nav>

	<div class="main-content">
		<main>
			<div class="cards">
				<div class="card-single">
					<div>
						<h1></h1>
					</div>
				</div>
			</div>
			<div class="container3">
				 <div class="row">
                    <div class="col-lg-12 ">
                        <div class="alert alert-info">
                             <strong>Welcome! </strong> You Have No pending Task For Today.
                        </div>
                       
                    </div>
                    </div>
			</div>
			 <br>         

		</main>
	</div>
</body>
</html>