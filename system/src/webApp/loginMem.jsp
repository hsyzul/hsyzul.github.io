
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login Member</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login1.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
</head>
<body>
  <div class="container">
  <h1>WELCOME BACK,Member!</h1>
  <div class="wrapper">
    <header>Member Login Form</header>
    
    <form action="loginM" method="post">
      <div class="field email">
        <div class="input-area">
          <input type="text" name="floatingEmail" placeholder="Email Address">
          <i class="icon fas fa-envelope"></i>
          
        </div>
        <div class="error error-txt">Email can't be blank</div>
      </div>
      <div class="field password">
        <div class="input-area">
          <input type="password" name="floatingPassword" placeholder="Password">
          <i class="icon fas fa-lock"></i>
        
        </div>
        <div class="error error-txt">Password can't be blank</div>
      </div>
      <div class="pass-txt"><a href="emailGen.jsp">Forgot password?</a></div>
      <input type="submit" value="Login">
    </form>
    <div class="sign-txt">Not a member? <a href="register.jsp">Signup now</a></div>
  </div>
    
 
</body>
</html>