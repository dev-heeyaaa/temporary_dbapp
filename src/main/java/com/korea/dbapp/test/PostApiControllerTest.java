package com.korea.dbapp.test;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.korea.dbapp.domain.comment.Comment;
=======
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
import com.korea.dbapp.domain.post.Post;
import com.korea.dbapp.domain.post.PostRepository;

@RestController
public class PostApiControllerTest {
	
	private final PostRepository postRepository;

<<<<<<< HEAD
	//생성자 만들면? DI된다.
	public PostApiControllerTest(PostRepository postRepository) {
		super();
=======
	public PostApiControllerTest(PostRepository postRepository) {
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
		this.postRepository = postRepository;
	}
	
	@GetMapping("/test/post")
	public List<Post> findAll(){
<<<<<<< HEAD
		// SELECT *FROM post 라는 쿼리문!!
		return postRepository.findAll();
		
	}
	
	@GetMapping("/test/post/{id}")
	public String findById(@PathVariable int id) {
		Post postEntity=postRepository.findById(id).get();
		System.out.println("1");
		postEntity.getUser().getUsername();
		System.out.println("2");
		return "ok";
=======
		// SELECT * FROM post
		return postRepository.findAll();
	}
	
	@GetMapping("/test/post/{id}")
	public Post findById(@PathVariable int id) {
		return postRepository.findById(id).get(); 
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
	}
	
}
