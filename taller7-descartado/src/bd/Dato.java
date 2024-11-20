package bd;

import utils.ObjetoBd;

public class Dato extends ObjetoBd{

	public Dato() {
		addToPrimaryKey("Id");
	}
	
	private int Id;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}
	
	
}
