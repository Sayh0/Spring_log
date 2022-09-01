<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/todo/updateform.jsp</title>
</head>
<body>
<div class="container">
	<h1>수정 폼</h1>
	<form action="${pageContext.request.contextPath }/todo/update.do" method="post">
		<input type="hidden" name="num" value="${dto.num}"/> <!-- 번호도 받아와야 하기 때문에 hidden으로 받아옴 -->
		<div>
			<label for="num">번호</label>
			<input type="text" name="num" id="num" value="${requestScope.dto.num }" disabled/>
		</div>
		<div>
			<label for="content">할일</label>
			<input type="text" name="content" id="content" value="${dto.content }"/> <!-- requestScope. 는 생략 가능 -->
		</div>
		<button type="submit">수정</button>
	</form>
</div>
<div>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>할일</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbod>
			<c:forEach var="tmp" items="${requestScope.list }">
				<tr>
					<td>${tmp.num }</td>
					<td>${tmp.content }</td>
					<td>${tmp.regdate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>