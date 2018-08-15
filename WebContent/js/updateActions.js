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
	
	function deleteProductImage(productImageId,piPath) {
		$.post("../productImage/deleteProductImage.action",{
				"productImageId":productImageId,
				"imagePath":piPath
		},function(data) {
			if (data == 1) {
				searchProductImages();
			}
		});
	}
	
	function deleteProductDetailImage(productDetailImageId,pdiPath) {
		$.post("../productDetailImage/deleteProductDetailImage.action",{
				"productDetailImageId":productDetailImageId,
				"imagePath" : pdiPath
		},function(data) {
			if (data == 1) {
				searchProductDetailImages();
			}
		});
	}
	
	function addProductImage() {
		var selectedProductId = $("#selectedProductId").val();
		var url = "../productImage/addProductImage.action";
		var selectFiles = document.getElementById("pi_addFile").files;
		
		if (selectFiles == null) {
			return;
		}
		$.each(selectFiles,function(index,image) {
			if (image != null) {
				var oFileReader = new FileReader();
		    	var tdBase64 = null;
			    	oFileReader.onload = function (e) {
			        	tdBase64 = e.target.result;     
			            $.ajaxSettings.async = false;
			    		$.post("../productImage/addProductImage.action",{
			    			"pId" : selectedProductId,
			    			"imageFile" : tdBase64
			    		},function(success) {
			    			if (success == 1) {
			    				searchProductImages();
			    			}
			    		},"json");
			         };
			         oFileReader.readAsDataURL(image);
			}
		});
		//searchProductImages();
		
	}
	
	function addProductDetailImage() {
		var selectedProductId = $("#selectedProductId").val();
		var url = "../productDetailImage/addProductDetailImage.action";
		var selectFiles = document.getElementById("pdi_addFile").files;
		
		if (selectFiles == null) {
			return;
		}
		$.each(selectFiles,function(index,image) {
			if (image != null) {
				var oFileReader = new FileReader();
		    	var tdBase64 = null;
			    	oFileReader.onload = function (e) {
			        	tdBase64 = e.target.result;     
			            $.ajaxSettings.async = false;
			    		$.post("../productDetailImage/addProductDetailImage.action",{
			    			"pId" : selectedProductId,
			    			"imageFile" : tdBase64
			    		},function(success) {
			    			if (success == 1) {
			    				searchProductDetailImages();
			    			}
			    		},"json");
			         };
			         oFileReader.readAsDataURL(image);
			}
		});
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
		        
        var oFileReader = new FileReader();
    	var tdBase64 = null;
    	if (fileObj != null) {
	        oFileReader.onload = function (e) {
	        	tdBase64 = e.target.result;     
	            console.log("tdBase641:"+tdBase64);
	            console.log("typeOfTdBase:"+typeof(tdBase64));
	            $.ajaxSettings.async = false;
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
	         };
	         oFileReader.readAsDataURL(fileObj);
         } else {
        	 $.ajaxSettings.async = false;
	    		$.post("../productType/addProductType.action",{
	    			"pId" : pId,
	    			"ptName" : ptName,
	    			"ptImage" : ptImage,
	    			"ptPrice" : ptPrice,
	    			"ptSalePrice" : ptSalePrice,
	    			"ptRQuantity" : ptRQuantity,
	    			"ptImageFile" : null
	    		},function(success) {
	    			if (success == 1) {
	    				listProductTypes();
	    			}
	    		},"json");
         }
        
        console.log("tdBase642:"+tdBase64);
        
	}
	
	function editProductType(ptId,ptImage) {
		var pId = $("#selectedProductId").val();
		var ptName = $("#pt_nameEditInput").val();
		var ptPrice = $("#pt_priceEditInput").val();
		var ptSalePrice = $("#pt_salePriceEditInput").val();
		var ptRQuantity = $("#pt_rQuantityEditInput").val();
		
		var imageFile=document.getElementById("pt_imageEditInput").files[0];
		console.log("imageFile:"+imageFile);
		
		var fr = new FileReader();
		var tdBase64 = null;
		if (imageFile != null) {
			fr.onload = function(e) {
				tdBase64 = e.target.result;
				$.ajaxSettings.async = false;
				$.post("../productType/editProductType.action",{
					"pId" : pId,
					"ptId" : ptId,
					"ptName" : ptName,
					"ptPrice" : ptPrice,
					"ptSalePrice" : ptSalePrice,
					"ptRQuantity" : ptRQuantity,
					"ptImageFile" : tdBase64,
					"ptImage" : ptImage
				},function(success) {
					if (success == 1) {
						listProductTypes();
					}
				},"json");
			};
       	 fr.readAsDataURL(imageFile);
		} else {
			$.ajaxSettings.async = false;
			$.post("../productType/editProductType.action",{
				"pId" : pId,
				"ptId" : ptId,
				"ptName" : ptName,
				"ptPrice" : ptPrice,
				"ptSalePrice" : ptSalePrice,
				"ptRQuantity" : ptRQuantity,
				"ptImageFile" : tdBase64,
				"ptImage" : null
			},function(success) {
				if (success == 1) {
					listProductTypes();
				}
			},"json");
		}
	}
	
	function deleteProductType(ptId,ptImage) {
		
		if ($("#editChange").length > 0 || $("#editCancel").length > 0) {
			return;
		}
		
		$.post("../productType/deleteProductType.action",{
			"ptId" : ptId,
			"ptImage" : ptImage
		},function(success) {
			if (success == 1) {
				listProductTypes();
			}
		},"json");
	}
	