package com.proballbly.ProballblyApp.Repositories;

import com.proballbly.ProballblyApp.Entities.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<Log,Long> {
}
