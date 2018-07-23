package com.niuguwang.test.apitestJava.model;

public class GetUserStocksCase {
	private int id;
	private int auto;
	private String usertoken;
	public final int getId() {
		return id;
	}
	public final void setId(int id) {
		this.id = id;
	}
	public final int getAuto() {
		return auto;
	}
	public final void setAuto(int auto) {
		this.auto = auto;
	}
	public final String getUsertoken() {
		return usertoken;
	}
	public final void setUsertoken(String usertoken) {
		this.usertoken = usertoken;
	}
	public GetUserStocksCase(int id, int auto, String usertoken) {
		this.id = id;
		this.auto = auto;
		this.usertoken = usertoken;
	}
	public GetUserStocksCase() {
		super();
	}
	@Override
	public String toString() {
		return "GetUserStocksCase [id=" + id + ", auto=" + auto + ", usertoken=" + usertoken + "]";
	}
	
	
	
}
