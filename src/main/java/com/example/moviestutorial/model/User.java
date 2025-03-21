package com.example.moviestutorial.model;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {

    @Id
    private ObjectId id;

    @Size(min = 3, max = 100)
    private String firstName;

    @Size(min = 1, max = 100)
    private String lastName;

    @Size(min = 1, max = 100)
    private String login;

    @Size(min = 1, max = 100)
    private String password;
}
