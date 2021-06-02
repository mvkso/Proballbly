package com.proballbly.ProballblyApp.Repositories;

import com.proballbly.ProballblyApp.Entities.Team;
import com.proballbly.ProballblyApp.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    Boolean existsByName(String name);

    Boolean existsByShortName(String shortName);

    Optional<User> findByName(String name);

}
