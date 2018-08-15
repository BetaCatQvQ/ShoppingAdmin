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
	<script src="${root }/js/showingActions.js"></script>
	<script src="${root }/js/updateActions.js"></script>
	<script src="${root }/js/windowsOperation.js"></script>
	
	<!-- DATA TABLE SCRIPTS -->
	<script>
		$(document).ready(function() {
		});
	</script>
</head>
<body>
	<div id="wrapper">
		
		<!-- 全局变量 -->
		<input type = "hidden" id = "root" name = "root" value = "${root }"/>
		<input type = "hidden" id = "m_categoryThreeId" name = "m_categoryThreeId" value = "1" />
		<input type = "hidden" id = "m_categoryTwoId" name = "m_categoryTwoId" value = "1" />
		<input type = "hidden" id = "m_categoryOneId" name = "m_categoryOneId" value = "1" />
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
												<th>编辑属性</th>
												<th>编辑分类</th>
												<th>删除产品</th>
											</tr>
										</thead>
										<tbody id = "listBody">
											<c:forEach items="${page.data}" var="p">
												<tr>
													<td>${p.productId}</td>
													<td><img class = "productImageShow" src = "${root}/${p.productImagePath}"></td>
													<td class = "pPic">${p.productName}</td>
													<td>${p.restQuantity}</td>
													<td>${p.productCreateDate}</td>

													<td><a><span
															class="glyphicon glyphicon-edit" onclick = "showUpdateWindow('edit','${p.productId}')"></span></a></td>
													<td><a><span
															class="glyphicon glyphicon-picture" onclick = "showUpdateWindow('imageEdit','${p.productId}')"></span></a></td>
													<td><a><span
															class="glyphicon glyphicon-list" onclick = "showUpdateWindow('propertyEdit','${p.productId}')"></span></a></td>
													<td><a><span
															class="glyphicon glyphicon-list" onclick = "showUpdateWindow('productTypeEdit','${p.productId}')"></span></a></td>
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
            	<button name = "cancelButton" onclick = "cancelWindow('add')">取消</button>
            	<select id = "addCategoryOneBox" name = "addcategoryOneBox" onchange = "getCategoryTwoList('add')"></select>
            	<select id = "addCategoryTwoBox" name = "addcategoryTwoBox" onchange = "getCategoryThreeList('add')"></select>
            	<select id = "addCategoryThreeBox" name = "addcategoryThreeBox"></select>
    </div>
    
    <!-- 修改窗口 -->
    
    <div class = "jumpWindow" id="editWindow">
            <label class = "jumpWindow-closeButton" style="position: absolute;top:2px;left: 95%;font-size: 25px;" onclick = "cancelWindow('edit')">x</label>
            	<label>请输入产品名称:</label><input type = "text" name = "edit_productName" id = "edit_productName" />
            	<button id = "editProductButton" name = "editProductButton" onclick = "updateProductAction('edit')">修改</button>
            	<button name = "cancelButton" onclick = "cancelWindow('edit')">取消</button>
            	<select id = "editCategoryOneBox" name = "editcategoryOneBox" onchange = "getCategoryTwoList('edit')"></select>
            	<select id = "editCategoryTwoBox" name = "editcategoryTwoBox" onchange = "getCategoryThreeList('edit')"></select>
            	<select id = "editCategoryThreeBox" name = "editcategoryThreeBox"></select>
    </div>
    
    <!-- 分类全局变量 -->
    
    <input type = "hidden" id = "addHasCategoryList" name = "addHasCategoryList" value = "0" />
    <input type = "hidden" id = "editHasCategoryList" name = "editHasCategoryList" value = "0" />
    
    <!-- 删除窗口 -->
    
    <div class = "jumpWindow" id="deleteWindow">
            <label class = "jumpWindow-closeButton" style="position: absolute;top:2px;left: 95%;font-size: 25px;" onclick = "cancelWindow('delete')">x</label>
            	<label>确定要删除吗</label><br/>
            	<button id = "deleteButton" name = "deleteButton" onclick = "updateProductAction('delete')">删除</button>
            	<button name = "cancelButton" onclick = "cancelWindow('delete')">取消</button>
    </div>
    
    <!-- 窗口信息 -->

	<!-- 一级背景 -->
	<div id = "background"></div>
	<!-- 二级背景 -->
	<div id = "background_2"></div>
    
    <input type = "hidden" name = "selectedProductId" id = "selectedProductId" value = "" />
    
    <!-- 图片管理 -->
    
    <div class = "jumpWindow" id = "imageEditWindow">
    	<label class = "jumpWindow-closeButton" style="position: absolute;top:2px;left: 95%;font-size: 25px;" onclick = "cancelWindow('imageEdit')">x</label>
    		<div id = "imageManagerLeftBox">
    			<label>产品图片</label>
    			<input type = "file" id = "pi_addFile" style = "display:none;" onchange = "addProductImage()" />
    			<button name = "pi_addButton" id = "pi_addButton" onclick = "showPIFileWindow()">添加图片</button>
    			<!-- <button name = "pi_refresh" onclick = "searchProductImages()" >刷新</button> -->
	    		<div id = "productImageBoxDiv" class = "imageBox" >
	    			<table border = "1" class = "imgEditTable">
	    				<thead style = "background-color:#ddffdd">
	    					<tr>
	    						<td class = "imgTd">图片</td>
	    						<td></td>
	    						<td colspan = "2">操作</td>
	    					</tr>
	    				</thead>
	    				<tbody id = "pi_listBody">
	    					
	    				</tbody>
	    			</table>
	    		</div>	
    		</div>
    		
    		<div id = "imageManagerRightBox">
    			<label>详情图片</label>
    			<input type = "file" id = "pdi_addFile" style = "display:none;" onchange = "addProductDetailImage()" />
    		<button name = "pdi_addButton" id = "pdi_addButton" onclick = "showPDIFileWindow()">添加详情图</button>
	    		<div id = "productImageDetailBoxDiv" class = "imageBox" >
	    			<table border = "1" class = "imgEditTable">
	    				<thead style = "background-color:#ddffdd">
	    					<tr>
	    						<td class = "imgTd">图片</td>
	    						<td></td>
	    						<td colspan = "2">操作</td>
	    					</tr>
	    				</thead>
	    				<tbody id = "pdi_listBody">
	    					
	    				</tbody>
	    			</table>
	    		</div>	
	    	</div>	
    </div>
    		<button name = "saveImagesManager" id = "saveImagesManager">关闭</button>
			
    
    <!-- 属性管理 -->
    
    <div class = "jumpWindow" id = "propertyEditWindow">
    <label class = "jumpWindow-closeButton" style="position: absolute;top:2px;left: 95%;font-size: 25px;" onclick = "cancelWindow('propertyEdit')">x</label>
    	选择属性:<select id = "productPropertySelect" name = "productPropertySelect"></select>
    	<button id = "btn_newProductProperty">设置属性名</button>
    	请输入属性值:<input type = "text" id = "addProductPropertyValue" name = "addProductPropertyValue" />
    	<button id = "btn_addProductPropertyValue" onclick = "addProductPropertyValue()">添加属性</button>
    	<div id = "productPropertyListBox">
    		<table id = "propertyListTable" border = "1">
    			<tbody id = "propertyListBody">
    			</tbody>
    		</table>
    	</div>
    	<button id = "btn_saveProductProperty">确定</button>
    </div>
    
    <!-- 添加属性名 -->
    
    <div class = "jumpWindow" id = "newPropertyNameWindow">
    <label class = "jumpWindow-closeButton" style="position: absolute;top:2px;left: 95%;font-size: 25px;" onclick = "cancelWindow('newPropertyName')">x</label>
    	请选择一级分类:<select id = "newPropertyCategoryOneBox" onchange = "getCategoryTwoList('newProperty')"></select>
    	请选择二级分类:<select id = "newPropertyCategoryTwoBox" onchange = "listProductProperties('list','#propertyNameListBody')"></select>
    	属性名:<input type = "text" id = "addProductPropertyName" />
    	<button id = "btn_addProductProperty">添加属性名</button>
    	<div id = "propertyNameListBox">
    		<table id = "propertyNameListTable" border = "1">
    			<thead id = "propertyNameListHead">
    				<tr>
    					<th>属性名称</th>
    					<th>所属二级分类</th>
    					<th colspan = "2">操作</th>
    				</tr>
    			</thead>
    			<tbody id = "propertyNameListBody">
    			</tbody>
    		</table>
    		<button id = "pp_goBackPage" onclick = "ppBoxPageAction('goBack')">&lt;</button>
    		<button id = "pp_goForePage" onclick = "ppBoxPageAction('goFore')">&gt;</button>
    		<label id = "ppPageNoLabel">0</label><label>/</label><label id = "ppPageCountLabel">0</label>
    	</div>
    	<button id = "btn_saveProductProperty" onclick="cancelWindow('newPropertyName')">确定</button>
    	<input id = "productPropertyPageNo" type = "hidden" value = "1" />
    	<input id = "productPropertyPageCount" type = "hidden" value = "0" />
    	<input id = "firstInPPEdit" type = "hidden" value = "0" />
    </div>
    
    <!-- 产品类型管理 -->
    
    <div class = "jumpWindow" id = "productTypeWindow">
    	<div id = "pt_searchBar">
				名称搜索:<input type = "text" id = "pt_searchMessage"/>
				价    格:<input type = "number" id = "pt_searchSalePrice_f" />-
					 <input type = "number" id = "pt_searchSalePrice_l" />
				库存量:<input type = "number" id = "pt_searchRestQuantity_f"/>-
					 <input type = "number" id = "pt_searchRestQuantity_l"/>
				
				<input type = "hidden" id = "pt_searchMessageHidden" value = "" />
				<input type = "hidden" id = "pt_salePriceHidden_f" value = "" />
				<input type = "hidden" id = "pt_salePriceHidden_l" value = "" />
				<input type = "hidden" id = "pt_restQuantityHidden_f" value = "" />
				<input type = "hidden" id = "pt_restQuantityHidden_l" value = "" />
				<button id = "pt_searchButton" name = "pt_searchButton" onclick = "listProductTypes()" >搜索</button>
		</div>
				
 				<button id = "pt_addButton">添加</button>
 				<table border="1">
 					<thead>
 						<tr>
 							<th>类型名称</th>
 							<th>类型图片</th>
 							<th>价格</th>
 							<th>优惠价格</th>
 							<th>库存</th>
 							<th>产品创建时间</th>
 							<th>所属产品</th>
 							<th colspan = "2">操作</th>
 						</tr>
 					</thead>
 					<tbody id = "pt_listBody">
 					
 					</tbody>
 				</table>
 				
 				<div id="pt_pagination">
 					<table border = "1">
 						<tbody>
 							<tr>
 								<td><button id = "pt_firstPage">首页</button></td>
 								<td><button id = "pt_backPage">上一页</button></td>
 								<td><label id = "pt_pageNoLabel">1</label><label>/</label><label id = "pt_pageCountLabel">1</label></td>
 								<td><button id = "pt_nextPage">下一页</button></td>
 								<td><button id = "pt_lastPagePage">尾页</button></td>
 								<td class = "space"></td>
 								<td>跳转至:</td>
 								<td><input type = "text" id = "pt_turnPageInput" value = "1"/></td>
 								<td><button id = "pt_jumpPage">跳转</button></td>
 							</tr>
 						</tbody>
 					</table>
						<input type = "hidden" id = "pt_pageNo" value = "1" />
						<input type = "hidden" id = "pt_pageCount" value = "0" />
						<input type = "hidden" id = "pt_pageSize" value = "10" />
				</div>
				
				<button name = "cancelButton" onclick = "cancelWindow('productTypeEdit')">关闭</button>
 		
    </div>
    
