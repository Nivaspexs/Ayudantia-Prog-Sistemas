package utils;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PanelImagen extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage imagen;

    public PanelImagen() {
        setLayout(null);
    }
    public void setImage(BufferedImage imagen) {
        this.imagen = imagen;
        repaint();
    }
    public BufferedImage getImage() {
        return this.imagen;
    }
    public void paint( Graphics g ) {
        super.paint(g);
        if( imagen != null ) {
        	int h = (this.getHeight()-imagen.getHeight())/2;
        	int w = (this.getWidth()-imagen.getWidth())/2;
            g.drawImage(imagen, w, h, imagen.getWidth(), imagen.getHeight(), this);
        }
    }
}
