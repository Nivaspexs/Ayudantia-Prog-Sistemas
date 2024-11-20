package dao;

import java.util.ArrayList;
import java.util.List;

import bd.Auto;
import utils.ObjetoBd;
import utils.ObjetoDao;

public class AutoDao extends ObjetoDao{

	public List<Auto> list() {
		List<ObjetoBd> lista = listAll();
		List<Auto> nueva = new ArrayList<Auto>();
		for (ObjetoBd obj : lista)
			nueva.add((Auto) obj);
		return nueva;

	}
	
}
