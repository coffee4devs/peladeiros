package br.com.coffeefordevs.peladeiros.service;

import br.com.coffeefordevs.peladeiros.dto.PlayerDTO;
import br.com.coffeefordevs.peladeiros.dto.ReturnDTO;
import br.com.coffeefordevs.peladeiros.entity.PlayerEntity;
import br.com.coffeefordevs.peladeiros.enums.CodeEnum;
import br.com.coffeefordevs.peladeiros.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PeopleService peopleService;

    public ReturnDTO insertDTO(PlayerDTO playerDTO) {
        if(playerDTO != null) {
            if(!peopleService.existPeopleById(playerDTO.getIdPeople())) {
                return new ReturnDTO(
                        CodeEnum.PEOPLE_NOT_FOUND.getCod(),
                        CodeEnum.PEOPLE_NOT_FOUND.getMessage()
                );
            }
            PlayerEntity playerEntity = insert(new PlayerEntity(playerDTO.getIdPeople(), playerDTO.getInvited()));
            return new ReturnDTO(
                    CodeEnum.SUCCESS.getCod(),
                    CodeEnum.SUCCESS.getMessage()
            );
        }
        return null;
    }

    public List<PlayerDTO> findAllDTO() {
        List<PlayerDTO> dto = new ArrayList<>();
        for(PlayerEntity player : findAll()) {
            dto.add( new PlayerDTO(
                    player.getIdPeople(),
                    player.getInvited()
            ) );
        }
        return dto;
    }

    public PlayerDTO findDTOById(Integer id) {
        Optional<PlayerEntity> playerEntity = findById(id);
        return playerEntity.map(entity -> new PlayerDTO(
                entity.getIdPeople(),
                entity.getInvited()
        )).orElse(null);
    }

    public Iterable<PlayerEntity> findAll() {
        return playerRepository.findAll();
    }

    public Optional<PlayerEntity> findById(Integer id) {
        return playerRepository.findById(id);
    }

    public PlayerEntity insert(PlayerEntity playerEntity) {
        return playerRepository.save(playerEntity);
    }

}
