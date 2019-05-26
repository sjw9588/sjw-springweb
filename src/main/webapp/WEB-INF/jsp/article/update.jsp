<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시판</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<h2>글 등록</h2>
	<p>
		<a href="./app/article/list">글 목록</a>
	</p>
	<form action="./app/article/add" method="post">
		<p>
			<label>제목 :</label><br /> <input type="text" name="title" maxlength="100" style="width: 100%;"
				value="${article.title }" required />
		</p>
		<p>
			<label>내용 : </label><br /> <textarea name="content" style="width: 100%; height: 200px;"
				value="${article.content}" required />
		</p>
		<p>
		
			<button type="submit">등록</button>
		</p>
	</form>
</body>
</html>