package model.services;

import model.entities.Contract;

public class ContractService {
	
	private Contract contract;
	private PaymentService paymentService;
	private int nOfInstallments;
	
	public ContractService() {
	}

	public ContractService(Contract contract, PaymentService paymentService, int nOfInstallments) {
		this.contract = contract;
		this.paymentService = paymentService;
		this.nOfInstallments = nOfInstallments;
	}
	
	public void performIntallments() {
		paymentService.tax(contract, nOfInstallments);
	}

	public Contract getContract() {
		return contract;
	}

	public PaymentService getPaymentService() {
		return paymentService;
	}

	public int getnOfInstallments() {
		return nOfInstallments;
	}
}
