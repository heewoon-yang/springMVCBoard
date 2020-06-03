<%@ page import="com.freehoon.web.board.model.BoardVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<%= request.getAttribute("serverTime") %><p>
<%= request.getAttribute("value2") %><p>
<c:out value="${value2}"/><p>
<c:out value="<font color='blue'>${hello}</font>" escapeXml="false"/><br><br>

<% 
	BoardVO boardVO = (BoardVO) request.getAttribute("value3"); 
	out.println(boardVO.getTitle()+"<br>");
	out.println(boardVO.getCate_cd()+"<br>");
%>
<%-- <%= boardVO.getTitle() %><br><br>
<%= boardVO.getCate_cd() %><br><br> --%>
</body>
</html>
