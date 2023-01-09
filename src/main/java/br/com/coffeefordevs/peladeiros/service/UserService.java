package br.com.coffeefordevs.peladeiros.service;

import br.com.coffeefordevs.peladeiros.dto.ReturnDTO;
import br.com.coffeefordevs.peladeiros.dto.UserDTO;
import br.com.coffeefordevs.peladeiros.dto.UserDTO;
import br.com.coffeefordevs.peladeiros.entity.UserEntity;
import br.com.coffeefordevs.peladeiros.entity.UserEntity;
import br.com.coffeefordevs.peladeiros.enums.CodeEnum;
import br.com.coffeefordevs.peladeiros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ReturnDTO insertDTO(UserDTO dto) {
        if(dto != null) {
            UserEntity playerEntity = insert(new UserEntity(dto.getIdPeople(), dto.getPassword()));
            return new ReturnDTO(
                    CodeEnum.SUCCESS.getCod(),
                    CodeEnum.SUCCESS.getMessage()
            );
        }
        return null;
    }

    public List<UserDTO> findAllDTO() {
        List<UserDTO> dto = new ArrayList<>();
        for(UserEntity entity : findAll()) {
            dto.add( new UserDTO(
                    entity.getIdPeople(),
                    entity.getPassword()
            ) );
        }
        return dto;
    }

    public UserDTO findDTOById(Integer id) {
        Optional<UserEntity> userEntity = findById(id);
        return userEntity.map(entity -> new UserDTO(
                entity.getIdPeople(),
                entity.getPassword()
        )).orElse(null);
    }

    public UserEntity insert(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public Iterable<UserEntity> findAll() {
        Iterable<UserEntity> userEntities = userRepository.findAll();
        return userEntities;
    }

    public Optional<UserEntity> findById(Integer id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity;
    }

}
