package br.com.security.service.mapper;


import br.com.security.dto.UserDto;
import br.com.security.model.User;

public interface UserMapStruct {
    //Mappage d l entity Usager pour envoyer
    UserDto toDto(User user);
    //Mappage d l entity Usager pour retourner
    User toEntity(UserDto userDto);
}
