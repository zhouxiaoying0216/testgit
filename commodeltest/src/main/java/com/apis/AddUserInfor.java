package com.apis;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class AddUserInfor {
    public static void main(String[] args) throws Exception{
        CloseableHttpClient httpClient= HttpClients.createDefault();//http://localhost:1111/v1/addUserInfoRequestBody
        try{
        HttpPost httpPost=new HttpPost("http://localhost:1111/v1/addUserInfoRequestBody");
        httpPost.setHeader("Content-Type","application/json; charset=UTF-8");
//        httpPost.setHeader("Accept","*/*");
        List<NameValuePair> nvps =new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("age","18"));
        nvps.add(new BasicNameValuePair("id","1000"));
        nvps.add(new BasicNameValuePair("isDelete","0"));
        nvps.add(new BasicNameValuePair("password","1234"));
        nvps.add(new BasicNameValuePair("permission","1"));
        nvps.add(new BasicNameValuePair("sex","女"));
        nvps.add(new BasicNameValuePair("userName","哲哲"));
        httpPost.setEntity((new UrlEncodedFormEntity(nvps)));
        CloseableHttpResponse response=httpClient.execute(httpPost);

        try{
            System.out.println(response.getStatusLine());
            System.out.println("返回结果为"+response);
            HttpEntity entity=response.getEntity();
            EntityUtils.consume(entity);
        }finally {
            response.close();
        }

    }finally {
            httpClient.close();
        }
        }
}
