package br.com.security.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReservationDto {
    private String lieuDepart;
    private String lieuArrivee;
    private Date dateDepart;
    private Date dateArrivee;
    private int prix;
    private boolean paiement;
}
