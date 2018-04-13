package com.example.demo.portfolio;
import java.util.ArrayList;
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
import com.example.demo.userstock.Userstock;
import com.example.demo.userstock.UserstockRepository;
import com.example.demo.portfolio.PortfolioRepository;
import com.example.demo.stock.Stock;
import com.example.demo.stock.StockRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PortfolioController {
		int worth=0;
		@Autowired
	    PortfolioRepository portfolioRepository;
		@Autowired
	  	UserstockRepository userstockrepository;
		@Autowired
	  	StockRepository stockrepository;

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
	    	body.setUser(new User(id," "," ",0));
	    	portfolioRepository.save(body);
	    }

	    @PutMapping("/api/users/{id}/portfolios/{pId}")
	    public void update(@PathVariable("pId") int pId, @RequestBody Portfolio body,@PathVariable("id") int id){
	        Portfolio u = portfolioRepository.findOne(id);
	        u.setUser(new User(id," "," ",0));
	        u.setpName(body.getpName());
	        u.setpWorth(body.getpWorth());
	    }

	    @DeleteMapping("/api/users/{id}/portfolios/{pId}")
	    public void delete(@PathVariable("pId") int  id){
	    	portfolioRepository.delete(id);;
	        
	    }
	    
	    @GetMapping("/api/users/{id}/portfolios/{pId}/networth")
	    public int netWorth(@PathVariable("pId") int pid) {
	    	worth = 0;
	    	List<Userstock> stocks = userstockrepository.findByPortfolioPId(pid);
	    	System.out.println("CHeck ner");
//	    	stocks = userstockrepository.findByPortfolioPId(pid);
	    	for(Userstock s:stocks) {
	    		System.out.println(s.getsName());
	    		Stock activeStock = stockrepository.findBySymbol(s.getsName());
	    		System.out.println(activeStock.getName());
	    		worth += activeStock.getCurrprice();
//	    		System.out.println(worth);
	    	}
	    	return worth;
	    }
	    
	    @PutMapping("/api/users/{id}/portfolios/{pId}/networth/put")
	    public void updatePortfolio(@PathVariable("pId") int pId, @RequestBody Portfolio body,@PathVariable("id") int id) {
	    	body = portfolioRepository.findOne(id);
	    	body.setpWorth(this.netWorth(pId));
	    	portfolioRepository.save(body);
	    }
	    
	    @GetMapping("/api/users/{id}/portfolios/returnid")
	    public List<Integer> getId(@PathVariable("id") int id) {
	    	List<Integer> ids = new ArrayList<Integer>();
	    	List<Portfolio> portfolio = (List<Portfolio>) portfolioRepository.findAll();
	    	for(Portfolio p:portfolio) {
	    		ids.add(p.getpId());
	    	}
	    	return ids;
	    }
	    @GetMapping("/api/users/{id}/portfolios/returnWorth")
	    public List<Integer> getWorth(@PathVariable("id") int id) {
	    	List<Integer> ids = new ArrayList<Integer>();
	    	List<Portfolio> portfolio = (List<Portfolio>) portfolioRepository.findAll();
	    	for(Portfolio p:portfolio) {
	    		ids.add(p.getpWorth());
	    	}
	    	return ids;
	    }
}
