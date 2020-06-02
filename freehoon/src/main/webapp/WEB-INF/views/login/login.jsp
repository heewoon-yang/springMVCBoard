<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url var="loginURL" value="/login/loginCheck"></c:url> 

<script> 
	function fn_btnSignupClick(){ 
		location.href ="${pageContext.request.contextPath}/user/signupForm"; 
	} 
	
	$(document).ready(function(){
		$('#signIn').click(function(e){
			
			e.preventDefault();
			
			var uid = $('#uid');
			var pwd = $('#pwd');
			var url = "${loginURL}";
			
			if(uid.val() == ''){
				alert('아이디를 입력하세요!');
				uid.focus();
				return;
			}
			if(pwd.val() == ''){
				alert('비번을 입력하세요!');
				pwd.focus();
				return;
			}
			
			//폼 내부의 데이터를 전송할 주소
			//document.form.action = "${pageContext.request.contextPath}/login/loginCheck";
			document.form.action = url;
			//제출
			document.form.submit();
			
			/*
			var paramData = {
				 "uid" : uid.val()
				,"pwd" : pwd.val()
			};
			
			$.ajax({ 
				  url : url 
				, type : "POST" 
				, dataType : "json" 
				, data : paramData 
				, success : function(result){ 
					//fn_showList();
					//초기화 이벤트 호출 
					//$("#btnInit").trigger("click");
					alert("로긴 성공 \n"+result);
				} 
			}); 			
			*/
			//$('form').submit();
		});
	});
</script>

<!-- login form {s} -->
<form:form class="form-signin" name="form" id="form" role="form" modelAttribute="userVO" method="post" action="${pageContext.request.contextPath}/board/saveBoard">
	<div class="text-center mb-4">
		<h1 class="h3 mb-3 font-weight-normal">FREEHOON.COM</h1>
	</div>
	
	<div class="form-label-group">
		<form:input path="uid" id="uid" class="form-control" placeholder="User ID" required="" autofocus="" />
		<label for="uid" class="sr-only">User ID</label>
	</div>
	
	<div class="form-label-group">
		<form:password path="pwd" id="pwd" class="form-control" placeholder="User Password" required="" />
		<label for="pwd" class="sr-only">User Password</label>
	</div>
	
	<button id="signIn" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	
	<span style="font-size:11pt;">
		<a href="#" onClick="fn_btnSignupClick()">Sign up</a>
	</span>
	
	<p class="mt-5 mb-3 text-muted text-center">© 2019. FREEHOON. All rights reserved.</p>
</form:form>
<!-- login form {e} -->