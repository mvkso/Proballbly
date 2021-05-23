package com.proballbly.ProballblyApp.Controllers;

import com.proballbly.ProballblyApp.Entities.User;
import com.proballbly.ProballblyApp.Entities.UserDetails;
import com.proballbly.ProballblyApp.Repositories.UserRepository;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
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

}
