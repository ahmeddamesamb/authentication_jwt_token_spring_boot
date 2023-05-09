package br.com.security.service.mapper;

import br.com.security.dto.ReservationDto;
import br.com.security.model.Reservation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ReservationMapStructImpl implements ReservationMapStruct{
    private final ModelMapper modelMapper;

    public ReservationMapStructImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ReservationDto toDto(Reservation reservation) {
        ReservationDto reservationDto = modelMapper.map(reservation, ReservationDto.class);
        return reservationDto;     }

    @Override
    public Reservation toEntity(ReservationDto reservationDto) {
        //utiliser pour les Method Post pour envoyer les donnes
        Reservation reservation = modelMapper.map(reservationDto, Reservation.class);
        return reservation;     }
}
