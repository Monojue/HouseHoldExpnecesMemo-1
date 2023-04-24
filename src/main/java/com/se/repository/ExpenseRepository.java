package com.se.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.se.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

//	@Query("SELECT to_char(edate, 'YYYY/MM'), SUM(amount) FROM EXPENSE group by to_char(edate, 'YYYY/MM')")
//	List<Expense> getMontlyList();
//
//	@Query("SELECT * FROM EXPENSE WHERE CAST(EDATE as VARCHAR) LIKE '?1%' order by EDATE DESC")
//	List<Expense> getDetailList(String month);
	
	

}
