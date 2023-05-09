package br.com.security.service;

import br.com.security.model.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservation();

    Reservation createReservation(Reservation reservation);

    Reservation updateReservation(long id, Reservation reservation);

    void deleteReservation(long id);

    Reservation getReservationById(long id);
}
