<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Purchase</title>
<script src='<c:url value="/resources/js/jquery.js" />'
	type="text/javascript"></script>
<script src='<c:url value="/resources/js/bpopup.js" />'
	type="text/javascript"></script>
<link href='<c:url value="/resources/css/style.css" />' />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- jvectormap -->
<link rel="stylesheet"
	href="resources/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<!-- Theme style -->
<link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="resources/dist/css/skins/_all-skins.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
				function formSubmit() {
					document.getElementById("logoutForm").submit();
				}
				// Removes leading whitespaces
				function LTrim( value ) {
					
					var re = /\s*((\S+\s*)*)/;
					return value.replace(re, "$1");
					
				}

				// Removes ending whitespaces
				function RTrim( value ) {
					
					var re = /((\s*\S+)*)\s*/;
					return value.replace(re, "$1");
					
				}

				// Removes leading and ending whitespaces
				function trim( value ) {
					
					return LTrim(RTrim(value));
					
				}
				function doADD() 
				{
					var purchasenumber = document.getElementById('purchasenumber');	 
			 		var tpurchasenumber = trim(purchasenumber.value);
			 		
			 		var qty1 = document.getElementById('qty1');	 
			 		var tqty1 = trim(qty1.value);
			 		var qty2 = document.getElementById('qty2');	 
			 		var tqty2 = trim(qty2.value);
			 		var unitrate = document.getElementById('unitrate');	 
			 		var tunitrate = trim(unitrate.value);
			 		var tax = document.getElementById('tax');	 
			 		var ttax = trim(tax.value);
			 		var taxamount = document.getElementById('taxamount');	 
			 		var ttaxamount = trim(taxamount.value);
			 		var totalprice = document.getElementById('totalprice');	 
			 		var ttotalprice = trim(totalprice.value);
			 		var totalpricetax = document.getElementById('totalpricetax');	 
			 		var ttotalpricetax = trim(totalpricetax.value);
			 		

					if ( tpurchasenumber.length > 0 && 
							
							tqty1.length > 0 && 
							tqty2.length>0 &&
							tunitrate.length >0&& 
							ttax >0 && 
							ttaxamount.length > 0 && 
							ttotalprice.length >0 &&
							ttotalpricetax>0 
							) 
					{
						
							document.forms[0].submit();	
									
					} 
					else{alert("Enter All Fields"); return false; }
				}
				function doADD1() 
				{
			 		var purchasenumber = document.getElementById('purchasenumber');	 
			 		var tpurchasenumber = trim(purchasenumber.value);
			 		var purchasedate = document.getElementById('purchasedate');	 
			 		var tpurchasedate = trim(purchasedate.value);
			 		var purchasedeldate = document.getElementById('purchasedeldate');	 
			 		var tpurchasedeldate = trim(purchasedeldate.value);
			 		var customername = document.getElementById('customername');	 
			 		var tcustomername = trim(customername.value);
			 		
					if ( tpurchasenumber.length > 0 && 
							tpurchasedate.length > 0 && 
							tpurchasedeldate.length>0 &&
							tcustomername.length > 0 ) 
					{
						
							document.forms[0].submit();	
									
					} 
					else{alert("Enter All Fields"); return false; }
				}
				function setValue(purchasenumber,qty,unitrate,tax,taxamount,totalprice,totalpricetax)
				{	
					var a = [purchasenumber,qty,unitrate,tax,taxamount,totalprice,totalpricetax,];
					document.getElementById("radio").value=a;
					document.getElementById("purchaseno").value = a[0];
					document.getElementById("qtys1").value = a[1];
					document.getElementById("qtys2").value = a[1];
					document.getElementById("unitrates").value = a[2];
					document.getElementById("taxs").value = a[3];
					document.getElementById("taxamounts").value = a[4];
					document.getElementById("totalprices").value = a[5];
					document.getElementById("totalpricetaxs").value = a[6];

		
				}
				function deleteitem()
				{
					var p = document.getElementById("purchaseid").value;
					window.location.replace("deletepurchaseitemdetail?purchaseitemdetail="+ p);
				}
			</script>

