package com.example.self_manager.constant;

public class SecurityConstant {
    public static final String WAKE_UP_URL = "/api/wakeUp";
    public static final String LOGIN_URL = "/api/login";
    public static final String GET_PARAM_URL = "/api/getParam";
    public static final String GET_TOKEN_URL = "/api/getToken";
    public static final String[] PASS_URLS =
            new String[] { WAKE_UP_URL, LOGIN_URL,GET_PARAM_URL , GET_TOKEN_URL };
    public static final String FRONT_END_URL = "https://tibame201020.github.io/manager_self";
    public static final String FRONT_END_URL2 = "http://localhost:4200";

    public static final String VALID_SUCCESSFUL_MSG = "the token is valid";
    public static final String VALID_UNSUCCESSFUL_EXPIRED_MSG = "the token has Expired";
    public static final String VALID_UNSUCCESSFUL_UN_VALID_MSG = "the token is un-valid";
    public static final String TOKEN_CAN_NOT_VERIFY =  "the token can not be verify";


}
