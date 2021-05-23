package com.proballbly.ProballblyApp.Repositories;


import com.proballbly.ProballblyApp.Entities.UserDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails,Long> {
}
