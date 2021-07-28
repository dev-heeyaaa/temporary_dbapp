package com.korea.dbapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
import org.springframework.web.bind.annotation.ResponseBody;

import com.korea.dbapp.domain.user.User;
import com.korea.dbapp.domain.user.UserRepository;
<<<<<<< HEAD
import com.korea.dbapp.util.Script;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
=======

>>>>>>> 036f4e5 (1. ORM 매핑 시작)
@Controller
public class UserController {

	private final UserRepository userRepository;
	private final HttpSession session;
	
<<<<<<< HEAD
	
	//회원가입 페이지로 가는 함수!
	//데이터 돌려주는게 아니라, 파일 응답해주는 !
	//클라이언트는 버튼 클릭해서 페이지이동할거다
	@GetMapping("/auth/joinForm") // "/auth"로 들어오면 필터에서 들여보내주게 설계!
	public String joinForm(User user) {
	
		return "auth/joinForm";
	}
	

	@GetMapping("/auth/loginForm") // "/auth"로 들어오면 필터에서 들여보내주게 설계!
=======
	public UserController(UserRepository userRepository, HttpSession session) {
		this.userRepository = userRepository;
		this.session = session;
	}

	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "auth/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
	public String loginForm() {
		return "auth/loginForm";
	}
	
<<<<<<< HEAD
	
	@PostMapping("/auth/join")  //auth 관련은 굳이 규칙 안지키고 주소 넣어도 됨
	public String join(User user) {
		userRepository.save(user);
		return "redirect:/auth/loginForm"; //위에 만들어놓은 함수로 선언된 로그인페이지로 redirect
	}
	
	//로그인 실패했을 때, alert뜨게 해보자!!! 그래서 데이터 리턴 코드로 하기 위해
	//RestController 사용한다.
	@PostMapping("/auth/login")
	public @ResponseBody String login(@RequestBody User user) {	//@ResponseBody 넣으면? RestController 로 된다!
		User userEntity=userRepository.mLogin(user.getUsername(),user.getPassword());
		
		if(userEntity==null) {
			return "fail";
			
		} else { 
			//key 값: principal 인증주체 =>setAttribute(키, Object);
			//session으로 로그인한 사용자인지 확인하려고!
			//userEntity.setPassword(null);
			session.setAttribute("principal", userEntity);
			
			return "ok";
		}
	}
	
	//로그아웃 함수
=======
	@PostMapping("/auth/join")
	public String join(User user) {
		userRepository.save(user);
		return "redirect:/auth/loginForm";
	} 
	
	// RestController
	@PostMapping("/auth/login")
	public @ResponseBody String login(User user) {
		User userEntity =  userRepository.mLogin(user.getUsername(), user.getPassword());
		if(userEntity == null) {
			
			return Script.back("로그인 실패");
		}else {
			session.setAttribute("principal", userEntity);
			return Script.href("/");
		}
	}
	
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
	@GetMapping("/user/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
<<<<<<< HEAD
	
	//업데이트 페이지
	@GetMapping("/user/updateForm")
	public String updateForm() {
		//1.인증과 권한을 검사해야함
		//2.세션값 사용하면 됨! 그러면 
	
		return "user/updateForm";
	}
	
	//업데이트 함수								//update할때, where절에 걸리므로 {id}!!
	@PostMapping("/user/{id}")	//원래는  Put으로 해야한다. 나중에 자바스크립트로 Put 요청하기! 
	public String update(@PathVariable int id, String password,String address) {//password와 address는 x-www-form으로 body데이터로 들어온다.
		//  1. 세션 아이디값으로 SELECT  하기
		//공통관심사
		User principal=(User)session.getAttribute("principal");
		if(principal!=null && id==principal.getId()) {
			User userEntity=userRepository.findById(id).get();	// 해당 아이디에 대한 모든 정보가 들어있음
			
			// 2. 전달받은 값으로 변경하고
			userEntity.setPassword(password);
			userEntity.setAddress(address);
			
			// 3. SAVE
			userRepository.save(userEntity);						//새로 저장된 데이터로 다시 저장! update
		
			// 4. 세션변경
			session.setAttribute("principal", userEntity);	//update하고  session값을 바꿔야한다.
			
			// 5.정보변경 완료 후 메인 페이지 이동
			return "redirect:/";
		}
		return "redirect:/auth/loginForm";
		
	}
	
	@GetMapping("/juso")
	public String jusoRequest() {
		return "juso/jusoPopup";
	}
	
	@PostMapping("/juso")
	public String jusoResponse(String roadFullAddr,String inputYn, Model model) {
		System.out.println("주소:"+roadFullAddr);
		model.addAttribute("roadFullAddr",roadFullAddr);
		model.addAttribute("inputYn",inputYn);
		return "juso/jusoPopup";
	}
	
=======

>>>>>>> 036f4e5 (1. ORM 매핑 시작)
}




<<<<<<< HEAD
=======

>>>>>>> 036f4e5 (1. ORM 매핑 시작)
