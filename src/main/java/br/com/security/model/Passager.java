package br.com.security.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@ToString
public class Passager extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(
        mappedBy = "passager",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Reservation> reservationList=new ArrayList<>();
}
