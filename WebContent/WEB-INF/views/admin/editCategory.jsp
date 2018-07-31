<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>模仿天猫-后台</title>
<!-- Bootstrap Styles-->
<link href="../assets/css/bootstrap.css" rel="stylesheet" />
<!-- FontAwesome Styles-->
<link href="../assets/css/font-awesome.css" rel="stylesheet" />
<!-- Morris Chart Styles-->

<!-- Custom Styles-->
<link href="../assets/css/custom-styles.css" rel="stylesheet" />
<!-- Google Fonts-->
<link href='https://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default top-navbar" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="listCategory">Tmall</a>
			</div>
		</nav>

		<!--/. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">

					<li><a class="active-menu"
						href="${rt }/cateogryOne/list.action"><i class="fa fa-bars"></i>
							分类管理</a></li>
					<li><a href="listUser"><i class="fa fa-user"></i> 用户管理</a></li>
					<li><a href="${rt }/order/listOrder.action"><i
							class="fa fa-list-alt"></i> 订单管理</a></li>
					<li><a href="listLink"><i class="fa fa-link"></i> 推荐链接管理</a></li>
				</ul>
			</div>

		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-header">
							分类管理 <small> - id:${category.id} </small>
						</h1>
					</div>
				</div>

				<div class="row">
					<div class="col-md-3">
						<a href="javascript:history.back()" class="btn btn-success">返回上一页</a>
					</div>
				</div>
				<br>

				<div class="row">
					<div class="col-md-6">
						<!-- Advanced Tables -->
						<div class="panel panel-default">
							<div class="panel-heading">编辑分类</div>
							<div class="panel-body">
								<div class="row col-lg-12">
									<fm:form action="uptCategoryOne.action" method="post"
										modelAttribute="categoryOne">
										<div class="form-group">
											<%-- 隐藏id属性，一并提交 --%>
											<fm:input type="hidden" path="categoryOneId"/><label>分类名称：</label>
											<fm:input path="categoryOneName"/><br />
											<div class="pull-right">
												<input type="submit" class="btn btn-default">
											</div>
										</div>
									</fm:form>
								</div>

							</div>
						</div>
						<!--End Advanced Tables -->
					</div>
				</div>

			</div>
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->
	<!-- JS Scripts-->
	<!-- jQuery Js -->
	<script src="../assets/js/jquery-1.10.2.js"></script>
	<!-- Bootstrap Js -->
	<script src="../assets/js/bootstrap.min.js"></script>
</body>
</html>
