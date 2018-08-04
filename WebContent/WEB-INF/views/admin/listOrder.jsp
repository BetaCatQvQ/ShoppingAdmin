<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

					<li><a href="${rt }/categoryOne/list.action"><i class="fa fa-bars"></i> 分类管理</a>
					</li>
					<li><a href="listUser"><i class="fa fa-user"></i> 用户管理</a></li>
					<li><a class="active-menu" href="listOrder"><i
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
							订单管理 <small></small>
						</h1>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<!-- Advanced Tables -->
						<div class="panel panel-default">
							<div class="panel-heading">订单管理表</div>
							<div class="panel-body">
								<div class="table-responsive">
									<div class="row">
										<div class="col-sm-6">
											<div class="dataTables_length" id="dataTables-example_length">
												<label><select name="dataTables-example_length"
													aria-controls="dataTables-example"
													class="form-control input-sm"><option value="2">2</option>
														<option value="5">5</option>
														<option value="7">7</option>
														<option value="10">10</option></select> records per page</label>
											</div>
										</div>
										<div class="col-sm-6">
											<div id="dataTables-example_filter" class="dataTables_filter">
												<label>Search:<input type="search"
													class="form-control input-sm"
													aria-controls="dataTables-example"></label>
											</div>
										</div>
									</div>
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th>订单id</th>
												<th>订单号</th>
												<th>收货地址</th>

												<th>收货人姓名</th>
												<th>手机号码</th>
												<th>用户备注</th>

												<th>订单创建时间</th>
												<th>订单支付时间</th>
												<th>订单发货时间</th>
												<th>确认收货时间</th>
												<th>订单状态</th>
												<th>操作</th>

											</tr>
										</thead>
										<tbody>
											<c:forEach items="${orders.data}" var="o">
												<tr>
													<td>${o.orderId}</td>
													<td>${o.orderItemId}</td>
													<td>${o.addressName}</td>

													<td>${o.consignee}</td>
													<td>${o.phone}</td>
													<td>${o.remark}</td>

													<td>${o.orderCreateDate}</td>
													<td>${o.orderPayDate}</td>
													<td>${o.orderDeliveryDate}</td>
													<td>${o.orderConfirmDate}</td>
													<td>${o.status}</td>
													<td>
														<form action="updateOrder.action" role="form">
															<%-- 表单隐藏信息 --%>
															<input type="hidden" name="orderId" value="${o.orderId}">
															<input type="hidden" name="orderItemId"
																value="${o.orderItemId}"> <input type="hidden"
																name="addressName" value="${o.addressName}"> <input
																type="hidden" name="consignee" value="${o.consignee}">
															<input type="hidden" name="phone" value="${o.phone}">
															<input type="hidden" name="remark" value="${o.remark}">

															<input type="hidden" name="orderCreateDate"
																value="${o.orderCreateDate}"> <input
																type="hidden" name="orderPayDate"
																value="${o.orderPayDate}"> <input type="hidden"
																name="orderDeliveryDate" value="${o.orderDeliveryDate}">
															<input type="hidden" name="orderConfirmDate"
																value="${o.orderConfirmDate}">
															<%-- 更改表单状态 --%>
															<c:if test="${o.status== 5}">
																<a href="orderDelivery?order_id=${o.orderId}">
																	<button class="btn btn-primary btn-xs">发货</button>
																</a>
															</c:if>
															<select name="status" class="form-control">
																<option>待付款</option>
																<option>已发货</option>
																<option>订单完成</option>
															</select> <input type="submit" class="form-control" value="提交">
														</form>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<div class="row">
									<div class="col-sm-6">
										<div class="dataTables_info" id="dataTables-example_info"
											role="alert" aria-live="polite" aria-relevant="all">Showing
											1 to 2 of 2 entries</div>
									</div>
									<div class="col-sm-6">
										<div class="dataTables_paginate paging_simple_numbers"
											id="dataTables-example_paginate">
											<ul class="pagination">
												<li class="paginate_button previous disabled"
													aria-controls="dataTables-example" tabindex="0"
													id="dataTables-example_previous"><a href="#">Previous</a></li>
												<li class="paginate_button active"
													aria-controls="dataTables-example" tabindex="0"><a
													href="#">1</a></li>
												<li class="paginate_button next disabled"
													aria-controls="dataTables-example" tabindex="1"
													id="dataTables-example_next"><a href="#">Next</a></li>
											</ul>
										</div>
									</div>
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
	<!-- Bootstrap Js -->
	<script src="../assets/js/bootstrap.min.js"></script>
</body>
</html>
