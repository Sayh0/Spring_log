<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/play.jsp</title>
</head>
<body>
	<h1>놀고십따...</h1>
		<a href="home.do">인덱스로 가기(작동안함)</a> 
		<!-- 
			 이건 제대로 작동하지 않는다.
			 상대경로로 작성해놓고 이렇게 작성해 놓으면 
			 현재 depth 안에서 움직이기 때문이다(sub/home.do 는 없는 경로). 
		-->
		<a href="../home.do">인덱스로 가기(작동함)</a>
		<!-- 올바른 상대경로 사용법 -->
		
		<img src="${pageContext.request.contextPath }/images/kim1.png" />절대경로
		<img src="../images/kim1.png"> 상대경로
		<!-- 
			이미지를 로딩하는 경로는 클라이언트가 로딩하는 거기 때문에, 
			클라이언트 기준(클라이언트가 요청을 보내는 주소창)으로 위치를 정해야 한다.
		 -->
		
		<li><a href="${pageContext.request.contextPath }/">인덱스로 돌아가기.</a></li>
</body>
</html>