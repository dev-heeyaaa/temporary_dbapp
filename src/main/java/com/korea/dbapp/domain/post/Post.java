package com.korea.dbapp.domain.post;

import javax.persistence.Entity;
<<<<<<< HEAD
import javax.persistence.FetchType;
=======
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.korea.dbapp.domain.user.User;

@Entity
public class Post {
<<<<<<< HEAD
	@Id																						
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;							//프라이머리키(기본키)
	private String title;					// varchar(255), 255글자수로 기본적으로 맞춰진다
	@Lob											//jpa문법! long text type으로!
	private String content;
	
	
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	@JoinColumn(name = "user_id")
	@ManyToOne(fetch = FetchType.EAGER)	 //Many는?? Post, One은?? User => FK키로 인식!
	private User user;					//ORM 사용
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
=======
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 프라이머리키 (기본키)
	private String title; // varchar(255) , 255는 글자수
	@Lob
	private String content;
	
	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user; // ORM 사용

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	
}


>>>>>>> 036f4e5 (1. ORM 매핑 시작)
