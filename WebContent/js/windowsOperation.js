function showUpdateWindow(windowType, productId) {
	switch (windowType) {
	case "add":
		$("#addWindow").slideDown(300);
		$("#background").show();
		getCategoryOneList("add");
		//setAddProductCategoryBox();	
		break;
	case "edit":
		$("#editWindow").slideDown(300);
		$("#background").show();
		$("#selectedProductId").val(productId);
		getCategoryOneList("edit");
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
		searchProductImages();
		searchProductDetailImages();
		break;
	case "propertyEdit":
		var propertySelection = $("#productPropertySelect");
		$("#propertyEditWindow").slideDown(500);
		$("#background").show();
		$("#selectedProductId").val(productId);
		listProductProperties("select",propertySelection);
		listProductPropertyValues();
		break;
	case "newPropertyName":
		$("#newPropertyNameWindow").slideDown(500);
		$("#background").show();		
		$("#selectedProductId").val(productId);	
		getCategoryOneList('newProperty');
		listProductProperties("list",$("#propertyNameListBody"));	
		$("#firstInPPEdit").val("1");
		break;
	case "productTypeEdit":
		$("#productTypeWindow").slideDown(500);
		$("#background").show();		
		$("#selectedProductId").val(productId);
		listProductTypes();
		break;
	}
}

function cancelWindow(windowType) {
	switch (windowType) {
	case "add":
		$("#addWindow").slideUp(300);
		$("#background").hide()
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
		$("#selectedProductId").val();
		break;
	case "propertyEdit":
		$("#propertyEditWindow").slideUp(500);
		$("#background").hide();
		$("#selectedProductId").val();
		$("#propertyListBody").html("");	
		break;
	case "newPropertyName":
		var propertySelection = $("#productPropertySelect");
		$("#newPropertyNameWindow").slideUp(500);
		$("#background_2").hide();
		/*$("#selectedProductId").val();*/
		$("#propertyNameListBody").html("");
		listProductProperties("select",propertySelection);
		listProductPropertyValues();
		$("#firstInPPEdit").val("0");
		break;
	case "productTypeEdit":
		$("#pt_listBody").html("");
		$("#productTypeWindow").slideUp(500);
		$("#background").hide();
		$("#selectedProductId").val();
		$("#pt_searchBar input").val("");
		break;
	}
	
}

function showPIFileWindow() {
	$("#pi_addFile").click();
}

function showPDIFileWindow() {
	$("#pdi_addFile").click();
}

//产品属性系列-------------------------------------------------------------------------------------------------

function ppvEditBoxChange(ppvId,ppId) {
	
	if (ppId == null || ppvId == null) {
		return;
	}
	
	if ($("#editChange").length > 0 || $("#editCancel").length > 0) {
		return;
	}
	
	var ppvName = $("#"+ppvId+"_ppvNameTd").text();
	
	$("#"+ppId+"_ppNameTd").html("<select id = 'ppIdEditSelect'></select>");
	$("#"+ppvId+"_ppvNameTd").html("<input type = 'text' id = 'ppvNameEditInput' value = '"+ppvName+"' style='width:100%'/>");
	$("#propertyListBody label").addClass("disbledAction");
	
	$("#"+ppvId+"_editPPV").html("<label id = 'editChange' onclick = editProductPropertyValue('"+ppvId+"')>Edit</label>");
	$("#"+ppvId+"_deletePPV").html("<label id = 'editCancel' onclick = listProductPropertyValues()>Cancel</label>");
	
	listProductProperties("select",$("#ppIdEditSelect"));
	$("#ppIdEditSelect option[value="+ppId+"]").attr("selected",true);
	$("#ppvNameEditSelect").focus();
}

function ppEditBoxChange(ctId,ppId) {
	
	if (ppId == null || ctId == null) {
		return;
	}
	
	if ($("#editChange").length > 0 || $("#editCancel").length > 0) {
		return;
	}
	
	var ppName = $("#"+ppId+"_ppNameInputTd").text();
	var box = "#propertyNameListBody";
	
	$("#btn_addProductProperty").attr("disabled",true);
	$("#"+ppId+"_ppNameInputTd").html("<input type = 'text' id = 'ppNameEditInput' value = '"+ppName+"' style='width:100%'/>");
	$("#"+ppId+"_ctNameTd").html("<select id = 'ppIdEditCategoryTwoBox'></select>"+
			"<input type = 'hidden' id = 'ppIdEditCategoryOneBox' value = '"+$("#newPropertyCategoryOneBox").val()+"' />");
	$("#propertyNameListBody label").addClass("disbledAction");
	
	$("#"+ppId+"_editPP").html("<label id = 'editChange' onclick = editProductProperty('"+ppId+"')>Edit</label>");
	$("#"+ppId+"_deletePP").html("<label id = 'editCancel' onclick = listProductProperties('list','"+box+"')>Cancel</label>");
	
	getCategoryTwoList("ppIdEdit");
	$("#ppIdEditCategoryTwoBox option[value="+ctId+"]").attr("selected",true);
	$("#ppNameEditSelect").focus();
}

//产品属性分页

function ppBoxPageAction(action) {
	var pageNoHidden = $("#productPropertyPageNo");
	var pageCount = $("#productPropertyPageCount").val();
	switch(action) {
	case "goBack":
		var pageNo = parseInt(pageNoHidden.val());
		if (pageNo <= 1) {
			break;
		}
		pageNoHidden.val(pageNo-1);
		break;
	case "goFore":
		var pageNo = parseInt(pageNoHidden.val());
		if (pageNo >= pageCount) {
			break;
		}
		pageNoHidden.val(pageNo+1);
		break;
	}
	listProductProperties("list",$("#propertyNameListBody"));
}

