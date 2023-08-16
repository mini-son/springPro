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
	
/*	public MemberDTO() {}
	
	public MemberDTO(int no, String memberid, String password, String name, Date regDate, String isshow) {
		super();
		this.no = no;
		this.memberid = memberid;
		this.password = password;
		this.name = name;
		this.regDate = regDate;
		this.isshow = isshow;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getIsshow() {
		return isshow;
	}

	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}

	@Override
	public String toString() {
		return "MemberDTO [no=" + no + ", memberid=" + memberid + ", password=" + password + ", name=" + name
				+ ", regDate=" + regDate + ", isshow=" + isshow + "]";
	}
	
	*/
	
}
