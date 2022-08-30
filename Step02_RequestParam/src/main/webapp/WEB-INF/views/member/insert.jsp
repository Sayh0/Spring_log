<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>회원 정보 잘 받았어 클라이언트야!</p>
	<p>${param.num } | ${param.name } | ${param.addr }</p>
	<!-- EL로 파라미터 추출 가능하다.  -->
	<a href="${pageContext.request.contextPath }/">인덱스로 돌아가기</a>
</body>
</html>