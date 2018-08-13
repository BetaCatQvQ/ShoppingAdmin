<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>模仿天猫-后台</title>
<!-- Bootstrap Styles-->
<link href="../assets/css/bootstrap.css" rel="stylesheet" />
<!-- FontAwesome Styles-->
<link href="../assets/css/font-awesome.css" rel="stylesheet" />
<!-- Dropdown_Search_row Styles-->
<link href="../assets/css/Dropdown_Search_row.css" rel="stylesheet" />
<!-- Custom Styles-->
<link href="../assets/css/custom-styles.css" rel="stylesheet" />
<!-- Google Fonts-->
<!-- <link href='https://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' /> -->
<!-- TABLE STYLES-->
<link href="../assets/js/dataTables/dataTables.bootstrap.css"
	rel="stylesheet" />

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

					<li><a class="active-menu" href="listCategory"><i
							class="fa fa-bars"></i> 分类管理</a></li>
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
							分类管理 <small>${sessionScope.user}<small>
						</h1>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<!-- Advanced Tables -->
						<div class="panel panel-default">
							<div class="panel-heading">
								分类管理表
								<div class="col-lg-5">
									<a class="dropdown-toggle" data-toggle="dropdown" href="#">
										分类选择<span class="caret"></span>
									</a>
									<ul class="dropdown-menu categoryMenu">
										<li><a href="javascript:void(0)"
											onclick="getCategoryOne()">一级分类</a></li>
										<li><a href="javascript:void(0)"
											onclick="getCategoryTwo()">二级分类</a></li>
										<li><a href="javascript:void(0)"
											onclick="getCategoryThree()">三级分类</a></li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<div class="table-responsive">
									<div class="row">
										<div class="col-sm-6">
											<div class="dataTables_length" id="dataTables-example_length">
												<label> <input id="pageSize" type="hidden"
													value="${page.pageSize }" /> <select onclick="getByPage()"
													name="dataTables-example_length"
													aria-controls="dataTables-example"
													class="form-control input-sm" id="selectPage">
														<option value="2">2</option>
														<option value="5">5</option>
														<option value="7">7</option>
														<option value="10">10</option>
												</select> <small>records per page</small>
												</label>
											</div>
										</div>
										<div class="col-sm-3"></div>
										<div class="col-lg-3">
											<div class="input-group">
												<input type="text" class="form-control" placeholder="请输入分类名称..." id="searchParams">
												<span class="input-group-btn"> <input
													class="btn btn-default" id="searchButton"
													onclick="getbySerach()" type="button" value="Search!" />
												</span>
											</div>
												<small>search category Name</small>
											<!-- /input-group -->
										</div>
									</div>
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th>分类id</th>
												<th>分类名称</th>

												<th>编辑分类</th>
												<th>产品管理</th>
												<th>分类等级</th>
											</tr>
										</thead>
										<tbody id="categoryTable">
											<c:forEach items="${page.data}" var="c" varStatus="i">
												<tr>
													<td id="Id">${c.categoryOneId}</td>
													<td id="Name">${c.categoryOneName}</td>

													<td id="edit"><a
														href="editCategory.action?id=${c.categoryOneId}"><span
															class="glyphicon glyphicon-th-list"></span></a></td>
													<td id="listProduct"><a
														href="${rt }/product/listProduct.action?category_id=${c.categoryOneId}&category='一级分类'"><span
															class="glyphicon glyphicon-shopping-cart"></span></a></td>
													<td id="hidden">一级分类</td>
												</tr>
											</c:forEach>
											<tr>
												<td id="pageNo" style="display: none;">${page.pageNo}</td>
											</tr>
											<tr>
												<td id="pageCount" style="display: none;">${page.pageCount}</td>
											</tr>
										</tbody>
									</table>
									<div class="uiPage">
										<ul class="pagination pagination-lg">
											<li id="start"><a href="javascript:getStartPage()"><-首页</a></li>
											<li id="Back"><a href="javascript:getBackPage()"><<</a></li>
											<li id="First"><a href="javascript:getFirstPage()">1</a></li>
											<li id="Second"><a href="javascript:getSecondPage()">2</a></li>
											<li id="Third"><a href="javascript:getThirdPage()">3</a></li>
											<li id="Fourth"><a href="javascript:getFourthPage()">4</a></li>
											<li id="Next"><a href="javascript:getNextPage()">>></a></li>
											<li id="End"><a href="javascript:getEndPage()">尾页-></a></li>
										</ul>
									</div>
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
	Bootstrap Js
	<script src="../assets/js/bootstrap.min.js"></script>
	Metis Menu Js
	<!-- <script src="../assets/js/jquery.metisMenu.js"></script> -->
	Dropdown_Search_row.js
	<script src="../assets/js/dataTables/DropCategory_Search_row.js"></script>
	DATA TABLE SCRIPTS
	<!-- <script src="../assets/js/dataTables/jquery.dataTables.js"></script> -->
	<!-- <script src="../assets/js/dataTables/dataTables.bootstrap.js"></script> -->
	<!-- <script>
		$(document).ready(function() {
			$('#dataTables-example').dataTable();
		});
	</script> -->
	<!-- Custom Js -->
	<!-- <script src="../assets/js/custom-scripts.js"></script> -->


</body>
</html>
