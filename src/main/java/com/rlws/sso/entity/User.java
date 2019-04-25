package com.rlws.sso.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class User implements Serializable {

    private int id;
    @NonNull
    private String email;
    private String username;
    private String password;
    private int sex;
    private String img;
    private String address;
    private Date birthday;

}