<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<!-- For login user -->
		<c:url value="/logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

		


			<div class="wrapper">
		<c:if test="${pageContext.request.userPrincipal.name != null}">

				<header class="main-header"> <!-- Logo --> <a
					href="${contextPath}" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
					<span class="logo-mini"><img
						src="resources/dist/img/cornet.png"> CTI</span> <!-- logo for regular state and mobile devices -->
					<span class="logo-lg"><img
						src="resources/dist/img/cornet.png"> CTI</span>
				</a> <!-- Header Navbar: style can be found in header.less --> <nav
					class="navbar navbar-static-top"> <!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a> <!-- Navbar Right Menu -->
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="resources/dist/img/images.png" class="user-image"
								alt="User Image"> <span class="hidden-xs">${pageContext.request.userPrincipal.name}</span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img
									src="resources/dist/img/images.png" class="user-image"
									alt="User Image">
									<p>${pageContext.request.userPrincipal.name}</p></li>
								<!-- Menu Body -->

								<!-- Menu Footer-->
								<li class="user-footer"><a
									href="${contextPath}/loadUserdetail?user=${pageContext.request.userPrincipal.name}"
									class="btn btn-default btn-flat">Update Profile</a> <a
									href="${contextPath}/changePassword"
									class="btn btn-default btn-flat">Change Password</a> <a
									href="javascript:formSubmit()" class="btn btn-default btn-flat">Sign
										out</a></li>
							</ul></li>
						<!-- Control Sidebar Toggle Button -->

					</ul>
				</div>

				</nav> </header>
				<!-- Left side column. contains the logo and sidebar -->
				<aside class="main-sidebar"> <!-- sidebar: style can be found in sidebar.less -->
				<section class="sidebar"> <!-- Sidebar user panel -->
				<div class="user-panel">
					<div class="pull-left image"></div>

				</div>

				<!-- /.search form --> <!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu">
					<li class="header">MAIN NAVIGATION</li>
					<li class="active treeview"><a href="${contextPath}"> <i
							class="fa fa-home"></i> <span>Home</span>
					</a></li>
					<li class="treeview"><a href="#"> <i class="fa fa-male"></i>
							<span>Clients</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="${contextPath}/listclient"><i
									class="fa fa-circle-o text-aqua"></i> List Clients</a></li>
							<li><a href="${contextPath}/newclient"><i
									class="fa fa-circle-o text-aqua"></i> New Client</a></li>
						</ul></li>


					<li class="treeview"><a href="#"> <i class="fa fa-inr"></i>
							<span>Purchases</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="${contextPath}/listpurchase"><i
									class="fa fa-circle-o text-aqua"></i> List POs</a></li>
							<li><a href="${contextPath}/newpurchase"><i
									class="fa fa-circle-o text-aqua"></i> New PO</a></li>
						</ul></li>


					<li class="treeview"><a href="#"> <i class="fa fa-file"></i>
							<span>Invoices</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="${contextPath}/listinvoice"><i
									class="fa fa-circle-o text-aqua"></i> List Invoices</a></li>
							<li><a href="${contextPath}/newinvoice"><i
									class="fa fa-circle-o text-aqua"></i> New Invoice</a></li>
						</ul></li>


					<li class="treeview"><a href="#"> <i class="fa fa-cubes"></i>
							<span>Products</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-circle-o text-aqua"></i>
									Items <i class="fa fa-angle-left pull-right"></i></a>
								<ul class="treeview-menu">
									<li><a href="${contextPath}/listitems"><i
											class="fa fa-square-o text-yellow"></i> List Items</a></li>
									<li><a href="${contextPath}/newitems"><i
											class="fa fa-square-o text-yellow"></i> New Item</a></li>
								</ul></li>

							<li><a href="#"><i class="fa fa-circle-o text-aqua"></i>
									Components <i class="fa fa-angle-left pull-right"></i></a>
								<ul class="treeview-menu">
									<li><a href="${contextPath}/listcomponent"><i
											class="fa fa-square-o text-yellow"></i> List Components</a></li>
									<li><a href="${contextPath}/newcomponent"><i
											class="fa fa-square-o text-yellow"></i> New Component</a></li>
								</ul></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i
							class="fa fa-black-tie"></i> <span>Engineers</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="${contextPath}/listEmployee"><i
									class="fa fa-circle-o text-aqua"></i> List Engineers</a></li>
							<li><a href="${contextPath}/newemployee"><i
									class="fa fa-circle-o text-aqua"></i> New Engineer</a></li>
						</ul></li>


					<li class="treeview"><a href="#"> <i class="fa fa-group"></i>
							<span>Users</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="${contextPath}/listusers"><i
									class="fa fa-circle-o text-aqua"></i> List Users</a></li>
							<li><a href="${contextPath}/newuser"><i
									class="fa fa-circle-o text-aqua"></i> New User</a></li>
						</ul></li>


			      
    <%--
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
       
        --%>    
       

				</ul>

				</section> <!-- /.sidebar --> </aside>
