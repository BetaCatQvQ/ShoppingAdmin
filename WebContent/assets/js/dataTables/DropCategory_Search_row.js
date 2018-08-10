//----------------------分类选择功能 start-----------------------

function getCategoryOne() {
	var url = "../categoryOne/listOne.action";
	var params = $("#selectPage").val();// 获取select选中的值
	console.log(params);
	$
			.post(
					url,
					{
						"pageSize" : params
					},
					function(data) {
						$("#categoryTable").empty();
						var thisListValueStr = "";
						console.log(data.data.length + "条数据");
						for (var i = 0; i < data.data.length; i++) {
							// 解释一下data[i],第一个[i]是获得JSONArray中的第i个Map
							// 如本方法caseList[0],是data中第一个list中的第一个Map
							var caseList = data.data[i]; // 获取Map
							console.log(caseList);
							if (data.data.length == 0) {
								thisListValueStr = "<tr><td colspan='5'>抱歉，未查询到数据~</td></tr>";
							} else {
								thisListValueStr = "<tr><td id='id'>"
										+ caseList.categoryOneId
										+ "</td><td id='name'>"
										+ caseList.categoryOneName
										+ "</td><td id='edit'><a href='../categoryOne/editCategory.action?id="
										+ caseList.categoryOneId
										+ "'><span class='glyphicon glyphicon-th-list'></span></a>"
										+ "</td><td id='listProduct'><a href='listProduct?category_id="
										+ caseList.categoryOneId
										+ "'><span class='glyphicon glyphicon-shopping-cart'></span></a>"
										+ " </td><td id='hidden'>一级分类</td></tr>"
										+ " <tr><td id='pageNo' style='display: none;'>"
										+ data.pageNo
										+ "</td></tr>"
										+ " <tr><td id='pageCount' style='display: none;'>"
										+ data.pageCount + "</td></tr>";
							}
							$("#categoryTable").append(thisListValueStr);
							thisListValueStr = "";
						}
					}, "json");
	this.disabledPage();
};
function getCategoryTwo() {
	var url = "../categoryTwo/listTwo.action";
	var params = $("#selectPage").val();// 获取select选中的值
	$
			.post(
					url,
					{
						"pageSize" : params
					},
					function(data) {
						$("#categoryTable").empty();
						var thisListValueStr = "";
						console.log(data.data.length + "条数据");
						for (var i = 0; i < data.data.length; i++) {
							// 解释一下data[i],第一个[i]是获得JSONArray中的第i个Map
							// 如本方法caseList[0],是data中第一个list中的第一个Map
							var caseList = data.data[i]; // 获取Map
							console.log(caseList);
							if (data.data.length == 0) {
								thisListValueStr = "<tr><td colspan='5'>抱歉，未查询到数据~</td></tr>";
							} else {
								thisListValueStr = "<tr><td id='id'>"
										+ caseList.categoryTwoId
										+ "</td><td id='name'>"
										+ caseList.categoryTwoName
										+ "</td><td id='edit'><a href='../categoryOne/editCategory.action?id="
										+ caseList.categoryTwoId
										+ "'><span class='glyphicon glyphicon-th-list'></span></a>"
										+ "</td><td id='listProduct'><a href='listProduct?category_id="
										+ caseList.categoryTwoId
										+ "'><span class='glyphicon glyphicon-shopping-cart'></span></a>"
										+ "</td><td id='hidden'>二级分类</td></tr>"
										+ " <tr><td id='pageNo' style='display: none;'>"
										+ data.pageNo
										+ "</td></tr>"
										+ " <tr><td id='pageCount' style='display: none;'>"
										+ data.pageCount + "</td></tr>";
							}
							$("#categoryTable").append(thisListValueStr);
							thisListValueStr = "";
						}
					}, "json");
	this.disabledPage();
};
function getCategoryThree() {
	var url = "../categoryThree/listThree.action";
	var params = $("#selectPage").val();// 获取select选中的值
	$
			.post(
					url,
					{
						"pageSize" : params
					},
					function(data) {
						$("#categoryTable").empty();
						var thisListValueStr = "";
						console.log(data.data.length + "条数据");
						for (var i = 0; i < data.data.length; i++) {
							// 解释一下data[i],第一个[i]是获得JSONArray中的第i个Map
							// 如本方法caseList[0],是data中第一个list中的第一个Map
							var caseList = data.data[i]; // 获取Map
							console.log(caseList);
							if (data.data.length == 0) {
								thisListValueStr = "<tr><td colspan='5'>抱歉，未查询到数据~</td></tr>";
							} else {
								thisListValueStr = "<tr><td id='id'>"
										+ caseList.categoryThreeId
										+ "</td><td id='name'>"
										+ caseList.categoryThreeName
										+ "</td><td id='edit'><a href='../categoryOne/editCategory.action?id="
										+ caseList.categoryThreeId
										+ "'><span class='glyphicon glyphicon-th-list'></span></a>"
										+ "</td><td id='listProduct'><a href='listProduct?category_id="
										+ caseList.categoryThreeId
										+ "'><span class='glyphicon glyphicon-shopping-cart'></span></a>"
										+ "</td><td id='hidden'>三级分类</td></tr>"
										+ " <tr><td id='pageNo' style='display: none;'>"
										+ data.pageNo
										+ "</td></tr>"
										+ " <tr><td id='pageCount' style='display: none;'>"
										+ data.pageCount + "</td></tr>";
							}
							$("#categoryTable").append(thisListValueStr);
							thisListValueStr = "";
						}
					}, "json");
	this.disabledPage();
};
// ----------------------分类选择功能 end-----------------------

