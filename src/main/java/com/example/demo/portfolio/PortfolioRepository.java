package com.example.demo.portfolio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PortfolioRepository extends CrudRepository<Portfolio, Integer> {
	

	public List<Portfolio> findByUserId(int id);
	public List<Portfolio> findByUserUname(String id);

}
