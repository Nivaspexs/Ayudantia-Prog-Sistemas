package utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;


public class Serializar {
	
	public static byte[] objectToBytes(Object objeto){
		ByteArrayOutputStream bs= new ByteArrayOutputStream();
		try {
			ObjectOutputStream os = new ObjectOutputStream (bs);
			os.writeObject(objeto);
			os.close();
		} catch (Exception e) {e.printStackTrace();}
		return  bs.toByteArray(); 
	}
	
	public static Object bytesToObject(byte[] bytes){
		ByteArrayInputStream bs= new ByteArrayInputStream(bytes);
		Object paquete=null;
		try{
			ObjectInputStream is = new ObjectInputStream(bs);
			paquete = (Object)is.readObject();
			is.close();
		} catch (Exception e) {e.printStackTrace();}
		return paquete;
	}
	public static byte[] BufferedImageToBytes(BufferedImage imagen){
		ByteArrayOutputStream bs= new ByteArrayOutputStream();
		try {
			ImageIO.write(imagen, "PNG", bs);
		} catch (Exception e) {e.printStackTrace();}
		return  bs.toByteArray(); 
	}
	public static BufferedImage BytesToBufferedImage(byte[] array){
		BufferedImage bufferedImage=null;
		try{
			ByteArrayInputStream bai = new ByteArrayInputStream(array);
			bufferedImage = ImageIO.read(bai);
		} catch (Exception e) {e.printStackTrace();}
		return bufferedImage; 
	}
}
