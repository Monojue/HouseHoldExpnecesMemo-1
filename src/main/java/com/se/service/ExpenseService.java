package com.se.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import com.se.entity.DailyExpense;
import com.se.entity.MontlyExpense;
import com.se.repository.DailyExpenseRepository;
import com.se.repository.MontlyExpenseRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
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
	
	public MontlyExpense getMonthlyListByMonth(String month) {
		return this.montlyExpenseRepository.getMonthlyExpenseByMonth(month);
	}
	
	public Optional<DailyExpense> getDailyExpenseById(Integer id) {
		return this.dailyExpenseRepository.findById(id);
	}
	
	public void addDailyExpense(DailyExpense ex) {
		try {
			this.dailyExpenseRepository.save(ex);
		} catch (Exception e) {
			TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
		}
	}
	
	public void updateDailyExense(DailyExpense ex) {
		try {
			this.dailyExpenseRepository.save(ex);
		}catch (Exception e) {
			TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
		}
	}

}