</c:if>
				<!-- Content Wrapper. Contains page content -->
				<div class="content-wrapper">
					<!-- Content Header (Page header) -->
					<section class="content-header">

					<ol class="breadcrumb">
						<li><a href="${contextPath}"><i class="fa fa-home"></i>
								Home</a></li>
						<li>Purchases</li>
						<li><a href="${contextPath}/listpurchase">List Purchases</a></li>
						<li class="active">Update Purchase</li>
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
					<script
						src="resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
					<script
						src="resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
					<!-- SlimScroll 1.3.0 -->
					<script src="resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
					<!-- ChartJS 1.0.1 -->
					<script src="resources/plugins/chartjs/Chart.min.js"></script>
					<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
					<script src="resources/dist/js/pages/dashboard2.js"></script>
					<!-- AdminLTE for demo purposes -->
					<script src="resources/dist/js/demo.js"></script>
		
		<div align="center">
			<form:form action="updatepurchase" onsubmit="return doADD1();" method="post"
				commandName="purchaseForm">
				<form:hidden path="purchase_ID" id="purchaseid"
					value="${purchaseForm.getPurchase_ID()}" />
	<div class="login-box">
  
  <div class="login-box-body">
		
          <div class="box box-primary">
            <div class="box-header with-border">
                 <h3 class="box-title">Update Purchase</h3>
            
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            
              
                <div class="form-group">
                  
