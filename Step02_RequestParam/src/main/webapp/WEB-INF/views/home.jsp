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
	Hello world!  
</h1>
<form action="${pageContext.request.contextPath }/send.do" method="post">
	<input type="text" name="msg" placeholder="할말 입력" />
	<button type="submit">전송</button>
</form>
<form action="${pageContext.request.contextPath }/send2.do" method="post">
   <input type="text" name="msg" placeholder="할말 입력..."/>
   <button type="submit">전송</button>
</form>

<h2> post 방식 요청</h2>
<form action="${pageContext.request.contextPath }/add.do" method="post">
	<input type="text" name="content" placeholder="내용을 입력하세요..."/>
	<button type="submit">추가</button>
</form>

<h2> get 방식 요청</h2>
<form action="${pageContext.request.contextPath }/add.do" method="get">
	<input type="text" name="content" placeholder="내용을 입력하세요..."/>
	<button type="submit">추가</button>
</form>

<ul>
	<li><a href="${pageContext.request.contextPath }/member/insertform.do">회원 추가하기</a></li>
</ul>
</body>

