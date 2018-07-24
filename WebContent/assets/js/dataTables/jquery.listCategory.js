function getCategoryOne(){
	var url = "../categoryOne/listOne.action";
	$.post(url,function(data){
		
	},"json")
};
function getCategoryTwo(){
	var url = "../categoryTwo/listTwo.action";
	$.post(url,function(data){
		console.log(data);
	},"json")
};
function getCategoryThree
(){
	var url = "../categoryThree/listThree.action";
	$.post(url,function(data){
		console.log(data);
	},"json")
};