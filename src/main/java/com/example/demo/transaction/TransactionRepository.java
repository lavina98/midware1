package com.example.demo.transaction;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

	public List<Transaction> findByUserId(int id);
}
