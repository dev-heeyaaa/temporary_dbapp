package com.korea.dbapp.domain.comment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.korea.dbapp.domain.post.Post;
import com.korea.dbapp.domain.user.User;

import lombok.Data;

@Data //getter, setter/ toString 을 만들어 줌
@Entity
public class Comment {
	@Id																						
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id; // PK
	private String text;
	
	//private int likeCount;
	
	// 한 명의 유저가 여러 개의 코멘트를 쓸 수 있으니 1:N 관계에서 N은 코멘드이다 -> FK는 Comment
	
	@JsonIgnoreProperties({"posts"})
	@JoinColumn(name="user_id")
	@ManyToOne
	private User user;
	 
	// 1:N 관계
	@JsonIgnoreProperties({"user"})
	@JoinColumn(name="post_id") 
	@ManyToOne
	private Post post;
}
