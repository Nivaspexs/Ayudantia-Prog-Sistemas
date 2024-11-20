package bd;

import utils.ObjetoBd;

public class usuario extends ObjetoBd{
	
	private String nombre;
	private String correo;
	private Integer edad;
	
	public usuario() {
		addToPrimaryKey("nombre"); // Esto es irrelevante en este caso
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	

}
