package br.com.security.service;

import br.com.security.model.Passager;
import br.com.security.repository.PassagerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassagerServiceImpl implements PassagerService{
    private final PassagerRepository passagerRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public PassagerServiceImpl(PassagerRepository passagerRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.passagerRepository = passagerRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Passager> getAllPassager() {
        return passagerRepository.findAll();
    }

    @Override
    public Passager createPassager(Passager passager) {
        passager.setPassword(passwordEncoder.encode(passager.getPassword()));
        return passagerRepository.save(passager);
    }

    @Override
    public Passager updatePassager(long id, Passager passagerRequest) {
        Passager passager = passagerRepository
            .findById(id)
            .orElseThrow(() ->
                new RuntimeException(
                    "La tentative de mise a jour du user na pas aboutit"
                )
            );
        passager.setNom(passagerRequest.getNom());
        passager.setEmail(passagerRequest.getEmail());
        passager.setAdresse(passagerRequest.getAdresse());
        passager.setImage(passagerRequest.getImage());
        passager.setNaissance(passagerRequest.getNaissance());
        passager.setPassword(passagerRequest.getPassword());
        passager.setPasswordConfirme(passagerRequest.getPasswordConfirme());
        passager.setTelephone(passagerRequest.getTelephone());
        return passagerRepository.save(passager);    }

    @Override
    public void deletePassager(long id) {
        Passager passager = passagerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("l'user que vous tenter de supprimer n existe pas"));
        passagerRepository.delete(passager);
    }

    @Override
    public Passager getPassagerById(long id) {
        Optional<Passager> result = passagerRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException("l'user que vous checher n existe pas!!!");
        }
    }
}
