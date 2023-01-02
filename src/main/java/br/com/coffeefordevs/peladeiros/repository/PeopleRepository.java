package br.com.coffeefordevs.peladeiros.repository;

import br.com.coffeefordevs.peladeiros.entity.PeopleEntity;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<PeopleEntity, Integer> {
}
