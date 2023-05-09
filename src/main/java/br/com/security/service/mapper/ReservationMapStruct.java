package br.com.security.service.mapper;

import br.com.security.dto.ReservationDto;
import br.com.security.model.Reservation;

public interface ReservationMapStruct {
    //Mappage d l entity Usager pour envoyer
    ReservationDto toDto(Reservation reservation);
    //Mappage d l entity Usager pour retourner
    Reservation toEntity(ReservationDto reservationDto);
}
