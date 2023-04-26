package com.se.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.se.entity.DailyExpense;
import com.se.entity.MontlyExpense;

@Repository
public interface DailyExpenseRepository extends JpaRepository<DailyExpense, Integer> {

	@Query(value = "select * from expense where CAST(EDATE AS VARCHAR) like :month% order by edate DESC", nativeQuery = true)
	List<DailyExpense> getDailyList(@Param("month") String month);
}
