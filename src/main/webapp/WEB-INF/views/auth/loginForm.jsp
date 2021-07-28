<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="container">
	<form onsubmit="tryLogin()">
		<div class="form-group">
			<label for="username">Username:</label> 
			<input id="username" type="text" class="form-control" placeholder="Enter username" name="username" required="required"/>
		</div>
		<div class="form-group">
			<label for="password">Password:</label> 
			<input id="password" type="password" class="form-control" placeholder="Enter password" name="password" required="required"/>
		</div>
		
		<button type="submit" class="btn btn-primary">로그인</button>
	</form>
</div>
<script>
	async function tryLogin(){
		event.preventDefault();
		let username = document.querySelector("#username").value;
		let password = document.querySelector("#password").value;

		let loginDto = {
			username:username,
			password:password
		};

		let response = await fetch("/auth/login", {
			method:"post",
			body: JSON.stringify(loginDto),
			headers:{
				"Content-Type":"application/json; charset=utf-8"
			}
		});
		let parseResponse = await response.text(); // json(), text()

		console.log(parseResponse);

		if(parseResponse === "ok"){
			location="/";
		}else{
			alert("로그인 실패");
		}


	}

</script>

<%@include file="../layout/footer.jsp"%>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div class="container">

	<!-- username=머시기&password=머시기&email=머시기&address=머시기 -->
	<form action="/auth/login" method="post">
		<div class="form-group">
			<label for="username">Username:</label> 
			<input type="text" class="form-control" placeholder="Enter username"  name="username" required="required" />
		</div>
		<div class="form-group">
			<label for="password">Password:</label> 
			<input type="password" class="form-control" placeholder="Enter password"  name="password" required="required" />
		</div>

		<button type="submit" class="btn btn-primary">로그인</button>
	</form>
	
</div>

<%@ include file="../layout/footer.jsp" %>
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
