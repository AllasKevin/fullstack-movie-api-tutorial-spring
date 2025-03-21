package com.example.moviestutorial.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CredentialsDto {

    private String login;
    private char[] password;

}