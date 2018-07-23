package com.niuguwang.test.apitestJava.utils;


import java.util.Locale;
import java.util.ResourceBundle;

import com.niuguwang.test.apitestJava.model.InterfaceName;

public class ConfigFile {

   private static ResourceBundle bundle= ResourceBundle.getBundle("application", Locale.CHINA);;
   		static String testUrl;
   		static String uri;
    public static String getUrl(InterfaceName name){
        String useraddress = bundle.getString("test.user.url");
        String shqaddress = bundle.getString("test.shq.url");
        
        
        
        if(name == InterfaceName.LOGIN){
            uri = bundle.getString("login.uri");
            testUrl = useraddress + uri;
           
        }

        if(name == InterfaceName.getQuickSearch){
            uri = bundle.getString("getQuickSearch.uri");
            testUrl = useraddress + uri;
           
        }

        if(name == InterfaceName.addQuestion){
            uri = bundle.getString("addQuestion.uri");
            testUrl = useraddress + uri;
           
        }

        if(name == InterfaceName.getQuestionReplyByLittle){
            uri = bundle.getString("getQuestionReplyByLittle.uri");
            testUrl = useraddress + uri;
          
        }
        

        if(name == InterfaceName.getUserStocks){
            uri = bundle.getString("getUserStocks.uri");
            testUrl = shqaddress + uri;
        }
        
        return testUrl;

    }
}

