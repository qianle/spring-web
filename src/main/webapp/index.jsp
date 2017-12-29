<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="listNews">
		<input type="text" name="content" value="${requestScope.content}">
		<input type="submit" value="提交"/>
	</form>
	<table>
	<tr>
		<th>标题</th>
		<th>内容</th>
	</tr>
	<c:forEach var="a" items="${requestScope.newsList.data }">
		<tr>
			<td>${pageScope.a.nTitle}</td>
			<td>${pageScope.a.nContent }</td>
		</tr>
	</c:forEach>
	</table>
	 <a href="${pageContext.request.contextPath}/listNews?content=${requestScope.content}&curPage=1">首页</a>
		<a href="${pageContext.request.contextPath}/listNews?content=${requestScope.content}&curPage=${requestScope.newsList.prePage}">上一页</a>
		<c:forEach var="i" begin="1" end="${requestScope.newsList.totalPage}" step="1">
		<a href="${pageContext.request.contextPath}/listNews?content=${requestScope.content}&curPage=${i}">${i}</a>
		</c:forEach>
		<a href="${pageContext.request.contextPath}/listNews?content=${requestScope.content}&curPage=${requestScope.newsList.nextPage}">下一页</a>
		<a href="${pageContext.request.contextPath}/listNews?content=${requestScope.content}&curPage=${requestScope.newsList.totalPage}">尾页</a>
</body>
</html>