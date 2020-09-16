
package juego;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Pareman {

    private String pareman;
    private int direccionX;
    private int direccionY;
    private int x;
    private int y;
    private Image imagen;

    public Pareman() {

        x = 10;
        y = 225;
        pareman = "pareman.png";
        ImageIcon img = new ImageIcon(this.getClass().getResource(pareman));
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
        if (key == KeyEvent.VK_W) {
            direccionY = -1;
            }
        
        if (key == KeyEvent.VK_S) {
            direccionY = +1;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            direccionY = 0;
        }
        if (key == KeyEvent.VK_S) {
            direccionY = 0;
        }
    }

}
