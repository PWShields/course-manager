package com.puffinpowered.coursemanager.security;

/**
 * Created by pshields on 28/10/2016.
 *
 * Url paths to avoid hard coding strings
 * where we need to specify an internal path such
 * as for security config
 *
 */
public enum UrlPath {
    ADMIN_ACCESS_REQUIRED_PATH("/admin/**"),
    LOGIN_PATH("/login"),
    DEFAULT_LOGIN_SUCCESS("/home"),
    LOGIN_FAILURE_PATH("/login-error");

    private String value;

    UrlPath(String path){
        value = path;
    }

    public String value(){
        return value;
    }
}
