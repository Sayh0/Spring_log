<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	
	<li><a href="${pageContext.request.contextPath }/file/list.do">자료실</a></li>
	
	<li><a href="${pageContext.request.contextPath }/play.do">놀러가기(회원 전용)</a></li>
	<li><a href="${pageContext.request.contextPath }/sub/play2.do">다른 데서 놀기(로그인 필요)</a></li>
</ul>
	<!-- 로그인 체크 여부 적용시키기 -->
	<c:choose>
		<c:when test="${empty sessionScope.id }">
			<form action="${pageContext.request.contextPath }/users/login.do" method="post">
				<input type="text" name="id" placeholder="아이디 입력..."/>
				<button type="submit">로그인</button>
			</form>
		</c:when>
		<c:otherwise>
			<p>
				<strong>${id }</strong> 님 로그인 중 ...
				<a href="${pageContext.request.contextPath }/users/logout.do">로그아웃</a>	
			</p>
		</c:otherwise>
	</c:choose>

<ul>
	<li><a href="send.do">json 테스트</a></li>
	<li><a href="send2.do">json 테스트2</a></li>
	<li><a href="send3.do">json 테스트3</a></li>
	<li><a href="send4.do">json 테스트4</a></li>
</ul>
	<h1>파일 업로드 폼</h1>
	<form action="${pageContext.request.contextPath }/file/upload.do" method="post" enctype="multipart/form-data">
		<input type="text" name="title" placeholder="설명 입력 . . . " /><br />
		<input type="file" name="myFile"/>
		<button type="submit">업로드</button>
	</form>
	
</body>
</html>
