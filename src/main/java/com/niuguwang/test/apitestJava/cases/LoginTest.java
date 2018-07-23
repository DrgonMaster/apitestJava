package com.niuguwang.test.apitestJava.cases;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.niuguwang.test.apitestJava.config.TestConfig;
import com.niuguwang.test.apitestJava.model.AddQuestionCase;
import com.niuguwang.test.apitestJava.model.GetQuestionReplybyLittle;
import com.niuguwang.test.apitestJava.model.GetQuickSearchCase;
import com.niuguwang.test.apitestJava.model.InterfaceName;
import com.niuguwang.test.apitestJava.model.LoginCase;
import com.niuguwang.test.apitestJava.utils.ConfigFile;
import com.niuguwang.test.apitestJava.utils.DatabaseUtil;


public class LoginTest{


    @BeforeTest
    public void beforeTest(){
        TestConfig.defaultHttpClient = new DefaultHttpClient();
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        System.out.println("执行测试前内容");
    }


    @Test(groups = "loginTrue",description = "使用手机号登录，用户名正确，密码正确")
    public void loginTrue() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase",1);

        //执行测试，获取返回
        String result = getResult(loginCase);
        JSONObject pjo =JSON.parseObject(result);
        String message =pjo.getString("message");
      //获取用户userinfo信息，取得usertoken
        String usertoken = pjo.getJSONObject("userInfo").getString("userToken");
        //将usertoken存储到getquickserchtest的表中
        GetQuickSearchCase getQuickSearchCase = new GetQuickSearchCase(1, -1, -1, usertoken);
        //将usertoken添加到addquestion表
        AddQuestionCase addQuestionCase = new AddQuestionCase(0, 0, "", "",usertoken, 0, 0);
        session.update("updateaddquestionusertoken", addQuestionCase);
        
        //将usertoken添加到getquestionreplybylittle表中
       GetQuestionReplybyLittle getQuestionReplybyLittle = new GetQuestionReplybyLittle(-1, usertoken);
       session.update("updateusertokenbyLittle", getQuestionReplybyLittle); 
       //从数据库中获得预期结果，和实际返回结果对比
        
        Reporter.log("请求接口地址："+TestConfig.loginUrl);
		 Reporter.log("请求参数："+loginCase.toString());
        session.update("updateusertoken", getQuickSearchCase);
        Assert.assertEquals(loginCase.getExpected(),message);
        
    }
    @Test(groups = "loginTrue",description = "使用用户名登录，用户名正确，密码错误")
    public void loginTrue01() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase",6);

        //执行测试，获取返回
        String result = getResult(loginCase);
        JSONObject pjo =JSON.parseObject(result);
        String message =pjo.getString("message");
        Reporter.log("请求接口地址："+TestConfig.loginUrl);
		 Reporter.log("请求参数："+loginCase.toString());
        Assert.assertEquals(loginCase.getExpected(),message);
       
    }

    @Test(groups = "loginfalse",description = "用户名正确，密码错误")
    public void loginFalse() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase",2);

        String result = getResult(loginCase);
        JSONObject pjo =JSON.parseObject(result);
        String message =pjo.getString("message");
        //从数据库中获得预期结果，和实际返回结果对比
        Reporter.log("请求接口地址："+TestConfig.loginUrl);
		Reporter.log("请求参数："+loginCase.toString());
        Assert.assertEquals(loginCase.getExpected(),message);
    }
    @Test(groups = "loginfalse",description = "用户名为空，密码为空")
    public void loginFalse01() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase",3);

        String result = getResult(loginCase);
        JSONObject pjo =JSON.parseObject(result);
        String message =pjo.getString("message");
        //从数据库中获得预期结果，和实际返回结果对比
        Reporter.log("请求接口地址："+TestConfig.loginUrl);
		 Reporter.log("请求参数："+loginCase.toString());
        Assert.assertEquals(loginCase.getExpected(),message);
      
    }
    @Test(groups = "loginfalse",description = "用户名正确，密码错误")
    public void loginFalse02() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase",4);
        String result = getResult(loginCase);
        JSONObject pjo =JSON.parseObject(result);
        String message =pjo.getString("message");
        //从数据库中获得预期结果，和实际返回结果对比
        
        Reporter.log("请求接口地址："+TestConfig.loginUrl);
		 Reporter.log("请求参数："+loginCase.toString());
        Assert.assertEquals(loginCase.getExpected(),message);
    }
    
    @Test(groups = "loginfalse",description = "用户名错误，密码正确")
    public void loginFalse03() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase",5);

        String result = getResult(loginCase);
        JSONObject pjo =JSON.parseObject(result);
        String message =pjo.getString("message");
        //从数据库中获得预期结果，和实际返回结果对比
        Reporter.log("请求接口地址："+TestConfig.loginUrl);
		 Reporter.log("请求参数："+loginCase.toString());
        Assert.assertEquals(loginCase.getExpected(),message);
    }
    @Test(groups = "loginfalse",description = "用户名错误，密码正确")
    public void loginFalse04() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase",7);

        String result = getResult(loginCase);
        JSONObject pjo =JSON.parseObject(result);
        String message =pjo.getString("message");
        //从数据库中获得预期结果，和实际返回结果对比
        Reporter.log("请求接口地址："+TestConfig.loginUrl);
		 Reporter.log("请求参数："+loginCase.toString());
        Assert.assertEquals(loginCase.getExpected(),message);
    }



    private String getResult(LoginCase loginCase) throws IOException {
        //新建post请求对象
        HttpPost post = new HttpPost(TestConfig.loginUrl);
        //设置header信息
        post.setHeader("content-type","application/x-www-form-urlencoded; charset=utf-8");
        post.setHeader("packtype","1");
        post.setHeader("s","_test");
        post.setHeader("version","3.9.1");
        post.setHeader("night","1");
        
       /*json格式发送请求
        * JSONObject param = new JSONObject();
        param.put("userName", loginCase.getUsername());
        param.put("password",loginCase.getPassword());
        param.put("loginType",loginCase.getLoginTyte());
        param.put("deviceid",loginCase.getDeviceid());
        param.put("company",loginCase.getCompany());
        //设置编码格式，发送post请求
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);*/
        
        
        ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();  
        
        NameValuePair pair1 = new BasicNameValuePair("userName", loginCase.getUsername());  
        NameValuePair pair2 = new BasicNameValuePair("password",loginCase.getPassword());  
        NameValuePair pair3 = new BasicNameValuePair("deviceid",loginCase.getDeviceid());  
        NameValuePair pair4 = new BasicNameValuePair("loginType",loginCase.getLoginTyte());  
        NameValuePair pair5 = new BasicNameValuePair("company",loginCase.getCompany());  
          
        pairs.add(pair1);  
        pairs.add(pair2);  
        pairs.add(pair3);
        pairs.add(pair4);
        pairs.add(pair5);
          
       post.setEntity(new UrlEncodedFormEntity(pairs, HTTP.UTF_8));
        
        String result;
        //获取请求返回结果
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        //请求返回结果转换为字符串
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("测试返回结果为"+result);
        TestConfig.store = TestConfig.defaultHttpClient.getCookieStore();
        return result;
    }


}
