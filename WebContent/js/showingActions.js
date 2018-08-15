//显示数据的方法

	function pageAction(turningType) {
			var root = $("#root").val();
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
							"lastDate" : lastDate,
							"categoryType" : "三级分类"
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
														imageHtml = "<img class = 'productImageShow' src = '"+root+"/"
															+ p.productImagePath
															+ "'  />"
													}
													
													var showList = "<tr><td>"
															+ p.productId
															+ "</td>"
															+ "<td class = 'pPic'>"
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
															+ "<td><a><span class='glyphicon glyphicon-picture'  onclick = showUpdateWindow('imageEdit','"
															+ p.productId
															+ "')></span></a></td>"
															+ "<td><a><span class='glyphicon glyphicon-list' onclick = showUpdateWindow('propertyEdit','"+p.productId+"')></span></a></td>"
															+ "<td><a><span class='glyphicon glyphicon-list' onclick = showUpdateWindow('productTypeEdit','"+p.productId+"')></span></a></td>"
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
	
//商品图片系列-------------------------------------------------------------------------------------------------
	
	function searchProductImages() {
		var root = $("#root").val();
		var url = "../productImage/getProductImagesByProductId.action";
		var productId = $("#selectedProductId").val();
		
		$.post(url,{
			"productId" : productId
		},function(data) {
			$("#pi_listBody").html("");
			jQuery.each(data,function(i,pi) {
				var piPath = pi.productImagePath;
				console.log(piPath);
				console.log("onclick = deleteProductImage('"+pi.productImageId+"','"+piPath+"')");
				var htmls = "<tr><td class = 'imgTd'><img class = 'piImg' src = '"+root+"/"+piPath+"'/></td>"+
				"<td style = 'width:50%'></td>"+
				"<td class = 'easyListOperation img_controll'><label>Edit</label></td>"+
				"<td class = 'easyListOperation img_controll'><label onclick = deleteProductImage('"+pi.productImageId+"','"+piPath+"') >X</label></td></tr>";
				$("#pi_listBody").append(htmls);
			})
		},"json");
		
	}
	
	function searchProductDetailImages() {
		var root = $("#root").val();
		var url = "../productDetailImage/getProductDetailImagesByProductId.action";
		var productId = $("#selectedProductId").val();
		
		$.post(url,{
			"productId" : productId
		},function(data) {
			$("#pdi_listBody").html("");
			jQuery.each(data,function(i,pdi) {
				var pdiPath = pdi.productDetailImagePath;
				console.log(pdiPath);
				console.log("onclick = deleteProductDetailImage('"+pdi.productDetailImageId+"','"+pdiPath+"')");
				var htmls = "<tr><td class = 'imgTd'><img class = 'piImg' src = '"+root+"/"+pdiPath+"'/></td>"+
				"<td style = 'width:50%'></td>"+
				"<td class = 'easyListOperation img_controll'><label>Edit</label></td>"+
				"<td class = 'easyListOperation img_controll'><label onclick = deleteProductDetailImage('"+pdi.productDetailImageId+"','"+pdiPath+"') >X</label></td></tr>";
				$("#pdi_listBody").append(htmls);
			})
		},"json");
	}
	
	function getProductById() {
		var root = $("#root").val();
		var productId = $("#selectedProductId").val();
		var url = "../product/getProductByProductId.action";
		
		//获取产品
		$.post(url,{
			"productId" : productId
		},function(product) {			
			if (product != null) {
				var categoryThreeId = null;
				$("#edit_productName").val(product.productName);
				
				categoryThreeId = product.categoryThree.categoryThreeId;
				
				$("#editCategoryThreeBox option[value="+categoryThreeId+"]").attr("selected",true);
					//获取二级分类id
					$.post("../categoryThree/getCategoryThreeById.action",{
						"categoryThreeId" : categoryThreeId
					},function(categoryThree) {
						if (categoryThree != null) {
							var categoryTwoId = categoryThree.categoryTwo.categoryTwoId;
							console.log("#editCategoryTwoBox option[value="+categoryTwoId+"]");
							$("#editCategoryTwoBox option[value="+categoryTwoId+"]").attr("selected",true);
							
							//获取一级分类id
							$.post("../categoryTwo/getCategoryTwoById.action",{
								"categoryTwoId" : categoryTwoId
							},function(categoryTwo) {
								if (categoryTwo != null) {
									console.log("#editCategoryOneBox option[value="+categoryTwo.categoryOne.categoryOneId+"]");
									$("#editCategoryOneBox option[value="+categoryTwo.categoryOne.categoryOneId+"]").attr("selected",true);
									
								}
							},"json");
						}
					},"json");		
				
			}
			
		},"json");	
	}
	
	/*function setAddProductCategoryBox() {
		var root = $("root").val();
		$("#addCategoryOneBox option[value="+1+"]").attr("selected",true);
		$("#addCategoryTwoBox option[value="+1+"]").attr("selected",true);
		$("#addCategoryThreeBox option[value="+1+"]").attr("selected",true);		
		
	}*/

