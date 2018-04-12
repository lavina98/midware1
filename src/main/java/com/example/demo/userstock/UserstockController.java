package com.example.demo.userstock;
import java.util.*;
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

import com.example.demo.portfolio.Portfolio;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserstockController {
	

		   @Autowired
		   UserstockRepository userstockrepository;

		    @GetMapping("/api/users/{id}/portfolios/{pid}/userstocks")
		    public List<Userstock> index(@PathVariable("pid") int pid){
		       return  userstockrepository.findByPortfolioPId(pid);
		        
		    }

		    @GetMapping("/api/users/{id}/portfolios/{pId}/userstocks/{uid}")
		    public Userstock show(@PathVariable("uId") int uId){
		        return userstockrepository.findOne(uId);
		    }
		    @PostMapping("/api/users/{id}/portfolios/{pid}/userstocks")
		    public void create(@RequestBody Userstock body,@PathVariable("pid") int pid,@PathVariable("id") int id){
		    	body.setPortfolio(new Portfolio(pid," ",0,id));
		    	userstockrepository.save(body);
		    }

		    @PutMapping("/api/users/{id}/portfolios/{pId}/userstocks/{uid}")
		    public void update(@PathVariable("pId") int pId, @RequestBody Userstock body,@PathVariable("id") int id
		    		,@PathVariable("uid") int uid)
			{
		        Userstock u = userstockrepository.findOne(uid);
		        u.setBuyingPrice(body.getBuyingPrice());
		        u.setQuantity(body.getQuantity());
		        u.setsName(body.getsName());
		        u.setPortfolio(new Portfolio(pId," ",0,id));
		    }

		    @DeleteMapping("/api/users/{id}/portfolios/{pId}/userstocks/{uid}")
		    public void delete(@PathVariable("uid") int  id){
		    	userstockrepository.delete(id);
		        
		    }
}