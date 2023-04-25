package com.se.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.entity.DailyExpense;
import com.se.entity.MontlyExpense;
import com.se.repository.DailyExpenseRepository;
import com.se.repository.MontlyExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	DailyExpenseRepository dailyExpenseRepository;

	@Autowired
	MontlyExpenseRepository montlyExpenseRepository;

	public List<DailyExpense> getDailyList(String month) {
		return this.dailyExpenseRepository.getDailyList(month);
	}

	public List<MontlyExpense> getMontlyList() {
		return this.montlyExpenseRepository.getMontlyList();
	}
	
	public Optional<DailyExpense> getDailyExpenseById(Integer id) {
		return this.dailyExpenseRepository.findById(id);
	}
}
