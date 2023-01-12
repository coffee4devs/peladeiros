package br.com.coffeefordevs.peladeiros.utils.security;

import lombok.Data;

@Data
public class AuthCredentials {

    private String email;
    private String password;

}
