package com.example.demo.userstock;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.portfolio.Portfolio;

@Repository
public interface UserstockRepository extends CrudRepository<Userstock,Integer> {

	public List<Userstock> findByPortfolioPId(int id);
//	 @Query(value="Select u from Userstock  u where u.portfolio.pId=:id and u.sName=:name")
//	 public Userstock findstock(@Param("pid") int pid, @Param("name")String name);
	public Userstock findBySName(String name);

}
