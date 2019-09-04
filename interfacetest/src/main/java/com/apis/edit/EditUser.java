package com.apis.edit;

import com.utils.AssertUtils;
import com.utils.RequestUtils;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import static org.assertj.core.api.Assertions.assertThat;

public class EditUser extends AssertUtils {
    @Parameters({"age","id","isDelete","password","permission","sex","userName"})
    @Test
    public void edituser(String age,String id,String isDelete,String password,String permission,String sex,String userName) throws IOException {
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
        String key = resource.getString("edituserurl");

        String result= RequestUtils.postRequest(key,str);
        System.out.println(result);

        //断言
        assertThat(result).contains("编辑成功");
        assertThat(result).contains("编辑成功").contains(userName);

//        String assetsid = result.substring(17,19);
//        assertThat(assetsid).as("字段校验").isEqualTo("619");

    }
}
