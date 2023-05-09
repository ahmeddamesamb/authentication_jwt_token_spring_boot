package br.com.security.service.mapper;

import br.com.security.dto.PassagerDto;
import br.com.security.model.Passager;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PassagerMapStructImpl implements PassagerMapStruct{
    private final ModelMapper modelMapper;

    public PassagerMapStructImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PassagerDto toDto(Passager passager) {
        PassagerDto passagerDto = modelMapper.map(passager, PassagerDto.class);
        return passagerDto;
    }

    @Override
    public Passager toEntity(PassagerDto passagerDto) {
        //utiliser pour les Method Post pour envoyer les donnes
        Passager passager = modelMapper.map(passagerDto, Passager.class);
        return passager;
    }
}
