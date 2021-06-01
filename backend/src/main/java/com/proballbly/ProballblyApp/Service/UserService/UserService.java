package com.proballbly.ProballblyApp.Service.UserService;

import com.proballbly.ProballblyApp.Entities.User;
import com.proballbly.ProballblyApp.Repositories.LogRepository;
import com.proballbly.ProballblyApp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final LogRepository logRepository;

    @Autowired
    public UserService(UserRepository userRepository, LogRepository logRepository){
        this.userRepository = userRepository;
        this.logRepository = logRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public LogRepository getLogRepository() {
        return logRepository;
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
    
}
