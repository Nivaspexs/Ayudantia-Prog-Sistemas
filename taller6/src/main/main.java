package main;

import java.util.List;

import bd.usuario;
import dao.usuarioDao;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Inicializamos el dao
		usuarioDao dao = new usuarioDao();
		
		//Agrego nuevos usuarios
		usuario usuario1 = new usuario();
		usuario1.setCorreo("1@gmail.com");
		usuario1.setEdad(23);
		usuario1.setNombre("Roberto LoL God");
		dao.add(usuario1);
		
		usuario usuario2 = new usuario();
		usuario2.setCorreo("2@gmail.com");
		usuario2.setEdad(17);
		usuario2.setNombre("Mechonsito 17");
		dao.add(usuario2);
		
			//Aquí vamos a filtrar
		//Obtenemos lista
		List<usuario> listaFiltrada = dao.filtrarPorEdad(18);
	
	}

}
