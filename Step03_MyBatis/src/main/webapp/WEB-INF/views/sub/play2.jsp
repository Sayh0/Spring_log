<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/sub/play2.jsp</title>
</head>
<body>
	<h1>로그인 된 회원 전용 공간입니다.</h1>
	<p>
		<strong>${id }</strong> 님 어서 와요!
		<a href="${pageContext.request.contextPath }/">인덱스로</a>
	</p>
</body>
</html>