package com.se.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.entity.Expense;

@Controller
public class ExpenseController {



	@GetMapping(value = "/")
	public String home() {
		return "index";
	}

	@GetMapping(value = "/add")
	public String addExpense(Model model) {
		model.addAttribute(new Expense());
		return "addExpense";
	}

	@PostMapping(value = "/add")
	public String addExpense(Model model, @ModelAttribute("form") Expense e) {
//		this.ExpensesService.addExpense(e);
		return "index";
	}

	@GetMapping(value = "/update/{id}")
	public String updateExpense(@RequestParam Integer id) {
		
		return "updateExpense";
	}

	@PostMapping(value = "/update")
	public String updateExpense(Model model) {
		return "index";
	}

	@GetMapping(value = "/detail")
	public String detailExpense() {
		return "detailExpense";
	}

}
