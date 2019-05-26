<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시판</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<h2>글 등록 완료</h2>
	<p>
		<a href="./app/article/list">글 목록으로 이동</a>
	</p>
	<hr />	
	<p>
		${article.name }님의 글이 등록되었습니다.
	</p>	<hr />
	<p>${article.contentHtml }</p>
	<hr />
</body>
</html>