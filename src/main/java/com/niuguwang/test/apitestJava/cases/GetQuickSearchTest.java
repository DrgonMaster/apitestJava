package com.niuguwang.test.apitestJava.cases;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.niuguwang.test.apitestJava.config.TestConfig;
import com.niuguwang.test.apitestJava.model.AddQuestionCase;
import com.niuguwang.test.apitestJava.model.GetQuickSearchCase;
import com.niuguwang.test.apitestJava.model.InterfaceName;
import com.niuguwang.test.apitestJava.utils.ConfigFile;
import com.niuguwang.test.apitestJava.utils.DatabaseUtil;

public class GetQuickSearchTest {
	@BeforeTest
	public void beforeTest(){
		TestConfig.defaultHttpClient =new DefaultHttpClient();
		TestConfig.getQuickSearchUrl=ConfigFile.getUrl(InterfaceName.getQuickSearch);
		System.out.println(TestConfig.getQuickSearchUrl);
	}
	
	@Test(groups = "GetQuickSearchTest",description = "首次进入获取欢迎列表")
	public void quickSearch() throws IOException{
		 SqlSession session = DatabaseUtil.getSqlSession();
		 GetQuickSearchCase getquicksearchcase =session.selectOne("getQuickSearch",1);
		 System.out.println(getquicksearchcase);
		 String resault = getResault(getquicksearchcase);
		 JSONObject parse = JSON.parseObject(resault);
		 
		 //获取问题列表的第一个
		 JSONObject question  = parse.getJSONObject("quickSearchInfo").getJSONObject("welcome").getJSONArray("quickSearchList").getJSONObject(3);
		 String questionstring = question.getString("quickSearchText");
		 //执行测试用例
		 AddQuestionCase addQuestionCase = new AddQuestionCase(1, 0,"", questionstring, "1", -1, -1);
		 session.update("updaAddQuestion", addQuestionCase);
		 
		 Reporter.log("请求接口地址："+TestConfig.getQuickSearchUrl);
		 Reporter.log("请求参数："+addQuestionCase.toString());
		 Assert.assertEquals(parse.getString("result"), "1");
	}
	
	
	
	private String getResault(GetQuickSearchCase getquicksearchcase) throws ClientProtocolException, IOException{
		HttpPost httpPost = new HttpPost(TestConfig.getQuickSearchUrl);
		httpPost.setHeader("packtype","1");
		httpPost.setHeader("s","_test");
		httpPost.setHeader("packtype","1");
		httpPost.setHeader("screenHeight","1920");
		httpPost.setHeader("screenWidth","1080");
		httpPost.setHeader("version","3.9.1");
		ArrayList<NameValuePair> list =new ArrayList<NameValuePair>();
		NameValuePair parasite1 = new BasicNameValuePair("pageIndex",Integer.toString(getquicksearchcase.getPageIndex()));
		NameValuePair parasite2 = new BasicNameValuePair("pageSize",Integer.toString(getquicksearchcase.getPageSize()));
		NameValuePair parasite3 = new BasicNameValuePair("userToken",getquicksearchcase.getUserToken());
		list.add(parasite1);
		list.add(parasite2);
		list.add(parasite3);
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8");
		httpPost.setEntity(entity);
		HttpResponse responed = TestConfig.defaultHttpClient.execute(httpPost);
		String resault = EntityUtils.toString(responed.getEntity(),"utf-8");
		System.out.println(resault);
		return resault;
		
	}
}
