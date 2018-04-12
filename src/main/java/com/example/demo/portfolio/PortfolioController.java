package com.example.demo.portfolio;
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
import com.example.demo.portfolio.PortfolioRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PortfolioController {

	  @Autowired
	    PortfolioRepository portfolioRepository;

	    @GetMapping("/api/users/{id}/portfolios")
	    public List<Portfolio> index(@PathVariable("id") int id){
	       return  portfolioRepository.findByUserId(id);
	        
	    }

	    @GetMapping("/api/users/{id}/portfolios/{pId}")
	    public Portfolio show(@PathVariable("pId") int pId){
	        return portfolioRepository.findOne(pId);
	    }
	    @PostMapping("/api/users/{id}/portfolios")
	    public void create(@RequestBody Portfolio body,@PathVariable("id") int id){
	    	body.setUser(new User(id," "," ",0," "));
	    	portfolioRepository.save(body);
	    }

	    @PutMapping("/api/users/{id}/portfolios/{pId}")
	    public void update(@PathVariable("pId") int pId, @RequestBody Portfolio body,@PathVariable("id") int id){
	        Portfolio u = portfolioRepository.findOne(id);
	        u.setUser(new User(id," "," ",0," "));
	        u.setpName(body.getpName());
	        u.setpWorth(body.getpWorth());
	    }

	    @DeleteMapping("/api/users/{id}/portfolios/{pId}")
	    public void delete(@PathVariable("pId") int  id){
	    	portfolioRepository.delete(id);;
	        
	    }
}
