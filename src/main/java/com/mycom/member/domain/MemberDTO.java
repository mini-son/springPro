package com.mycom.member.domain;

import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
/*lombok에서 사용가능한 @들
  @Data : @Setter,@Getter,@ToString,@EqualsAndHashCode
 @NoArgsConstructor
 @AllArgsConstructor  등*/
//member 테이블관련 data저장,제공 등의 기능을 제공 클래스
public class MemberDTO {

	private int			no;			//회원번호.pk
	private String  memberid;	//회원id
	private String  password;	//비번
	private String  name;		//회원명
	private Date		regDate;	//가입일
	private String  isshow;	    //노출여부.isshow  기본값'Y', 삭제시 'N'	
	
	
}
