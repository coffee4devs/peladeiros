package br.com.coffeefordevs.peladeiros.controller;

import br.com.coffeefordevs.peladeiros.dto.ReturnDTO;
import br.com.coffeefordevs.peladeiros.dto.TeamPlayerDTO;
import br.com.coffeefordevs.peladeiros.enums.CodeEnum;
import br.com.coffeefordevs.peladeiros.service.TeamPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(TeamPlayerController.PATH)
public class TeamPlayerController {

    public static final String PATH = "/api/teamplayer";

    @Autowired
    private TeamPlayerService teamPlayerService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReturnDTO> insertPlayer(@RequestBody TeamPlayerDTO dto) {
        ReturnDTO insert = teamPlayerService.insertDTO(dto);
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
    public ResponseEntity<TeamPlayerDTO> getPeopleById(@PathVariable("id") Integer id) {
        TeamPlayerDTO dto = teamPlayerService.findDTOById(id);
        if(dto != null) {
            return ResponseEntity.ok(dto);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<TeamPlayerDTO>> getAllPlayers() {
        List<TeamPlayerDTO> dtoList = teamPlayerService.findAllDTO();
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
