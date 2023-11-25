package com.example.registrationstudent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class Student {

    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
}
