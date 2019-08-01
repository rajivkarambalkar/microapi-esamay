package com.esamay.domain;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phoneNumber;
}
