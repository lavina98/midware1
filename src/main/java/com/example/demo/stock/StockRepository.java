package com.example.demo.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer>{

	public Stock findByName(String name);
	public Stock findBySymbol(String name);
}
