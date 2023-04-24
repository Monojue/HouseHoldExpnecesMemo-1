package com.se.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.entity.Expense;
import com.se.repository.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;
	
	public List<Expense> getAll(){
		List<Expense> list = new ArrayList<>();
		list = this.expenseRepository.findAll();
		return list;
	}
	
//	public List<Expense> getMontlyList(){
//		List<Expense> list = new ArrayList<>();
//		list = this.expenseRepository.getMontlyList();
//		return list;
//	}
}
