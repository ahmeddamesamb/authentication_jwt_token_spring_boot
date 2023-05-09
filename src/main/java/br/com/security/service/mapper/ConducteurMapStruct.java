package br.com.security.service.mapper;

import br.com.security.dto.ConducteurDto;
import br.com.security.model.Conducteur;

public interface ConducteurMapStruct {
    //Mappage d l entity Usager pour envoyer
    ConducteurDto toDto(Conducteur conducteur);
    //Mappage d l entity Usager pour retourner
    Conducteur toEntity(ConducteurDto conducteurDto);
}
