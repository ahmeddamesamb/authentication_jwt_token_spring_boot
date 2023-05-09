package br.com.security.controller;

import br.com.security.dto.ConducteurDto;
import br.com.security.model.Conducteur;
import br.com.security.service.ConducteurService;
import br.com.security.service.mapper.ConducteurMapStruct;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/book_yonn/auth")
@CrossOrigin("*")
@Log4j2
public class ConducteurController {
    private final ModelMapper modelMapper;
    private final ConducteurService conducteurService;
    private final ConducteurMapStruct conducteurMapStruct;

    public ConducteurController(ModelMapper modelMapper, ConducteurService conducteurService, ConducteurMapStruct conducteurMapStruct) {
        this.modelMapper = modelMapper;
        this.conducteurService = conducteurService;
        this.conducteurMapStruct = conducteurMapStruct;
    }

    @GetMapping("/conducteur")
    public List<ConducteurDto> getAllConducteur() {
        return conducteurService.getAllConducteur().stream().map(conducteur->modelMapper.map(conducteur,ConducteurDto.class)).collect(Collectors.toList());
    }

    // *****************************END DELETE METHOD*****************************
    // *****************************ADD METHOD*****************************
    @PostMapping("/conducteur")
    public ResponseEntity<ConducteurDto> createConducteur(@RequestBody ConducteurDto conducteurDto) {
        Conducteur conducteurResquest = conducteurMapStruct.toEntity(conducteurDto);
        Conducteur conducteur = conducteurService.createConducteur(conducteurResquest);
        ConducteurDto conducteurResponse = conducteurMapStruct.toDto(conducteur);
        return ResponseEntity.ok().body(conducteurResponse);
    }
    //GET USAGER & USERS BY ID

    @GetMapping("/conducteur/{id}")
    public ResponseEntity<ConducteurDto> getUserById(@PathVariable(name = "id") Long id) {
        Conducteur conducteur = conducteurService.getConducteurById(id);
        ConducteurDto conducteurResponse = conducteurMapStruct.toDto(conducteur);
        return ResponseEntity.ok().body(conducteurResponse);

    }

    // *****************************UPDATE METHOD*****************************

    @PutMapping("/conducteur/{id}")
    public ResponseEntity<ConducteurDto> updateUser(@PathVariable Long id, @RequestBody ConducteurDto conducteurDto) {
        log.info("id:{},userDto:{}", id, conducteurDto);
        Conducteur conducteurResquest = conducteurMapStruct.toEntity(conducteurDto);
        Conducteur conducteur = conducteurService.updateConducteur(id, conducteurResquest);
        ConducteurDto conducteurResponse = conducteurMapStruct.toDto(conducteur);
        return ResponseEntity.ok().body(conducteurResponse);

    }
    // *****************************END UPDATE METHOD*****************************

    // *****************************DELETE METHOD*****************************

    @DeleteMapping("/conducteur/{id}")
    public ResponseEntity<?> deleteConducteur(@PathVariable(name = "id") Long id) {
        conducteurService.deleteConducteur(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