// ----------------------分页选择功能 start-----------------------
function getByPage() {
	var categoryId = document.getElementById("hidden").innerHTML; // 获取分类等级
	console.log("--------------categoryId:" + categoryId);
	if ("一级分类" == categoryId) {
		this.getCategoryOne();
	} else if ("二级分类" == categoryId) {
		this.getCategoryTwo();
	} else if ("三级分类" == categoryId) {
		this.getCategoryThree();
	}
	this.disabledPage();
}
// ----------------------分页选择功能 end-----------------------

// ----------------------搜索功能 start-----------------------
function getbySerach() {
	var searchParams = $("#searchParams").val(); // 获取搜索条件
	var categoryId = document.getElementById("hidden").innerHTML; // 获取分类等级
	var selectVal = $("#selectPage").val();// 获取select选中的值
	var pageNo = document.getElementById("pageNo").innerHTML; // 获取pageNo
	console.log(pageNo);
	var params = {
		"searchParams" : searchParams,
		"selectVal" : selectVal,
		"pageNo" : pageNo
	};
	if ("一级分类" == categoryId) {
		var url = "../categoryOne/getBysearch.action";
		$
				.post(
						url,
						params,
						function(data) {
							$("#categoryTable").empty();
							var thisListValueStr = "";
							console.log(data.data.length + "条数据");
							for (var i = 0; i < data.data.length; i++) {
								// 解释一下data[i],第一个[i]是获得JSONArray中的第i个Map
								// 如本方法caseList[0],是data中第一个list中的第一个Map
								var caseList = data.data[i]; // 获取Map
								if (data.data.length == 0) {
									thisListValueStr = "<tr><td colspan='5'>抱歉，未查询到数据~</td></tr>";
								} else {
									thisListValueStr = "<tr><td id='id'>"
											+ caseList.categoryOneId
											+ "</td><td id='name'>"
											+ caseList.categoryOneName
											+ "</td><td id='edit'><a href='../categoryOne/editCategory.action?id="
											+ caseList.categoryOneId
											+ "'><span class='glyphicon glyphicon-th-list'></span></a>"
											+ "</td><td id='listProduct'><a href='listProduct?category_id="
											+ caseList.categoryOneId
											+ "'><span class='glyphicon glyphicon-shopping-cart'></span></a>"
											+ "</td><td id='hidden'>一级分类</td></tr>"
											+ " <tr><td id='pageNo' style='display: none;'>"
											+ data.pageNo
											+ "</td></tr>"
											+ " <tr><td id='pageCount' style='display: none;'>"
											+ data.pageCount + "</td></tr>";
								}
								$("#categoryTable").append(thisListValueStr);
								thisListValueStr = "";
							}
						}, "json");
	} else if ("二级分类" == categoryId) {
		var url = "../categoryTwo/getBysearch.action";
		$
				.post(
						url,
						params,
						function(data) {
							$("#categoryTable").empty();
							var thisListValueStr = "";
							console.log(data.data.length + "条数据");
							for (var i = 0; i < data.data.length; i++) {
								// 解释一下data[i],第一个[i]是获得JSONArray中的第i个Map
								// 如本方法caseList[0],是data中第一个list中的第一个Map
								var caseList = data.data[i]; // 获取Map
								console.log(caseList);
								if (data.data.length == 0) {
									thisListValueStr = "<tr><td colspan='5'>抱歉，未查询到数据~</td></tr>";
								} else {
									thisListValueStr = "<tr><td id='id'>"
											+ caseList.categoryTwoId
											+ "</td><td id='name'>"
											+ caseList.categoryTwoName
											+ "</td><td id='edit'><a href='../categoryOne/editCategory.action?id="
											+ caseList.categoryTwoId
											+ "'><span class='glyphicon glyphicon-th-list'></span></a>"
											+ "</td><td id='listProduct'><a href='listProduct?category_id="
											+ caseList.categoryTwoId
											+ "'><span class='glyphicon glyphicon-shopping-cart'></span></a>"
											+ "</td><td id='hidden'>二级分类</td></tr>"
											+ " <tr><td id='pageNo' style='display: none;'>"
											+ data.pageNo
											+ "</td></tr>"
											+ " <tr><td id='pageCount' style='display: none;'>"
											+ data.pageCount + "</td></tr>";
								}
								$("#categoryTable").append(thisListValueStr);
								thisListValueStr = "";
							}
						}, "json");
	} else if ("三级分类" == categoryId) {
		var url = "../categoryThree/getBysearch.action";
		$
				.post(
						url,
						params,
						function(data) {
							$("#categoryTable").empty();
							var thisListValueStr = "";
							console.log(data.data.length + "条数据");
							for (var i = 0; i < data.data.length; i++) {
								// 解释一下data[i],第一个[i]是获得JSONArray中的第i个Map
								// 如本方法caseList[0],是data中第一个list中的第一个Map
								var caseList = data.data[i]; // 获取Map
								console.log(caseList);
								if (data.data.length == 0) {
									thisListValueStr = "<tr><td colspan='5'>抱歉，未查询到数据~</td></tr>";
								} else {
									thisListValueStr = "<tr><td id='id'>"
											+ caseList.categoryThreeId
											+ "</td><td id='name'>"
											+ caseList.categoryThreeName
											+ "</td><td id='edit'><a href='../categoryOne/editCategory.action?id="
											+ caseList.categoryThreeId
											+ "'><span class='glyphicon glyphicon-th-list'></span></a>"
											+ "</td><td id='listProduct'><a href='listProduct?category_id="
											+ caseList.categoryThreeId
											+ "'><span class='glyphicon glyphicon-shopping-cart'></span></a>"
											+ "</td><td id='hidden'>三级分类</td></tr>"
											+ " <tr><td id='pageNo' style='display: none;'>"
											+ data.pageNo
											+ "</td></tr>"
											+ " <tr><td id='pageCount' style='display: none;'>"
											+ data.pageCount + "</td></tr>";
								}
								$("#categoryTable").append(thisListValueStr);
								thisListValueStr = "";
							}
						}, "json");
	}
	this.disabledPage();
}
// ----------------------搜索功能 end-----------------------

