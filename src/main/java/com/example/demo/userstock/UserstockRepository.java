package com.example.demo.userstock;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.portfolio.Portfolio;

@Repository
public interface UserstockRepository extends CrudRepository<Userstock,Integer> {

	public List<Userstock> findByPortfolioPId(int id);

}
