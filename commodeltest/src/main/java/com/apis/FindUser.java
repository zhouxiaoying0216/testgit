package com.apis;

import com.utils.RequestUtils;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class FindUser {
    @Parameters("age")
    @Test
    public void finduser(String age) throws IOException{
        Map<String,String> map=new HashMap();
        map.put("age",age);
        String str = JSONObject.toJSONString(map);


        ResourceBundle resource = ResourceBundle.getBundle("url");
        String key = resource.getString("findUserurl");

        String result= RequestUtils.postRequest(key,str);
        System.out.println(result);


    }
}
