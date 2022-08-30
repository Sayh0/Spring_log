<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
</head>
<body>
	<div class="container">
		<h1>인덱스 페이지입니다.</h1>
		<h2>공지사항</h2>
		<ul>
			<li><a href="study.do">공부하러 가기.</a></li>
			<li><a href="${pageContext.request.contextPath }/sub/play.do">놀러가기</a>
		</ul>
		<img src="${pageContext.request.contextPath }/images/kim1.png" />절대경로
		<img src="images/kim1.png"> 상대경로(현재 depth 는 webapp)
		<ul>
			<c:forEach var="tmp" items="${requestScope.noticeList }">
				<li>${tmp }</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
