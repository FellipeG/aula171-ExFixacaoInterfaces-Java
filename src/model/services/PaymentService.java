package model.services;

import model.entities.Contract;

public interface PaymentService {
	
	public void tax(Contract contract, int nOfInstallments);

}
