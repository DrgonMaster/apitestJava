package com.niuguwang.test.apitestJava.cases;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.niuguwang.test.apitestJava.config.TestConfig;
import com.niuguwang.test.apitestJava.model.AddQuestionCase;
import com.niuguwang.test.apitestJava.model.GetQuestionReplybyLittle;
import com.niuguwang.test.apitestJava.model.InterfaceName;
import com.niuguwang.test.apitestJava.utils.ConfigFile;
import com.niuguwang.test.apitestJava.utils.DatabaseUtil;
import com.niuguwang.test.apitestJava.utils.HttpPostClient;
import com.niuguwang.test.apitestJava.utils.PrintTestInfo;

public class AddQuestionTest {
	@BeforeTest
	public void beforetest(){
		TestConfig.defaultHttpClient=new DefaultHttpClient();
		TestConfig.addQuestionUrl=ConfigFile.getUrl(InterfaceName.addQuestion);
	}
	@DataProvider(name="addQuestionCase")
	public  Iterator<AddQuestionCase> getlQuestionlist() throws IOException{
		SqlSession session = DatabaseUtil.getSqlSession();
		List<AddQuestionCase> addquestion = session.selectList("addquestionlist");
		Iterator<AddQuestionCase> it=addquestion.iterator();
		return it;
	}
	
	@Test(dataProvider ="addQuestionCase",groups="askstock-addquestion",description="首页问题列表" )
	public void addquestionList(AddQuestionCase addQuestionCase) throws ClientProtocolException, IOException{
		String result = getResult(addQuestionCase);
		JSONObject parseObject = JSON.parseObject(result);
		//获取返回的请求的id
		PrintTestInfo.printRequestinfo(TestConfig.addQuestionUrl, addQuestionCase.toString());
		 String actual = parseObject.getString("message");
		 Assert.assertEquals(actual,"操作成功");
	}
	
	
	
	/*如果不使用dataProvider参数化，那么就会如下执行相同的步骤的用例，一个的查出每一个参数的model
	 * 
	 * @Test(description="股票相关板块信息")
	public void addquestion() throws IOException{
		SqlSession session = DatabaseUtil.getSqlSession();
		AddQuestionCase aaquestion = session.selectOne("addquestion",1);
		PrintTestInfo.printRequestinfo(TestConfig.addQuestionUrl, aaquestion.toString());
		String result = getResult(aaquestion);
		JSONObject parseObject = JSON.parseObject(result);
		//获取返回的请求的id
		int questionId = parseObject.getJSONObject("questionInfo").getInteger("questionId");
		//请求
		GetQuestionReplybyLittle getQuestionReplybyLittle = new GetQuestionReplybyLittle(questionId, ""); 
		
		session.update("updategetQuestionReplybyLittle", getQuestionReplybyLittle);
		
		 String actual = parseObject.getString("message");
		 Assert.assertEquals(actual,"操作成功");
	}

	*/
	
	private String getResult(AddQuestionCase addquestion) throws ClientProtocolException, IOException{
		//将请求参数直接封装在map中
		HashMap<String, String> parameters = new HashMap<String, String>();
		parameters.put("ownerIds", Integer.toString(addquestion.getOwnerIds()));
		parameters.put("ownerNames", addquestion.getOwnerNames());
		parameters.put("content", addquestion.getContent());
		parameters.put("width", Integer.toString(addquestion.getWidth()));
		parameters.put("height",Integer.toString(addquestion.getHeight()) );
		parameters.put("userToken",addquestion.getUserToken() );

		//将请求参数传给HttpPost对象的创建方法中	
		HttpPost postClient = HttpPostClient.getPostClient(TestConfig.addQuestionUrl,parameters, true);
		HttpResponse responsedata = TestConfig.defaultHttpClient.execute(postClient);
		String result = EntityUtils.toString(responsedata.getEntity()); 
		return result;	
	}
}
