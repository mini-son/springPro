package com.mycom.app;

import java.util.Arrays;
import java.util.List;

public class TestDTO {
	
	private String userName; //이름
	//private String hobby;//취미
	//private String[] hobby;//취미
	private List<String> hobby;//취미
	private int pageNo;//페이지번호
	private String search;//검색분야
	private String keyword;//검색어
	
	public TestDTO() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public  List<String> getHobby() {
		return hobby;
	}

	public void setHobby( List<String> hobby) {
		this.hobby = hobby;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "TestDTO [userName=" + userName + ", hobby=" + hobby + ", pageNo=" + pageNo + ", search=" + search
				+ ", keyword=" + keyword + "]";
	}



	
	
}
