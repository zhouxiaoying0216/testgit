package com.apis.find;

import com.alibaba.fastjson.JSON;
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

public class FindUserJsonToJsonString extends AssertUtils {
    @Parameters({"age","id","isDelete","password","permission","sex","userName"})
    @Test
    public void finduserjsontojsonstring(String age,String id,String isDelete,String password,String permission,String sex,String userName) throws IOException {
        Map<String,String> map=new HashMap();
        map.put("age",age);
        map.put("id",id);
        map.put("isDelete",isDelete);
        map.put("password",password);
        map.put("permission",permission);
        map.put("sex",sex);
        map.put("userName",userName);
        String str = JSONObject.toJSONString(map);

        ResourceBundle resource = ResourceBundle.getBundle("url");
        String key = resource.getString("findUser_json_tojsonstringurl");

        String result= RequestUtils.postRequest(key,str);

        System.out.println(result);//{"age":"18","id":612,"isDelete":"0","password":"123321","permission":"0","sex":"0","userName":""}


        //断言
        assertThat(result).contains("添加成功");
        assertThat(result).contains("添加成功").contains(userName);

//        JSONObject jsonObject= JSON.parseObject(result);      //转换成object
//        String assertage=jsonObject.getString("age");


////        String assertage=getValue(result,age);
//        System.out.println("jsonObject"+jsonObject);
//        System.out.println("age:"+age);
//        assertThat(assertage).as("字段校验").isEqualTo("1");

    }
}
