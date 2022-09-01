<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/todo/list.jsp</title>
</head>
<body>
	<h1>할일 목록입니다.</h1>
	<ul>
		<li><a href="${pageContext.request.contextPath }/todo/insertform.do">할일 추가</a></li>
	</ul>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>할일</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${requestScope.list }">
				<tr>
					<td>${tmp.num }</td>
					<td>${tmp.content }</td>
					<td>${tmp.regdate }</td>
					<td><a href="${pageContext.request.contextPath }/todo/updateform.do?num=${tmp.num}">수정</a></td>
					<td><a href="${pageContext.request.contextPath }/todo/delete.do?num=${tmp.num}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>