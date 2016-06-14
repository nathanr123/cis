<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase List</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">

  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="resources/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="resources/dist/css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<!-- For login user -->
		<c:url value="/logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />


			<script>
				function formSubmit() {
					document.getElementById("logoutForm").submit();
				}
			</script>
	

			<c:if test="${pageContext.request.userPrincipal.name != null}">
<div class="wrapper">

  <header class="main-header">

    <!-- Logo -->
    <a href="${contextPath}" class="logo">
    
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><img src="resources/dist/img/cornet.png"> CTI</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><img src="resources/dist/img/cornet.png"> CTI</span>
    </a>

    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
                   <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <img src="resources/dist/img/images.png" class="user-image" alt="User Image">
              <span class="hidden-xs">${pageContext.request.userPrincipal.name}</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
             
  <img src="resources/dist/img/images.png" class="user-image" alt="User Image">
                <p>
                 ${pageContext.request.userPrincipal.name}
                </p>
              </li>
              <!-- Menu Body -->
             
              <!-- Menu Footer-->
              <li class="user-footer">
                  <a href="${contextPath}/loadUserdetail?user=${pageContext.request.userPrincipal.name}" class="btn btn-default btn-flat">Update Profile</a>
                  <a href="${contextPath}/changePassword" class="btn btn-default btn-flat">Change Password</a>
                        
	          <a href="javascript:formSubmit()" class="btn btn-default btn-flat">Sign out</a>
                
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          
        </ul>
      </div>

    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
       
        </div>
      
      </div>
    
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        <li class="active treeview">
          <a href="${contextPath}">
            <i class="fa fa-home"></i> <span>Home</span> 
          </a>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-male"></i>
            <span>Clients</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="${contextPath}/listclient"><i class="fa fa-circle-o text-aqua"></i> List Clients</a></li>
            <li><a href="${contextPath}/newclient"><i class="fa fa-circle-o text-aqua"></i>  New Client</a></li>
          </ul>
        </li>


        <li class="treeview">
          <a href="#">
            <i class="fa fa-inr"></i>
            <span>Purchases</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="${contextPath}/listpurchase"><i class="fa fa-circle-o text-aqua"></i> List POs</a></li>
            <li><a href="${contextPath}/newpurchase"><i class="fa fa-circle-o text-aqua"></i>  New PO</a></li>
          </ul>
        </li>


        <li class="treeview">
          <a href="#">
            <i class="fa fa-file"></i>
            <span>Invoices</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="${contextPath}/listinvoice"><i class="fa fa-circle-o text-aqua"></i> List Invoices</a></li>
            <li><a href="${contextPath}/newinvoice"><i class="fa fa-circle-o text-aqua"></i>  New Invoice</a></li>
          </ul>
        </li>


                <li class="treeview">
          <a href="#">
            <i class="fa fa-cubes"></i> <span>Products</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li>
              <a href="#"><i class="fa fa-circle-o text-aqua"></i> Items <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="${contextPath}/listitems"><i class="fa fa-square-o text-yellow"></i> List Items</a></li>
                <li>
                  <a href="${contextPath}/newitems"><i class="fa fa-square-o text-yellow"></i>  New Item</a>
                                  </li>
              </ul>
            </li>

            <li>
              <a href="#"><i class="fa fa-circle-o text-aqua"></i> Components <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="${contextPath}/listcomponent"><i class="fa fa-square-o text-yellow"></i> List Components</a></li>
                <li>
                  <a href="${contextPath}/newcomponent"><i class="fa fa-square-o text-yellow"></i>  New Component</a>
                                  </li>
              </ul>
            </li>
</ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-black-tie"></i>
            <span>Engineers</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="${contextPath}/listEmployee"><i class="fa fa-circle-o text-aqua"></i> List Engineers</a></li>
            <li><a href="${contextPath}/newemployee"><i class="fa fa-circle-o text-aqua"></i>  New Engineer</a></li>
          </ul>
        </li>


        <li class="treeview">
          <a href="#">
            <i class="fa fa-group"></i>
            <span>Users</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="${contextPath}/listusers"><i class="fa fa-circle-o text-aqua"></i> List Users</a></li>
            <li><a href="${contextPath}/newuser"><i class="fa fa-circle-o text-aqua"></i>  New User</a></li>
          </ul>
        </li>
        
        
        <li class="treeview">
          <a href="#">
            <i class="fa fa-briefcase"></i>
            <span>Jobs</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> List Jobs</a></li>
            <li><a href="#"><i class="fa fa-circle-o text-aqua"></i>  New Job</a></li>
          </ul>
        </li>

	  <li class="treeview">
          <a href="#">
            <i class="fa fa-file-text-o"></i>
            <span>Reports</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-circle-o text-aqua"></i>Item Based</a></li>
            <li><a href="#"><i class="fa fa-circle-o text-aqua"></i>Invoice Based</a></li>
            <li><a href="#"><i class="fa fa-circle-o text-aqua"></i>Job Based</a></li>
            <li><a href="#"><i class="fa fa-circle-o text-aqua"></i>Warrant Based</a></li>
          </ul>
        </li>
        
             </ul>
             
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
     
      <ol class="breadcrumb">
        <li><a href="${contextPath}"><i class="fa fa-home"></i> Home</a></li>
         <li>Purchases
        </li>
        <li class="active">List POs
        </li>
      </ol>
    </section>

   

<!-- jQuery 2.2.0 -->
<script src="resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="resources/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="resources/dist/js/app.min.js"></script>
<!-- Sparkline -->
<script src="resources/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- SlimScroll 1.3.0 -->
<script src="resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- ChartJS 1.0.1 -->
<script src="resources/plugins/chartjs/Chart.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="resources/dist/js/pages/dashboard2.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="resources/dist/js/demo.js"></script>


</c:if>

	<c:if test="${not empty msg}">
		<tr>
			<td colspan="2" align="center">${msg}</td>
		</tr>
	</c:if>

	<h3>Purchase List</h3>
	<c:if test="${!empty purchaselist}">
		 
            <div class="box-body no-padding">
              <table class="table table-striped">

			<tr>
				<th>S.No</th>
				<th>Purchase Number</th>
				<th>Purchase Date</th>
				<th>Purchase Delivery Date</th>
				<th>Customer Name</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<c:set var="sno" value = "0"/>
			<c:forEach items="${purchaselist}" var="purchaseDetail">
				<tr>
				<td><c:set var="sno" value = "${sno+1 }"/>
				<c:out value="${sno }"/></td>
					<td>${purchaseDetail.purchase_number}</td>
					<td>${purchaseDetail.purchase_date}</td>
					<td>${purchaseDetail.purchase_del_date}</td>
					<td>${purchaseDetail.purchase_cust_name}</td>
					<td> <a href="${contextPath}/loadpurchase?purchase=${purchaseDetail.purchase_ID}">Update </a></td>
					<td><a href="${contextPath}/deletepurchase?purchase=${purchaseDetail.purchase_ID}">Delete </a></td>
					<td><a href="${contextPath}/listpurchaseitemdetail?purchase=${purchaseDetail.purchase_ID}">List Purchase Item</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</sec:authorize>
</body>
</html>