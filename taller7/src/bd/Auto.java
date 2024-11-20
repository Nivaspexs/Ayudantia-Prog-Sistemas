package bd;

import utils.ObjetoBd;

public class Auto extends ObjetoBd{
	
	private String patente;
	private String modelo;
	private String marca;
	
	public Auto() {
		addToPrimaryKey("modelo");
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	
	
	
}
