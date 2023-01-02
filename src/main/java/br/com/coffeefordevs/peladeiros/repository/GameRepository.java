package br.com.coffeefordevs.peladeiros.repository;

import br.com.coffeefordevs.peladeiros.entity.GameEntity;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<GameEntity, Integer> {
}
