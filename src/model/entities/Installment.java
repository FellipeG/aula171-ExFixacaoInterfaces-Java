package model.entities;

import java.util.Date;

public class Installment {
	
	private Date date;
	private double value;
	
	public Installment() {
	}

	public Installment(Date date, double value) {
		this.date = date;
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public double getValue() {
		return value;
	}
}
