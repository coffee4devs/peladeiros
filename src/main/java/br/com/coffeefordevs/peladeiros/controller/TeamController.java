package br.com.coffeefordevs.peladeiros.controller;

import br.com.coffeefordevs.peladeiros.dto.ReturnDTO;
import br.com.coffeefordevs.peladeiros.dto.TeamDTO;
import br.com.coffeefordevs.peladeiros.enums.CodeEnum;
import br.com.coffeefordevs.peladeiros.service.PlayerService;
import br.com.coffeefordevs.peladeiros.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(TeamController.PATH)
public class TeamController {

    @Autowired
    private TeamService teamService;

    public static final String PATH = "/api/team";

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReturnDTO> insertPlayer(@RequestBody TeamDTO dto) {
        ReturnDTO insert = teamService.insertDTO(dto);
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
    public ResponseEntity<TeamDTO> getPeopleById(@PathVariable("id") Integer id) {
        TeamDTO dto = teamService.findDTOById(id);
        if(dto != null) {
            return ResponseEntity.ok(dto);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<TeamDTO>> getAllPlayers() {
        List<TeamDTO> dtoList = teamService.findAllDTO();
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
