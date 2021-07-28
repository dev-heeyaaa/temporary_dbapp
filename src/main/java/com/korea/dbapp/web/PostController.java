package com.korea.dbapp.web;

<<<<<<< HEAD
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.korea.dbapp.domain.comment.Comment;
import com.korea.dbapp.domain.comment.CommentRepository;
import com.korea.dbapp.domain.post.Post;
import com.korea.dbapp.domain.post.PostRepository;
import com.korea.dbapp.domain.user.User;
import com.korea.dbapp.util.Script;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final 써있는 애들을 생성자로 만들어 줌
@Controller
public class PostController {
	
	private final PostRepository postRepository;
	private final HttpSession session;
	private final CommentRepository commentRepository;
	

	
	@GetMapping({"/","/post"})
	public String list(Model model) {	//model=request
		
		model.addAttribute("postsEntity",postRepository.findAll());
		return "post/list";	//ViewResolver도움!!!+RequestDispatcher(request유지기법)
	}
	
	//상세보기
	@GetMapping("/post/{id}")
	public String detail(@PathVariable int id, Model model) {
		Post postEntity=postRepository.findById(id).get();
		model.addAttribute("postEntity",postEntity);
		
		List<Comment> commentsEntity = commentRepository.mFindAllByPostId(id);
		model.addAttribute("commentsEntity", commentsEntity);
		return "post/detail";
	}
	
	//게시글 삭제하기
	@DeleteMapping("/post/{id}")	//id는?? postEntity의 id이다!!!!! 
	public @ResponseBody String deleteById(@PathVariable int id) {	//@ResponseBody사용하면??? MessageConverter를 타고간다

		Post postEntity=postRepository.findById(id).get();	

		int postUserId=postEntity.getUser().getId();
		
		//인증된 사용자 : session에 저장된 User객체 들고오기
		User principal=(User)session.getAttribute("principal");
		int userId=principal.getId();
		 
		if(postUserId==userId) {
			//2.{id}값으로 삭제!!
			postRepository.deleteById(id);
			 
			//redirect안하면??? 기존에 만들어놓은게 삭제된다!!! 
			//예를들어, post/list로 가라고 해놓으면? postsEntity값이 없어서 글목록 못뿌림
			//return "redirect:/";	
			return "ok"; 		//이 요청을 브라우저가 받아서 해석한다! alert띄우고 href 페이지 이동
		} else {
			
			return "fail";
		}
		
		//return "redirect:/auth/loginForm";
		 
	}//end of deleteById
	
	@GetMapping("/post/saveForm")
	public String saveForm() {
		//1. 인증 체크-세션이 있는사람만!(숙제)-잘못된 접근이면! Script.back으로 하는게.. 
		return "post/saveForm";	//파일을 호출
	}
	
	//글쓰기 save!!!!!!!!
	//title,content, principal을 user객체에 넣고.. post의 id는 principal에서??? 
	@PostMapping("/post")
	public String save(Post post) {
		User principal=(User)session.getAttribute("principal");
		//인증안된 사용자는 쫓아내면 된다!
		if(principal==null) {
			return "redirect:/auth/loginForm";//주소를 호출, 인증안된 사용자 접근에 대해선 친절히 alert안해줘도 된다
		}
//		현재 principal에 password도 없고, User의 변수인 List<Post>도 없다.그런데 상관없다
//		DB구조상, DB에 Post가 저장될때에는 user_id만 필요하다!!!!!!!
		post.setUser(principal);
		postRepository.save(post);
		return "redirect:/";
	}
	
	@GetMapping("/post/{id}/updateForm")	//MVC패턴으로 where절이 필요하니까!! {id}를 사용
	public String updateForm(@PathVariable int id,Model model) {
		
		//인증,권한 부여해야한다!!!!!(각각 하지 말고 한번에 가능)
		User principal=(User)session.getAttribute("principal");
		int loginId=principal.getId();
				
		Post postEntity=postRepository.findById(id).get();//post안에 User담겨져 있다! 왜?? 기본 전략이 Eager이니까!!!
		int postOwnerId=postEntity.getUser().getId();
		
		if(loginId==postOwnerId) {
			model.addAttribute("postEntity",postEntity);
			return "post/updateForm";
		}
		//정상적으로는 절대 들어올수 없는 페이지이니까, 친절히 alert를 띄울 필요 없이 로그인페이지로 보냄
		return "redirect:/auth/loginForm";	
	}
	
	//게시글 업데이트 함수
	@PutMapping("/post/{id}")
	public @ResponseBody String update(@PathVariable int id,@RequestBody Post post) {
		//0.인증 및 권한!
		User principal=(User)session.getAttribute("principal");
		int loginId=principal.getId();
		
		//1.{id}로 해당 게시글에 대한 id가 있으니, id로 기존 DB에 저장된 post정보 select해오기
		Post postEntity=postRepository.findById(id).get();
		int postOwnerId=postEntity.getUser().getId();
		
		if(loginId==postOwnerId) {
			//2.수정된 데이터 받아온 걸로 다시 저장하기!
			postEntity.setTitle(post.getTitle());
			postEntity.setContent(post.getContent());
			
			//3.수정된 게시글post을 다시 DB에 저장하기
			postRepository.save(postEntity);
//			return Script.href("redirect:/post/"+"id","수정완료");
			return "ok"; 
		}	else {
//			return Script.back("수정실패");
			return "redirect:auth/login";
		}
		
=======
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

	@GetMapping("/")
	public String home() {
		System.out.println("home 실행됨");
		return "index";
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
	}
}
