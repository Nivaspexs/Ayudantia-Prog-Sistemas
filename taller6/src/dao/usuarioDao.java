package dao;

import java.util.ArrayList;
import java.util.List;

import bd.usuario;
import utils.ObjetoBd;
import utils.ObjetoDao;

public class usuarioDao extends ObjetoDao {

	public List<usuario> list() {
		List<ObjetoBd> lista = listAll();
		List<usuario> nueva = new ArrayList<usuario>();
		for (ObjetoBd obj : lista)
			nueva.add((usuario) obj);
		return nueva;

	}

	public List<usuario> filtrarPorEdad(Integer edadFiltro) {

		List<usuario> lista = list();

		List<usuario> listaFiltrada = new ArrayList<usuario>();

		for (usuario usuario : lista) {
			if (usuario.getEdad() >= edadFiltro) {
				listaFiltrada.add(usuario);
				System.out.println("Usuario mayor de "+edadFiltro+ " "+usuario.getNombre());
			}
		}
		return listaFiltrada;
	}

}
