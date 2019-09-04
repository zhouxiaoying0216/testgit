package com.apis.remove;

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

public class RemoveUserById extends AssertUtils {
    @Parameters("id")
    @Test
    public  void removeuserbyid(String id) throws IOException {

        List<BasicNameValuePair> param=new ArrayList<BasicNameValuePair>();
        param.add(new BasicNameValuePair("id",id));

        ResourceBundle resource = ResourceBundle.getBundle("url");
        String key = resource.getString("removeuserbyidurl");

        String result= RequestUtils.postRequest1(key,param);

        System.out.println(result);//删除成功：UserInfo(id=619, userName=, password=123321, age=18, sex=0, permission=0, isDelete=0)

        //断言
        assertThat(result).contains("删除成功");
//        assertThat(result).contains("删除成功").contains(userName);
//        String assetsid = result.substring(9,11);
//        assertThat(assetsid).as("字段校验").isEqualTo("");
    }
}
