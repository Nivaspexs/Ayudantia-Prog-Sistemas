package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import bd.Dato;
import dao.DatoDao;

public class Main {

	public static void main(String[] args){

		// Iniciamos el hilo
		Hilo hilo = new Hilo();
		hilo.start();
		
		DatoDao dao = new DatoDao();
		for (int i = 1; i==100; i++) {
			Dato dato = new Dato();
			dato.setId(i);
			dao.add(dato);
		}

	}

}
