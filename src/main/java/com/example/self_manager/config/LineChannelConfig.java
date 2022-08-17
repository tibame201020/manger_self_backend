package com.example.self_manager.config;

public class LineChannelConfig {

    public static final String CHANNEL_ID = "1657065757";
    public static final String CHANNEL_ID_SECRET = "7461f90ef413c1969b01cfe4e7bb14c4";
    public static final String BASE_ACCESS_URL = "https://access.line.me/oauth2/v2.1/authorize";
    public static final String QUERY_PARAM = "?response_type=code&client_id=%s&redirect_uri=%s&state=%s&scope=%s";
    public static final String REDIRECT_URI = "https://tibame201020.github.io/manager_self/user/login";
    public static final String GET_TOKEN_URL = "https://api.line.me/oauth2/v2.1/token";

    public static String getAccessUrl () {
        return String.format(BASE_ACCESS_URL + QUERY_PARAM, CHANNEL_ID, REDIRECT_URI, "State", "profile%20openid");
    }

}
