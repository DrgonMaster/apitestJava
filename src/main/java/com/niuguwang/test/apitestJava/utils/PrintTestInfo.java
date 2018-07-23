package com.niuguwang.test.apitestJava.utils;

import org.testng.Reporter;

import com.niuguwang.test.apitestJava.config.TestConfig;

public class PrintTestInfo {
	public static void printRequestinfo(String requestUrl,String requestparameters){
		Reporter.log("请求接口地址："+requestUrl);
		Reporter.log("请求参数："+requestparameters);
	}
}
