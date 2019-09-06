package com.apis;

import com.apis.add.AddUser;
import com.apis.remove.RemoveUserById;
import org.testng.annotations.Factory;

public class FactoryTest {
    /*
    批量运行测试类
     */
    @Factory
    public Object[] factoryTest(){

        return new Object[]{

                new AddUser(),
//                new EditUser(),
//                new FindUser(),
//                new FindUserById(),
//                new FindUserJsonArrayToJsonString(),
//                new FindUserJsonToJsonString(),
//                new RemoveUser(),
                new RemoveUserById(),


        };

    }

}
