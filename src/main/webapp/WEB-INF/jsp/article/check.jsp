<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>글보기</title>
</head>
	<body>
	<p> 
		순번 : ${article.articleId } 
	</p>
	<p> 
		제목 : ${article.title } 
	</p>
	<p> 
		내용 : ${article.contentHtml }
	<p> 
		학번 : ${article.userId } 
	</p>
	<p> 
		글쓴이 : ${article.name } 
	</p>
	<p> 
		날짜 : ${article.cdate } 
	</p>
	<form action="./app/articles">
		<button type= "submit">글 목록</button>
	</form>
	</body>
</html>