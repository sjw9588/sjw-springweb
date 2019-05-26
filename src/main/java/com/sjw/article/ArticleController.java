package com.sjw.article;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.sjw.book.chap11.Member;

/**
 * 회원가입 컨트롤러
 * 
 * @author sjw
 */
@Controller
public class ArticleController {

	@Autowired
   ArticleDao articleDao;

	static final Logger logger = LogManager.getLogger();

	
	@GetMapping("/article/view")
	public void check(@RequestParam("articleId") String articleId,
			Model model) {
		Article article = articleDao.getArticle(articleId);
		model.addAttribute("article", article);
	}

	
	/**
	 * 글 목록
	 */
	@GetMapping("/article/list")
	public void articleList(
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {

		// 페이지당 행의 수와 페이지의 시작점
		final int COUNT = 100;
		int offset = (page - 1) * COUNT;
		
		List<Article> articleList = articleDao.selectAll(offset, COUNT);
		int totalCount = articleDao.countAll();
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("articleList", articleList);
}
	
/**
 * 
 *  글 등록 화면
 * 
 */
	@GetMapping("/article/addForm")
	public String articleAddForm(HttpSession session) {
		return "article/addForm";
	}
	

	@GetMapping("/article/update")
	public String articleUpdate(@RequestParam("articleId") Article article,
			Model model) {

		articleDao.updateArticle(article);
		model.addAttribute("article",article);
		//"articleId") Article article,@SessionAttribute("MEMBER") Member member,Model model) {
		
		//@SessionAttribute("MEMBER") Member member)
		return "redirect:/app/article/update";
	}
	

	@GetMapping("/article/delete")
	public String articleDelete (String articleId,
			@SessionAttribute("MEMBER") Member member) {
		articleDao.deleteArticle(articleId);
		return "article/delete";
		
	}
	
	@PostMapping("/article/add")
	public String articleAdd(Article article,	
			@SessionAttribute("MEMBER") Member member){
			article.setUserId(member.getMemberId());
			article.setName(member.getName());
			articleDao.insert(article);	
			return "redirect:/app/article/add";

	}
	
}