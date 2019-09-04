package com.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

import java.util.*;

public class AssertUtils {



    /*
    根据key读取对应value
     */
    public static String getValue(String json, String key) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        String str = JSONPath.eval(jsonObject, key).toString();
        return str;
    }





    }

