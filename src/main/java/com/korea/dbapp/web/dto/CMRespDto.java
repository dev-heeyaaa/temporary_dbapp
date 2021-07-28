package com.korea.dbapp.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CMRespDto<T> {
	private int code;
	private String msg;
	private T data;
}
// bean 
// 클래스 자료형 (커스텀 자료형)
// 서버가 응답하는 데이터 : 리스폰스 데이터 (나갈 때 데이터 : 리스폰스디티오) - 하나만 필요
// 통신을 위한 데이터 (서버 쪽으로 들어오는 데이터 : 리퀘스트 데이터) ( 들어올 때 : 리퀘스트디티오) - 많이 필요 ex) 로그인 DTO, 
// 통신할 때 -DTO

// 통신할 때는 모델로 만들지 않는다.
// 데이터베이스랑 테이블이랑 똑같이 생겼으면 모델이라고 부름
// repository에서 만들어지는 것 - 모델