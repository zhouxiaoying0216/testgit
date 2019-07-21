package com.apis;

import com.alibaba.fastjson.JSONObject;
import com.utils.RequestUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;



/**
 *
 */
public class AddUser {
    @Parameters({"age","isDelete","password","permission","sex","userName"})
    @Test
    public void adduser(String age,String isDelete,String password,String permission,String sex,String userName) throws Exception {


        Map<String,String> map=new HashMap();
        map.put("age","18");
        map.put("isDelete",isDelete);
        map.put("password",password);
        map.put("permission",permission);
        map.put("sex",sex);
        map.put("userName",userName);

        String str = JSONObject.toJSONString(map);
        ResourceBundle resource = ResourceBundle.getBundle("url");
        String key = resource.getString("adduserurl");
        String result= RequestUtils.postRequest(key,str);
        System.out.println(key);
        System.out.println(result);

    }
}
