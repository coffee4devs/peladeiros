package br.com.coffeefordevs.peladeiros.controller;

import br.com.coffeefordevs.peladeiros.dto.GameDTO;
import br.com.coffeefordevs.peladeiros.dto.ReturnDTO;
import br.com.coffeefordevs.peladeiros.enums.CodeEnum;
import br.com.coffeefordevs.peladeiros.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(GameController.PATH)
public class GameController {

    @Autowired
    private GameService gameService;

    public static final String PATH = "/api/game";

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReturnDTO> insertPlayer(@RequestBody GameDTO dto) {
        ReturnDTO insert = gameService.insertDTO(dto);
        if(insert != null) {
            if(insert.getCod() == CodeEnum.SUCCESS.getCod()) {
                return ResponseEntity.ok(insert);
            } else {
                return new ResponseEntity<>(insert, HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GameDTO> getPeopleById(@PathVariable("id") Integer id) {
        GameDTO dto = gameService.findDTOById(id);
        if(dto != null) {
            return ResponseEntity.ok(dto);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<GameDTO>> getAllPlayers() {
        List<GameDTO> dtoList = gameService.findAllDTO();
        if (dtoList != null) {
            if(dtoList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.ok(dtoList);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
