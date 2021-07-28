<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div class="container">
	<!-- 수정,삭제  인증만 확인할때!! -->
	<%-- <c:if test="${!empty sessionScope.principal}"> --%>
	<!-- 권한 부여!! 해당 글을 작성한 user의 id와 세션(인증주체)에 있는 user의 id랑 같으면! -->
	<c:if test="${sessionScope.principal.id==postEntity.user.id}">
		<a href="/post/${postEntity.id}/updateForm" class="btn btn-warning">수정</a>

		<form style="display: inline-block" onsubmit="deletePost(${postEntity.id})">
			<button id="btn-delete" class="btn btn-danger" type="submit" onclick="">삭제</button>
		</form>
	</c:if>
	<br />
	<br />
	<div>
		<span>글 번호 : ${postEntity.id}</span> 작성자 : <span><i>${postEntity.user.username} </i></span>
	</div>
	<br />
	<div>
		<h3>${postEntity.title}</h3>
	</div>
	<hr />
	<div>
		<div>${postEntity.content}</div>
	</div>
	<hr />

	<div class="card">
		<form onsubmit="saveComment(${postEntity.id})">
			<div class="card-body">
				<textarea id="reply-text" class="form-control" rows="1"></textarea>
			</div>
			<div class="card-footer">
				<button class="btn btn-primary">등록</button>
			</div>
		</form>

	</div>
	<br />

	<div class="card">
		<div class="card-header">
			<b>댓글 리스트</b>
		</div>
		<ul id="reply-box" class="list-group">
			<c:forEach var="comment" items="${commentsEntity}">
				<li id="reply-${comment.id}" class="list-group-item d-flex justify-content-between">
					<div>${comment.text}</div>
					<div class="d-flex">
						
						<div class="font-italic">작성자 : ${comment.user.username} &nbsp;</div>
					
						<c:if test="${principal.id == comment.user.id}">
							<button class="badge" onclick="deleteComment(${comment.id})">삭제</button>
						</c:if>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	<br />
</div>
<script>
	async function deletePost(postId){
		event.preventDefault(); // 새로고침 실행되는 거 막기 폼 태그에만
		let response = await fetch("/post/"+postId, {
			method: "delete"

		});

		let parseResponse = await response.text(); // 통신으로 받은 게 문자열 (json이 아니라)
		console.log(parseResponse);

		if(parseResponse === "ok"){
			location = "/"
		}else{
			alert("삭제 실패");
		}
	}

	async function deleteComment(commentId){
		let response = await fetch("/comment/"+commentId,{
			method: "delete"
		});
		let parseResponse = await response.text(); // 통신으로 받은 게 문자열 (json이 아니라)

		if(parseResponse === "ok"){
			//location.reload();
			let deleteEL = document.querySelector("#reply-"+commentId);
			deleteEL.remove();
			console.log(deleteEL);
		}else{
			alert("삭제 실패");
		}
	}

	let saveComment = async (postId) => { 
		event.preventDefault(); // form action 타지 마!!!

		let commentReqDto = {
			text: document.querySelector("#reply-text").value,
			postId: postId
		};
		// JSON.parse(제이슨 문자열);
		// console.log(JSON.stringify(commentReqDto));
		// let test = JSON.stringify(commentReqDto);

		//console.log(JSON.parse(test));

		let response = await fetch("/comment",{
			method: "post",
			body: JSON.stringify(commentReqDto),
			headers: {
				"Content-Type":"application/json; charset=utf-8"
			}
		});

		let parseResponse = await response.json();
		
		
		
	
		location.reload();
	}
</script>
<%@ include file="../layout/footer.jsp"%>