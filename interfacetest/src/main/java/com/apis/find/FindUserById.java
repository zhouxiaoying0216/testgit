package com.apis.find;

import com.utils.AssertUtils;
import com.utils.RequestUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static org.assertj.core.api.Assertions.assertThat;

public class FindUserById extends AssertUtils {
    @Parameters("id")
    @Test
    public  void finduserbyid(String id) throws IOException{

        List<BasicNameValuePair> param=new ArrayList<BasicNameValuePair>();
        param.add(new BasicNameValuePair("id",id));

        ResourceBundle resource = ResourceBundle.getBundle("url");
        String key = resource.getString("finduserbyidurl");

        String result= RequestUtils.postRequest1(key,param);

        System.out.println(result);//查询成功：UserInfo(id=619, userName=花花1, password=123321, age=18, sex=0, permission=0, isDelete=0)

        //断言
        assertThat(result).contains("查询成功");
        assertThat(result).contains("查询成功").contains(id);

//        String assetsid = result.substring(12,14);
//        assertThat(assetsid).as("字段校验").isEqualTo("595");
    }
}
