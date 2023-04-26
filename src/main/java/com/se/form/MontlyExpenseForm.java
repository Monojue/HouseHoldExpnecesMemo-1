package com.se.form;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;


@Data
public class MontlyExpenseForm {

	String edate;
	String total;
}
