package com.example.demo.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {

	@Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/api/users/{uid}/transactions")
    public List<Transaction> index(@PathVariable("uid") int id){
        return  transactionRepository.findByUserId(id);
    }

    @GetMapping("/api/users/{uid}/transactions/{id}")
    public  Transaction show(@PathVariable("id") int id){
        return transactionRepository.findOne(id);
    }
    @PostMapping("/api/users/{uid}/transactions")
    public void create(@RequestBody Transaction body,@PathVariable("uid") int uid){
    	body.setUser(new User(uid," "," ",0," "));
    	transactionRepository.save(body);
    }

    @PutMapping("/api/users/{uid}/transactions/{id}")
    public void update(@PathVariable("uid") int uid, @RequestBody Transaction body,@PathVariable("id") int id){
       Transaction u =transactionRepository.findOne(id);
      u.setUser(new User(uid," "," ",0," "));
      u.setPrice(body.getPrice());
      u.setQuantity(body.getQuantity());
      u.setsName(body.getsName());
      u.setType(body.getType());
    }

    @DeleteMapping("/api/users/{uid}/transactions/{id}")
    public void delete(@PathVariable("id") int  id){
    	transactionRepository.delete(id);
        
    }

}