<form:input id="purchasenumber" placeholder="Purchase Number" path="purchase_number" class="form-control"/>                  </div>
              
               
                <div class="form-group">
                 
   <form:input id="purchasedate" placeholder="Purchase Date" path="purchase_date" class="form-control"/>                   
                  </div>
              
               
                
                 <div class="form-group">
                 
 <form:input id="purchasedeldate" placeholder="Purchase Delivery Date" path="purchase_del_date" class="form-control"/>                 
                </div>
                
                   <div class="form-group">
             
  <form:select id="customername" path="purchase_cust_name" class = "form-control">
							<form:option value="0" label="Customer Name" />
							<c:forEach items="${cust}" var="clientDetail">
							
							<form:option value="${clientDetail.client_ID}" label='${clientDetail.clientname}'/>
							
							</c:forEach>
						</form:select>                  </div>
                
               
              <!-- /.box-body -->
              <div class="box-footer">
         
                <button type="submit" class="btn btn-primary pull-center">Update Purchase</button>
	</div>
	</div>
	</div>
	</div>
	
			</form:form>
			<div align=center>

				<section class="content">
				<div class="row">

					<div class="col-xs-12">

						<div class="box">
							<div class="box-header">
								<h3>Purchase Item List</h3>
								<c:if test="${!empty purchaseitemdetaillist}">


									<div class="box-body no-padding">

										<!-- /.box-header -->
										<div class="box-body">
											<table id="example1"
												class="table table-bordered table-striped">
												<thead>
													<tr>
													<th></th>
														<th>S.No</th>
														<th>Purchase Number</th>
														<th>Quantity</th>
														<th>Unit Rate</th>
														<th>Tax</th>
														<th>Tax Amount</th>
														<th>Total Price</th>
														<th>Total Price (with tax)</th>

													</tr>
												</thead>
												<tbody>

													<c:set var="sno" value="0" />
													<c:forEach items="${purchaseitemdetaillist}"
														var="purchaseitemdetailDetail">
														<tr>
													<td>	<input type="radio" id="radio" name="radio" onclick="setValue('${purchaseitemdetailDetail.purchasenumber}','${purchaseitemdetailDetail.qty}','${purchaseitemdetailDetail.unitrate}','${purchaseitemdetailDetail.tax}', '${purchaseitemdetailDetail.taxamount}', '${purchaseitemdetailDetail.totalprice}', '${purchaseitemdetailDetail.totalpricetax}');" ></td>
														
															<td><c:set var="sno" value="${sno+1 }" /> <c:out
																	value="${sno }" /></td>
															<td>${purchaseitemdetailDetail.purchasenumber}</td>
															<td>${purchaseitemdetailDetail.qty}</td>
															<td>${purchaseitemdetailDetail.unitrate}</td>
															<td>${purchaseitemdetailDetail.tax}</td>
															<td>${purchaseitemdetailDetail.taxamount}</td>
															<td>${purchaseitemdetailDetail.totalprice}</td>
															<td>${purchaseitemdetailDetail.totalpricetax}</td>
													</c:forEach>



												</tbody>



											</table>
										</div>
										<!-- /.box-body -->
									</div>
								</c:if>
							</div>
							<!-- /.box -->
						</div>
						<!-- /.col -->
					</div>

					<button type="button" class="btn btn-primary pull-center"
						data-toggle="modal" data-target="#myModal1">Add Purchase
						Item</button>
					<button type="button" class="btn btn-primary pull-center"
						data-toggle="modal" data-target="#myModal2">Modify
						Purchase Item</button>
					<button type="button" class="btn btn-primary pull-center"
						data-toggle="modal" data-target="#myModal3">Delete
						Purchase Item</button>
				</div>
				<!-- /.row --> </section>

				<!-- /.content -->

				<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<form:form action="createnewpurchaseitemdetail" onsubmit="return doADD();" method="post"
									commandName="purchaseitemdetailForm">
												<form:hidden path="product_ID"/>
								
				<div class="login-box">
  
  <div class="login-box-body">
		
          <div class="box box-primary">
            <div class="box-header with-border">
                 <h3 class="box-title">New Purchase Item</h3>
            
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            
              
                <div class="form-group">
                  
 <form:input path="purchasenumber" id="purchasenumber" placeholder="Purchase Number" class="form-control" />                  </div>
              
               
                <div class="form-group">
              
 <form:input path="qty" id="qty1" placeholder="Quantity" class="form-control"/>
                  <form:input path="qty" id="qty2" placeholder="Unit" class="form-control"/>                   
                  </div>
              
             
                
                 <div class="form-group">
                 
 <form:input path="unitrate" id="unitrate" placeholder="Unitrate" class="form-control"/>                 
                </div>
                
                   <div class="form-group">
             
 <form:input path="tax" id="tax" placeholder="Tax" class="form-control"/>                  </div>
                
                 <div class="form-group">
             
  <form:input path="taxamount" id="taxamount" placeholder="Tax Amount" class="form-control"/>				</div>
                  
                 
                  
                    <div class="form-group">
             
 <form:input path="totalprice" id="totalprice" placeholder="Total Price" class="form-control"/>     				</div>
                  
                    <div class="form-group">
             
 <form:input path="totalpricetax" id="totalpricetax" placeholder="Total Price (With tax)" class="form-control"/>  					</div>
              
     </div>  
	</div>
	</div>							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="submit" class="btn btn-primary">Save
									changes</button>
									<button type="reset" class="btn btn-primary">Reset</button>
							</div>
							</form:form>						</div>
					</div>
				</div>
				
			</div>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					
					<div class="modal-body">
						<form:form action="updatepurchaseitemdetail" id="updatepurchaseitemdetail" method="post"
			commandName="purchaseitemdetailForm">
							
			<form:hidden path="product_ID" 
							value="${purchaseitemdetailForm.getProduct_ID()}" />
					
		<div class="login-box">
  
  <div class="login-box-body">
		
          <div class="box box-primary">
            <div class="box-header with-border">
                         <h3 class="box-title">Update Purchase Item</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            
              <div class="box-body">
               <div class="form-group">
                 <form:input id="purchaseno" path="purchasenumber" placeholder="Purchase Number" class="form-control" />
                 
              
                </div>
                
                
                  <div class="form-group">
              
 <form:input path="qty" id="qtys1" placeholder="Quantity" class="form-control"/>
                  <form:input path="qty" id="qtys2" placeholder="Unit" class="form-control"/>                   
                  </div>
              
             
                
                 <div class="form-group">
                 
 <form:input path="unitrate" id="unitrates" placeholder="Unitrate" class="form-control"/>                 
                </div>
                
                   <div class="form-group">
             
 <form:input path="tax" id="taxs" placeholder="Tax" class="form-control"/>                  </div>
                
                 <div class="form-group">
             
  <form:input path="taxamount" id="taxamounts" placeholder="Tax Amount" class="form-control"/>				</div>
                  
                 
                  
                    <div class="form-group">
             
 <form:input path="totalprice" id="totalprices" placeholder="Total Price" class="form-control"/>     				</div>
                  
                    <div class="form-group">
             
 <form:input path="totalpricetax" id="totalpricetaxs" placeholder="Total Price (With tax)" class="form-control"/>  					</div>
              
            
	</div>
	</div>
	</div>
	</div>			
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">Save
									changes</button>
					</div>
					</form:form>
					</div>
					
				</div>
			</div>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
				
					
					<div class="modal-body">Do you really want to delete the purchase item?
					 </div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" onclick="deleteitem();" class="btn btn-primary">Delete</button>
					</div>
				</div>
			</div>

		</div>


		</div>

</div>


  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 1.0.0
    </div>
    <strong>Copyright &copy; 2016 <a href="${contextPath}">Cornet Technology India Pvt Ltd</a>.</strong> All rights
    reserved.
  </footer>
  </div>
	</sec:authorize>
</body>
</html>