package com.se.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.se.entity.MontlyExpense;

@Repository
public interface MontlyExpenseRepository extends JpaRepository<MontlyExpense, String> {

	@Query(value = "select to_char(EDATE, 'YYYY/MM') AS edate, sum(amount) as total from expense group by to_char(EDATE, 'YYYY/MM') order by to_char(EDATE, 'YYYY/MM') DESC", nativeQuery = true)
	List<MontlyExpense> getMontlyList();
	
	@Query(value = "select to_char(EDATE, 'YYYY/MM') as edate, sum(amount) as total from expense where CAST(EDATE AS VARCHAR) like :month% group by to_char(EDATE, 'YYYY/MM')", nativeQuery = true)
	List<MontlyExpense> getMonthlyListByMonth(@Param("month") String month);
	
}