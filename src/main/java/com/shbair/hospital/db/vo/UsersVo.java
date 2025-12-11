// omayma hamad 
// 252613
package com.shbair.hospital.db.vo;

import com.shbair.hospital.db.type.UsersType;

/**
 *
 * @author LCS
 */
public class UsersVo {
    private int id ;
    private String userName;
    private String password;
    private UsersType usersType;
    public String getPassword;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsersType getUsersType() {
        return usersType;
    }

    public void setUsersType(UsersType usersType) {
        this.usersType = usersType;
    }
    
}
