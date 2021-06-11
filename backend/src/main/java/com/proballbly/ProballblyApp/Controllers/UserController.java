package com.proballbly.ProballblyApp.Controllers;

import com.proballbly.ProballblyApp.Entities.Role;
import com.proballbly.ProballblyApp.Entities.Roles;
import com.proballbly.ProballblyApp.Entities.User;
import com.proballbly.ProballblyApp.Entities.UserDetails;
import com.proballbly.ProballblyApp.Repositories.RoleRepository;
import com.proballbly.ProballblyApp.Repositories.UserDetailsRepository;
import com.proballbly.ProballblyApp.Repositories.UserRepository;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;
    private final RoleRepository roleRepository;

    public void addUsersAndDetails(){



    }

    @Autowired
    public UserController(UserRepository userRepository, UserDetailsRepository userDetailsRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/")
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @GetMapping("/{id}")
    @Nullable
    public User getUser(@PathVariable("id") Long id){
        Optional<User> optionalUser = userRepository.findById(id);

        return optionalUser.orElse(null);
    }

    @PutMapping(path = "/{id}/edit", consumes = "application/json")
    public ResponseEntity<String> editUserDetails(@RequestBody UserDetails details, @PathVariable("id") Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUserDetails(details);
            userRepository.save(user);
            return new ResponseEntity<>("User edited successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/", consumes = "application/json")
    public void addUser(@RequestBody User user){
        this.userRepository.save(user);
    }

    @PostMapping(path = "/details", consumes = "application/json")
    public void addUserDetails(@RequestBody User user){
        this.userRepository.save(user);
    }

    @GetMapping("/details")
    public List<UserDetails> getUserDetails(){
        List<UserDetails> users = new ArrayList<>();
        userDetailsRepository.findAll().forEach(users::add);
        return users;
    }

    @GetMapping("/roles")
    public List<Role> getRoles(){
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }

}
