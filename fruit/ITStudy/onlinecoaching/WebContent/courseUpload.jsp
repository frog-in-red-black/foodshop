<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传课程</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
 <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script>
	$(document).ready(function() {
				$('.btn1').click(function() {
					 		var nums =	parseInt($("#videoS").attr('num')) + 1;
							$(".plusVideo").append(
									'<table>' + '<tr>' + '<td>'
											+ '<input name="videoUrl'+nums+'"  type="file">' + '</td>'
											+ '</tr>' + '</table>');
						 $("#videoS").attr('num',nums);
				});

				$(".btn2").click(function() {
					if( parseInt($("#videoS").attr('num')) > 1){
						$("table:last").remove();/* 点击-删除-所在的table */
						var nums =	parseInt($("#videoS").attr('num')) - 1;
					    $("#videoS").attr('num',nums);	
					}
					
				});
				
				 //通过接口获取的课程分类
				  $.get("CourseTypeApiServlet",function(e){
					  if(e.result == "success"){
						  var str = "";
						  for(var i in e.data){
							  str += '<option value="'+ e.data[i].courseTypeId +'">'+ e.data[i].courseTypeName+'</option>';
						  }
						  $("#courseTypes").html(str);
					  }else{
						  alert(e.message);
					  }
				  },"json");
				 
				//获取所有我的组合单一课程
					 $.get("RecommandCourseApiServlet?action=4",function(e){
						 if(e.result=="success"){
							 var str="<option selected>可以多选</option>";
							 for (i in e.data){
								str += '<option value="'+e.data[i].id+'">'+e.data[i].courseName+'</option>';
							}
							 $("#setCourseId").html(str);
						 }else{
							 alert(e.message);
						 }
					
						 return false;
					 },"json");
				
				//单一课程和组合课程的效果
				$("#customRadioInline1").click(function(){
					$("#c2").hide();
					$("#c1").show();
				});
				
				$("#customRadioInline2").click(function(){
					$("#c1").hide();
					$("#c2").show();
				});

			});
			
		function moveOption(e1,e2) {
		try {
			for (var i = 0; i < e1.options.length; i++) {
				if (e1.options[i].selected) {
					var e = e1.options[i];
					e2.options.add(new Option(e.text, e.value));
					e1.remove(i);
					i = i - 1;
				}
			}
		} catch (e) {
		}
	}	
			
</script>
  <style>
  /* Make the image fully responsive */
  .carousel-inner img {
      width: 100%;
      height: 100%;
  }
  .header .box{
      position: relative;
  }
  .none{display: none;}
  </style>
</head>
<body>
<%@include file="header.jsp" %>
<div class="header">
  <div class="box">
    <div class="L"><a onClick="javascript:history.back(-1)" class="goback"><img src="images/goback.png" /></a></div>
    <div class="C"><p>发布管理</p></div>
  </div>
