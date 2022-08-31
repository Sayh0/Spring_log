<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	인덱스 페이지입니다.  
</h1>
<h2>공지사항</h2>
<ul>
	<li>Spring FrameWork 시작입니다.</li>
	<li>화이팅!</li>
	<li><a href="${pageContext.request.contextPath }/member/list.do">회원 목록보기</a></li>
	<li><a href="${pageContext.request.contextPath }/todo/list.do">할일 목록 보기</a></li>
</ul>

</body>
</html>
