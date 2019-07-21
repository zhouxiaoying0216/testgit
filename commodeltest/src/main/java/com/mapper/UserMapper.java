package com.mapper;

import com.model.UserInfo;

public interface UserMapper {
    public void addUserInfo(UserInfo userinfo);

    public void deleteUserInfo(UserInfo userinfo);

    public void  deleteUserById(int id);

    public void updateUserInfoById(UserInfo userinfo);

    public UserInfo findUserInfo(UserInfo userinfo);

    public UserInfo getUserInfoById(int id);

}
