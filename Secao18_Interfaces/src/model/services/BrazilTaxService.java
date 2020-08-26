package model.services;

public class BrazilTaxService implements TaxService {
	
	//esta sendo utilizado o tipo primitivo (double) porque estamos assumindo que sempre haverá um retorno deste valor
	//diferente das outras classes onde pode haver uma integraçao com banco de dados e ser necessario que algum atributo possa assumir
	//valores nulos (null). Essa é a idéia de quando utilizar ou não a wrapper class
	public double tax (double amount) {
		if (amount <= 100.0) {
			return amount * 0.2;
		}
		else {
			return amount * 0.15;
		}
	}
}
