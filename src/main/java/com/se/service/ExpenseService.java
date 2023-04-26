package com.se.service;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import com.se.common.Utils;
import com.se.entity.DailyExpense;
import com.se.entity.MontlyExpense;
import com.se.form.DailyExpenseForm;
import com.se.form.MontlyExpenseForm;
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

	@Autowired
	Utils utils;

	public List<DailyExpenseForm> getDailyList(String month) {
		return utils.changeDailyEntityListToForm(this.dailyExpenseRepository.getDailyList(month));
	}

	public List<MontlyExpenseForm> getMontlyList() {
		return utils.changeMontlyEntityListToForm(this.montlyExpenseRepository.getMontlyList());
	}

	public MontlyExpenseForm getMonthlyListByMonth(String month) {
		return utils.changeMontlyEntityToForm(this.montlyExpenseRepository.getMonthlyExpenseByMonth(month));
	}

	public DailyExpenseForm getDailyExpenseById(Integer id) {
		return utils.changeDailyEntityToForm(this.dailyExpenseRepository.findById(id).get());
	}

	public void addDailyExpense(DailyExpenseForm ex) {
		try {
			this.dailyExpenseRepository.save(ex);
		} catch (Exception e) {
			TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
		}
	}

	public void updateDailyExense(DailyExpense ex) {
		try {
			this.dailyExpenseRepository.save(ex);
		} catch (Exception e) {
			TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
		}
	}

}
