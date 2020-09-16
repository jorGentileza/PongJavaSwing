package juego;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Paco {

    private String paco;
    private int direccionX;
    private int direccionY;
    private int x;
    private int y;
    private Image imagen;

    public Paco() {

        x = 940;
        y = 225;
        paco = "/imagenes/PacoPrueba.png";
        ImageIcon img = new ImageIcon(this.getClass().getResource(paco));
        imagen = img.getImage();

    }
    
    public void mover(){
        
        if(y <=10){
            y=10;
        }
        y += direccionY;
        
        if( y >= 380){
            y=380;
        }
        y +=direccionY;
    }
    
    public int tenerX(){
        return x;
    }

    public int tenerY(){
        return y;
    }
    
    public Image tenerImagen(){
        return imagen;
    }
    
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            direccionY = -1;
            }
        
        if (key == KeyEvent.VK_DOWN) {
            direccionY = +1;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            direccionY = 0;
        }
        if (key == KeyEvent.VK_DOWN) {
            direccionY = 0;
        }
    }

}
