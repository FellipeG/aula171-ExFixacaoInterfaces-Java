package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class Paypal implements PaymentService {
	
	public Paypal() {
	}
	
	public void tax(Contract contract, int nOfInstallments) {
		
		Calendar cal = Calendar.getInstance();
		Date date = contract.getDate();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 1);
		date = cal.getTime();
		double installmentsInitialValue = contract.getValue() / nOfInstallments;
		for(int i=1; i<=nOfInstallments; i++) {
			double newInstallmentValue = installmentsInitialValue + ((installmentsInitialValue * 0.01) * i);
			newInstallmentValue += newInstallmentValue * 0.02;
			contract.addInstallment(new Installment(date, newInstallmentValue));
			cal.add(Calendar.MONTH, 1);
			date = cal.getTime();
		}
		
	}

}
