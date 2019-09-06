package com.apis.add;

import com.Enum.ApiEnum;
import com.alibaba.fastjson.JSONObject;
import com.utils.PropertiesUtils;
import com.utils.RequestUtils;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author zhouxiaoying
 */
public class AddUser {

    @Parameters({"age","isDelete","password","permission","sex","userName"})
    @Test
    public void adduser(String age,String isDelete,String password,String permission,String sex,String userName) throws Exception {

        String url = PropertiesUtils.getApiUrl(ApiEnum.addUser);

        Map<String,String> map=new HashMap();
        map.put("age",age);
        map.put("isDelete",isDelete);
        map.put("password",password);
        map.put("permission",permission);
        map.put("sex",sex);
        map.put("userName",userName);

        String str = JSONObject.toJSONString(map);

//        ResourceBundle resource = ResourceBundle.getBundle("sit1");
////        String key = resource.getString("adduserurl");

        String result= RequestUtils.postRequest(url,str);


        System.out.println(result);
        Reporter.log("返回结果为");


        //断言
          assertThat(result).contains("添加成功");
          assertThat(result).contains("添加成功").contains(userName);
//        String assetsid = result.substring(17,18);
//        assertThat(assetsid).as("字段校验").isEqualTo("0");

    }
}