// ----------------------分页功能 start-----------------------
window.onload = disabledPage();

function disabledPage() {
	// ------------ 根据后台选择分页框的值 start---------
	// 根据值去除选中状态
	$("#selectPage option[value='2']").removeAttr("selected");

	var key = $("#pageSize").val();
	console.log(key);
	// 根据值让option选中
	$("#selectPage option[value='" + key + "']").attr("selected", "selected");
	// ------------ 根据后台选择分页框的值 end----------

	var pageNo = $("#pageNo")[0].innerHTML;
	var pageCount = $("#pageCount")[0].innerHTML;
	console.log("-----pageNo:" + pageNo);
	console.log("-------pageCount:" + pageCount);

	// 分页栏的样式动态修改 ---start----
	if (pageNo == 1) {
		$("#First")[0].setAttribute("class", "active");
		$("#Second").removeClass("active");
		$("#Third").removeClass("active");
		$("#Fourth").removeClass("active");
		$("#Next").removeClass("active");

		$("#Back")[0].setAttribute("class", "disabled");
		$("#Back").removeClass("href");
		// -------禁止标签的动态修改 start---------
		if (pageCount == 1) {
			$("#Second")[0].setAttribute("class", "disabled");
			$("#Third")[0].setAttribute("class", "disabled");
			$("#Fourth")[0].setAttribute("class", "disabled");

			$("#Second").removeClass("href");
			$("#Third").removeClass("href");
			$("#Fourth").removeClass("href");
		} else if (pageCount <= 2) {
			// ----移除鼠标符号 start -----
			$("#First").removeClass("disabled");
			$("#Second").removeClass("disabled");

			$("#First")[0].setAttribute("href", "javascript:getFirstPage()");
			$("#Second")[0].setAttribute("href", "javascript:getSecondPage()");
			// ----添加鼠标点击事件 end-----

			// ----添加鼠标符号 start -----
			$("#Third")[0].setAttribute("class", "disabled");
			$("#Fourth")[0].setAttribute("class", "disabled");

			$("#Third").removeAttr("href");
			$("#Fourth").removeAttr("href");
			// -----取消鼠标点击事件 end -----
		} else if (pageCount <= 3) {
			// ----移除鼠标符号 start -----
			$("#First").removeClass("disabled");
			$("#Second").removeClass("disabled");
			$("#Third").removeClass("disabled");

			$("#First")[0].setAttribute("href", "javascript:getFirstPage()");
			$("#Second")[0].setAttribute("href", "javascript:getSecondPage()");
			$("#Third")[0].setAttribute("href", "javascript:getThirdPage()");
			// ----添加鼠标点击事件 end-----

			// ----添加鼠标符号 start -----
			$("#Fourth")[0].setAttribute("class", "disabled");

			$("#Fourth").removeClass("href");
			// -----取消鼠标点击事件 end -----
		} else if (pageCount <= 4) {
			// ----移除鼠标符号 start -----
			$("#First").removeClass("disabled");
			$("#Second").removeClass("disabled");
			$("#Third").removeClass("disabled");
			$("#Fourth").removeClass("disabled");

			$("#First")[0].setAttribute("href", "javascript:getFirstPage()");
			$("#Second")[0].setAttribute("href", "javascript:getSecondPage()");
			$("#Third")[0].setAttribute("href", "javascript:getThirdPage()");
			$("#Fourth")[0].setAttribute("href", "javascript:getFourthPage()");
			// ----添加鼠标点击事件 end-----
		} else if (pageCount > 4) {
			// ----移除鼠标符号 start -----
			$("#First").removeClass("disabled");
			$("#Second").removeClass("disabled");
			$("#Third").removeClass("disabled");
			$("#Fourth").removeClass("disabled");

			$("#First")[0].setAttribute("href", "javascript:getFirstPage()");
			$("#Second")[0].setAttribute("href", "javascript:getSecondPage()");
			$("#Third")[0].setAttribute("href", "javascript:getThirdPage()");
			$("#Fourth")[0].setAttribute("href", "javascript:getFourthPage()");
			// ----添加鼠标点击事件 end-----
		}
		if (pageCount == pageNo) {
			$("#Next")[0].setAttribute("class", "disabled");
			$("#Next").removeClass("href");
		} else {
			$("#Next").removeClass("disabled");
			$("#Next")[0].setAttribute("href", "javascript:getNextPage()");
		}
		// -------禁止标签的动态修改 end ---------
	}
	if (pageNo == 2) {
		$("#Second")[0].setAttribute("class", "active");
		$("#First").removeClass("active");
		$("#Third").removeClass("active");
		$("#Fourth").removeClass("active");
		$("#Next").removeClass("active");
		
		$("#Back").removeClass("disabled");
		$("#Back").attr("href","javascript:getBackPage()");
		if (pageCount <= 2) {
			// ----移除鼠标符号 start -----
			$("#First").removeClass("disabled");
			$("#Second").removeClass("disabled");

			$("#First")[0].setAttribute("href", "javascript:getFirstPage()");
			$("#Second")[0].setAttribute("href", "javascript:getSecondPage()");
			// ----添加鼠标点击事件 end-----

			// ----添加鼠标符号 start -----
			$("#Third")[0].setAttribute("class", "disabled");
			$("#Fourth")[0].setAttribute("class", "disabled");

			$("#Third").removeAttr("href");
			$("#Fourth").removeAttr("href");
			// -----取消鼠标点击事件 end -----
		} else if (pageCount <= 3) {
			// ----移除鼠标符号 start -----
			$("#First").removeClass("disabled");
			$("#Second").removeClass("disabled");
			$("#Third").removeClass("disabled");

			$("#First")[0].setAttribute("href", "javascript:getFirstPage()");
			$("#Second")[0].setAttribute("href", "javascript:getSecondPage()");
			$("#Third")[0].setAttribute("href", "javascript:getThirdPage()");
			// ----添加鼠标点击事件 end-----

			// ----添加鼠标符号 start -----
			$("#Fourth")[0].setAttribute("class", "disabled");

			$("#Fourth").removeClass("href");
			// -----取消鼠标点击事件 end -----
		} else if (pageCount <= 4) {
			// ----移除鼠标符号 start -----
			$("#First").removeClass("disabled");
			$("#Second").removeClass("disabled");
			$("#Third").removeClass("disabled");
			$("#Fourth").removeClass("disabled");

			$("#First")[0].setAttribute("href", "javascript:getFirstPage()");
			$("#Second")[0].setAttribute("href", "javascript:getSecondPage()");
			$("#Third")[0].setAttribute("href", "javascript:getThirdPage()");
			$("#Fourth")[0].setAttribute("href", "javascript:getFourthPage()");
			// ----添加鼠标点击事件 end-----
		} else if (pageCount > 4) {
			// ----移除鼠标符号 start -----
			$("#First").removeClass("disabled");
			$("#Second").removeClass("disabled");
			$("#Third").removeClass("disabled");
			$("#Fourth").removeClass("disabled");

			$("#First")[0].setAttribute("href", "javascript:getFirstPage()");
			$("#Second")[0].setAttribute("href", "javascript:getSecondPage()");
			$("#Third")[0].setAttribute("href", "javascript:getThirdPage()");
			$("#Fourth")[0].setAttribute("href", "javascript:getFourthPage()");
			// ----添加鼠标点击事件 end-----
		}
		if (pageCount == pageNo) {
			$("#Next")[0].setAttribute("class", "disabled");
			$("#Next").removeClass("href");
		} else {
			$("#Next").removeClass("disabled");
			$("#Next")[0].setAttribute("href", "javascript:getNextPage()");
		}
	}
	if (pageNo == 3) {
		$("#Third")[0].setAttribute("class", "active");
		$("#Second").removeClass("active");
		$("#First").removeClass("active");
		$("#Fourth").removeClass("active");
		$("#Next").removeClass("active");
		
		$("#Back").removeClass("disabled");
		$("#Back").attr("href","javascript:getBackPage()");
		if (pageCount <= 3) {
			// ----移除鼠标符号 start -----
			$("#First").removeClass("disabled");
			$("#Second").removeClass("disabled");
			$("#Third").removeClass("disabled");

			$("#First")[0].setAttribute("href", "javascript:getFirstPage()");
			$("#Second")[0].setAttribute("href", "javascript:getSecondPage()");
			$("#Third")[0].setAttribute("href", "javascript:getThirdPage()");
			// ----添加鼠标点击事件 end-----

			// ----添加鼠标符号 start -----
			$("#Fourth")[0].setAttribute("class", "disabled");

			$("#Fourth").removeClass("href");
			// -----取消鼠标点击事件 end -----
		} else if (pageCount <= 4) {
			// ----移除鼠标符号 start -----
			$("#First").removeClass("disabled");
			$("#Second").removeClass("disabled");
			$("#Third").removeClass("disabled");
			$("#Fourth").removeClass("disabled");

			$("#First")[0].setAttribute("href", "javascript:getFirstPage()");
			$("#Second")[0].setAttribute("href", "javascript:getSecondPage()");
			$("#Third")[0].setAttribute("href", "javascript:getThirdPage()");
			$("#Fourth")[0].setAttribute("href", "javascript:getFourthPage()");
			// ----添加鼠标点击事件 end-----
		} else if (pageCount > 4) {
			// ----移除鼠标符号 start -----
			$("#First").removeClass("disabled");
			$("#Second").removeClass("disabled");
			$("#Third").removeClass("disabled");
			$("#Fourth").removeClass("disabled");

			$("#First")[0].setAttribute("href", "javascript:getFirstPage()");
			$("#Second")[0].setAttribute("href", "javascript:getSecondPage()");
			$("#Third")[0].setAttribute("href", "javascript:getThirdPage()");
			$("#Fourth")[0].setAttribute("href", "javascript:getFourthPage()");
			// ----添加鼠标点击事件 end-----
		}
		if (pageCount == pageNo) {
			$("#Next")[0].setAttribute("class", "disabled");
			$("#Next").removeClass("href");
		} else {
			$("#Next").removeClass("disabled");
			$("#Next")[0].setAttribute("href", "javascript:getNextPage()");
		}
	}
	if (pageNo == 4) {
		$("#Fourth")[0].setAttribute("class", "active");
		$("#Second").removeClass("active");
		$("#Third").removeClass("active");
		$("#First").removeClass("active");
		$("#Next").removeClass("active");
		
		$("#Back").removeClass("disabled");
		$("#Back").attr("href","javascript:getBackPage()");
		
		$("#Next")[0].setAttribute("class", "disabled");
		$("#Next").removeAttr("href");
		if (pageCount <= 4) {
			// ----移除鼠标符号 start -----
			$("#First").removeClass("disabled");
			$("#Second").removeClass("disabled");
			$("#Third").removeClass("disabled");
			$("#Fourth").removeClass("disabled");

			$("#First")[0].setAttribute("href", "javascript:getFirstPage()");
			$("#Second")[0].setAttribute("href", "javascript:getSecondPage()");
			$("#Third")[0].setAttribute("href", "javascript:getThirdPage()");
			$("#Fourth")[0].setAttribute("href", "javascript:getFourthPage()");
			// ----添加鼠标点击事件 end-----
		} else if (pageCount > 4) {
			// ----移除鼠标符号 start -----
			$("#First").removeClass("disabled");
			$("#Second").removeClass("disabled");
			$("#Third").removeClass("disabled");
			$("#Fourth").removeClass("disabled");

			$("#First")[0].setAttribute("href", "javascript:getFirstPage()");
			$("#Second")[0].setAttribute("href", "javascript:getSecondPage()");
			$("#Third")[0].setAttribute("href", "javascript:getThirdPage()");
			$("#Fourth")[0].setAttribute("href", "javascript:getFourthPage()");
			// ----添加鼠标点击事件 end-----
		}
		if (pageCount == pageNo) {
			$("#Next")[0].setAttribute("class", "disabled");
			$("#Next").removeClass("href");
		} else {
			$("#Next").removeClass("disabled");
			$("#Next")[0].setAttribute("href", "javascript:getNextPage()");
		}
	}
}
// 分页栏的样式动态修改 --- end ----
// 首页
function getStartPage() {
	document.getElementById("pageNo").innerHTML = 1;
	console.log(document.getElementById("pageNo").innerHTML);
	this.getbySerach();
	this.disabledPage();

}

// 上一页
function getBackPage() {
	document.getElementById("pageNo").innerHTML = (document
			.getElementById("pageNo").innerHTML)*1 - 1;
	this.getbySerach();
	this.disabledPage();
}

// 第一页
function getFirstPage() {
	this.getStartPage();
}

// 第二页
function getSecondPage() {
	document.getElementById("pageNo").innerHTML = 2;
	this.getbySerach();
	this.disabledPage();
}

// 第三页
function getThirdPage() {
	document.getElementById("pageNo").innerHTML = 3;
	this.getbySerach();
	this.disabledPage();
}

// 第四页
function getFourthPage() {
	document.getElementById("pageNo").innerHTML = 4;
	this.getbySerach();
	this.disabledPage();
}

// 下一页
function getNextPage() {

	document.getElementById("pageNo").innerHTML = (document
			.getElementById("pageNo").innerHTML)*1 + 1;
	this.getbySerach();
	this.disabledPage();
}

// 尾页
function getEndPage() {
	document.getElementById("pageNo").innerHTML = document
			.getElementById("pageCount").innerHTML;
	this.getbySerach();
}
// ----------------------分页功能 end-----------------------

