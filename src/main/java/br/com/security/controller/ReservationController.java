package br.com.security.controller;

import br.com.security.dto.ReservationDto;
import br.com.security.model.Reservation;
import br.com.security.service.ReservationService;
import br.com.security.service.mapper.ReservationMapStruct;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/book_yonn/auth")
@CrossOrigin("*")
@Log4j2
public class ReservationController {
    private final ModelMapper modelMapper;
    private final ReservationService reservationService;
    private final ReservationMapStruct reservationMapStruct;

    public ReservationController(ModelMapper modelMapper, ReservationService reservationService, ReservationMapStruct reservationMapStruct) {
        this.modelMapper = modelMapper;
        this.reservationService = reservationService;
        this.reservationMapStruct = reservationMapStruct;
    }


    @GetMapping("/reservation")
    public List<ReservationDto> getAllReservation() {
        return reservationService.getAllReservation().stream().map(reservation->modelMapper.map(reservation,ReservationDto.class)).collect(Collectors.toList());
    }

    // *****************************END DELETE METHOD*****************************
    // *****************************ADD METHOD*****************************
    @PostMapping("/reservation")
    public ResponseEntity<ReservationDto> createReservation(@RequestBody ReservationDto reservationDto) {
        Reservation reservationResquest = reservationMapStruct.toEntity(reservationDto);
        Reservation reservation = reservationService.createReservation(reservationResquest);
        ReservationDto reservationResponse = reservationMapStruct.toDto(reservation);
        return ResponseEntity.ok().body(reservationResponse);
    }
    //GET USAGER & USERS BY ID

    @GetMapping("/reservation/{id}")
    public ResponseEntity<ReservationDto> getPassagerById(@PathVariable(name = "id") Long id) {
        Reservation reservation = reservationService.getReservationById(id);
        ReservationDto reservationResponse = reservationMapStruct.toDto(reservation);
        return ResponseEntity.ok().body(reservationResponse);

    }

    // *****************************UPDATE METHOD*****************************

    @PutMapping("/reservation/{id}")
    public ResponseEntity<ReservationDto> updatePassager(@PathVariable Long id, @RequestBody ReservationDto reservationDto) {
        log.info("id:{},reservationDto:{}", id, reservationDto);
        Reservation reservationResquest = reservationMapStruct.toEntity(reservationDto);
        Reservation reservation = reservationService.updateReservation(id, reservationResquest);
        ReservationDto reservationResponse = reservationMapStruct.toDto(reservation);
        return ResponseEntity.ok().body(reservationResponse);

    }
    // *****************************END UPDATE METHOD*****************************

    // *****************************DELETE METHOD*****************************

    @DeleteMapping("/reservation/{id}")
    public ResponseEntity<?> deleteConducteur(@PathVariable(name = "id") Long id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
