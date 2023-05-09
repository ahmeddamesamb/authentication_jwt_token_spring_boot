package br.com.security.service;

import br.com.security.model.Reservation;
import br.com.security.repository.ReservationRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ReservationServiceImpl implements ReservationService{
        private final ReservationRepository reservationRepository;
        private final ModelMapper modelMapper;

        public ReservationServiceImpl(ReservationRepository reservationRepository, ModelMapper modelMapper) {
            this.reservationRepository = reservationRepository;
            this.modelMapper = modelMapper;
        }

        @Override
        public List<Reservation> getAllReservation() {
            return reservationRepository.findAll();
        }

        @Override
        public Reservation createReservation(Reservation reservation) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            log.info("auth user:{}",auth);
            
            String username = auth.getName();
            log.info("auth username:{}",username);

            return reservationRepository.save(reservation);
        }

        @Override
        public Reservation updateReservation(long id, Reservation reservationRequest) {
            Reservation reservation = reservationRepository
                .findById(id)
                .orElseThrow(() ->
                    new RuntimeException(
                        "La tentative de mise a jour du user na pas aboutit"
                    )
                );
            reservation.setDateDepart(reservationRequest.getDateDepart());
            reservation.setDateArrivee(reservationRequest.getDateArrivee());
            reservation.setLieuArrivee(reservationRequest.getLieuArrivee());
            reservation.setLieuDepart(reservationRequest.getLieuDepart());
            return reservationRepository.save(reservation);
        }

        @Override
        public void deleteReservation(long id) {
            Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("la reservation que vous tenter de supprimer n existe pas"));
            reservationRepository.delete(reservation);
        }

        @Override
        public Reservation getReservationById(long id) {
            Optional<Reservation> result = reservationRepository.findById(id);
            if (result.isPresent()) {
                return result.get();
            } else {
                throw new ResourceNotFoundException("la reservation que vous checher n existe pas!!!");
            }    }
}
