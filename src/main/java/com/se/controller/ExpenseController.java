package com.se.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.entity.DailyExpense;
import com.se.service.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	@GetMapping(value = "/")
	public String home(Model model) {
		model.addAttribute("list", this.expenseService.getMontlyList());
		return "home";
	}

	@GetMapping(value = "/add")
	public String addExpense(Model model) {
		model.addAttribute("form", new DailyExpense());
		return "addExpense";
	}

	@PostMapping(value = "/add")
	public String addExpense(Model model, @ModelAttribute("form") DailyExpense e) {
		this.expenseService.addDailyExpense(e);
		model.addAttribute("list", this.expenseService.getMontlyList());
		return "home";
	}

	@GetMapping(value = "/update/{id}")
	public String updateExpense(Model model, @PathVariable Integer id) {
		model.addAttribute("expense", this.expenseService.getDailyExpenseById(id));
		return "addExpense";
	}

	@PostMapping(value = "/update")
	public String updateExpense(Model model, @ModelAttribute("form") DailyExpense e) {
		return "index";
	}

	@GetMapping(value = "/detail/{year}/{month}")
	public String detailExpense(Model model,@PathVariable String year, @PathVariable String month) {
//		model.addAttribute("list", this.expenseService.getDailyList(year +"-"+month));
//		model.addAttribute("total", this.expenseService.getMonthlyListByMonth(year +"-"+month));
		return "detailExpense";
	}

}
