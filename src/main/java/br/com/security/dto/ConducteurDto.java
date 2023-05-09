package br.com.security.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ConducteurDto {
    private String password;
    private String nom;
    private String email;
    private String adresse;
    private String telephone;
    private Date naissance;
    private String image;
    private String numeropermis;
    private String numeroSerie;
    private String scanPermis;
    private String couleurVoiture;
}
