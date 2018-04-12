package com.example.demo.portfolio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.user.User;

public interface PortfolioRepository extends CrudRepository<Portfolio, Integer> {

	public List<Portfolio> findByUserId(int id);
	public List<Portfolio> findByUserUname(String id);

}
