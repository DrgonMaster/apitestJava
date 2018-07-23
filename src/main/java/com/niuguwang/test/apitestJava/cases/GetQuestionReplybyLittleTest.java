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
import org.bson.json.JsonMode;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.niuguwang.test.apitestJava.config.TestConfig;
import com.niuguwang.test.apitestJava.model.GetQuestionReplybyLittle;
import com.niuguwang.test.apitestJava.model.InterfaceName;
import com.niuguwang.test.apitestJava.utils.ConfigFile;
import com.niuguwang.test.apitestJava.utils.DatabaseUtil;

public class GetQuestionReplybyLittleTest {
	private String url;
	SqlSession sqlSession;
	@BeforeTest
	public void beforetest() throws IOException {
		url = ConfigFile.getUrl(InterfaceName.getQuestionReplyByLittle);
		sqlSession = DatabaseUtil.getSqlSession();

	}
	@Test(description="通过问题的内容获取诊股答案")
	public void getQuestionReplaybyLittle() throws ClientProtocolException, IOException{
		
		GetQuestionReplybyLittle getQuestionReplybyLittle = sqlSession.selectOne("getQuestionReplaybyLittle",1 );
		String resault = getResault(getQuestionReplybyLittle);
		JSONObject parse = JSON.parseObject(resault);
		String rs = parse.getString("message");
		
		Reporter.log("接口地址："+url);
		Reporter.log("请求参数："+getQuestionReplybyLittle.toString());
		Assert.assertEquals(rs, "获取成功");
	}
	
	public String getResault(GetQuestionReplybyLittle getQuestionReplybyLittle) throws ClientProtocolException, IOException{
		DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		 post.setHeader("content-type","application/x-www-form-urlencoded; charset=utf-8");
	        post.setHeader("packtype","1");
	        post.setHeader("s","_test");
	        post.setHeader("version","3.9.1");
	        post.setHeader("night","1");
	        
	        ArrayList<NameValuePair> list =new ArrayList<NameValuePair>();
	        list.add(new BasicNameValuePair("questionId", Integer.toString(getQuestionReplybyLittle.getQuestionId())));
	        list.add(new BasicNameValuePair("userToken", getQuestionReplybyLittle.getUserToken()));
	        post.setEntity(new UrlEncodedFormEntity(list,"utf-8"));
	        HttpResponse rp = defaultHttpClient.execute(post);
	        String resault = EntityUtils.toString(rp.getEntity());
		return resault;
	}
	
}
