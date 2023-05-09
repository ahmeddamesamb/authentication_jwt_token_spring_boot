package br.com.security.service.mapper;

import br.com.security.dto.ConducteurDto;
import br.com.security.model.Conducteur;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ConducteurMapStructImpl implements ConducteurMapStruct{
    private final ModelMapper modelMapper;

    public ConducteurMapStructImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public ConducteurDto toDto(Conducteur conducteur) {
        ConducteurDto conducteurDto = modelMapper.map(conducteur, ConducteurDto.class);
        return conducteurDto;
    }

    @Override
    public Conducteur toEntity(ConducteurDto conducteurDto) {
        //utiliser pour les Method Post pour envoyer les donnes
        Conducteur conducteur = modelMapper.map(conducteurDto, Conducteur.class);
        return conducteur;
    }
}
