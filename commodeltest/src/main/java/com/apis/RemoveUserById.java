package com.apis;

import com.utils.RequestUtils;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RemoveUserById {
    @Parameters("id")
    @Test
    public  void removeuserbyid(String id) throws IOException {

        List<BasicNameValuePair> param=new ArrayList<BasicNameValuePair>();
        param.add(new BasicNameValuePair("id",id));

        ResourceBundle resource = ResourceBundle.getBundle("url");
        String key = resource.getString("removeuserbyidurl");

        String result= RequestUtils.postRequest1(key,param);
        System.out.println(result);
    }
}
