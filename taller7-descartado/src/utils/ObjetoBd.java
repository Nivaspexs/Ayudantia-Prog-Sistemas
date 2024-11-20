package utils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class ObjetoBd implements Serializable{

	private transient List<Field> primaryKey = new ArrayList<Field>();


	private List<Field> getPrimaryKey(ObjetoBd obj) {
		try{
			if(obj.primaryKey!=null)
				return obj.primaryKey;
			Class<?> clase = getClass();
			ObjetoBd aux = (ObjetoBd)clase.newInstance();
			return aux.primaryKey;
		}catch (Exception e) {e.printStackTrace();}
		return new ArrayList<Field>();
	}

	public boolean equals(ObjetoBd obj){
		primaryKey = getPrimaryKey(this);
		obj.primaryKey = getPrimaryKey(obj);
		if(primaryKey.size() == obj.primaryKey.size()){
			for(int i=0;i<primaryKey.size();i++){
				Class<?> returnType = primaryKey.get(i).getType();	
				String nameField = primaryKey.get(i).getName();
				if( returnType == String.class){ //no numeric
					String m1 = (String) getValor(nameField);
					String m2 = (String) obj.getValor(nameField);
					if(!m1.equals(m2))
						return false;
				}else{// numeric
					if( returnType == int.class){
						int m1 =  (Integer) getValor(nameField);
						int m2 =  (Integer) obj.getValor(nameField);
						if(m1 != m2)
							return false;
					}
					if( returnType == float.class){
						float m1 =  (Float) getValor(nameField);
						float m2 =  (Float) obj.getValor(nameField);
						if(m1 != m2)
							return false;
					}
					if( returnType == double.class){
						double m1 =  (Double) getValor(nameField);
						double m2 =  (Double) obj.getValor(nameField);
						if(m1 != m2)
							return false;
					}
					if( returnType == long.class){
						long m1 =  (Long) getValor(nameField);
						long m2 =  (Long) obj.getValor(nameField);
						if(m1 != m2)
							return false;
					}
					if( returnType == char.class){
						char m1 =  (Character) getValor(nameField);
						char m2 =  (Character) obj.getValor(nameField);
						if(m1 != m2)
							return false;
					}
					if( returnType == boolean.class){
						boolean m1 =  (Boolean) getValor(nameField);
						boolean m2 =  (Boolean) obj.getValor(nameField);
						if(m1 != m2)
							return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	protected void addToPrimaryKey(String fieldName) {
		try{
			Class<?> clase = getFieldClass(fieldName);//getClass();//getPrimitiveClass();
			Field campoPrimario = clase.getDeclaredField(fieldName); 
			campoPrimario.setAccessible(true);
			primaryKey.add(campoPrimario);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Class<?> getFieldClass(String fieldName){
		Class<?> clase = this.getClass();
		boolean ok=false;
		while(!ok && clase != ObjetoBd.class){
			ok=true;
			try{
				clase.getDeclaredField(fieldName);
			}catch (NoSuchFieldException e) {
				ok=false;
				clase = clase.getSuperclass();
			}
		}
		if(!ok)
			return null;
		return clase;
	}
	public Object getValor(String fieldName){
		try {
			char[] aux = fieldName.toCharArray();
			aux[0]-=32;//primera letra a mayuscula
			Class<?> clase = getFieldClass(fieldName);
			Method metodo = clase.getDeclaredMethod("get"+String.valueOf(aux));
			return metodo.invoke(this);
		} catch (Exception e) {e.printStackTrace();}
		return null;
	}
}
