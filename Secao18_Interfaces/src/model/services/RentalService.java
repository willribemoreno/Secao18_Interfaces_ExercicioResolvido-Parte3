package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	
	private Double pricePerDay;
	private Double pricePerHour;
	
	private TaxService taxService;
	
	public RentalService() {		
	}

	public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
		//(t2-t1) > Diferença em milisegundos (getTime); 	
		double hours = (double)(t2 - t1) / 1000 / 60 / 60;
		
		double basicPayment;
		
		if (hours <= 12.0) {
			basicPayment = Math.ceil(hours) * pricePerHour;
		}
		else {
			basicPayment = Math.ceil(hours / 24) * pricePerDay;
		}
		
		double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
	
	/*
	public String test() {
		long t3 = start.getTime();
		long t4 = finish.getTime();
		//(t2-t1) > Diferença em milisegundos (getTime); 	
		//Long hours = t4-t3;
		double hours = (double)TimeUnit.MILLISECONDS.toMinutes(t4-t3);
		//Double hours3 = (double)(hours2);
		//hours = hours / 
		int hours2 = (int)hours/60;
		int minutes = (int)hours%60;
		//return String.valueOf(hours2)+ ":" + String.valueOf(minutes);
		return hours2 + ":" + minutes;
	}
	*/
}
