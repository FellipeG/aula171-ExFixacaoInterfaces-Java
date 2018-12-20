package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.Paypal;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.println("ENTER CONTRACT DATA:");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Date (dd/MM/yyyy): ");
			sc.nextLine();
			Date date = sdf.parse(sc.nextLine());
			System.out.print("Contract value: ");
			double value = sc.nextDouble();
			System.out.print("Enter number of installments: ");
			int nOfInstallments = sc.nextInt();
			ContractService contractService = new ContractService(new Contract(number, date, value), new Paypal(), nOfInstallments);
			contractService.performIntallments();
			System.out.println();
			System.out.println("INSTALLMENTS:");
			for(Installment installment : contractService.getContract().getInstallment()) {
				System.out.println(sdf.format(installment.getDate()) + " - " + String.format("%.2f", installment.getValue()));
			}
		}
		catch(ParseException e) {
			System.out.println("Error parsing data: " + e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Input error: " + e.getMessage());
		}
		finally {
			sc.close();
		}

	}

}
