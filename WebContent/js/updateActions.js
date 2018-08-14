//更新数据的操作
	
	function updateProductAction(actionType) {
		var url = "../product/addProduct.action";
		var selectedProductId = $("#selectedProductId").val();
		var productName = $("#add_productName").val();
		var categoryThreeId = $("#addCategoryThreeBox").val();
		switch (actionType) {
			case "add":
				url = "../product/addProduct.action";
				var productName = $("#add_productName").val();
				categoryThreeId = $("#addCategoryThreeBox").val();
				break;
			case "edit":
				url = "../product/editProduct.action";
				var productName = $("#edit_productName").val();
				categoryThreeId = $("#editCategoryThreeBox").val();
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
	
	function deleteProductImage(productImageId) {
		$.post("../productImage/deleteProductImage.action",{
				"productImageId":productImageId
		},function(data) {
			if (data == 1) {
				searchProductImages();
			}
		});
	}
	
	function deleteProductDetailImage(productDetailImageId) {
		$.post("../productDetailImage/deleteProductDetailImage.action",{
				"productDetailImageId":productDetailImageId
		},function(data) {
			if (data == 1) {
				searchProductDetailImages();
			}
		});
	}
	
	function addProductImage() {
		var selectedProductId = $("#selectedProductId").val();
		var url = "../productImage/addProductImage.action";
		
		var fileObj = $("#btn_addProductImage_file").files[0]; // js 获取文件对象
	    if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
	        alert("请选择图片");
	        return;
	    }
	    var formFile = new FormData();
	    /*formFile.append("action", "../images");*/  
	    formFile.append("productId", selectedProductId);
	    formFile.append("imageFile", fileObj);
	    
	    $.post(url,formFile,function(row){
	    	if (row != 1) {
	    		return;
	    	}
	    	searchProductImages();
	    },"json");
		
		console.log(path);
	}
	
	function addProductDetailImage() {
		var selectedProductId = $("#selectedProductId").val();
		var path = $("btn_addProductDetailImage_file").val();
		var url = "../productImage/addProductDetailImage.action";
		
		console.log(path);
	}
	
//-------------------------------------------------产品属性值操作-----------------------------------------------------------
	
	//删除产品属性值
	function deleteProductPropertyValue(ppvId) {
		if ($("#editChange").length > 0 || $("#editCancel").length > 0) {
			return;
		}
		//var selectedPPVId = $("#selectedPPVId").val();
		$.post("../productPropertyValue/deleteProductPropertyValue.action",{
			"productPropertyValueId" : ppvId
		},function(success){
			if (success == 1) {
				listProductPropertyValues();
			}
		},"json");
	}
	
	//添加产品属性值
	function addProductPropertyValue() {
		if ($("#editChange").length > 0 || $("#editCancel").length > 0) {
			return;
		}
		var selectedProductId = $("#selectedProductId").val();
		var selectedPPId = $("#productPropertySelect").val();
		var ppvName = $("#addProductPropertyValue").val();
		$.post("../productPropertyValue/addProductPropertyValue.action",{
			"valueName" : ppvName,
			"productId" : selectedProductId,
			"ppId" : selectedPPId
		},function(success) {
			if (success == 1) {
				listProductPropertyValues();
			}
		}
		,"json");
	}
	
	//修改产品属性值
	function editProductPropertyValue(ppvId) {
		var ppId = $("#ppIdEditSelect").val();
		var ppvName = $("#ppvNameEditInput").val();
		$.post("../productPropertyValue/editProductPropertyValue.action",{
			"valueId" : ppvId,
			"valueName" : ppvName,
			"ppId" : ppId
		},function(success) {
			if (success == 1) {
				listProductPropertyValues();
			}
		},"json")
	}
	
//-------------------------------------------------产品属性操作-----------------------------------------------------------
	
	function addProductProperty() {
		if ($("#editChange").length > 0 || $("#editCancel").length > 0) {
			return;
		}
		var ctId = $("#newPropertyCategoryTwoBox").val();
		var ppName = $("#addProductPropertyName").val();
		$.post("../productProperty/addProductProperty.action",{
			"ppName" : ppName,
			"categoryTwoId" : ctId
		},function(success){
			console.log("addSuccess:"+success);
			if (success == 1) {
				listProductProperties("list",$("#propertyNameListBody"));
			}
		},"json");
	}
	
	function deleteProductProperty(ppId) {
		$.post("../productProperty/deleteProductProperty.action",{
			"propertyId" : ppId
		},function (success) {
			if (success == 1) {
				listProductProperties("list",$("#propertyNameListBody"));
			}
		},"json");
	}
	
	function editProductProperty(ppId) {
		var ppName = $("#ppNameEditInput").val();
		var ctId = $("#ppIdEditCategoryTwoBox").val();
		if (ctId == null || ctId == undefined) {
			return;
		}
		
		$.post("../productProperty/editProductProperty.action",{
			"ppName" : ppName,
			"categoryTwoId" : ctId,
			"ppId" : ppId			
		},function(success) {
			if (success == 1) {
				listProductProperties("list",$("#propertyNameListBody"));
			}
		},"json");
	}
	
//-------------------------------------------------产品类型操作-------------------------------------------------------------------
	
	function addProductType() {
		if ($("#editChange").length <= 0 || $("#editCancel").length <= 0) {
			return;
		}
		var pId = $("#selectedProductId").val();
		var ptName = $("#pt_nameAddInput").val();
		var ptImage = $("#pt_imageAddInput").val();
		var ptPrice = $("#pt_priceAddInput").val();
		var ptSalePrice = $("#pt_salePriceAddInput").val();
		var ptRQuantity = $("#pt_rQuantityAddInput").val();
		
		var fileObj=document.getElementById("pt_imageAddInput").files[0];
		
		console.log(fileObj);
		/*var imageForm = new FormData();
		//imageForm.append("ptImageFile",$("#pt_imageAddInput").get(0).files[0]);		
		imageForm.append("pId", pId); 
		imageForm.append("ptName", ptName); 
		imageForm.append("ptImage", ptImage); 
		imageForm.append("ptPrice", ptPrice); 
		imageForm.append("ptSalePrice", ptSalePrice); 
		imageForm.append("ptRQuantity", ptRQuantity); 
		imageForm.append("ptImageFile", fileObj);
		console.log(imageForm);*/
		var oFileReader = new FileReader();
		var tdBase64 = null;
        oFileReader.onload = function (e) {
          tdBase64 = e.target.result;
        };
        oFileReader.readAsDataURL(fileObj);
		$.post("../productType/addProductType.action",{
			"pId" : pId,
			"ptName" : ptName,
			"ptImage" : ptImage,
			"ptPrice" : ptPrice,
			"ptSalePrice" : ptSalePrice,
			"ptRQuantity" : ptRQuantity,
			"ptImageFile" : tdBase64
		},function(success) {
			if (success == 1) {
				listProductTypes();
			}
		},"json");
	}
	
	function editProductType(ptId) {
		var pId = $("#selectedProductId").val();
		var ptName = $("#pt_nameAddInput").val();
		var ptImage = $("#pt_imageAddInput").val();
		var ptPrice = $("#pt_priceAddInput").val();
		var ptSalePrice = $("#pt_salePriceAddInput").val();
		var ptRQuantity = $("#pt_rQuantityAddInput").val();
		
		$.post("../productType/editProductType.action",{
			"pId" : pId,
			"ptId" : ptId,
			"ptName" : ptName,
			"ptImage" : ptImage,
			"ptPrice" : ptPrice,
			"ptSalePrice" : ptSalePrice,
			"ptRQuantity" : ptRQuantity
		},function(success) {
			if (success == 1) {
				listProductTypes();
			}
		},"json");
	}
	
	function deleteProductType(ptId) {
		
		if ($("#editChange").length > 0 || $("#editCancel").length > 0) {
			return;
		}
		
		var ptImage = $("#pt"+ptId+"imageTd>img").attr("src");
		
		$.post("../productType/deleteProductType.action",{
			"ptId" : ptId,
			"ptImage" : ptImage
		},function(success) {
			if (success == 1) {
				listProductTypes();
			}
		},"json");
	}