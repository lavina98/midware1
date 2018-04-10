package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/users")
    public List<User> index(){
        return userRepository.findAll();
    }

    @GetMapping("/api/users/{id}")
    public User show(@PathVariable("id") int id){
        return userRepository.findOne(id);
    }
    @PostMapping("/api/users")
    public void create(@RequestBody User body){
        userRepository.save(body);
    }

    @PutMapping("/api/users/{id}")
    public void update(@PathVariable("id") int id, @RequestBody User body){
        User u = userRepository.findOne(id);
        u.setUname(body.getUname());
        u.setNetworth(body.getNetworth());
        u.setPassword(body.getPassword());
    }

    @DeleteMapping("/api/users/{id}")
    public void delete(@PathVariable("id") int  id){
        userRepository.delete(id);;
        
    }


}
