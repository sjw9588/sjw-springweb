package com.sjw.letter;

import java.util.List;

import com.sjw.article.Article;

public interface LetterDao {
	
	/**
	 * 보낸 목록
	 */
	void sendList(Letter letter);
	
	/**
	 * 받은 목록
	 */
	void receiveList(Letter letter);
	
	/**
	 * 편지 조회(보기)
	 */
	Letter getLetter(String article) ;
	
	/**
	 * 편지 저장 (쓰기)
	 */
	void sendLetter(Letter letter);
	
	/**
	 * 편지 삭제
	 */
	int deleteArticle(String articleId,String userId);

}
