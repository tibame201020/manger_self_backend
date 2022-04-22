package com.example.self_manager.service;

import com.example.self_manager.domain.LineJwt;

public interface LineApi {
    LineJwt getLineJwt(String code);
}
