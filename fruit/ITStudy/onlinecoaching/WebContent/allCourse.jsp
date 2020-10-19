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
   .teacherLi li{ position: relative;
   
    box-sizing: border-box;
    }
    .teacherTitle{
     top: 10px;
    left: 10px;
    position: absolute;
    padding: 15px;
    }
  </style>
  <script type="text/javascript">
  $("document").ready(function(){
	 /*
	 $.get(url,function(e){},传输的格式)
	 */
	  $.get("BannerAPIServlet?page=1&count=2",
			function(e){
		  		if(e.result == "success"){
		  			var str1 = "";
		  			var str2 = "";
		  			for(var i in e.data){
		  				if(i == 0){
		  					str1 += '<li data-target="#demo" data-slide-to="'+i+'" class="active"></li>';
		  					
		  					str2 += '<div class="carousel-item active"><img src="'+e.data[i].bannerUrl+'"></div>';
		  				}else{
		  					str1 += '<li data-target="#demo" data-slide-to="'+i+'" ></li>';
		  					str2 += '<div class="carousel-item"><img src="'+e.data[i].bannerUrl+'"></div>';
		  				}//end if
		  			}//end for
		  			
		  			$("#demo .carousel-indicators").html(str1);
		  			$("#demo .carousel-inner").html(str2);
		  		}else{
		  			alert(e.message);
		  		}
		  		return false;
	  		},
			"json");

	 
	 $.get("AllCourseApiServlet",function(e){
		 if(e.result=="success"){
			 var str="";
			 for (i in e.data){
				 str+='<li><div class="L"><img src="'+e.data[i].courseImg+'"></div><div class="R">'
				 str+='<div class="tit">'+e.data[i].courseName+'</div>'
				 str+='<div class="sub">'+e.data[i].introduction+'</div>'
				 str+='<div class="pri">'+e.data[i].price+'元<a href="">立即报名</a></div></div></li>'
			 }
			 
			 $(".ul_2").html(str);
		 }else{
			 alert(e.message);
		 }
		 return false;
	 },"json")
	 
	 //显示课程
	 var typeValue=$('#inlineFormCustomSelect').val();
	 alert(typeValue)
	 
	 //获取课程分类 getCourseType
	 
	 $.get("CourseTypeApiServlet",function(e){
		 if(e.result=="success"){
			 var str="<option selected>请选择课程分类</option>";
			 for (i in e.data){
				 str+='<option value="'+e.data[i].courseTypeId+'">'+e.data[i].courseTypeName+'</option>'
			 }
			 alert(str);
			 $("#inlineFormCustomSelect").html(str);
		 }else{
			 alert(e.message);
		 }
		 return false;
	 },"json")
  });
  
  
  
  </script>
</head>

<body>
<%@include file="header.jsp"  %>  

<div class="clear"></div>
<div class="allbox"></div>
<img src="images/bannerm1.jpg">
<div class="allbox"></div>
<div class="clear"></div>
<div class="courseBox">
  
 
  <div class="titbox">
    <img src="images/icon2.png"><p>全部课程</p><img src="images/go.png">
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
  
  <ul class="ul_2">
    <li>
      <div class="L"><img src="images/2.jpg"></div>
      <div class="R">
        <div class="tit">UI设计法则-名师直播课</div>
        <div class="sub">适合想了解UI的学生</div>
        <div class="pri">5000.00元<a href="">立即报名</a></div>
      </div>
    </li>
    <li>
      <div class="L"><img src="images/2.jpg"></div>
      <div class="R">
        <div class="tit">UI设计法则-名师直播课</div>
        <div class="sub">适合想了解UI的学生</div>
        <div class="pri">5000.00元<a href="">立即报名</a></div>
      </div>
    </li>
    <li>
      <div class="L"><img src="images/2.jpg"></div>
      <div class="R">
        <div class="tit">UI设计法则-名师直播课</div>
        <div class="sub">适合想了解UI的学生</div>
        <div class="pri">5000.00元<a href="">立即报名</a></div>
      </div>
    </li>
  </ul>
  
  <div class="clear">
  </div>
 
</div>
<%@include file="footer.jsp"  %>  
</body>
</html>
    