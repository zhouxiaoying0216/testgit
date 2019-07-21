package com.apis;

import com.utils.RequestUtils;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class FindUserJsonToJsonString {
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
        System.out.println(result);




    }
}
