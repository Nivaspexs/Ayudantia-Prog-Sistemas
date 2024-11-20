package cl.ufro.cliente;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import cl.ufro.bd.NotasEstudiante;

public class cliente {

	// TODO Auto-generated method stub
	public static void main(String[] args) {

		cliente notas = new cliente();

		NotasEstudiante notasEstudiante = new NotasEstudiante();

		/* Le doy valores a las notas y matricula */
		notasEstudiante.setMatricula("21070882021");
		notasEstudiante.setPromedioRamoA("6.1");
		notasEstudiante.setPromedioRamoB("3.0");
		notasEstudiante.setPromedioRamoC("4.0");
		
		if(notas.enviarNotas(notasEstudiante)) // Se envían por TCP
			System.out.println("Se envío correctamente");
		else
			System.out.println("Hubo un error con el envío");

	}

	public Boolean enviarNotas(NotasEstudiante notasEstudiante) {
		
		try {
			

			InetAddress ip = InetAddress.getByName("127.0.0.1"); // No es necesario tan exacto
			Socket sock = new Socket(ip, 5000); // Ó poner IP directamente

			ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());

			oos.writeObject(notasEstudiante);

			oos.close();
			sock.close(); // No es tan necesario, detalles

			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

}
