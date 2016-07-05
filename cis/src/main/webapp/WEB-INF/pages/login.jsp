<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
 
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.5 -->
  <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="resources/plugins/iCheck/square/blue.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body class="hold-transition login-page" onload='document.loginForm.username.focus();' >

  <div class="login-box">
  <div class="login-logo">
    <a href="login"><b>CTI</b> Login</a>
  </div>
 	<div id="login-box">  
 <div class="login-box-body">
    <p class="login-box-msg">Sign in to start your session</p>




		<form name='loginForm' action="<c:url value='/login' />" method='POST'>
 <div class="form-group has-feedback">
 <div class="form-group has-feedback"><input type='text' class="form-control" name='username' placeholder='Username'>	
<span class="glyphicon glyphicon-user form-control-feedback"></span>	</div>
 <div class="form-group has-feedback">	
					 <input type='password' class="form-control" name='password' placeholder='Password' />      
<span class="glyphicon glyphicon-lock form-control-feedback"></span>
</div>
      
          <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>

 
			
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
</div>

		</form>
		
</div>
</div>

</div>

	<p>
		<c:if test="${not empty error}">
			<div class="callout callout-danger">
                <h4 align = "center"><b>Error!</b></h4>

              </div>

		</c:if>
		<c:if test="${not empty msg}">
		<div class="callout callout-success">
                <h4 align = "center"><b>You've been logged out successfully.</b></h4>
              </div>
			
		</c:if>
	</p>
	<!-- jQuery 2.1.4 -->
<script src="resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="resources/plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

	
  <footer>
    <div class="pull-right hidden-xs">
      <b>Version</b> 1.0.0
    </div>
   
    <strong>Copyright &copy; 2016 <a href="${contextPath}">Cornet Technology India Pvt Ltd</a>.</strong> All rights
    reserved.
   
  </footer>

</body>

</html>