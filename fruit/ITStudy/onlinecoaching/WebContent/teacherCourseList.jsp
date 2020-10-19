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
	  var count = 3;
	  var order = "id";
	  var sort = "desc";
	  var courseTypeId = 0;
	  var courseName = "";
	  showList(page,count,order,sort,courseTypeId,courseName);
	  //通过接口获取的课程分类
	  $.get("CourseTypeApiServlet",function(e){
		  if(e.result == "success"){
			  var str = "<option value='0' selected>Choose...</option>";
			  for(var i in e.data){
				  str += '<option value="'+ e.data[i].courseTypeId +'">'+ e.data[i].courseTypeName+'</option>';
			  }
			  $("#inlineFormCustomSelect").html(str);
		  }else{
			  alert(e.message);
		  }
	  },"json");
	  
	  $("#search").click(function() {
		   page = 1;
		   courseTypeId = $("#inlineFormCustomSelect").val();
		   courseName = $("#courseName").val();  
		   showList(page,count,order,sort,courseTypeId,courseName);
		   
		   return false;
	});
	  
	$(".page-link").click(function(){
		
		if($(this).text().trim() == "»"){
			page = page + 1;
		}else if($(this).text().trim() == "«" && page != 1){
			page = page - 1;
		}else{
			page = parseInt($(this).text());
		}
		
		 courseTypeId = $("#inlineFormCustomSelect").val();
		 courseName = $("#courseName").val();  
		 showList(page,count,order,sort,courseTypeId,courseName);
		return false;
	});  
	  
  });
  
  function showList(page,count,order,sort,courseTypeId,courseName) {
	  var url = "CourseApiServlet?page="+page+"&count="+count+"&order="+order+"&sort="+sort;
	  if(courseTypeId != 0){
		  url += "&courseTypeId="+courseTypeId;
	  }
	  if(courseName.length != 0 ){
		  url += "&courseName="+courseName;
	  }
	
	$.get(url,
		function(e){
	 		var str = ""; 
	 		if(e.result == "success"){
	 			for(var i in e.data){
	 				str += '<tr>';
	 				str += '      <th scope="row">'+e.data[i].id+'</th>';
	 				str += '      <td>'+e.data[i].courseName+'</td>';
	 				str += '      <td>'+e.data[i].courseTypeName+'</td>';
	 				str += '      <td>'+e.data[i].userTruename+'</td>';
	 				str += '      <td>'+e.data[i].ctime+'</td>';
	 				str += '      <td>';
	 				str += '		<button type="button" ids="'+e.data[i].id+'" class="btn btn-danger btn-sm">删除</button>';
	 				str += '      	<button type="button" ids="'+e.data[i].id+'" class="btn btn-primary btn-sm">修改</button>';
	 				str += '      </td>';
	 				str += '    </tr>';
	 			}
	 		}else{
	 			str = e.message;
	 		}
	 		$("#courseList").html(str);
	 		return false;
			}
			,"json");
}
  </script>
</head>

<body>
<%@include file="header.jsp" %>
<div class="header">
  <div class="box">
    <div class="L"><a onClick="javascript:history.back(-1)" class="goback"><img src="images/goback.png" /></a></div>
    <div class="C"><p>课程管理</p></div>
  </div>
</div>
<div class="clear"></div>
<div class="allbox"></div>
<!-- start from -->

  <div class="form-row align-items-center">
    <div class="col-auto my-1">
      <label class="sr-only" for="courseName">课程名</label>
      <input type="text" class="form-control" id="courseName" value="" placeholder="课程名">
    </div>
    
   <div class="col-auto my-1">
      <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">课程分类</label>
      <select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
        <option selected>Choose...</option>
        <option value="1">java</option>
        <option value="2">web</option>
        <option value="3">Three</option>
      </select>
    </div>
    
    <div class="col-auto my-1">
      <button type="submit" class="btn btn-primary" id="search">检索</button>
    </div>
     <div class="col-auto my-1">
      <button type="button" class="btn btn-success">添加课程</button>
    </div>
    
  </div>

<!-- end form -->
<div class="allbox"></div>
<!-- start table -->
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">序号</th>
      <th scope="col">课程名称</th>
      <th scope="col">课程分类</th>
      <th scope="col">老师</th>
      <th scope="col">上传时间</th>
      <th scope="col">操作</th>
    </tr>
  </thead>
  <tbody id="courseList">
  
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
    