package com.niuguwang.test.apitestJava.model;

public class GetQuestionReplybyLittle {
	private int questionId;
	private String userToken;
	
	public GetQuestionReplybyLittle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GetQuestionReplybyLittle(int questionId, String userToken) {
		this.questionId = questionId;
		this.userToken = userToken;
	}
	public final int getQuestionId() {
		return questionId;
	}
	public final void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public final String getUserToken() {
		return userToken;
	}
	public final void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	@Override
	public String toString() {
		return "GetQuestionReplybyLittle [questionId=" + questionId + ", userToken=" + userToken + "]";
	}
}
