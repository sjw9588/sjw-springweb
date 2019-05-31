package com.sjw.letter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sjw.article.Article;
import com.sjw.book.chap11.Member;

public class LetterDaoImplUsingSpringJdbc implements LetterDao{

	static final String INSERT = "INSERT letter(title,content,senderId,senderName,receiverID,receiverName) values(?,?,?,?,?,?)";
	
	static final String SEND_LIST = "select letterId,title,receiverId,receiverName,cdate where senderId=?";
	
	static final String RECEIVE_LIST = "select letterId,title,senderId,senderName,cdate from letter where receiverId=?";
	
	static final String GET_LETTER = "Select letterId,title,content,senderId,senderName,receiverId,receiverName,cdate from letter where letterId=9 and (senderId = 1376 or receiverId = 1376)";
	
	static final String DELETE = "delete from letter where letterId=9 and (senderId = 1376 or receiverId = 1376)";
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	final RowMapper<Article> memberRowMapper = new BeanPropertyRowMapper<>(
										Article.class);


	/**
	 * p.201 [리스트 8.12]의 insert() 메서드 수정
	 */
	@Override
	public void sendLetter(Letter letter) {
		jdbcTemplate.update(INSERT, letter.getTitle(), letter.getContent(),
				letter.getSenderId(),letter.getSenderName(),letter.getReceiverId(),letter.getReceiverName());
	}
	/**
	 * 보낸 편지 목록
	 */
	List<Letter> selectSendList(int offset, int count);
	/**
	 * 받은 편지 목록
	 */
	List<Letter> selectReceiveList(int offset, int count);
	
}
