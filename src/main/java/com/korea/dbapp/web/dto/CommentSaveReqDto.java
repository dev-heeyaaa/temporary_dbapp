package com.korea.dbapp.web.dto;

import lombok.Data;

// 모델로 받을 수 없기 때문에 DTO 만들었다!
// postId 왜 이렇게 이름을 지었냐? - 잭슨
// 잭슨 라이브러리가 메세지 컨버터에 붙어있다. 메시지 컨버터는 추상 클래스 -> 잭슨 대신 xml을 파싱할 수도 있어서 이름을 지을 때 언더바를 사용하지 않는다.


@Data
public class CommentSaveReqDto {
	private String text;
	private int postId;
}
