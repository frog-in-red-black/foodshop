<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, maximum-scale=1.0, initial-scale=1.0, user-scalable=0" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css">
 <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <style>
  /* Make the image fully responsive */
  .carousel-inner img {
      width: 100%;
      height: 100%;
  }
  .header .box{
      position: relative;
  }
  </style>
  <script type="text/javascript">
  $("document").ready(function(){
	  var page = 1;
	  var count = 5;
	  var order = "userId";
	  var sort = "desc";
	  var userName = "";
	  showList(page,count,order,sort,userName);
	 	  
	  // 查询
	  $("#search").click(function() {
		   page = 1;
		   userName = $("#userName").val();  
		   showList(page,count,order,sort,userName);		   
		   return false;
	});
	  
	  //分页
	$(".page-link").click(function(){
		
		if($(this).text().trim() == "»"){
			page = page + 1;
		}else if($(this).text().trim() == "«" && page != 1){
			page = page - 1;
		}else{
			page = parseInt($(this).text()) ;//转为数字类型
		}
		
		userName = $("#userName").val();  
		 showList(page,count,order,sort,userName);
		return false;
	});  
	  
  });
 
  
  function showList(page,count,order,sort,userName) {
	  var url = "UserApiServlet?page="+page+"&count="+count+"&order="+order+"&sort="+sort;	  
	  if(userName.length != 0 ){
		  url += "&userName="+userName;
	  }
	  
	$.get(url,
		function(e){
	 		var str = ""; 
	 		if(e.result == "success"){
	 			for(var i in e.data){
	 				str += '<tr>';
	 				str1 = '';
	 				if(e.data[i].userRole == 1){
	 					str1 = "学生";
	 				} else if(e.data[i].userRole ==2){
	 					str1 ="老师";				
	 				} else {
	 					str1 ="管理员";	
	 				}
	 				
	 				str2 ='';
	 				if(e.data[i].userStatus == 1){
	 					str2 = "使用";
	 				} else{
	 					str2 ="禁用";	
	 				}
	 					 				
	 				str += '      <th scope="row">'+e.data[i].userTrueName+'</th>';
	 				str += '      <td>'+str1+'</td>';
	 				str += '      <td>'+str2+'</td>';
	 				str += '      <td>'+e.data[i].userEmail+'</td>';
	 				str += '      <td>';
	 				str += '		<button type="button" ids="'+e.data[i].id+'" class="btn btn-danger btn-sm">删除</button>';
	 				str += '      	<button type="button" ids="'+e.data[i].id+'" class="btn btn-primary btn-sm">修改</button>';
	 				str += '      </td>';
	 				str += '    </tr>';
	 			}
	 		}else{
	 			str = e.message;
	 		}
	 		$("#userList").html(str);
	 		return false;
			}
			, "json" );
  }
  </script>
</head>

<body>
<%--<%@include file="header.jsp" %> --%>
<div class="header">
  <div class="box">
    <div class="L"><a onClick="javascript:history.back(-1)" class="goback"><img src="images/goback.png" /></a></div>
    <div class="C"><p>用户管理</p></div>
  </div>
</div>
<div class="clear"></div>
<div class="allbox"></div>
<!-- start from -->

  <div class="form-row align-items-center">
    <div class="col-auto my-1">
      <label class="sr-only" for="userName"> 用户名</label>
      <input type="text" class="form-control" id="userName" value="" placeholder="用户名">
    </div>
    
  
    
    <div class="col-auto my-1">
      <button type="submit" class="btn btn-primary" id="search">检索</button>
    </div>
     <div class="col-auto my-1">
      <button type="button" class="btn btn-success">添加用户</button>
    </div>
    
  </div>

<!-- end form -->
<div class="allbox"></div>
<!-- start table -->
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">用户名</th>
      <th scope="col">角色</th>
      <th scope="col">状态</th>
      <th scope="col">邮箱</th>
      <th scope="col">操作</th>
    </tr>
  </thead>
  <tbody id="userList">
  
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
      <td>Otto</td>
      <td>
		<button type="button" class="btn btn-danger btn-sm">删除</button>
      	<button type="button" class="btn btn-primary btn-sm">修改</button>
      </td>
    </tr>
    
  </tbody>
</table>
<!-- end table -->

<!-- start page -->
<div>
<nav aria-label="Page navigation example" style="margin: 0 auto;width: 50%;text-align:center;">
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
</div>
<!-- end page -->
<div class="allbox"></div>
<%@include file="footer.jsp"  %>  
</body>
</html>
    