</div>
<div class="clear"></div>
<div class="allbox"></div>
	<!-- enctype="multipart/form-data" 传输音频，视频，图片，压缩包时 -->
	<form action="" method="post" style="padding:0 20px;"  enctype="multipart/form-data">
		
		<div class="form-group row">
		    <label for="inputEmail3" class="col-sm-2 col-form-label">课程名</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="courseName" placeholder="请输入课程名" value="">
		    </div>
		 </div>
 
		 <div class="form-group">
    		<label for="exampleFormControlTextarea1">课程简介</label>
    		<textarea rows="4" class="form-control"  name="introduction" placeholder="请输入课程简介" ></textarea>
  		</div>
  
		
		<div class="form-group row">
		 <label for="inputEmail3" class="col-sm-3 col-form-label">课程价格￥</label>
		  <div class="col-sm-9">
			<input type="number" class="form-control" name="price" placeholder="请输入价格" min="0" max="1000000" step="1000">
			</div>
		</div>
		<div class="form-group row">
		 <label for="inputEmail3" class="col-sm-3 col-form-label">优惠价格￥</label>
		  <div class="col-sm-9">
			<input type="number" class="form-control" name="salePrice" 	placeholder="请输入价格" min="0" max="1000000" step="1000">
		</div>
		</div>
		
		<div class="custom-file">
		  <input type="file" class="courseImg" id="customFile">
		  <label class="custom-file-label" for="customFile">课程图片</label>
		</div>

 		<div class="form-group">
    		<label for="exampleFormControlTextarea1">课程详细介绍</label>
    		<div class="col-sm-12">
    		<INPUT type="hidden" class="form-control"  name="mark" id="content1" />
				<IFRAME ID="eWebEditor1"src="ewebeditor.htm?id=content1&style=standard" width="500" height="200"　frameborder="0" scrolling="no" >
			</IFRAME>
			</div>
  		</div>
  		
		
		
		<div class="form-group">
			<label class="col-sm-3">课程方式：</label>
			<div class="custom-control custom-radio custom-control-inline">
			  <input type="radio" id="RadioInline1" name='live' value="1" class="custom-control-input">
			  <label class="custom-control-label" for="RadioInline1">直播课</label>
			</div>

			<div class="custom-control custom-radio custom-control-inline">
			  <input type="radio" id="RadioInline2" name='live' value="2" class="custom-control-input">
			  <label class="custom-control-label" for="RadioInline2">录播</label>
			</div>
			
			<div class="custom-control custom-radio custom-control-inline">
			  <input type="radio" id="RadioInline3" name='live' value="3" class="custom-control-input">
			  <label class="custom-control-label" for="RadioInline3">线下课</label>
			</div>

			<div class="custom-control custom-radio custom-control-inline">
			  <input type="radio" id="RadioInline4" name='live' value="4" class="custom-control-input">
			  <label class="custom-control-label" for="RadioInline4">直播课+录播</label>
			</div>
			
			
			<div class="custom-control custom-radio custom-control-inline">
			  <input type="radio" id="RadioInline5" name='live' value="5" class="custom-control-input">
			  <label class="custom-control-label" for="RadioInline5">线下课+录播</label>
			</div>

		</div>
		
		<!-- 鼠标移动到课程类型就show，hide选择组合，反之亦然 -->
		<div class="form-group" >
			<label class="col-sm-5"><strong>是否是组合课程：</strong></label>
			
			<div class="custom-control custom-radio custom-control-inline">
  <input type="radio" checked="checked" id="customRadioInline1" name='setCourse' value="2" class="custom-control-input">
  <label class="custom-control-label" for="customRadioInline1">单一课程</label>
</div>
<div class="custom-control custom-radio custom-control-inline">
  <input type="radio" id="customRadioInline2" name='setCourse' value="1" class="custom-control-input">
  <label class="custom-control-label" for="customRadioInline2">组合课程</label>
</div>

		
		</div>
		<div id="c1">
			<div class="form-group" >
				<label class="col-sm-3">课程分类</label>
				<select class="custom-select col-sm-8" id="courseTypes" name="courseTypeId" >
					<option value="">请选择</option>
					<option value="java8">java8</option>
					<option value="mysql">mysql</option>
					<option value="javaWeb">JDBC</option>
				</select>
			</div>
		
		<!-- <div>
			主讲老师<select name="" style="width: 100px">
				<option value="">请选择</option>
				<option value="张老师">张老师</option>
				<option value="王老师">王老师</option>
				<option value="李老师">李老师</option>
			</select>
		</div> -->
			<div class="form-group" >
				<label class="col-sm-3" id="videoS" num="1" >课程视频</label>
				<table class="plusVideo col-sm-9">
					<tr>
						<td><input type="file" name="videoUrl1"></td>
						<td><input type="button" class="btn1 btn btn-success btn-sm" value="+"></td>
						<td><input type="button" class="btn2 btn btn-danger btn-sm" value="-"></td>
					</tr>
				</table>
			</div>
		</div>
		
		<div  class="form-group none" id="c2">	
			<label class="col-sm-5" >选择组合课程</label>
			<select name="setCourseId" id="setCourseId" class="custom-select" multiple>
			  <option selected>Open this select menu</option>
			  <option value="1">One</option>
			  <option value="2">Two</option>
			  <option value="3">Three</option>
			</select>
		</div>		
		<input type="submit" value="上传">
	</form>
<div class="allbox"></div>
<%@include file="footer.jsp"  %> 
</body>
</html>