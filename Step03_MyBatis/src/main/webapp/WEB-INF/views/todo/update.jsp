<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/todo/update.jsp</title>
</head>
<body>
<h1>수정 완료</h1>
<strong>${param.num }</strong>번 리스트를 수정했습니다.
<a href="${pageContext.request.contextPath }/todo/list.do">목록보기</a>
</body>
</html>