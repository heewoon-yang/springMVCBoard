<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>

<%-- <%@ include file="/WEB-INF/views/layout/header.jsp" %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board</title>
<script src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
<script>
	//저장 버튼 클릭 이벤트
	$(document).on('click', '#btnSave', function(e){
		e.preventDefault();
		$("#form").submit();
	});
	//목록으로 이동
	$(document).on('click', '#btnList', function(e){
		e.preventDefault();
		location.href="${pageContext.request.contextPath}/board/getBoardList";
	});
	//데이터를 입력폼에 셋팅
	$(document).ready(function(){
		debugger;
		var mode='<c:out value="${mode}"/>';
		if(mode == 'edit'){
			//입력 폼 셋팅
			$('#reg_id').prop('readonly',true);
			$('input:hidden[name="bid"]').val('<c:out value="${boardContent.bid}"/>');
			$('input:hidden[name="mode"]').val('<c:out value="${mode}"/>');
			$('input:hidden[name="cate_cd"]').val('1');
			$('#reg_id').val('<c:out value="${boardContent.reg_id}"/>');
			$('#title').val('<c:out value="${boardContent.title}"/>');
			$('#content').val('<c:out value="${boardContent.content}"/>');
			$('#tag').val('<c:out value="${boardContent.tag}"/>');
		}
	});
</script>
</head>

<body>
	<article>
		<div class="container" role="main"> 
			<h2>board Form</h2>
			
			<form:form 	name="form" id="form" role="form" modelAttribute="boardVO" method="post" action="${pageContext.request.contextPath}/board/saveBoard">
				
				<form:hidden path="bid"/>
				<form:hidden path="cate_cd"/>
				<input type="hidden" name="mode"/>
				
				<div class="mb-3">
					<label for="title">제목</label>
					<form:input path="title" type="text" class="form-control" name="title" id="title" placeholder="제목을 입력해 주세요"/>
				</div>
				<div class="mb-3">
					<label for="reg_id">작성자</label>
					<form:input path="reg_id" type="text" class="form-control" name="reg_id" id="reg_id" placeholder="이름을 입력해 주세요"/>
				</div>
				<div class="mb-3">
					<label for="content">내용</label>
					<form:textarea path="content" class="form-control" rows="5" name="content" id="content" placeholder="내용을 입력해 주세요" />
				</div>
				<div class="mb-3">
					<label for="tag">TAG</label>
					<form:input path="tag" type="text" class="form-control" name="tag" id="tag" placeholder="태그를 입력해 주세요"/>
				</div>
			</form:form>
			
			<div >
				<button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
			</div>
		</div>
	</article>
</body>

</html>

<script src="${pageContext.request.contextPath}/resources/common/js/ckeditor.js"></script>






