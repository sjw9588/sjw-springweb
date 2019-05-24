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
import org.springframework.web.bind.annotation.RequestMapping;
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

	@RequestMapping("/main1")
	public String main() {
		return "main1";
	}

	
	
	
	@GetMapping("/article/view")
	public void check(@RequestParam("articleId") String articleId,
			Model model) {
		Article article = articleDao.getArticle(articleId);
		model.addAttribute("article", article);
	}

	
	@GetMapping("/articles")
	public String articles(
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {

		// 페이지 당 가져오는 행의 수
		final int COUNT = 100;
		// 시작점
		int offset = (page - 1) * COUNT;

		List<Article> articleList = articleDao.selectAll(offset, COUNT);

		int totalCount = articleDao.countAll();
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("articles", articleList);
		return "articles";
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
	public String articleUpdate(HttpSession session) {
		return "article/update";
	}
	

	@GetMapping("/article/delete")
	public String articleDelete(HttpSession session) {
		return "article/delete";
	}
	
	@PostMapping("/article/add")
	public String articleAdd(Article article,
			@SessionAttribute("MEMBER") Member member){
			article.setUserId(member.getMemberId());
			article.setName(member.getName());
			articleDao.insert(article);	
			return "redirect:/app/articles";

	}
}