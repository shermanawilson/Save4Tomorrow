package com.save4tomorrow.save4tomorrow.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIController {
    @Value("af490826bd781f8c6df4775c5164833f")
    private String WeatherAPI;

    @Value("AIzaSyC3Q0K6kAG0qce-oA4DnCMtrth7fI1iuuc")
    private String YoutubeAPI;

    @Override
    public String toString() {
        return "APIController{" +
                "WeatherAPI='" + WeatherAPI + '\'' +
                ", YoutubeAPI='" + YoutubeAPI + '\'' +
                '}';
    }

    @RequestMapping(path = "/keys.js")
    @ResponseBody
    public String apiKeys() {
        System.out.println(WeatherAPI);
        return "const WeatherAPI = `" + WeatherAPI + "`;\n const YoutubeAPI = `" + YoutubeAPI + "`; ";
    }


}
