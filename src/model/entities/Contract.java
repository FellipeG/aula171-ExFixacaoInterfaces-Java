package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

	private int number;
	private Date date;
	private double value;
	
	private List<Installment> installment = new ArrayList<>();
	
	public Contract() {
	}

	public Contract(int number, Date date, double value) {
		this.number = number;
		this.date = date;
		this.value = value;
	}

	public int getNumber() {
		return number;
	}

	public Date getDate() {
		return date;
	}

	public double getValue() {
		return value;
	}
	
	public void addInstallment(Installment installment) {
		this.installment.add(installment);
	}
	
	public void removeInstallment(Installment installment) {
		this.installment.remove(installment);
	}

	public List<Installment> getInstallment() {
		return installment;
	}
}
