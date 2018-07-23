package com.niuguwang.test.apitestJava.cases;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.text.AbstractDocument.Content;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.http.entity.mime.content.StringBody; 

public class UploadLogoTest {
	@BeforeTest
	public void beforeTest(){
		
	}
	@Test
	public void uploadLogo() throws ClientProtocolException, IOException{
		DefaultHttpClient httpClient =new DefaultHttpClient();
		HttpPost httpPost = new HttpPost("https://swww.niuguwang.com/photo/uploadlogo.ashx");
		httpPost.setHeader("Content-Type", "multipart/form-data");
//		httpPost.setHeader("usertoken", "rvvLMTV7FdG1c60xgC2wKMtTmoBCfBaHpXao9JZag_Kp6k5PMJtibg**");
		String filePath="D:\\pictures\\jpgtest.jpg";
		FileBody  fileBody = new FileBody(new File(filePath));
//		ContentBody usertokenbody =new StringBody("rvvLMTV7FdG1c60xgC2wKMtTmoBCfBaHpXao9JZag_Kp6k5PMJtibg**");
		MultipartEntity  reqEntity = new MultipartEntity(); 
        reqEntity.addPart("fileInput", fileBody);//相当于<input type="file" name="media"/>  
        reqEntity.addPart("usertoken", new StringBody("rvvLMTV7FdG1c60xgC2wKMtTmoBCfBaHpXao9JZag_Kp6k5PMJtibg**"));
        httpPost.setEntity(reqEntity);  
		HttpResponse response = httpClient.execute(httpPost);
		String result = EntityUtils.toString(response.getEntity(),"utf-8");
	     System.out.println("测试返回结果为"+result);
	}
}
