package com.example.self_manager.domain;

import java.io.Serializable;

import static com.example.self_manager.config.LineChannelConfig.CHANNEL_ID;
import static com.example.self_manager.config.LineChannelConfig.CHANNEL_ID_SECRET;
import static com.example.self_manager.config.LineChannelConfig.REDIRECT_URI;

public class LineAuthorization implements Serializable {
    private String grant_type = "authorization_code";
    private String code;
    private String redirect_uri = REDIRECT_URI;
    private String client_id = CHANNEL_ID;
    private String client_secret = CHANNEL_ID_SECRET;

    public void setCode(String code) {
        this.code = code;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getCode() {
        return code;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    @Override
    public String toString() {
        return "grant_type=" + grant_type +
                "&code=" + code +
                "&redirect_uri=" + redirect_uri +
                "&client_id=" + client_id +
                "&client_secret=" + client_secret;
    }
}
