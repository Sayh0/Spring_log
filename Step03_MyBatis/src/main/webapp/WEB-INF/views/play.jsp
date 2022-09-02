<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/play.jsp</title>
</head>
<body>
	<h1>로그인 된 회원 전용 놀이터입니다.</h1>
	<p>
		<strong>${id }</strong> 님 환영합니다!
		<a href="${pageContext.request.contextPath }/">인덱스로</a>
	</p>
</body>
</html>