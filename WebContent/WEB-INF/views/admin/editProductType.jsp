<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
    <nav class="navbar navbar-default top-navbar" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="listCategory">Tmall</a>
        </div>
    </nav>

    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">

                <li>
                    <a class="active-menu" href="listCategory"><i class="fa fa-bars"></i> 分类管理</a>
                </li>
                <li>
                    <a href="listUser"><i class="fa fa-user"></i> 用户管理</a>
                </li>
                <li>
                    <a href="listOrder"><i class="fa fa-list-alt"></i> 订单管理</a>
                </li>
                <li>
                    <a href="listLink"><i class="fa fa-link"></i> 推荐链接管理</a>
                </li>
            </ul>
        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        分类管理
                        <small> - ${category.name} - id:${product.id} 产品管理</small>
                    </h1>
                </div>
            </div>

            <div class="row">
                <div class="col-md-3">
                    <a href="javascript:history.back()" class="btn btn-success">返回上一页</a>
                </div>
            </div>
            <br>

            <div class="row">
                <div class="col-md-6">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           添加产品类型信息
                        </div>
                        <%-- <div class="panel-body">
                            <div class="row col-lg-12">
                                <form action="updateProduct" role="form">
                                    <div class="form-group">
                                        <input type="hidden" name="id" value="${product.id}">
                                        <label>产品类型名：</label>
                                        <input type="text" name="name" class="form-control" value="${product.name}">
                                        <label>产品类型价格：</label>
                                        <input type="text" name="sub_title"class="form-control" value="${product.sub_title}">
                                        <label>产品类型优惠价格：</label>
                                        <input type="text" name="sub_title"class="form-control" value="${product.sub_title}">
                                        <label>产品类型库存：</label>
                                        <input type="text" name="sub_title"class="form-control" value="${product.sub_title}">
                                        <label>产品类型图片:</label>
                                        <input type = "file" name = "fileControll" id = "productTypeImageInput" vlaue = "${} }"
                                    </div>
                                    <input type = "submit" name = "submitProduct" id = "submitProduct"
                                </form>
                            </div> --%>

                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>

        </div>
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
</body>
</html>