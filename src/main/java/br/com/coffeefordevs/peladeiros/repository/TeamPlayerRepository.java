package br.com.coffeefordevs.peladeiros.repository;

import br.com.coffeefordevs.peladeiros.entity.TeamPlayerEntity;
import org.springframework.data.repository.CrudRepository;

public interface TeamPlayerRepository extends CrudRepository<TeamPlayerEntity, Integer> {
}
