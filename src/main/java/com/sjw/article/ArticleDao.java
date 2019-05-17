package com.sjw.article;

import java.util.List;

/**
 * p.184 [리스트 8.2] MemberDao 를 interface로 수정<br>
 * 회원 테이블을 조작하는 Data Access Object
 * 
 * @author sjw
 */
public interface ArticleDao {

	/**
	 * 작성된 글 저장
	 */
	void insert(Article article);

	/**
	 * 글 수정
	 */
	void update(Article article);

	/**
	 * 글 목록
	 */
	List<Article> selectAll(int offset, int count);
	
	/**
	 * 글 수
	 */
	int countAll();
	
	Article getArticle(String article) ;
}