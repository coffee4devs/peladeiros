package br.com.coffeefordevs.peladeiros.service;

import br.com.coffeefordevs.peladeiros.dto.GameDTO;
import br.com.coffeefordevs.peladeiros.dto.ReturnDTO;
import br.com.coffeefordevs.peladeiros.entity.GameEntity;
import br.com.coffeefordevs.peladeiros.enums.CodeEnum;
import br.com.coffeefordevs.peladeiros.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public ReturnDTO insertDTO(GameDTO dto) {
        if(dto != null) {
            if(insert(new GameEntity(dto.getDate(), dto.getName(),dto.getLocal())) != null) {
                return new ReturnDTO(
                        CodeEnum.SUCCESS.getCod(),
                        CodeEnum.SUCCESS.getMessage()
                );
            }
            return null;
        }
        return null;
    }

    public List<GameDTO> findAllDTO() {
        List<GameDTO> dto = new ArrayList<>();
        for(GameEntity entity : findAll()) {
            dto.add( new GameDTO(
                    entity.getDate(),
                    entity.getName(),
                    entity.getLocal()
            ) );
        }
        return dto;
    }

    public GameDTO findDTOById(Integer id) {
        Optional<GameEntity> playerEntity = findById(id);
        return playerEntity.map(entity -> new GameDTO(
                entity.getDate(),
                entity.getName(),
                entity.getLocal()
        )).orElse(null);
    }

    public GameEntity insert(GameEntity gameEntity) {
        return gameRepository.save(gameEntity);
    }

    public Iterable<GameEntity> findAll() {
        Iterable<GameEntity> gameEntities = gameRepository.findAll();
        return gameEntities;
    }

    public Optional<GameEntity> findById(Integer id) {
        Optional<GameEntity> gameEntity = gameRepository.findById(id);
        return gameEntity;
    }

}
