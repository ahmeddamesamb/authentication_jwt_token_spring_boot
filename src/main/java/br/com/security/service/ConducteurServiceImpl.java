package br.com.security.service;

import br.com.security.model.Conducteur;
import br.com.security.repository.ConducteurRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConducteurServiceImpl implements ConducteurService{
    private final ConducteurRepository conducteurRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public ConducteurServiceImpl(ConducteurRepository conducteurRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.conducteurRepository = conducteurRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Conducteur> getAllConducteur() {
        return conducteurRepository.findAll();
    }

    @Override
    public Conducteur createConducteur(Conducteur conducteur) {
        conducteur.setPassword(passwordEncoder.encode(conducteur.getPassword()));
        return conducteurRepository.save(conducteur);
    }

    @Override
    public Conducteur updateConducteur(long id, Conducteur conducteurRequest) {
        Conducteur conducteur = conducteurRepository
            .findById(id)
            .orElseThrow(() ->
                new RuntimeException(
                    "La tentative de mise a jour du user na pas aboutit"
                )
            );
        conducteur.setNom(conducteurRequest.getNom());
        conducteur.setEmail(conducteurRequest.getEmail());
        conducteur.setAdresse(conducteurRequest.getAdresse());
        conducteur.setImage(conducteurRequest.getImage());
        conducteur.setNaissance(conducteurRequest.getNaissance());
        conducteur.setPassword(conducteurRequest.getPassword());
        conducteur.setPasswordConfirme(conducteurRequest.getPasswordConfirme());
        conducteur.setTelephone(conducteurRequest.getTelephone());
        conducteur.setCouleurVoiture(conducteurRequest.getCouleurVoiture());
        conducteur.setNumeropermis(conducteurRequest.getNumeropermis());
        conducteur.setNumeroSerie(conducteurRequest.getNumeroSerie());
        conducteur.setScanPermis(conducteurRequest.getScanPermis());

        return conducteurRepository.save(conducteur);
    }

    @Override
    public void deleteConducteur(long id) {
        Conducteur conducteur = conducteurRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("l'user que vous tenter de supprimer n existe pas"));
        conducteurRepository.delete(conducteur);
    }

    @Override
    public Conducteur getConducteurById(long id) {
        Optional<Conducteur> result = conducteurRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException("l'user que vous checher n existe pas!!!");
        }
    }
}
