package com.sjw.article;

/**
 * p.60 [리스트 3.3] Member 클래스 수정<br>
 * 회원정보 도메인 오브젝트. 회원 테이블과 매핑한다.
 * 
 * @author sjw
 */
public class Article {
	String articleId;
	String title;
	String content; 
	String userId;
	String name; 
	String cdate; 
	String udate;

	/**
	 * Default Constructor
	 */
	public Article() {
	}

	public Article(String title, String content, String userId, String name) {
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.name = name;
	}


	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getUdate() {
		return udate;
	}

	public void setUdate(String udate) {
		this.udate = udate;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	
	public String getContentHtml() {
		if(content != null)
			return content.replace("\n","<br/>");
		return null;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", title=" + title + ", content="
				+ content + ", userId=" + userId + ", name=\" + name + \","
						+ "cdate=\" + cdate + \", udate=\" + udate + \"]";
	}
}