</body>
	<style type = "text/css">
	
		.pPic {
        	width:3px;
        	height:3px;
        }
        
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
            top: 50%; 
            left: 50%; 
            width: 40%; 
            height: 65%; 
            padding: 20px; 
            border: 3px solid #ccc; 
            background-color: white;
            z-index:2; 
            overflow: auto; 
        }
        
        .jumpWindow-closeButton:hover {cursor: pointer;color: rgb(55,198,192);}
        
        #background,#background_2 {
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
            filter: alpha(opacity=70);
        }
        
        #background_2 {
        	z-index:2;
        }
        
        /* #imageEditWindow>div {
        	width:100%;
        	display:flex;
        	border:1px solid black;
        	height:75%;
        }
        
        #imageEditWindow>div>div {
        	width:100%;
        	border:1px solid brown;
        	overflow:scroll;
        } */
        
        .piImg {
        	width:100%;
        	height:auto;
        }
        
        .deleteX {
        	display:inline-block;
        	/* position:relative;
        	left:90%;
        	bottom:20%; */
        	float:right;
        }
        
        #propertyListBody {
        	autoflow:scroll;
        }
        
        #propertyListBody *,#propertyNameListTable *{
        	 font-size:10px;
        	 max-height:100px;
        }
        
        #propertyListBody label:hover,.easyListOperation label:hover {
        	 color:orange;
        	 text-decoration:underline;
        	 font-weight:bold;
        	 cursor:pointer;
        }
        
        .disbledAction {
        	color:gray;
        	text-decoration:none;
        	cursor:default;
        }
        
        .disbledAction:hover {
        	color:gray;
        	text-decoration:none;
        	cursor:default;
        }
        
        #editChange {
        	color:#008800;  	
        }
        
        #editChange:hover {
        	color:#00CC00;
        	text-decoration:underline;
        	font-weight:bold;
        	cursor:pointer;
        }
        
        #editCancel {
        	color:#CC5500;  	
        }
        
        #editCancel:hover {
        	color:#FF7700;  
        	text-decoration:underline;
        	font-weight:bold;
        	cursor:pointer;	
        }
        
        #productPropertyListBox {
        	autoflow:scroll;
        	background-color:white;
        	border:1px solid black;
        }
        
        #propertyNameListBox {
        	background-color:white;
        }
        
        #productTypeWindow {
        	top: 30%; 
            left: 20%; 
        	width: 70%; 
            height: 65%; 
        }
        
        .pt_imageTd {
        	width:20px;
        	height:20px;
        }
        
        .pt_imageTd img {
        	width:95%;
        	height:auto;
        }
        
        #pt_addTr td {
        	height:30px;
        	max-height:30px;
        }
        
        #pt_addTr input {
        	display:inline-block;
        	padding:0px;
        	line-height:0px;
        }
        
        .pt_row td {
        	height:30px;
        	max-height:30px;
        }
        
        .imgEditTable {
        	width:100%;
        }
        
        .imgEditTable td {
        	text-align:center;
        	vertical-align: middle;
        }
        
        .imgEditTable .imgTd {
        	width:60px;
        	height:60px;
        }
        
        .img_controll {
        	width:30px;
        }
        
	</style>
</html>
