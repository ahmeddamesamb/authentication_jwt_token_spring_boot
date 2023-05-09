package br.com.security.service;

import br.com.security.model.Conducteur;

import java.util.List;

public interface ConducteurService {
    List<Conducteur> getAllConducteur();

    Conducteur createConducteur(Conducteur conducteur);

    Conducteur updateConducteur(long id, Conducteur conducteur);

    void deleteConducteur(long id);

    Conducteur getConducteurById(long id);
}
