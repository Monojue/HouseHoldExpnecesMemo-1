package com.se.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.se.entity.MontlyExpense;

@Repository
public interface MontlyExpenseRepository extends JpaRepository<MontlyExpense, String> {

	@Query(value = "select to_char(EDATE, 'YYYY/MM') AS edate, sum(amount) as total from expense group by to_char(EDATE, 'YYYY/MM') order by to_char(EDATE, 'YYYY/MM') DESC", nativeQuery = true)
	List<MontlyExpense> getMontlyList();
	
}
