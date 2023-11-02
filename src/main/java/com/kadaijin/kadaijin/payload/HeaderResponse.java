package com.kadaijin.kadaijin.payload;

import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import io.swagger.v3.oas.models.headers.Header;

public class HeaderResponse {

    public static HttpHeaders responseHeader(Object object) {

        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType mediaType = new MediaType("application", "json");


//        httpHeaders.add("application/json;","charset=UTF-8" );
//        httpHeaders.setContentType(mediaType);

//        response.setContentType("application/json; charset=UTF-8");

        return httpHeaders;

    }
}
