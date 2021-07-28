package com.korea.dbapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.korea.dbapp.domain.comment.Comment;
import com.korea.dbapp.domain.comment.CommentRepository;
import com.korea.dbapp.domain.post.Post;
import com.korea.dbapp.domain.post.PostRepository;
import com.korea.dbapp.domain.user.User;
import com.korea.dbapp.web.dto.CMRespDto;
import com.korea.dbapp.web.dto.CommentSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CommentController {
	private final CommentRepository commentRepository;
	private final HttpSession session;
	private final PostRepository postRepository;


	// 1 save - post - Data return 
	@PostMapping("/comment")
	public @ResponseBody CMRespDto<Comment> save(@RequestBody CommentSaveReqDto dto){

		Comment comment = new Comment();
		comment.setText(dto.getText());

		Post postEntity = postRepository.findById(dto.getPostId()).get();
		postEntity.setId(dto.getPostId());
		comment.setPost(postEntity);

		User principal = (User)session.getAttribute("principal");
		comment.setUser(principal);

		if(principal == null) {
			return new CMRespDto<>(-1, "댓글쓰기실패", null);
		}

		Comment commentEntity = commentRepository.save(comment);
		return new CMRespDto<>(1, "댓글쓰기성공", commentEntity);

	}    

	// 2 delete - delete - Data return 
	@DeleteMapping("/comment/{id}")
	public @ResponseBody String deleteById(@PathVariable int id) {
		Comment commentEntity = commentRepository.findById(id).get();
		int commentUserId = commentEntity.getUser().getId();

		User principal=(User)session.getAttribute("principal");
		int userId=principal.getId();

		if(commentUserId == userId) {
			commentRepository.deleteById(id);
			return "ok"; 
		}else {
			return "fail";
		}   

	} 
	// 3 select - findAll 안 됨. findAllByPostId() 이런 식으로 쿼리 만들기 - get - 상세보기 페이지로 갈 때 모델로 담아가야 함(여기서 사용 못함) -> PostController

}
