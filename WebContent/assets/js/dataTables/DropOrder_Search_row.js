

//·················listOrder.jsp
//					每页行数  start	·······················
 
//                  end 每页行数     ·······················
//				          根据后台选择分页框的值  start	···········
window.onload= function(){
	// 根据值去除选中状态
	$(" #dataTables-example_SelectVal option[value='2']").removeAttr("selected");

	var key = $("#pageSize")[0].innerHTML;
	
	// 根据值让option选中
	$(" #dataTables-example_SelectVal option[value='" + key + "']").attr("selected", "selected");
	
	this.locationByPage();
}
// 					 end 根据后台选择分页框的值   ············

//					分页设计  start	·······················
function locationByPage(){
	var keyPageNo = $("#pageNo")[0].innerHTML;
	var keyPageCount = $("#pageCount")[0].innerHTML;
	
	$("#dataTables-example_info")[0].innerHTML="";
	$("#dataTables-example_info")[0].innerHTML="Showing"+keyPageNo+"to "+keyPageCount+" of "+keyPageCount+" entries";
	
	if(keyPageCount>1 && keyPageNo<keyPageCount){
		$("#dataTables-example_next").removeClass("disabled");
		
	}else{
		$("#dataTables-example_next").removeClass("disabled");
		$("#dataTables-example_next")[0].setAttribute("class", "disabled");
	}
}
//					end 分页设计     ·······················

var isClick=false;  //判断按钮是否被点击 ···················

//					search start·······················
function getbySerach(){
	isClick = true;
	//判断搜索框数据
	var number = "^[0-9]*$";
	var nameChinese = "^[\u4e00-\u9fa5]{0,4}$";
	var nameEnglish = "^[A-Za-z0-9]+$";
	var nameChAndEng = "^[\u4E00-\u9FA5A-Za-z0-9]+$";
	var dataTime = "";
}
//					end  search ·······················


/*					NEXT ······························
 *						oncilck 事件····················			
 *							start ·····················
 */

function getByNext(){
	var keyPageNo = $("#pageNo")[0].innerHTML;
	var keySelectVal = $("#dataTables-example_SelectVal").val();
	var keysearchParams =$("#dataTables-example_filter_Search").val();
	//ajax
	var url ="../order/nextOrder.action";
	var params ={
			"pageSize":keySelectVal,
			"searchParams":keysearchParams
	};
	if(isClick != true){
		alert("请先点击Search!查询!或者清除查询框数据");
	}else{
		$.post(url,params,function(data){
			console.log(data);
		});
	}
}