//商品分类系列-------------------------------------------------------------------------------------------------	
	
	//处理一级分类列表
	function getCategoryOneList(type) {	
		if ($("#"+type+"HasCategoryList").val() == "1") {
			return;
		}
		//type只能是 add 或者 edit
		var root = $("#root").val();
		
		$.ajaxSettings.async = false;
		$.post("../categoryOne/listOneAll.action",null,function(data) {
				if (data != null) {
					$.each(data.data,function(index,cate){
						var htmls = "<option value = '"+cate.categoryOneId+"'>"+cate.categoryOneName+"</option>"
						
						$("#"+type+"CategoryOneBox").append(htmls);
					});				
					$("#"+type+"CategoryOneBox option[value="+$("m_categoryOneId").val()+"]").attr("selected",true);
					getCategoryTwoList(type);
					
				}
			},"json");
		
		$("#"+type+"HasCategoryList").val("1");
	}
	
	//处理二级分类列表
	function getCategoryTwoList(type) {
		var testValue = "#"+type+"CategoryOneBox";
		var selectedTestValue = $("#"+type+"CategoryOneBox");
		var selectedValue = $("#"+type+"CategoryOneBox").val();
			//type只能是 add 或者 edit
		$.ajaxSettings.async = false;
		$.post("../categoryTwo/listTwoByOne.action",{
			"categoryOneId" : selectedValue
		},function(data) {
			if (data != null) {
				$("#"+type+"CategoryTwoBox").html("");
				$.each(data,function(index,cate){
					var htmls = "<option value = '"+cate.categoryTwoId+"'>"+cate.categoryTwoName+"</option>"
					
					$("#"+type+"CategoryTwoBox").append(htmls);
				});			
				$("#"+type+"CategoryTwoBox option[value="+$("m_categoryTwoId").val()+"]").attr("selected",true);
				getCategoryThreeList(type);
			}
		},"json");
	}
	
	//处理第三分类列表
	function getCategoryThreeList(type) {
		if ($("#"+type+"CategoryThreeBox").length <= 0) {
			return;
		}
		var selectedValue = $("#"+type+"CategoryTwoBox option:selected").val();
			//type只能是 add 或者 edit
		
		$.ajaxSettings.async = false;
		$.post("../categoryThree/listThreeByTwo.action",{
			"categoryTwoId" : selectedValue
		},function(data) {			
			if (data != null) {
				$("#"+type+"CategoryThreeBox").html("");
				$.each(data,function(index,cate){
					var htmls = "<option value = '"+cate.categoryThreeId+"'>"+cate.categoryThreeName+"</option>"
					
					$("#"+type+"CategoryThreeBox").append(htmls);
				});			
				$("#"+type+"CategoryThreeBox option[value="+$("m_categoryThreeId").val()+"]").attr("selected",true);
			}
		},"json");
	}
	
