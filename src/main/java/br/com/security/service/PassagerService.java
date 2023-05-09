package br.com.security.service;

import br.com.security.model.Passager;

import java.util.List;

public interface PassagerService {
    List<Passager> getAllPassager();

    Passager createPassager(Passager passager);

    Passager updatePassager(long id, Passager passager);

    void deletePassager(long id);

    Passager getPassagerById(long id);
}
