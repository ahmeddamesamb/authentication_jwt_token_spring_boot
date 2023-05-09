package br.com.security.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@ToString
public class Conducteur extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String numeropermis;
    @Column
    private String numeroSerie;
    @Column
    private String scanPermis;
    @Column
    private String couleurVoiture;
    @OneToMany(
        mappedBy = "conducteur",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Reservation> reservationList=new ArrayList<>();

}
