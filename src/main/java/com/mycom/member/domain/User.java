package com.mycom.member.domain;

//로그인한 user의 정보를 관리용도의 클래스이다.
public class User {

	private String  id; //회원id
	private String  name; //회원명
	private String  nickname; //회원별칭
	
	public User() {
	}

	public User(String id, String name, String nickname) {
		this.id = id;
		this.name = name;
		this.nickname = nickname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
	
	
}
