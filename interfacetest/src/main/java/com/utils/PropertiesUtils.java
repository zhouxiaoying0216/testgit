package com.utils;

import com.Enum.ApiEnum;
import com.Enum.HostEnum;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.Enum.HostEnum.HOST;

public class PropertiesUtils {

    /**
     * 在 choose_env.properties 文件中定义不同的“环境”：dev pre pro test1 test2
     * 先获取到环境，再从对应环境的配置文件（如：dev.properties）中获取具体的参数。
     * 这样做的好处是，测试环境与测试代码分离，切换环境仅修改配置文件即可。
     */
    private static String env_file="properties/env/choose_env";
    private static ResourceBundle resource = ResourceBundle.getBundle(env_file, Locale.CHINA);
    private static String env_value = resource.getString("env_config_file_name");


    private static String config_file="properties"+env_value;
    private static ResourceBundle resource1 = ResourceBundle.getBundle(config_file, Locale.CHINA);


    public static String getHost(HostEnum hostEnum){

        String host=null;

        switch (hostEnum){
            case HOST:
                host=resource1.getString("HOST");
                break;

                default:
                    host="getHost() error";
        }
         return host;
    }

    public static String getHost(){
        String host=resource1.getString("HOST");
        return host;
    }


    public static String getUrl(ApiEnum apiEnum){

        String url=null;

        switch (apiEnum){
            case addUser:
                url=resource1.getString("addUser");
                break;

            case editUser:
                url=resource1.getString("editUser");
                break;

            case findUser:
                url=resource1.getString("findUser");
                break;

            case findUserById:
                url=resource1.getString("findUserById");
                break;

            case findUser_JSONArray_toJSONString:
                url=resource1.getString("findUser_JSONArray_toJSONString");
                break;

            case findUser_JSON_toJSONString:
                url=resource1.getString("findUser_JSON_toJSONString");
                break;

            case removeUser:
                url=resource1.getString("removeUser");
                break;

            case removeUserById:
                url=resource1.getString("removeUserById");
                break;

                default:
                    url="getUrl() error";

        }

        return url;
    }

   public static String getUri(String urlkey){

        String url=resource1.getString(urlkey);
        return url;
   }

   public static String getApiUri(HostEnum hostEnum,ApiEnum apiEnum){
        String host=getHost(hostEnum);
        String url=getUrl(apiEnum);
        return host+url;
   }

   public static String getApiUrl(ApiEnum apiEnum){
        String host=getHost(HOST);
        String url=getUrl(apiEnum);
        return host+url;

   }
}

