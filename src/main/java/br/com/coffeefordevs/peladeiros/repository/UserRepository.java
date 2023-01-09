package br.com.coffeefordevs.peladeiros.repository;

import br.com.coffeefordevs.peladeiros.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
