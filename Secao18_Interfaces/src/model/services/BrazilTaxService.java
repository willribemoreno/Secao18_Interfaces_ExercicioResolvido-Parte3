package model.services;

public class BrazilTaxService implements TaxService {
	
	//esta sendo utilizado o tipo primitivo (double) porque estamos assumindo que sempre haver� um retorno deste valor
	//diferente das outras classes onde pode haver uma integra�ao com banco de dados e ser necessario que algum atributo possa assumir
	//valores nulos (null). Essa � a id�ia de quando utilizar ou n�o a wrapper class
	public double tax (double amount) {
		if (amount <= 100.0) {
			return amount * 0.2;
		}
		else {
			return amount * 0.15;
		}
	}
}
