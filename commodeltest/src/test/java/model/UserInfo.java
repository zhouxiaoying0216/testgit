package model;

import lombok.Data;

@Data
public class UserInfo {

    private int id;
    private String username;
    private String password;
    private int age;
    private String sex;
    private String permission;
    private String isDelete;

}
