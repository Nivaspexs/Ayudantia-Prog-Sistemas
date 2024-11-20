package main;

import java.util.List;

import bd.Auto;
import dao.AutoDao;

public class Hilo1 extends Thread {

	public void run() {
		AutoDao dao = new AutoDao();
		List<Auto> lista = dao.list();

		for (Auto auto : lista) {
			System.out.println("Hilo1: Modelo: " + auto.getModelo());
		}
	}
}
