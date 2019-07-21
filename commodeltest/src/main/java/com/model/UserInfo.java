package com.model;

public class UserInfo {
    private int id;
    private String username;
    private String password;
    private int age;
    private String sex;
    private String permission;
    private String isDelete;

    public void setIsDelete(String isDelete)
    {
        this.isDelete = isDelete;
    }

    public void setPermission(String permission)
    {
        this.permission = permission;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setUserName(String userName)
    {
        this.username = userName;
    }

    public String toString()
    {
        return "UserInfo(id=" + getId() + ", userName=" + getUserName() + ", password=" + getPassword() + ", age=" + getAge() + ", sex=" + getSex() + ", permission=" + getPermission() + ", isDelete=" + getIsDelete() + ")";
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getId()
    {
        return id;
    }

    public String getUserName()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public Integer getAge()
    {
        return age;
    }

    public String getSex()
    {
        return sex;
    }

    public String getPermission()
    {
        return this.permission;
    }

    public String getIsDelete()
    {
        return this.isDelete;
    }

}
