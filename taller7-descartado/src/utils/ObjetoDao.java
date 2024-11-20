package utils;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public abstract class ObjetoDao { 

	public static final String ruta = "files";

	public void add(ObjetoBd registro){
		try{
			File file = getFileBD(registro);
			Object aux = find(registro);
			if(aux==null){
				FileOutputStream fos = new FileOutputStream(file,true); // abre en modo append
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(registro);
				oos.close();
				fos.close();
			}else{
				System.err.println("Insert-Error: Clave primaria duplicada en "+ registro.getClass().getSimpleName().toLowerCase());
			}
		}catch (Exception e) {e.printStackTrace();}
	}
	public void update(ObjetoBd registro){
		remove(registro);
		add(registro);
	}
	public void remove(ObjetoBd registro){
		try{
			Object obj = find(registro);
			if(obj!=null){
				List<ObjetoBd> lista = this.listAll(registro);
				File file = getFileBD(registro);
				file.delete();
				for(int i=0;i<lista.size();i++){
					if(!lista.get(i).equals(registro))
						add(lista.get(i));
				}
			}else{
				System.err.println("Delete-Error: Clave primaria inexistente en "+ registro.getClass().getSimpleName().toLowerCase());
			}
		}catch (Exception e) {e.printStackTrace();}
	}
	protected Object find(ObjetoBd registro){ 
		List<ObjetoBd> lista = this.listAll(registro);
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).equals(registro))
				return lista.get(i); 
		}
		return null;
	}
	protected List<ObjetoBd> listAll(){ 
		List<ObjetoBd> lista = new ArrayList<ObjetoBd>();
		FileInputStream fis=null;
		try{
			File file = getFileBD();
			fis = new FileInputStream(file);
			while(true){
				ObjectInputStream ois = new ObjectInputStream(fis);
				ObjetoBd aux = (ObjetoBd) ois.readObject();
				lista.add(aux);
			}
		}catch (EOFException e) {
			try {
				fis.close();
			} catch (IOException e1) {e1.printStackTrace();}
		}catch (Exception e) {e.printStackTrace();}
	return lista;
	}
	protected List<ObjetoBd> listAll(ObjetoBd registro){ 
		List<ObjetoBd> lista = new ArrayList<ObjetoBd>();
		FileInputStream fis=null;
		try{
			File file = getFileBD(registro);
			fis = new FileInputStream(file);
			while(true){
				ObjectInputStream ois = new ObjectInputStream(fis);
				ObjetoBd aux = (ObjetoBd) ois.readObject();
				lista.add(aux);
			}
		}catch (EOFException e) {
			try {
				fis.close();
			} catch (IOException e1) {e1.printStackTrace();}
		}catch (Exception e) {e.printStackTrace();}
	return lista;
	}

	protected File getFileBD(ObjetoBd registro){
		File file = null;
		try{
			File folder = new File(ruta);
			if(!folder.exists())
				folder.mkdir();
			String nombreClase = registro.getClass().getSimpleName().toLowerCase();
			String pathArchivo = ruta+"/"+nombreClase;
			file= new File(pathArchivo);
			if(!file.exists())
				file.createNewFile();
		}catch (Exception e) {e.printStackTrace();}
		return file;
	}
	protected File getFileBD(){	
		File file = null;
		try{
			File folder = new File(ruta);
			if(!folder.exists())
				folder.mkdir();
			String nombreClase = this.getClass().getSimpleName().toLowerCase();
			String[] aux = nombreClase.split("dao$");
			nombreClase = aux[0];
			String pathArchivo = ruta+"/"+nombreClase;
			file= new File(pathArchivo);
			if(!file.exists())
				file.createNewFile();
		}catch (Exception e) {e.printStackTrace();}
		return file;
	}
}
