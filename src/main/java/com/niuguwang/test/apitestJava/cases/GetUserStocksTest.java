package com.niuguwang.test.apitestJava.cases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NavigableMap;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.niuguwang.test.apitestJava.config.TestConfig;
import com.niuguwang.test.apitestJava.model.GetUserStocksCase;
import com.niuguwang.test.apitestJava.model.InterfaceName;
import com.niuguwang.test.apitestJava.utils.ConfigFile;
import com.niuguwang.test.apitestJava.utils.DatabaseUtil;
import com.niuguwang.test.apitestJava.utils.HttpGetClient;
import com.niuguwang.test.apitestJava.utils.HttpPostClient;
import com.niuguwang.test.apitestJava.utils.PrintTestInfo;

public class GetUserStocksTest {
	SqlSession sqlSession;
	@BeforeTest
	public void before() throws IOException{
		TestConfig.defaultHttpClient=new DefaultHttpClient();
		TestConfig.getUserStocksUrl=ConfigFile.getUrl(InterfaceName.getUserStocks);
		sqlSession = DatabaseUtil.getSqlSession();
	}
	@Test(groups = "userstocks",description = "获取用户列表")
	public void getUserStocks() throws ClientProtocolException, IOException{
		GetUserStocksCase getuserstockcase=sqlSession.selectOne("GetUserStocks",1 );
		String result = getResult(getuserstockcase);
		JSONObject parseObject = JSON.parseObject(result);
		//获取返回的请求的id
		PrintTestInfo.printRequestinfo(TestConfig.getUserStocksUrl, getuserstockcase.toString());
		 String actual = parseObject.getString("status");
		 Assert.assertEquals(actual,"success");
	}
	
	private String getResult(GetUserStocksCase getuserstockcase) throws ClientProtocolException, IOException{
		
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		BasicNameValuePair basicNameValuePair = new BasicNameValuePair("usertoken", getuserstockcase.getUsertoken());
		BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("auto",Integer.toString(getuserstockcase.getAuto()));
		nameValuePairs.add(basicNameValuePair2);
		nameValuePairs.add(basicNameValuePair);
		
		String uri =EntityUtils.toString(new UrlEncodedFormEntity(nameValuePairs), "utf-8");
		String url =TestConfig.getUserStocksUrl+"?"+uri;
		
		HttpGet httpGet = new HttpGet(url);
		
		HttpResponse responsedata = TestConfig.defaultHttpClient.execute(httpGet);
		String result = EntityUtils.toString(responsedata.getEntity()); 
		return result;	
		
	}
	
}
