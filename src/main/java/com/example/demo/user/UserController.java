package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/users")
    public List<User> index(){
        return userRepository.findAll();
    }

    @GetMapping("/api/users/{name}")
    public User show(@PathVariable("name") String name){
        return userRepository.findByUname(name);
    }
    @PostMapping("/api/users")
    public void create(@RequestBody User body){
        userRepository.save(body);
    }

    @PutMapping("/api/users/{id}")
    public void update(@PathVariable("id") String id, @RequestBody User body){
        User u = userRepository.findByUname(id);
        u.setUname(body.getUname());
        u.setNetworth(body.getNetworth());
        u.setPassword(body.getPassword());
    }

    @DeleteMapping("/api/users/{id}")
    public void delete(@PathVariable("id") int  id){
        userRepository.delete(id);;
        
    }


}
