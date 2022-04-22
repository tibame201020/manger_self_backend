package com.example.self_manager.controller;

import com.example.self_manager.config.LineChannelConfig;
import com.example.self_manager.domain.LineAuthorization;
import com.example.self_manager.service.LineApi;
import com.example.self_manager.util.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private LineApi lineApi;
    @Autowired
    private JwtProvider jwtProvider;

    @RequestMapping("/wakeUp")
    public void wakeUp() {
    }

    @RequestMapping("/login")
    public String login() {
        return LineChannelConfig.getAccessUrl();
    }

    @RequestMapping("/getParam")
    public String getParam(@RequestBody String code) {
        LineAuthorization lineAuthorization = new LineAuthorization();
        lineAuthorization.setCode(code);
        return lineAuthorization.toString();
    }

    @RequestMapping("/getToken")
    public String getToken(@RequestBody String sub) {
        String accessToken = jwtProvider.getToken(sub, 1000 * 60 * 60 * 24, "manager_self");
        return accessToken;
    }


}
