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
	 
	 //推荐课程
	 $.get("RecommandCourseApiServlet",function(e){
		 if(e.result=="success"){
			 var str="";
			
			 //1:直播 2：录播,3:线下课4，直播+录播',
			 for (i in e.data){
				 var str1="";
				 if(e.data[i].live==1){
					 str1+="直播";
				 }else if(e.data[i].live==2){
					 str1+="录播";
				 }else if(e.data[i].live==3){
					 str1+="线下课";
				 }else if(e.data[i].live==4){
					 str1+="直播+录播";
				 }
				 if(e.data[i].courseImg == ''){
					 str+='<li><img width="236" height="128" src="images/1.jpg">';
				 }else{
					 str+='<li><img width="236" height="128" src="'+e.data[i].courseImg+'">';
				 }
				 str+=' <div class="tit">'+e.data[i].courseName+'</div><div class="price">￥'+e.data[i].price+'<span>'+str1+'</span></div></li>'
			 }
			 $("#a.ul_1").html(str);
		 }else{
			 alert(e.message);
		 }
	
		 return false;
	 },"json");
	 
	 				
	 //热门课程
	 $.get("RecommandCourseApiServlet?action=2&count=3",function(e){
		 if(e.result=="success"){
			 var str="";
			 for (i in e.data){
				 str += '<li>';
				 if(e.data[i].courseImg == ''){
					 str += '     <div class="L"><img src="images/2.jpg"></div>';
				 }else{
					 str += '     <div class="L"><img src="'+e.data[i].courseImg+'"></div>';

				 }
				 str += '    <div class="R">';
				 str += '       <div class="tit">'+e.data[i].courseName+'</div>';
				 str += '       <div class="sub">'+e.data[i].introduction +'</div>';
				 str += '       <div class="pri">5000.00元<a href="'+e.data[i].id +'">立即报名</a></div>';
				 str += '     </div>';
				 str += '   </li>';
			 }
			 $("#host").html(str);
		 }else{
			 alert(e.message);
		 }
	
		 return false;
	 },"json");
	 
	 //老师
	 $.get("TeacherListAPIServlet?page=1&count=4",
				function (e) {
					if (e.result=="success") {
						var str="";
		
						for(var i in e.data){
								str += '<li>';
						  		str += '<a class="more-course-content" href="'+e.data[i].userId+'">';
						  		if(e.data[i].userHeadimage == ''){
									 str += '<img src="images/t1.png">';
								 }else{
									 str += '<img src="'+e.data[i].userHeadimage+'">';
								 }
						  		
						  		str += '	<span class="teacherTitle">'+e.data[i].userTruename+'</span></a>';
						  		str += '</li>';
				
						}//end for
					
					}else{
						alert(e.message);
					}
					
					$(".teacherLi").html(str);
					
				},
				"json");
	 
	//我的课程
	 $.get("RecommandCourseApiServlet?action=3&count=2",function(e){
		 if(e.result=="success"){
			 var str="";
			 
			 //1:直播 2：录播,3:线下课4，直播+录播',
			 for (i in e.data){
				 var str1="";
				 if(e.data[i].live==1){
					 str1+="直播";
				 }else if(e.data[i].live==2){
					 str1+="录播";
				 }else if(e.data[i].live==3){
					 str1+="线下课";
				 }else if(e.data[i].live==4){
					 str1+="直播+录播";
				 }
				 if(e.data[i].courseImg == ''){
					 str+='<li><img width="236" height="128" src="images/1.jpg">';
				 }else{
					 str+='<li><img width="236" height="128" src="'+e.data[i].courseImg+'">';
				 }
				 str+=' <div class="tit">'+e.data[i].courseName+'</div><div class="price">￥'+e.data[i].price+'<span>'+str1+'</span></div></li>'
			 }
			 $("#myCourse").html(str);
		 }else{
			 alert(e.message);
		 }
	
		 return false;
	 },"json");
  });
  </script>
</head>

<body>
<%@include file="header.jsp"  %>  
<div class="typebox">
  <ul style="margin-bottom:0;">
    <li><img src="images/javaIcon.jpg"><p>Java</p></li>
    <li><img src="images/htmlIcon.jpg"><p>Web</p></li>
    <li><img src="images/data.jpg"><p>数据库</p></li>
    <li><img src="images/goIcon.jpg"><p>Go语言</p></li>
    <li><img src="images/pythonIcon.jpg"><p>Python</p></li>
    <li><img src="images/awsIcon.png"><p>考证</p></li>
    <li><img src="images/ywIcon.jpg"><p>服务器</p></li>
    <li><img src="images/allIcon.png"><p>全部课程</p></li>
  </ul>
</div>
<div class="clear"></div>
<div class="allbox"></div>
<img src="images/bannerm1.jpg">
<div class="allbox"></div>
<div class="clear"></div>
<div class="courseBox">
  <div class="titbox">
    <img src="images/icon.png"><p>最新推荐</p><img src="images/go.png">
  </div>
  <ul id='a' class="ul_1">
    <li>
      <img src="images/1.jpg">
      <div class="tit">UI设计法则-名师直播课</div>
      <div class="price">￥3000<span>588人购买</span></div>
    </li>
    <li>
      <img src="images/1.jpg">
      <div class="tit">UI设计法则-名师直播课</div>
      <div class="price">￥3000<span>588人购买</span></div>
    </li>
  </ul>
  <div class="titbox">
    <img src="images/icon1.png"><p>我的课程</p><img src="images/go.png">
  </div>
  <ul class="ul_1" id="myCourse">
    <!-- <li>
      <img src="images/1.jpg">
      <div class="tit">UI设计法则-名师直播课</div>
      <div class="price">￥3000<span>588人购买</span></div>
    </li>
    <li>
      <img src="images/1.jpg">
      <div class="tit">UI设计法则-名师直播课</div>
      <div class="price">￥3000<span>588人购买</span></div>
    </li> -->
    你还没有登录,点击<a href="login.jps">登录</a>
  </ul>
  <div class="titbox">
    <img src="images/icon2.png"><p>优选课程</p><img src="images/go.png">
  </div>
  <ul class="ul_2" id="host">
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
  <ul class="ul_1 teacherLi">
  	<li>
  		<a class="more-course-content" href="#">
  			<img src="//images.koolearn.com/shark/project/m-koolearn/3.x/i/mix/zhongxue.png">
  			<span class="teacherTitle">罗老师</span></a>
  	</li>
  	<li>
  		<a class="more-course-content" href="#">
  		<img src="//images.koolearn.com/shark/project/m-koolearn/3.x/i/mix/sat.png">
  		<span class="teacherTitle">沈老师</span>
  		</a>
  	</li>
  	<li>
  		<a class="more-course-content" href="#">
  		<img src="//images.koolearn.com/shark/project/m-koolearn/3.x/i/mix/act.png">
  		<span class="teacherTitle">程老师</span>
  		</a>
  	</li>
  	<li>
  		<a class="more-course-content" href="#">
  		<img src="//images.koolearn.com/shark/project/m-koolearn/3.x/i/mix/yasi.png">
  		<span class="teacherTitle">高桥老师</span>
  		</a>
  	</li>
  </ul>
</div>
<%@include file="footer.jsp"  %>  
</body>
</html>
    