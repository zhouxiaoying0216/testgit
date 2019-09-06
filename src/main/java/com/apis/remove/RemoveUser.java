package com.apis.remove;

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

public class RemoveUser extends AssertUtils {
    @Parameters({"age","id","isDelete","password","permission","sex","userName"})
    @Test
    public void removeuser(String age,String id,String isDelete,String password,String permission,String sex,String userName) throws IOException {
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
        String key = resource.getString("removeuserurl");

        String result= RequestUtils.postRequest(key,str);

        System.out.println(result);


        //断言
        assertThat(result).contains("删除成功");
        assertThat(result).contains("删除成功").contains(userName);

//        String assetsid = result.substring(12,14);
//        assertThat(assetsid).as("字段校验").isEqualTo("");



    }
}
