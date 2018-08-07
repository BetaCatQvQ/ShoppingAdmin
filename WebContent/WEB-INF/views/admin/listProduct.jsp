<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>模仿天猫-后台</title>
<!-- Bootstrap Styles-->
<link href="${root }/assets/css/bootstrap.css" rel="stylesheet" />
<!-- FontAwesome Styles-->
<link href="${root }/assets/css/font-awesome.css" rel="stylesheet" />
<!-- Morris Chart Styles-->
<!-- Custom Styles-->
<link href="${root }/assets/css/custom-styles.css" rel="stylesheet" />
<!-- Google Fonts-->
<link href='https://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<!-- TABLE STYLES-->
<link href="${root }/assets/js/dataTables/dataTables.bootstrap.css"
	rel="stylesheet" />
		<!-- JS Scripts-->
	<!-- jQuery Js -->
	<script src="${root }/js/jquery/2.0.0/jquery.min.js"></script>
	<!-- Bootstrap Js -->
	<script src="${root }/assets/js/bootstrap.min.js"></script>
	<!-- Metis Menu Js -->
	<script src="${root }/assets/js/jquery.metisMenu.js"></script>
	<!-- DATA TABLE SCRIPTS -->
	<script>
		$(document).ready(function() {
			//$('#dataTables-example').dataTable();
			//pageAction("page");
		});

	</script>
	
	<script>
	
	//显示数据的方法
	
	function pageAction(turningType) {
		var currentPage = $('#currentPageHidden').val();
		var getTotalPage = $('#totalPageHidden').val();
		var pageSize = $('#pageSize').val();
		/* var searchId = null; */
		var searchName = $('#searchMessageHidden').val();
		var firstDate = $('#firstDateHidden').val();
		var lastDate = $('#lastDateHidden').val();
		var categoryThreeId = 1;
		/* //提交给后台的查询参数
		var param = ""; */
		switch (turningType) {
		case "first":
			if (currentPage != 1) {
				currentPage = 1;
				//          $('#cpage').text(currentPage);
			} else {
				alert("已是首页！");
			}
			;
			break;
		case "previous":
			if (currentPage > 1) {
				currentPage--;
				//  $('#cpage').text(currentPage);
			} else {
				alert("已是首页！");
			}
			;
			break;
		case "next":
			if (parseInt(currentPage) < parseInt(getTotalPage)) {
				currentPage++;
				/// $('#cpage').text(currentPage);
			} else {
				alert("已是尾页！");
			}
			;
			break;
		case "last":
			if (currentPage != getTotalPage) {
				currentPage = getTotalPage
				// $('#cpage').text(currentPage);
			} else {
				alert("已是尾页！");

			}
			;
			break;

		case "jump":
			if ($('#jumpPage').val() > getTotalPage) {
				currentPage = getTotalPage;
			} else {
				currentPage = $('#jumpPage').val();
				$('#thisPage').val(currentPage);
			}
			break;
		
		case "search":
			/* param = $('searchForm').serialize(); */
			/* searchId = $('#searchId').text(); */
			searchName = $('#searchMessage').val();
			firstDate = $('#firstDate').val().replace("T"," ");
			lastDate = $('#lastDate').val().replace("T"," "); 
			
			/* alert(firstDate);
			alert(lastDate); */
			$('#searchMessageHidden').val(searchName);
			$('#firstDateHidden').val(firstDate);
			$('#lastDateHidden').val(lastDate);
			break;
		}		
		
		console.log("searchName:"+searchName);
		$.post("../product/searchProducts.action",{
						"currentPage" : currentPage,
						/* "totalPage" : getTotalPage, */
						"pageSize" : pageSize,
						"categoryId" : categoryThreeId,
						"searchName" : searchName,
						"firstDate" : firstDate,
						"lastDate" : lastDate
						},
						function(page) {
						//回调函数执行了不给调用者看到
						var testData = page;						
						if (page != null) {
							$('#currentPageHidden').val(page.pageNo);
							$('#totalPageHidden').val(page.pageCount);
							$('#totalPage').text(page.pageNo);
							$('#thisPage').text(page.pageCount);
							$('#listBody').html("");//清空table数据
							console.log(page);
							jQuery
									.each(
											page.data,
											function(i, p) {
												
												var imageHtml = "无";
												
												if (p.productImagePath != '' && p.productImagePath != null) {
													imageHtml = "<img src = '${root}/"
														+ p.productImagePath
														+ "'  />"
												}
												
												var showList = "<tr><td>"
														+ p.productId
														+ "</td>"
														+ "<td>"
														+ imageHtml
														+ "<td>"
														+ p.productName
														+ "</td>"
														+ "<td>"
														+ p.restQuantity
														+ "</td>"
														+ "<td>" + p.productCreateDate
														+ "</td>"
														+ "<td><a><span class='glyphicon glyphicon-edit' onclick = showUpdateWindow('edit','"
														+ p.productId
														+ "')></span></a></td>"
														+ "<td><a><span class='glyphicon glyphicon-pcture'  onclick = showUpdateWindow('imageEdit','"
														+ p.productId
														+ "')></span></a></td>"
														+ "<td><a><span class='glyphicon glyphicon-list'></span></a></td>"
														+ "<td><a><span class='glyphicon glyphicon-trash' onclick = showUpdateWindow('delete','"+p.productId+"')></span></a></td>";
														
														//console.log(showList);
												/* <th>产品id</th>
												<th>产品图片</th>
												<th>产品名称</th>
												<th>产品总销量</th>
												<th>产品库存</th> */
												
												$('#listBody').append(showList);
											});
						} else {
							alert("没有该页数据");
							$('#totalPage').val(1);
						}
					},"json");
	}
	
	//更新数据的操作
	
	function updateProductAction(actionType) {
		var url = "../product/addProduct.action";
		var selectedProductId = $("#selectedProductId").val();
		var productName = $("#add_productName").val();
		var categoryThreeId = 1;
		switch (actionType) {
			case "add":
				url = "../product/addProduct.action";
				var productName = $("#add_productName").val();
				break;
			case "edit":
				url = "../product/editProduct.action";
				var productName = $("#edit_productName").val();
				break;
			case "delete":
				url = "../product/deleteProduct.action";
				break;
		}

		$.post(url,{
			"productId" : selectedProductId,
			"productName" : productName,
			"categoryThreeId" : categoryThreeId
		},function(data){
			if (data == 1) {
				cancelWindow(actionType);
				pageAction("");
			}
		},"json");
	}
	
	function getProductById() {
		var productId = $("#selectedProductId").val();
		var url = "../product/getProductByProductId.action";
		$.post(url,{
			"productId" : productId
		},function(product) {
			if (product != null) {
				$("#edit_productName").val(product.productName);
			}
			//alert(product);
		},"json");
	}
	
	function getInformationByProductId(actionType) {
		var productId = $("#selectedProductId").val();
		var url = ""
		
		switch (actionType) {
			case "productImage":
					url = "../productImage/getProductImagesByProductId";
				break;
			case "productDetailImage":
					url = "../productDetailImage/getProductDetailImagesByProductId";
				break;
			case "productPropertyValue":
					url = "../productPropertyValue/getPropertyValuesFromProduct";
				break;
			case "productType":
					url = "../productType/getProductTypesByProductId";
				break;
		}
		
		$.post(url,{
			"productId" : productId
		},function(data) {
			return data;
		},"json");
	}
	
	</script>
	
	<script>
		function showUpdateWindow(windowType,productId) {			
			switch (windowType) {
				case "add":
						$("#addWindow").slideDown(300);
	                    $("#background").show();	
					break;
				case "edit":
						$("#editWindow").slideDown(300);
						$("#background").show();
						$("#selectedProductId").val(productId);
						//alert(productId);
						getProductById();
					break;
				case "delete":
						$("#deleteWindow").slideDown(500);
						$("#background").show();
						$("#selectedProductId").val(productId);
					break;
				case "imageEdit":
						$("#imageEditWindow").slideDown(500);
						$("#background").show();
						$("#selectedProductId").val(productId);
					break;
			}
		}
		
		function cancelWindow(windowType) {
			switch (windowType) {
				case "add":
						$("#addWindow").slideUp(300);
	                    $("#background").hide();
	                    $("#addWindow input").val("");
					break; 
				case "edit":
						$("#editWindow").slideUp(300);
						$("#background").hide();
						$("#editWindow input").val("");
					break;
				case "delete":
						$("#deleteWindow").slideUp(500);
						$("#background").hide();
					break;
				case "imageEdit":
						$("#imageEditWindow").slideUp(500);
						$("#background").hide();
						$("#selectedProductId").val(productId);
					break;
			}
		}
	</script>
