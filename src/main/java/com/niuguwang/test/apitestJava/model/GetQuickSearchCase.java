package com.niuguwang.test.apitestJava.model;

import lombok.Data;

@Data
public class GetQuickSearchCase {
	private int id;
	private int pageIndex;
	private int pageSize;
	private String userToken;
	
	
	public GetQuickSearchCase() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public GetQuickSearchCase(int id, int pageIndex, int pageSize, String userToken) {
		this.id = id;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.userToken = userToken;
	}
	public final int getId() {
		return id;
	}
	public final void setId(int id) {
		this.id = id;
	}
	public final int getPageIndex() {
		return pageIndex;
	}
	public final void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public final int getPageSize() {
		return pageSize;
	}
	public final void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public final String getUserToken() {
		return userToken;
	}
	public final void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	@Override
	public String toString() {
		return "GetQuickSearchCase [id=" + id + ", pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", userToken="
				+ userToken + "]";
	}

}
