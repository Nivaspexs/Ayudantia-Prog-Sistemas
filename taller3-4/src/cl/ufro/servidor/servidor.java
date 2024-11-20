package cl.ufro.servidor;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import cl.ufro.bd.NotasEstudiante;

public class servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		servidor notas = new servidor();
		
		notas.escucha();
		
	}

	public void escucha() {
		try {
			ServerSocket sersock = new ServerSocket(5000);
			while (true) {
				System.out.println("Esperando Objeto....");
				Socket sock = sersock.accept();
				ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
				Object objeto = ois.readObject();
				NotasEstudiante notasRecibidas = (NotasEstudiante) objeto;

				System.out.println(
						"Las notas de " + notasRecibidas.getMatricula() + " son:" + notasRecibidas.getPromedioRamoA()
								+ " " + notasRecibidas.getPromedioRamoB() + " " + notasRecibidas.getPromedioRamoC());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
