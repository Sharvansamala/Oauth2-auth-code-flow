package com.demo.auth_code_flow.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(OAuth2AuthenticationToken token) {

        DefaultOAuth2User user = (DefaultOAuth2User) token.getPrincipal();
        user.getAttributes().forEach((key, value) ->
                System.out.println(key + ": " + value)
        );
        return "Hello, " + user.getAttribute("name") + "! You are logged in with " + user.getAttribute("email")+" roles :" +
                user.getAuthorities().toString();
    }
}
