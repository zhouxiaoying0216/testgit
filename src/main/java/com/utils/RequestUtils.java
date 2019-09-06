package com.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class RequestUtils {
    public static String postRequest(String url, String str) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);

        httpPost.setHeader("Content-Type", "application/json");

        StringEntity reqentity = new StringEntity(str, "utf-8");

        httpPost.setEntity(reqentity);

        CloseableHttpResponse response = httpClient.execute(httpPost);

        if (response.getStatusLine().getStatusCode() != 200) {
            return "response error, status != 200";
        }

        String result = EntityUtils.toString(response.getEntity());

        return result;

    }

    public static String postRequest1(String url, List<BasicNameValuePair> str) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        HttpEntity reqentity = new UrlEncodedFormEntity(str);
        httpPost.setEntity(reqentity);

        CloseableHttpResponse response = httpClient.execute(httpPost);

        if (response.getStatusLine().getStatusCode() != 200) {
            return "response error, status != 200";
        }
        String result= EntityUtils.toString(response.getEntity());
        return result;
    }

}
