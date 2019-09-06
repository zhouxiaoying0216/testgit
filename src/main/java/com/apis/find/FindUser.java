package com.apis.find;

import com.utils.AssertUtils;
import com.utils.RequestUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import static org.assertj.core.api.Assertions.assertThat;

public class FindUser extends AssertUtils {
    @Parameters("age")
    @Test
    public void finduser(String age) throws IOException{
        Map<String,String> map=new HashMap();
        map.put("age",age);
        String str = JSONObject.toJSONString(map);


        ResourceBundle resource = ResourceBundle.getBundle("url");
        String key = resource.getString("findUserurl");

        String result= RequestUtils.postRequest(key,str);
        System.out.println(result);//查询结果：[UserInfo(id=595, userName=123, password=123456, age=18, sex=0, permission=1, isDelete=0), UserInfo(id=596, userName=黄晓东, password=12348, age=18, sex=0, permission=1, isDelete=0), UserInfo(id=597, userName=敦敦, password=123456, age=18, sex=0, permission=1, isDelete=0), UserInfo(id=604, userName=null, password=null, age=18, sex=null, permission=null, isDelete=null), UserInfo(id=608, userName=敦小, password=123456, age=18, sex=0, permission=1, isDelete=0), UserInfo(id=610, userName=null, password=null, age=18, sex=null, permission=null, isDelete=null), UserInfo(id=611, userName=花花, password=123321, age=18, sex=0, permission=0, isDelete=0), UserInfo(id=612, userName=, password=123321, age=18, sex=0, permission=0, isDelete=0), UserInfo(id=613, userName=, password=123321, age=18, sex=0, permission=0, isDelete=0), UserInfo(id=614, userName=, password=123321, age=18, sex=0, permission=0, isDelete=0), UserInfo(id=615, userName=, password=123321, age=18, sex=0, permission=0, isDelete=0), UserInfo(id=616, userName=, password=123321, age=18, sex=0, permission=0, isDelete=0), UserInfo(id=617, userName=, password=123321, age=18, sex=0, permission=0, isDelete=0), UserInfo(id=618, userName=, password=123321, age=18, sex=0, permission=0, isDelete=0), UserInfo(id=619, userName=, password=123321, age=18, sex=0, permission=0, isDelete=0)]


        //断言
        assertThat(result).contains("查询结果");
        assertThat(result).contains("查询结果").contains(age);
//        String assetsid = result.substring(13,15);
//        assertThat(assetsid).as("字段校验").isEqualTo("595");


    }
}
