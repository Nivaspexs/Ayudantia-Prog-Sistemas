package main;

import java.util.ArrayList;
import java.util.List;

import bd.Dato;
import dao.DatoDao;

public class Hilo extends Thread{
	
	
	public void run() {
		DatoDao dao = new DatoDao();
		System.out.println("Desde hilo:");
		while(true) {
			System.out.println("A");
			List<Dato> lista = dao.list();
			for(Dato dato : lista) {
				System.out.println("AAA");
			}
		}
		
	}

}
