package com.github.nkzawa.socketio.androidchat;

import java.io.Serializable;

/**
 * LoginRequest
 *
 * @author jasonhongcn
 * @version 1.0
 * @since 2018/1/18
 */
public class LoginRequest implements Serializable {

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

    private String userName;
    private String password;
    private int code;
    private String body;

    public LoginRequest() {
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "code=" + code +
                ", body='" + body + '\'' +
                '}';
    }

    public LoginRequest(int code, String body) {
        super();
        this.code = code;
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
