package utils;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imagen {
	public static BufferedImage readColorImage(String path){
		BufferedImage image=null;
		try {
			image = ImageIO.read(new File(path));
			image=bufferedImageTo3ByteBGR(image);
		} catch (IOException e) {}
		return image;
	}
	public static BufferedImage readGrayImage(String path){
		BufferedImage image=null;
		try {
			image = ImageIO.read(new File(path));
			image=bufferedImageToByteGray(image);
		} catch (IOException e) {}
		return image;
	}
	public static BufferedImage scale(BufferedImage original, int width, int height){
		BufferedImage escalada = null;
		if(original!=null){
			if ((float)original.getWidth()/(float)width > (float)original.getHeight()/(float)height)
				height = (original.getHeight() * width) / original.getWidth();
			else
				width = (original.getWidth() * height) / original.getHeight();
			escalada = new BufferedImage(width, height, original.getType());
			Graphics2D g = escalada.createGraphics();
			g.drawImage(original, 0, 0, width, height, null);
			g.dispose();
		}
		return escalada;
	}
	public static BufferedImage rotate(BufferedImage original,int angle){
		BufferedImage rotada = null;
		if(original!=null){
			rotada = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
			Graphics2D gb1 = (Graphics2D)rotada.getGraphics();
			//gb1.translate(original.getWidth()/2, original.getHeight()/2);
			gb1.rotate(Math.toRadians(angle),original.getWidth()/2, original.getHeight()/2);
			//gb1.translate(-original.getWidth()/2, -original.getHeight()/2);
			gb1.drawImage(original, null, 0, 0);
		}
		return rotada;
	}
	public static BufferedImage imageToBufferedImage(Image image){
		int type = BufferedImage.TYPE_3BYTE_BGR;
		BufferedImage bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
		Graphics g = bimage.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		return bimage;
	}
	private static BufferedImage bufferedImageToByteGray(BufferedImage buff){
		BufferedImage buffer;
		if (buff.getType()!=BufferedImage. TYPE_BYTE_GRAY){
			buffer = new BufferedImage(buff.getWidth(), buff.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
			Graphics g = buffer.getGraphics();
			g.drawImage(buff, 0, 0, null);
			g.dispose();
		}else
			buffer=buff;
		return buffer;
	}
    public static BufferedImage bufferedImageTo3ByteBGR(BufferedImage original){
		BufferedImage newTypeBufferedImage = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = newTypeBufferedImage.createGraphics();
		g.drawImage(original, 0, 0, original.getWidth(), original.getHeight(), null);
		g.dispose();
		return newTypeBufferedImage;
	}
}
