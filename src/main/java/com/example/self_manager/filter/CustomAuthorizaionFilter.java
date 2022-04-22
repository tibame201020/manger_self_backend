package com.example.self_manager.filter;

import com.example.self_manager.domain.Jwt;
//import com.example.self_manager.util.JwtProvider;
import com.example.self_manager.util.JwtProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.example.self_manager.constant.SecurityConstant.PASS_URLS;

public class CustomAuthorizaionFilter extends OncePerRequestFilter {

    private JwtProvider jwtProvider = new JwtProvider();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (isUrlCanPass(request)) {
            filterChain.doFilter(request, response);
        } else {
          String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
          if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
              String token = authorizationHeader.substring("Bearer ".length());
              Jwt jwt = jwtProvider.validToken(token);
              if (jwt.isExpire()) {
                  String account = jwt.getAccount();
                  Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                  UsernamePasswordAuthenticationToken authenticationToken =
                          new UsernamePasswordAuthenticationToken(account, null, authorities);
                  SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                  request.setAttribute("sub", account);
                  filterChain.doFilter(request, response);
              } else {
                  response.setHeader("error", jwt.getExceptionMsg());
                  response.setStatus(HttpStatus.FORBIDDEN.value());
                  Map<String, String> errorMsg = new HashMap<>();
                  errorMsg.put("error", jwt.getExceptionMsg());
                  response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                  new ObjectMapper().writeValue(response.getOutputStream(), errorMsg);
              }
          } else {
              filterChain.doFilter(request, response);
          }
        }
    }

    private boolean isUrlCanPass(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        return Arrays.asList(PASS_URLS).contains(servletPath);
    }
}
