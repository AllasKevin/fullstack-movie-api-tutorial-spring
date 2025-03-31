package com.example.moviestutorial.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class SpaController {

    @RequestMapping(value = { "/"})
    public ResponseEntity<Resource> index() throws IOException {
        // Load index.html from the static folder
        Resource resource = new ClassPathResource("/static/index.html");
        if (!resource.exists()) {
            throw new IOException("index.html not found in /static folder");
        }
        return ResponseEntity
                .ok()
                .contentType(MediaType.TEXT_HTML)
                .body(resource);
    }
}
