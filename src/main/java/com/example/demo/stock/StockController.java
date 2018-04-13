package com.example.demo.stock;

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

import com.example.demo.transaction.Transaction;
import com.example.demo.transaction.TransactionRepository;
import com.example.demo.user.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StockController {

	@Autowired
    StockRepository stockRepository;

    @GetMapping("/api/stocks")
    public List<Stock> index(){
        return  stockRepository.findAll();
    }

//    @GetMapping("/api/stocks/{name}")
//    public  Stock show(@PathVariable("name") String name){
//        return  stockRepository.findByName(name);
//    }
    @GetMapping("/api/stocks/{sym}")
    public  Stock showbysymbol(@PathVariable("sym") String sym){
        return  stockRepository.findBySymbol(sym);
    }
    
    @GetMapping("/api/stocks/{sname}")
    public  Stock showbyname(@PathVariable("sanme") String sname){
        return  stockRepository.findByName(sname);
    }
   
}
