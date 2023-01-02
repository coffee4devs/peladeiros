package br.com.coffeefordevs.peladeiros.service;

import br.com.coffeefordevs.peladeiros.dto.ReturnDTO;
import br.com.coffeefordevs.peladeiros.dto.TeamPlayerDTO;
import br.com.coffeefordevs.peladeiros.entity.TeamEntity;
import br.com.coffeefordevs.peladeiros.entity.TeamPlayerEntity;
import br.com.coffeefordevs.peladeiros.enums.CodeEnum;
import br.com.coffeefordevs.peladeiros.repository.TeamPlayerRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamPlayerService {

    @Autowired
    private TeamPlayerRepository teamPlayerRepository;

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    public ReturnDTO insertDTO(TeamPlayerDTO dto) {
        ReturnDTO returnDTO = null;
        if(dto != null) {
            ReturnDTO returnValidations = validations(dto);
            if(returnValidations.getCod() == CodeEnum.SUCCESS.getCod()) {
                if(insert(new TeamPlayerEntity(dto.getIdTeam(), dto.getIdPlayer(), dto.getActive())) != null) {
                    returnDTO = new ReturnDTO(
                            CodeEnum.SUCCESS.getCod(),
                            CodeEnum.SUCCESS.getMessage()
                    );
                }
            } else {
                returnDTO = new ReturnDTO(
                        returnValidations.getCod(),
                        returnValidations.getMessage()
                );
            }
        }
        return returnDTO;
    }

    public List<TeamPlayerDTO> findAllDTO() {
        List<TeamPlayerDTO> dto = new ArrayList<>();
        for(TeamPlayerEntity entity : findAll()) {
            dto.add( new TeamPlayerDTO(
                    entity.getIdTeam(),
                    entity.getIdPlayer(),
                    entity.getActive()
            ) );
        }
        return dto;
    }

    public TeamPlayerDTO findDTOById(Integer id) {
        Optional<TeamPlayerEntity> playerEntity = findById(id);
        return playerEntity.map(entity -> new TeamPlayerDTO(
                entity.getIdTeam(),
                entity.getIdPlayer(),
                entity.getActive()
        )).orElse(null);
    }

    public TeamPlayerEntity insert(TeamPlayerEntity teamPlayerEntity) {
        return teamPlayerRepository.save(teamPlayerEntity);
    }

    public Iterable<TeamPlayerEntity> findAll() {
        Iterable<TeamPlayerEntity> teamPlayerEntities = teamPlayerRepository.findAll();
        return teamPlayerEntities;
    }

    public Optional<TeamPlayerEntity> findById(Integer id) {
        Optional<TeamPlayerEntity> teamPlayerEntity = teamPlayerRepository.findById(id);
        return teamPlayerEntity;
    }

    private ReturnDTO validations(TeamPlayerDTO dto) {
        if(dto != null) {
            if(teamService.findById(dto.getIdTeam()).isPresent()) {
                if(playerService.findById(dto.getIdPlayer()).isPresent()) {
                    return new ReturnDTO(
                            CodeEnum.SUCCESS.getCod(),
                            CodeEnum.SUCCESS.getMessage()
                    );
                } else {
                    return new ReturnDTO(
                            CodeEnum.PLAYER_NOT_FOUND.getCod(),
                            CodeEnum.PLAYER_NOT_FOUND.getMessage()
                    );
                }
            } else {
                return new ReturnDTO(
                        CodeEnum.TEAM_NOT_FOUND.getCod(),
                        CodeEnum.TEAM_NOT_FOUND.getMessage()
                );
            }
        }
        return null;
    }

}
