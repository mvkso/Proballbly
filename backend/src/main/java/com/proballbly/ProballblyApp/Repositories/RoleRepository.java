package com.proballbly.ProballblyApp.Repositories;

import com.proballbly.ProballblyApp.Entities.Role;
import com.proballbly.ProballblyApp.Entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(Roles name);
}
