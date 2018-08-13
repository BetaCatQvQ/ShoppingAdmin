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
	}
}

function showPIFileWindow() {
	$("#btn_addProductImage_file").click();
}

function showPDIFileWindow() {
	$("btn_addProductDetailImage_file").click();
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

//产品属性分页------------------------------------

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