//-----------------------------------------------商品属性系列----------------------------------------------------
	
	//在下拉框里显示商品属性
	function listProductProperties(type,boxDoc) {
		var productId = $("#selectedProductId").val();
		var box = null;
		if (typeof(boxDoc) == "string"&&boxDoc.constructor==String) {
			box = $(boxDoc);
		} else {
			box = boxDoc;
		}
		$("#btn_addProductProperty").attr("onclick","addProductProperty()");
		
		//获取三级分类
		$.ajaxSettings.async = false;
		$.post("../product/getProductByProductId.action",{
			"productId" : productId
		},function(product) {	
			if (product != null) {
				var categoryThreeId = null;
				$("#edit_productName").val(product.productName);
				
				categoryThreeId = product.categoryThree.categoryThreeId;
				
					//获取二级分类id
					$.ajaxSettings.async = false;
					$.post("../categoryThree/getCategoryThreeById.action",{
						"categoryThreeId" : categoryThreeId
					},function(categoryThree) {
						console.log("categoryThree:"+categoryThree);
						if (categoryThree != null) {
							var categoryTwoId = categoryThree.categoryTwo.categoryTwoId;
							url = "../productProperty/listProductProperties.action";
							var pageSize = 10;
							var pageNo = $("#productPropertyPageNo").val();
							
							if (type == "list") {
								url = "../productProperty/listProductPropertiesByPage.action";
								if ($("#firstInPPEdit").val() == "1") {
									categoryTwoId = $("#newPropertyCategoryTwoBox").val();
								}
							} else if (type == "select") {
								url = "../productProperty/listProductProperties.action";
							}
							
							$.ajaxSettings.async = false;
							$.post(url,{
								"categoryTwoId" : categoryTwoId,
								"currentPage" : pageNo,
								"pageSize" : pageSize
							},function(ppList) {
								console.log("productPropertyPage:"+ppList);
								
								if (ppList != null) {
									if (type == "select") {
										box.html("");
										$.each(ppList,function(index,pp) {
											var htmls = "<option value = '"+pp.productPropertyId+"'>"+pp.productPropertyName+"</option>";
											
											box.append(htmls);
										});				
									} else if (type == "list") {
										box.html("");
										console.log("productPropertyList:"+ppList.data);
										$.each(ppList.data,function(index,pp) {
											var ppId = pp.productPropertyId;
											console.log("ppId_In_ShowAction:"+ppId);
											var ctId = pp.categoryTwo.categoryTwoId;
											var htmls = "<tr><td id = '"+ppId+"_ppNameInputTd'>"+pp.productPropertyName+"</td>"+
											"<td id = '"+ppId+"_ctNameTd'>"+pp.categoryTwo.categoryTwoName+"</td>"+
											"<td id = '"+ppId+"_editPP'><label class = 'easyListOperation' onclick=ppEditBoxChange('"+ctId+"','"+ppId+"') >Edit</label></td>"+
											"<td id = '"+ppId+"_deletePP'><label class = 'easyListOperation' onclick=deleteProductProperty('"+ppId+"')>Delete</label></td></tr>";
											
											box.append(htmls);
										});
										$("#productPropertyPageNo").val(ppList.pageNo);
										$("#ppPageNo").html(ppList.pageNo);
										$("#productPropertyPageCount").val(ppList.pageCount);
										$("#ppPageCount").html(ppList.pageCount);
									}
									$("#btn_addProductProperty").attr("disabled",false);
								} else {
									$("#btn_addProductProperty").attr("disabled",false);
								}
							},"json");
							if (type == "select") {
								box.append();
							}
						}
					},"json");
			}
			
		},"json");	
	}

	
	//显示商品属性值
	function listProductPropertyValues() {
		var productId = $("#selectedProductId").val();
		$("#btn_newProductProperty").attr("onclick","showUpdateWindow('newPropertyName', '"+productId+"')");
		$.ajaxSettings.async = false;
		$.post("../productPropertyValue/showProductPropertyValues.action",{
			"productId" : productId
		},function(ppvList) {
			if (ppvList != null) {
				$("#propertyListBody").html("");
				$.each(ppvList,function(index,ppv) {
					var ppId = ppv.productProperty.productPropertyId;
					var ppvId = ppv.productPropertyValueId;
					var htmls = "<tr><td id='"+ppId+
					"_ppNameTd'>"+ppv.productProperty.productPropertyName+
					":</td><td id='"+ppvId+"_ppvNameTd'>"+ppv.productPropertyValueName+"</td>"+
						"<td id = '"+ppvId+"_editPPV'><label onclick = ppvEditBoxChange('"+ppvId+"','"+ppId+"')>Edit</label></td>"+
						"<td id = '"+ppvId+"_deletePPV'><label onclick = deleteProductPropertyValue('"+ppv.productPropertyValueId+"') >Delete<label></td></tr>";
					$("#propertyListBody").append(htmls);
				})
			}
		},"json");
	}
	
