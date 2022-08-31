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
<h1>수정 완료</h1>
<strong>${param.name }</strong>님의 정보를 수정했습니다.
<a href="${pageContext.request.contextPath }/member/list.do">목록보기</a>
</body>
</html>