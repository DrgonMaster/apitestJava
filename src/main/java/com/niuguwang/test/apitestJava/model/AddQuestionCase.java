package com.niuguwang.test.apitestJava.model;

public class AddQuestionCase {
	private int id;
	private int ownerIds;
	private String ownerNames;
	private String content;
	private String userToken;
	private int width;
	private int height;
	
	public AddQuestionCase(int id, int ownerIds, String ownerNames, String content, String userToken, int width,
			int height) {
		this.id = id;
		this.ownerIds = ownerIds;
		this.ownerNames = ownerNames;
		this.content = content;
		this.userToken = userToken;
		this.width = width;
		this.height = height;
	}
	
	public AddQuestionCase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public final int getId() {
		return id;
	}
	public final void setId(int id) {
		this.id = id;
	}
	public final int getOwnerIds() {
		return ownerIds;
	}
	public final void setOwnerIds(int ownerIds) {
		this.ownerIds = ownerIds;
	}
	public final String getOwnerNames() {
		return ownerNames;
	}
	public final void setOwnerNames(String ownerNames) {
		this.ownerNames = ownerNames;
	}
	public final String getContent() {
		return content;
	}
	public final void setContent(String content) {
		this.content = content;
	}
	public final String getUserToken() {
		return userToken;
	}
	public final void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public final int getWidth() {
		return width;
	}
	public final void setWidth(int width) {
		this.width = width;
	}
	public final int getHeight() {
		return height;
	}
	public final void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "AddQuestion [id=" + id + ", ownerIds=" + ownerIds + ", ownerNames=" + ownerNames + ", content="
				+ content + ", userToken=" + userToken + ", width=" + width + ", height=" + height + "]";
	}
	
}