//-----------------------------------------------商品属性名系列----------------------------------------------------
	
//-----------------------------------------------产品类型系列----------------------------------------------------
	
	//显示产品类型
	function listProductTypes() {
		var pId = $("#selectedProductId").val();
		var ptName = $("#pt_searchMessage").val();
		var ptSalePriceF = $("#pt_searchSalePrice_f").val();
		var ptSalePriceL = $("#pt_searchSalePrice_l").val();
		var ptRestQuantityF = $("#pt_searchRestQuantity_f").val();
		var ptRestQuantityL = $("#pt_searchRestQuantity_l").val();
		var pageNo = $("#pt_pageNo").val();
		var pageSize = $("#pt_pageSize").val();
		
		var root = $("#root").val();
		
		$.post("../productType/listTypesByPage.action",{
			"pId" : pId,
			"ptName" : ptName,
			"ptSalePriceF" : ptSalePriceF,
			"ptSalePriceL" : ptSalePriceL,
			"ptQuantityF" : ptRestQuantityF,
			"ptQuantityL" : ptRestQuantityL,
			"pageNo" : pageNo,
			"pageSize" : pageSize
		},function(ptList){
			if (ptList != null) {
				$("#pt_addButton").attr("onclick","ptAddBoxChange("+pId+")");
				$("#pt_listBody").html("");
				$.each(ptList.data,function(index,pt) {
					var ptImage = pt.productTypeImagePath;
					var imgHtmls = "无";
					if (ptImage != null && ptImage != "") {
						imgHtmls = "<img src = '"+root+"/"+ptImage+"'/>";
					}
					var ptId = pt.productTypeId;
					var htmls = "<tr class = 'pt_row'><td id = 'pt"+ptId+"nameTd'>"+pt.productTypeName+"</td>"+
							"<td class = 'pt_imageTd' id = 'pt"+ptId+"imageTd'>"+imgHtmls+"</td>"+
							"<td id = 'pt"+ptId+"priceTd'>"+pt.price+"</td>"+
 							"<td id = 'pt"+ptId+"salePriceTd'>"+pt.salePrice+"</td><td id = 'pt"+ptId+"rQuantityTd'>"+pt.restQuantity+"</td><td>"+pt.productTypeCreateDate+"</td>"+
 							"<td>"+pt.productName+"</td>"+
 							"<td id = 'pt"+ptId+"edit' class = 'easyListOperation'><label onclick = ptEditBoxChange('"+ptId+"','"+ptImage+"')>Edit</label></td>"+
 							"<td id = 'pt"+ptId+"delete' class = 'easyListOperation'><label onclick = deleteProductType('"+ptId+"','"+ptImage+"') >Delete</label></tr>";
					$("#pt_listBody").append(htmls);
				})
			}		
		},"json");
	}
	
	