package br.com.security.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PassagerDto {
    private String password;
    private String nom;
    private String email;
    private String adresse;
    private String telephone;
    private Date naissance;
    private String image;
}
