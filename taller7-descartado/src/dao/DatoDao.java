package dao;

import java.util.ArrayList;
import java.util.List;

import bd.Dato;
import utils.ObjetoBd;
import utils.ObjetoDao;

public class DatoDao extends ObjetoDao{

		public List<Dato> list(){
			List<ObjetoBd> lista = (List<ObjetoBd>)listAll();
			List<Dato> nueva = new ArrayList<Dato>();
			for(ObjetoBd objeto : lista) {
				nueva.add((Dato)objeto);
			}
			return nueva;
		}
}
