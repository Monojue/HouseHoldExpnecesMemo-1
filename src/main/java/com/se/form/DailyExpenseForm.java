package com.se.form;

import lombok.Data;

@Data
public class DailyExpenseForm {

	int id;
	String edate;
	String name;
	double amount;
}
