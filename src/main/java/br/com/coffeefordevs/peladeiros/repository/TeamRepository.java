package br.com.coffeefordevs.peladeiros.repository;

import br.com.coffeefordevs.peladeiros.entity.TeamEntity;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<TeamEntity, Integer> {
}
