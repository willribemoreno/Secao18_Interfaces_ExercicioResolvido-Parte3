package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");

		char sair = 'y';
		while (sair != 'N') {
			System.out.println("ENTER RENTAL DATA");
			System.out.print("Car model: ");
			String carModel = sc.nextLine();
			System.out.print("Pickup date/time (dd/MM/yyy hh:mm): ");
			Date start = sdf.parse(sc.nextLine());
			System.out.print("Return date/time (dd/MM/yyy hh:mm): ");
			Date finish = sdf.parse(sc.nextLine());

			CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

			System.out.println();
			System.out.print("Enter price per hour: ");
			double pricePerHour = sc.nextDouble();
			System.out.print("Enter price per day: ");
			double pricePerDay = sc.nextDouble();

			RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());

			rentalService.processInvoice(cr);

			System.out.println();
			System.out.println("INVOICE: ");
			System.out.println("Basic payment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
			System.out.println("Tax: " + String.format("%.2f", cr.getInvoice().getTax()));
			System.out.println("Total payment: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));

			System.out.println("Do you want to add new rental information? (Y/N)");
			sc.nextLine();
			sair = sc.nextLine().toUpperCase().charAt(0);			
		}
		sc.close();
	}

}
