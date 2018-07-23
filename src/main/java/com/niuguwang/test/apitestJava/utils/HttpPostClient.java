package com.niuguwang.test.apitestJava.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import com.niuguwang.test.apitestJava.config.TestConfig;

public class HttpPostClient {
	private static HashMap<String, String> generalheaders = new HashMap<String, String>();

	public static HashMap<String, String> getGeneralheaders() {

		generalheaders.put("s", "_test");
		generalheaders.put("version", "3.9.1");
		generalheaders.put("packtype", "1");
		generalheaders.put("night", "0");

		return generalheaders;
	}

	public static void getPostClient(String Url,HashMap<String, String> headers, HashMap<String, String> parameters,boolean hasgeneralheader)
			throws UnsupportedEncodingException {
		
		// ��������ͷ��Ϣ
		if (hasgeneralheader) {
			headers.putAll(getGeneralheaders());
		}
		
		HttpPost httpPost = new HttpPost(Url);
		for (Entry<String, String> entry : headers.entrySet()) {
			httpPost.addHeader(entry.getKey(), entry.getValue());
		}

		// �������������Ϣ
		ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
		for (Entry<String, String> entry : parameters.entrySet()) {
			NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue());
			pairs.add(pair);
		}
		httpPost.setEntity(new UrlEncodedFormEntity(pairs, "utf-8"));
	}
	
	public static HttpPost getPostClient(String Url,HashMap<String, String> parameters,boolean hasgeneralheader)
			throws UnsupportedEncodingException {
		
		// ��������ͷ��Ϣ
		HttpPost httpPost = new HttpPost(Url);
		for (Entry<String, String> entry : getGeneralheaders().entrySet()) {
			httpPost.addHeader(entry.getKey(), entry.getValue());
		}

		// �������������Ϣ
		ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
		for (Entry<String, String> entry : parameters.entrySet()) {
			NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue());
			pairs.add(pair);
		}
		httpPost.setEntity(new UrlEncodedFormEntity(pairs, "utf-8"));
		return httpPost;
	}
	

}
