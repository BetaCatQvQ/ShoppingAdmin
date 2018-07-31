function getCategoryOne() {
	var url = "../categoryOne/listOne.action";
	$
			.post(
					url,
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
										+ "</td><td id='edit'><a href='../categoryOne/editCategory.action?id=${caseList.categoryOneId}'><span class='glyphicon glyphicon-th-list'></span></a>"
										+ "</td><td id='listProduct'><a href='listProduct?category_id=${caseList.categoryOneId}'><span class='glyphicon glyphicon-shopping-cart'></span></a>"
										+ "</td><td id='listProperty'><a href='listProperty?category_id=${caseList.categoryOneId}'><span class='glyphicon glyphicon-edit'></span></a>"
										+ "</td></tr>";
							}
							$("#categoryTable").append(thisListValueStr);
							thisListValueStr = "";
						}
					}, "json")
};
function getCategoryTwo() {
	var url = "../categoryTwo/listTwo.action";
	$
			.post(
					url,
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
										+ "</td><td id='edit'><a href='../categoryOne/editCategory.action?id=${caseList.categoryTwoId}'><span class='glyphicon glyphicon-th-list'></span></a>"
										+ "</td><td id='listProduct'><a href='listProduct?category_id=${caseList.categoryTwoId}'><span class='glyphicon glyphicon-shopping-cart'></span></a>"
										+ "</td><td id='listProperty'><a href='listProperty?category_id=${caseList.categoryTwoId}'><span class='glyphicon glyphicon-edit'></span></a>"
										+ "</td></tr>";
							}
							$("#categoryTable").append(thisListValueStr);
							thisListValueStr = "";
						}
					}, "json")
};
function getCategoryThree() {
	var url = "../categoryThree/listThree.action";
	$
			.post(
					url,
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
										+ "</td><td id='edit'><a href='../categoryOne/editCategory.action?id=${caseList.categoryThreeId}'><span class='glyphicon glyphicon-th-list'></span></a>"
										+ "</td><td id='listProduct'><a href='listProduct?category_id=${caseList.categoryThreeId}'><span class='glyphicon glyphicon-shopping-cart'></span></a>"
										+ "</td><td id='listProperty'><a href='listProperty?category_id=${caseList.categoryThreeId}'><span class='glyphicon glyphicon-edit'></span></a>"
										+ "</td></tr>";
							}
							$("#categoryTable").append(thisListValueStr);
							thisListValueStr = "";
						}
					}, "json")
};

function getByPage() {
	var categoryid = $(".categoryMenu").val();// 获取select选中的值
	var params = $()
	var url = "categoryOne";
	$
			.ajax({
				url : 'url?' + 'selectVal=' + val,// 后台请求url，传入值
				type : 'GET',// 使用get请求，如果用post，值写在data里
				cache : true,// 缓存
				dataType : 'json',// 返回的数据类型，就是后台返回回来的类型，可以是html，或xml
				async : true,// 使用异步方式
				success : function(data) {// 成功后返回值data
					$("#categoryTable").empty();
					var thisListValueStr = "";
					console.log(data.length + "条数据");
					for (var i = 0; i < data.length; i++) {
						// 解释一下data[i],第一个[i]是获得JSONArray中的第i个Map
						// 如本方法caseList[0],是data中第一个list中的第一个Map
						var caseList = data[i]; // 获取Map
						if (data.length == 0) {
							thisListValueStr = "<tr><td colspan='5'>抱歉，未查询到数据~</td></tr>";
						} else {
							thisListValueStr = "<tr><td id='id'>"
									+ caseList.categoryOneId
									+ "</td><td id='name'>"
									+ caseList.categoryOneName
									+ "</td><td id='edit'><a href='../categoryThree/editCategory.action?id=${c.categoryThreeId}'><span class='glyphicon glyphicon-th-list'></span></a>"
									+ "</td><td id='listProduct'><a href='listProduct?category_id=${c.categoryThreeId}'><span class='glyphicon glyphicon-shopping-cart'></span></a>"
									+ "</td><td id='listProperty'><a href='listProperty?category_id=${c.categoryThreeId}'><span class='glyphicon glyphicon-edit'></span></a>"
									+ "</td><tr/>";
						}
						$("#resultTable").append(thisListValueStr);
						thisListValueStr = "";
					}
				},
				error : function() {// 失败的处理
					window.location.href="404.jsp" 
				}
			});
}