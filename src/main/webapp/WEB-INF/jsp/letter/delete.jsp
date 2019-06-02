<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시판</title>
</script>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<h2>보낸 목록</h2>
	<p>
		<a href="./app/letter/listSent">글목록</a>
	</p>
	<p>
		삭제 완료
	</p>
	<p>${article.contentHtml }</p>
	<hr />
</body>
</html>