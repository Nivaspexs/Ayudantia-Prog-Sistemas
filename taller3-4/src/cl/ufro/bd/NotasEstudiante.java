package cl.ufro.bd;

import java.io.Serializable;

public class NotasEstudiante implements Serializable{
	
	private String Matricula;
	private String promedioRamoA;
	private String promedioRamoB;
	private String promedioRamoC;
	public String getMatricula() {
		return Matricula;
	}
	public void setMatricula(String matricula) {
		Matricula = matricula;
	}
	public String getPromedioRamoA() {
		return promedioRamoA;
	}
	public void setPromedioRamoA(String promedioRamoA) {
		this.promedioRamoA = promedioRamoA;
	}
	public String getPromedioRamoB() {
		return promedioRamoB;
	}
	public void setPromedioRamoB(String promedioRamoB) {
		this.promedioRamoB = promedioRamoB;
	}
	public String getPromedioRamoC() {
		return promedioRamoC;
	}
	public void setPromedioRamoC(String promedioRamoC) {
		this.promedioRamoC = promedioRamoC;
	}

	
}
