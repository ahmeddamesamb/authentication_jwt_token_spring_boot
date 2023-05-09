package br.com.security.service.mapper;

import br.com.security.dto.UserDto;
import br.com.security.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserMapStructImpl implements UserMapStruct{
    private final ModelMapper modelMapper;

    public UserMapStructImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto toDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
        //utiliser pour les Method Get pour recuper les donnes
    }

    @Override
    public User toEntity(UserDto userDto) {
        //utiliser pour les Method Post pour envoyer les donnes
        User user = modelMapper.map(userDto, User.class);
        return user;
    }
}
