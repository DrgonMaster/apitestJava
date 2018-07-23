package com.niuguwang.test.apitestJava.config;

import lombok.Data;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;


@Data
public class TestConfig {

    public class addQuestionUrl {

	}
	//鐧婚檰鎺ュ彛uri
    public static String loginUrl;
    //闂偂棣栨杩涘叆鏃舵帴鍙�
    public static String getQuickSearchUrl;
    //闂偂鎻愰棶涓�涓棶棰樼殑杩斿洖鎴愬姛鏃剁殑鎺ュ彛
    public static String addQuestionUrl;
    //鐢ㄦ埛鎻愰棶闂鐨勮缁嗗洖绛�
    public static String getQuestionReplyByLittleUrl;

    //鐢ㄦ潵瀛樺偍cookies淇℃伅鐨勫彉閲�
    public static CookieStore store;
    //澹版槑http瀹㈡埛绔�
    public static DefaultHttpClient defaultHttpClient;
	public static String getUserStocksUrl;

}