</head>
<body>
	<div id="wrapper">
	
		<!-- <nav class="navbar navbar-default top-navbar" role="navigation">
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

		/. NAV TOP 
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">

					<li><a class="active-menu" href="listCategory"><i
							class="fa fa-bars"></i> 分类管理</a></li>
					<li><a href="listUser"><i class="fa fa-user"></i> 用户管理</a></li>
					<li><a href="listOrder"><i class="fa fa-list-alt"></i>
							订单管理</a></li>
					<li><a href="listLink"><i class="fa fa-link"></i> 推荐链接管理</a></li>
				</ul>
			</div>
		</nav> -->
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<%-- <div class="row">
					<div class="col-md-12">
						<h1 class="page-header">
							分类管理 <small> - ${category.name} 产品管理</small>
						</h1>
					</div>
				</div> --%>

				<div class="row">
					<div class="col-md-3">
						<a href="javascript:history.back()" class="btn btn-success">返回上一页</a>
					</div>
				</div>
				<br>
				<div id = "searchBar">
					名称搜索:<input type = "text" name = "searchMessage" id = "searchMessage"/>
					开始日期:<input type = "datetime-local" name = "firstDate" id = "firstDate" />
					结束日期:<input type = "datetime-local" name = "lastDate" id = "lastDate" />
					
					<input type = "hidden" name = "searchMessageHidden" id = "searchMessageHidden" value = "" />
					<input type = "hidden" name = "firstDateHidden" id = "firstDateHidden" value = "" />
					<input type = "hidden" name = "lastDateHidden" id = "lastDateHidden" value = "" />
 					<button id = "searchButton" name = "searchButton" onclick = "pageAction('search')" >搜索</button>
 				</div>
 				<div id = "addButtonOuterDiv">
 					<button id = "addButton" name = "addButton" onclick = "showUpdateWindow('add',0)" >添加一个产品</button>
 				</div>
				<div class="row">
					<div class="col-md-12">
						<!-- Advanced Tables -->
						<div class="panel panel-default">
							<div class="panel-heading">产品管理表</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead id = "listHead">
											<tr>
												<th>产品id</th>
												<th>产品图片</th>
												<th>产品名称</th>
												<th>产品总库存</th>
												<th>产品创建日期</th>

												<th>编辑产品</th>
												<th>编辑图片</th>
												<th>编辑分类</th>
												<th>删除产品</th>
											</tr>
										</thead>
										<tbody id = "listBody">
											<c:forEach items="${page.data}" var="p">
												<tr>
													<td>${p.productId}</td>
													<td><img id = "productImageShow" src = "${root}/${p.productImagePath}"></td>
													<td>${p.productName}</td>
													<td>${p.restQuantity}</td>
													<td>${p.productCreateDate}</td>

													<td><a><span
															class="glyphicon glyphicon-edit" onclick = "showUpdateWindow('edit','${p.productId}')"></span></a></td>
													<td><a><span
															class="glyphicon glyphicon-picture" onclick = "showUpdateWindow('imageEdit','${p.productId}')"></span></a></td>
													<td><a><span
															class="glyphicon glyphicon-list"></span></a></td>
													<td><a><span
															class="glyphicon glyphicon-trash" onclick = "showUpdateWindow('delete','${p.productId}')"></span></a></td>
												</tr>
	
											</c:forEach>
										</tbody>
									</table>
								</div>

							</div>
						</div>
						<!--End Advanced Tables -->
					</div>
				</div>

				<!-- 分页 -->
				<div id="pagination">
					<div id="sy" style="float: left;">
						<button id="firstPage" type="button" onClick="pageAction('first')">首页</button>
					</div>
					<div id="syy" style="float: left;">
						<button id="previousPage" type="button" onClick="pageAction('previous')">上一页</button>
					</div>
					<b style="float: left;"><lable id="thisPage"></lable>/<lable id="totalPage"></lable></b>
					<div id="xyy" style="float: left;">
						<button id="nextPage" type="button" onClick="pageAction('next')">下一页</button>
					</div>
					<div id="wy" style="float: left;">
						<button id="lastPage" type="button" onClick="pageAction('last')">尾页</button>
					</div>
					<div id="jumpPageButton" style="float:left;"><input type="button" onClick="pageAction('jump')" value="跳转"/>
					<input type="text" id="jumpPage" value="1"/></div>
					<div id="myxs" style="float: left;">
						每页显示数量
				
						<input type = "number" id = "pageSize" step="5" min = "5" max = "50" value = "10"/>
					</div>
					<div name = "pageHiddenParameter">
						<input type = "hidden" name = "currentPageHidden" id = "currentPageHidden" value = "${page.pageNo}" />
						<input type = "hidden" name = "totalPageHidden" id = "totalPageHidden" value = "${page.pageCount }"/>
					</div>
				</div>
				<%-- 产品增加表单 --%>
				<%-- <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            增加产品
                        </div>
                        <div class="panel-body">
                            <form action="addProduct" role="form">
                                <input type="hidden" name="id" value="">
                                <label>产品名称：</label>
                                <input type="text" class="form-control" name="name" placeholder="请在这里输入产品名称">
                                <label>产品标题：</label>
                                <input type="text" class="form-control" name="sub_title" placeholder="">
                                <label>产品价格：</label>
                                <input type="text" class="form-control" name="price" placeholder="">
                                <label>产品销量：</label>
                                <input type="text" class="form-control" name="sale" placeholder="">
                                <label>产品库存：</label>
                                <input type="text" class="form-control" name="stock" placeholder="">
                                <input type="hidden" name="category_id" value="${category.id}">
                                <input type="submit" class="btn btn-default pull-right" value="添加">
                            </form>
                        </div>
                    </div>
                </div>
            </div> --%>

			</div>
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->
	
	<!-- 添加窗口 -->
	
	<div class = "jumpWindow" id="addWindow">
            <label class = "jumpWindow-closeButton" style="position: absolute;top:2px;left: 95%;font-size: 25px;" onclick="cancelWindow('add')">x</label>
            	<label>请输入产品名称:</label><input type = "text" name = "add_productName" id = "add_productName" />
            	<button id = "addProductButton" name = "addProductButton" onclick = "updateProductAction('add')">添加</button>
            	<button id = "cancelButton" name = "cancelButton" onclick = "cancelWindow('add')">取消</button>
    </div>
    
    <!-- 修改窗口 -->
    
    <div class = "jumpWindow" id="editWindow">
            <label class = "jumpWindow-closeButton" style="position: absolute;top:2px;left: 95%;font-size: 25px;" onclick = "cancelWindow('edit')">x</label>
            	<label>请输入产品名称:</label><input type = "text" name = "edit_productName" id = "edit_productName" />
            	<button id = "editProductButton" name = "editProductButton" onclick = "updateProductAction('edit')">修改</button>
            	<button id = "cancelButton" name = "cancelButton" onclick = "cancelWindow('edit')">取消</button>
    </div>
    
    <!-- 删除窗口 -->
    
    <div class = "jumpWindow" id="deleteWindow">
            <label class = "jumpWindow-closeButton" style="position: absolute;top:2px;left: 95%;font-size: 25px;" onclick = "cancelWindow('delete')">x</label>
            	<label>确定要删除吗</label><br/>
            	<button id = "deleteButton" name = "deleteButton" onclick = "updateProductAction('delete')">删除</button>
            	<button id = "cancelButton" name = "cancelButton" onclick = "cancelWindow('delete')">取消</button>
    </div>
    
    <!-- 窗口信息 -->

	<div id = "background"></div>
    
    <input type = "hidden" name = "selectedProductId" id = "selectedProductId" value = "" />
    
    <!-- 图片管理 -->
    
    <div class = "jumpWindow" id = "imageEdit">
    	<label class = "jumpWindow-closeButton" style="position: absolute;top:2px;left: 95%;font-size: 25px;" onclick = "cancelWindow('imageEdit')">x</label>
    </div>

</body>
	<style type = "text/css">
		#productImageShow {
			max-width:100%;
			height:auto;
		}
		
		#listBody tr td {
			height:20px;
		}
		
		#listHead tr td {
			height:20px;
		}
		
		#listHead * {
			font-size:12px;
			/* //font-family:"宋体"; */
		}
		
		#listBody * {
			font-size:12px;
			/* //font-family:"宋体"; */
		}
		
		.jumpWindow {
            display: none; 
            position: absolute; 
            top: 25%; 
            left: 25%; 
            width: 30%; 
            height: 55%; 
            padding: 20px; 
            border: 3px solid #ccc; 
            background-color: white;
            z-index:2; 
            overflow: auto; 
        }
        
        .jumpWindow-closeButton:hover {cursor: pointer;color: rgb(55,198,192);}
        
        #background {
            display: none; 
            position: absolute; 
            top: 0%; 
            left: 0%; 
            width: 100%; 
            height: 1100px; 
            background-color: black; 
            z-index:1; 
            -moz-opacity: 0.8; 
            opacity:.80; 
            filter: alpha(opacity=88);
        }
        		
	</style>
</html>
