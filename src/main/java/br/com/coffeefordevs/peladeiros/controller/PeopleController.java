package br.com.coffeefordevs.peladeiros.controller;

import br.com.coffeefordevs.peladeiros.dto.PeopleDTO;
import br.com.coffeefordevs.peladeiros.repository.PeopleRepository;
import br.com.coffeefordevs.peladeiros.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PeopleController.PATH)
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    public static final String PATH = "/api/people";
    @Autowired
    private PeopleRepository peopleRepository;

    @PostMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PeopleDTO> getPeopleById(@PathVariable("id") Integer id) {
        PeopleDTO peopleDTO = peopleService.findDTOById(id);
        if(peopleDTO != null) {
            return ResponseEntity.ok(peopleDTO);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PeopleDTO> insertPeople(@RequestBody PeopleDTO peopleDTO) {
        PeopleDTO insert = peopleService.insertDTO(peopleDTO);
        if(insert != null) {
            return ResponseEntity.ok(insert);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<PeopleDTO>> getAllPeople() {
        List<PeopleDTO> peopleDTOList = peopleService.findAllDTO();
        if (peopleDTOList != null) {
            if(peopleDTOList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.ok(peopleDTOList);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


}
