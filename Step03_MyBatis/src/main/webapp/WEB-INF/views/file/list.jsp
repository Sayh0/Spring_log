<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/file/list.jsp</title>
</head>
<body>
	<h1>자료실 목록입니다.</h1>
	<ul>
		<li><a href="${pageContext.request.contextPath }/file/insertform.do""></a>파일 추가</li>
		<li><a href=""></a>파일 삭제</li>
	</ul>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>파일명</th>
				<th>크기</th>
				<th>등록일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${requestScope.list }">
				<tr>
					<td>${tmp.num }</td>
					<td>${tmp.writer }</td>
					<td>${tmp.title }</td>
					<td>${tmp.orgFileName }</td>
					<td>${tmp.fileSize }</td>
					<td>${tmp.regdate }</td>
					<td>삭제</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>