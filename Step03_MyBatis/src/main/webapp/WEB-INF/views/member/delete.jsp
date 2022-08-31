<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/member/delete.jsp</title>
</head>
<body>
<h1>삭제 완료</h1>
<p>
<strong>${param.num }</strong>번 회원님의 정보를 삭제했습니다.
<a href="${pageContext.request.contextPath }/member/list.do">목록보기</a>
</p>
</body>
</html>