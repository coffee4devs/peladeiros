package br.com.coffeefordevs.peladeiros.controller;

import br.com.coffeefordevs.peladeiros.dto.PlayerDTO;
import br.com.coffeefordevs.peladeiros.dto.ReturnDTO;
import br.com.coffeefordevs.peladeiros.enums.CodeEnum;
import br.com.coffeefordevs.peladeiros.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PlayerController.PATH)
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    public static final String PATH = "/api/player";

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReturnDTO> insertPlayer(@RequestBody PlayerDTO playerDTO) {
        ReturnDTO insert = playerService.insertDTO(playerDTO);
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
    public ResponseEntity<PlayerDTO> getPeopleById(@PathVariable("id") Integer id) {
        PlayerDTO playerDTO = playerService.findDTOById(id);
        if(playerDTO != null) {
            return ResponseEntity.ok(playerDTO);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
        List<PlayerDTO> playerDTOList = playerService.findAllDTO();
        if (playerDTOList != null) {
            if(playerDTOList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.ok(playerDTOList);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
