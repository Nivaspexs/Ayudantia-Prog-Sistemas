package main;

import bd.Auto;
import dao.AutoDao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Agregar los datos de prueba
		AutoDao dao = new AutoDao();
		Auto auto = new Auto();
		Auto auto1 = new Auto();
		auto.setModelo("RX7");
		auto.setMarca("Mazda");
		dao.add(auto);
		auto1.setModelo("2000GT");
		auto1.setMarca("Toyota");
		dao.add(auto1);
		
		//Crear e iniciar los hilos
		Hilo1 hilo1 = new Hilo1();
		Hilo2 hilo2 = new Hilo2();
		hilo1.start();
		hilo2.start();
	}

}
