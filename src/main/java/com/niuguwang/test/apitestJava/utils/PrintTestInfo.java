package com.niuguwang.test.apitestJava.utils;

import org.testng.Reporter;

import com.niuguwang.test.apitestJava.config.TestConfig;

public class PrintTestInfo {
	public static void printRequestinfo(String requestUrl,String requestparameters){
		Reporter.log("����ӿڵ�ַ��"+requestUrl);
		Reporter.log("���������"+requestparameters);
	}
}
