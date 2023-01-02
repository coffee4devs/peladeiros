package br.com.coffeefordevs.peladeiros.service;

import br.com.coffeefordevs.peladeiros.dto.ReturnDTO;
import br.com.coffeefordevs.peladeiros.dto.TeamDTO;
import br.com.coffeefordevs.peladeiros.entity.TeamEntity;
import br.com.coffeefordevs.peladeiros.enums.CodeEnum;
import br.com.coffeefordevs.peladeiros.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public ReturnDTO insertDTO(TeamDTO dto) {
        if(dto != null) {
            TeamEntity playerEntity = insert(new TeamEntity(dto.getName()));
            return new ReturnDTO(
                    CodeEnum.SUCCESS.getCod(),
                    CodeEnum.SUCCESS.getMessage()
            );
        }
        return null;
    }

    public List<TeamDTO> findAllDTO() {
        List<TeamDTO> dto = new ArrayList<>();
        for(TeamEntity entity : findAll()) {
            dto.add( new TeamDTO(
                    entity.getName()
            ) );
        }
        return dto;
    }

    public TeamDTO findDTOById(Integer id) {
        Optional<TeamEntity> playerEntity = findById(id);
        return playerEntity.map(entity -> new TeamDTO(
                entity.getName()
        )).orElse(null);
    }

    public TeamEntity insert(TeamEntity teamEntity) {
        return teamRepository.save(teamEntity);
    }

    public Iterable<TeamEntity> findAll() {
        Iterable<TeamEntity> teamEntities = teamRepository.findAll();
        return teamEntities;
    }

    public Optional<TeamEntity> findById(Integer id) {
        Optional<TeamEntity> teamEntity = teamRepository.findById(id);
        return teamEntity;
    }

}
