package com.se.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "expense")
public class MontlyExpense {

	@Id
	@Column(name = "edate")
	String edate;
	@Column(name = "total")
	double total;
}
