<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>글 쓰기</title>
</head>
<body>
	<h2>글 작성</h2>
	<form action="./app/article/step2" method="post">
		<p>
			제목:<br> <input type="title" name="title" value="${param.title }">
		</p>
		<p>
			내용:<br> <textarea type="content" name="content" value="${param.content }">
		</textarea>
		</p>
		<button type="submit">작성완료</button>
	</form>
</body>
</html>