//产品类型系列-------------------------------------------------------------------------------------------------

function ptEditBoxChange(ptId,ptImage) {
	if (ptId == null) {
		return null;
	}
	
	if ($("#editChange").length > 0 || $("#editCancel").length > 0) {
		return;
	}
	
	var ptName = $("#pt"+ptId+"nameTd").text();
	var ptPrice = $("#pt"+ptId+"priceTd").text();
	var ptRQuantity = $("#pt"+ptId+"rQuantityTd").text();
	var ptSalePrice = $("#pt"+ptId+"salePriceTd").text();
	
	$("#pt"+ptId+"nameTd").html("<input type='text' id = 'pt_nameEditInput' value = '"+ptName+"'/>");
	$("#pt"+ptId+"imageTd").html("<button id = 'pt_imageEditButton' onclick = ptSelectFile('edit')>选择图片</button>"+
			"<input type='file' id = 'pt_imageEditInput' style = 'display:none'/>");
	$("#pt"+ptId+"priceTd").html("<input type = 'number' id = 'pt_priceEditInput' value = '"+ptPrice+"' />");
	$("#pt"+ptId+"salePriceTd").html("<input type = 'number' id = 'pt_salePriceEditInput' value = '"+ptSalePrice+"' "+
			"onchange = 'ptSalePriceControll()' />");
	$("#pt"+ptId+"rQuantityTd").html("<input type = 'number' id = 'pt_rQuantityEditInput' value = '"+ptRQuantity+"' />");
	
	$("#pt_listBody label").addClass("disbledAction");
	
	$("#pt"+ptId+"edit").html("<label id = 'editChange' onclick = editProductType('"+ptId+"','"+ptImage+"') >Edit</label>");
	$("#pt"+ptId+"delete").html("<label id = 'editCancel' onclick = ' listProductTypes()' >Cancel</label>");
	
	/*getCategoryTwoList("ppIdEdit");*/
	$("#pt_nameEditInput").focus();
}

function ptAddBoxChange(pId) {
	
	if (pId == null) {
		return;
	}
	var htmls = "<tr id = 'pt_addTr'><td><input type='text' id = 'pt_nameAddInput'/></td>"+
				"<td class = 'pt_imageTd'><button id = 'pt_imageAddButton' onclick = ptSelectFile('add')>选择图片</button>"+
				"<form id = 'pt_imageAddInputForm' name = 'pt_imageAddInputForm' enctype='multipart/form-data'><input id = 'pt_imageAddInput' type = 'file' style = 'display:none;' /></form>"+
				"<td><input type='number' id = 'pt_priceAddInput' name = 'pt_priceAddInput' value = '0'/></td>"+
				"<td><input type='number' id = 'pt_salePriceAddInput' name = 'pt_salePriceAddInput' value = '0'/></td>"+
				"<td><input type='number' id = 'pt_rQuantityAddInput' name = 'pt_rQuantityAddInput' value = '0'/></td>"+
 				"<td></td>"+
 				"<td><label id = 'editChange' onclick = addProductType() >Add</label></td>"+
 				"<td><label id = 'editCancel' onclick = listProductTypes() >Cancel</label></td></tr>";
	
	$("#pt_listBody").append(htmls);
	$("#pt_listBody label").addClass("disbledAction");
	
	/*getCategoryTwoList("ppIdEdit");*/
	$("#pt_nameAddInput").focus();
}

function ptSalePriceControll() {
	var ptPrice = parseFloat($("#pt_priceEditInput").val());
	var ptSalePrice = parseFloat($("#pt_salePriceEditInput").val());
	if (ptSalePrice > ptPrice) {
		$("#pt_salePriceEditInput").val(ptPrice);
	}
}

//展开图片选择
function ptSelectFile(type) {
	if (type == "add") {
		$("#pt_imageAddInput").click();
	} else if (type == "edit") {
		$("#pt_imageEditInput").click();
	}
}
//产品类型分页

function ptBoxPageAction(action) {
	var pageNoHidden = $("#pt_PageNo");
	var pageCount = $("#pt_PageCount").val();
	switch(action) {
		case "goBack":
			var pageNo = parseInt(pageNoHidden.val());
			if (pageNo <= 1) {
				break;
			}
			pageNoHidden.val(pageNo-1);
			break;
		case "goFore":
			var pageNo = parseInt(pageNoHidden.val());
			if (pageNo >= pageCount) {
				break;
			}
			pageNoHidden.val(pageNo+1);
			break;
		case "firstPage":
			pageNoHidden.val(1);
			break;
		case "lastPage":
			pageNoHidden.val(pageCount);
			break;
		case "jumpPage":
			var jumpNum = parseInt($("#pt_pageJumpInput").val());
			if (jumpNum < 1) {
				pageNoHidden.val(1);
			} else if (jumpNum > pageCount) {
				pageNo = pageCount;
			}
			break;
	}
	
	listProductTypes();
}

//额外---------------------------------------------------------------------------------------------------------
function sc1(idName) {
    var d = document.getElementById(idName);
    d.style.top = (document.documentElement.scrollTop + (document.documentElement.clientHeight - d.offsetHeight) / 2) + "px";
    d.style.left = (document.documentElement.scrollLeft + (document.documentElement.clientWidth - d.offsetWidth) / 2) + "px";
}