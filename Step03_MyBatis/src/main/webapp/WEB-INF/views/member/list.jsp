<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/member/list.jsp</title>
</head>
<body>
	<h1>회원목록입니다.</h1>
	<ul>
		<li><a href="${pageContext.request.contextPath }/member/insertform.do">회원 추가</a></li>
		<li><a href="${pageContext.request.contextPath }/member/deleteform.do">회원 삭제</a></li>
		<li><a href="${pageContext.request.contextPath }/member/updateform.do">회원 수정</a></li>
	</ul>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${requestScope.list }">
				<tr>
					<td>${tmp.num }</td>
					<td>${tmp.name }</td>
					<td>${tmp.addr }</td>
					<td>
						<a href="${pageContext.request.contextPath }/member/updateform.
						do?num=${tmp.num}">수정</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath }/member/delete.do?num=${tmp.num }">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>