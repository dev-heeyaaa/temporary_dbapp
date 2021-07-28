package com.korea.dbapp.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BootStrapControllerTest {

	@GetMapping("/test/boot/navbar")
<<<<<<< HEAD
	public  String navbar() {
		return "test/navTest";
=======
	public String navbar() {
		return "test/navbarTest";
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
	}
}
