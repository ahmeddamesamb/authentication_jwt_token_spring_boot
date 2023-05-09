package br.com.security.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String lieuDepart;
    @Column
    private String lieuArrivee;
    @Column
    private Date dateDepart;
    @Column
    private Date dateArrivee;
    @Column
    private int prix;
    @Column
    private boolean paiement;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passager_id")
    private Passager passager;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conducteur_id")
    private Conducteur conducteur;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    private User user;
}
