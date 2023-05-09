package br.com.security.service.mapper;

import br.com.security.dto.PassagerDto;
import br.com.security.model.Passager;

public interface PassagerMapStruct {
    //Mappage d l entity Usager pour envoyer
    PassagerDto toDto(Passager passager);
    //Mappage d l entity Usager pour retourner
    Passager toEntity(PassagerDto passagerDto);
}
