package br.com.security.controller;

import br.com.security.dto.PassagerDto;
import br.com.security.model.Passager;
import br.com.security.service.PassagerService;
import br.com.security.service.mapper.PassagerMapStruct;
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
public class PassagerController {
    private final ModelMapper modelMapper;
    private final PassagerService passagerService;
    private final PassagerMapStruct passagerMapStruct;

    public PassagerController(ModelMapper modelMapper, PassagerService passagerService, PassagerMapStruct passagerMapStruct) {
        this.modelMapper = modelMapper;
        this.passagerService = passagerService;
        this.passagerMapStruct = passagerMapStruct;
    }

    @GetMapping("/passager")
    public List<PassagerDto> getAllPassager() {
        return passagerService.getAllPassager().stream().map(passager->modelMapper.map(passager,PassagerDto.class)).collect(Collectors.toList());
    }

    // *****************************END DELETE METHOD*****************************
    // *****************************ADD METHOD*****************************
    @PostMapping("/passager")
    public ResponseEntity<PassagerDto> createPassager(@RequestBody PassagerDto passagerDto) {
        Passager passagerResquest = passagerMapStruct.toEntity(passagerDto);
        Passager passager = passagerService.createPassager(passagerResquest);
        PassagerDto passagerResponse = passagerMapStruct.toDto(passager);
        return ResponseEntity.ok().body(passagerResponse);
    }
    //GET USAGER & USERS BY ID

    @GetMapping("/passager/{id}")
    public ResponseEntity<PassagerDto> getPassagerById(@PathVariable(name = "id") Long id) {
        Passager passager = passagerService.getPassagerById(id);
        PassagerDto passagerResponse = passagerMapStruct.toDto(passager);
        return ResponseEntity.ok().body(passagerResponse);

    }

    // *****************************UPDATE METHOD*****************************

    @PutMapping("/passager/{id}")
    public ResponseEntity<PassagerDto> updatePassager(@PathVariable Long id, @RequestBody PassagerDto passagerDto) {
        log.info("id:{},passagerDto:{}", id, passagerDto);
        Passager passagerResquest = passagerMapStruct.toEntity(passagerDto);
        Passager passager = passagerService.updatePassager(id, passagerResquest);
        PassagerDto passagerResponse = passagerMapStruct.toDto(passager);
        return ResponseEntity.ok().body(passagerResponse);

    }
    // *****************************END UPDATE METHOD*****************************

    // *****************************DELETE METHOD*****************************

    @DeleteMapping("/passager/{id}")
    public ResponseEntity<?> deleteConducteur(@PathVariable(name = "id") Long id) {
        passagerService.deletePassager(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
