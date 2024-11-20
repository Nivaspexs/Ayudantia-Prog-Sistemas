package utils;

import java.util.HashMap;
import java.util.Map;

public abstract class ManagerSession {
	
	private static Map<String, Object> map = new HashMap<String, Object>();
	
	//permite guardar y cargar el "estado" de un objeto en la session. 
	public static Object removeObject(String key){
		Object object = map.get(key);
		map.remove(key);
		return object;
	}
	public static Object findObject(String key){
		return map.get(key);
	} 
	public static void saveObject(String key, Object object){ 
		map.put(key, object);
	} 
}
