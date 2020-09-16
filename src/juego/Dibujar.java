package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Dibujar extends JPanel implements ActionListener {

    private String fondo;
    private Image imagen;
    private boolean juego = false;
    private int scorePareman = 0;
    private int scorePaco = 0;

    Bola bola = new Bola();
    Paco paco = new Paco();
    Pareman pareman = new Pareman();

    Timer timer = new Timer(5, this);

    public Dibujar() {
        fondo();
        addKeyListener(new teclado());
        setFocusable(true);
        timer.start();
    }

    private void fondo() {
        fondo = "fondo.png";
        ImageIcon img = new ImageIcon(this.getClass().getResource(fondo));
        imagen = img.getImage();
    }

    public void colisiones() {
        int direccionBola = bola.tenerDireccionX();
        if (new Rectangle(bola.tenerX(), bola.tenerY(), 50, 50).intersects(new Rectangle(pareman.tenerX(), pareman.tenerY(), 50, 80))) {
            direccionBola = bola.cambiarDireccionX();
        }
        if (new Rectangle(bola.tenerX(), bola.tenerY(), 50, 50).intersects(new Rectangle(paco.tenerX(), paco.tenerY(), 50, 80))) {
            direccionBola = bola.cambiarDireccionX();
        }
    }

    public void paint(Graphics grafica) {
        super.paint(grafica);
        Graphics2D g2 = (Graphics2D) grafica;
        g2.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        g2.drawImage(paco.tenerImagen(), paco.tenerX(), paco.tenerY(), null);
        g2.drawImage(pareman.tenerImagen(), pareman.tenerX(), pareman.tenerY(), null);
        g2.drawImage(bola.tenerImagen(), bola.tenerX(), bola.tenerY(), null);
                
        //puntuacion
        g2.setColor(Color.YELLOW);
        g2.setFont(new Font("Action Man Extended", Font.BOLD, 48));
        g2.drawString(""+bola.tenerPuntuacionIzquerda(), 425, 40);
        g2.drawString(""+bola.tenerPuntuacionDerecha(), 525, 40);

    }

    public void actionPerformed(ActionEvent e) {
        if (juego) {
            paco.mover();
            pareman.mover();
            bola.mover();
            repaint();
            colisiones();
        }
    }

    private class teclado extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            paco.keyPressed(e);
            pareman.keyPressed(e);
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                juego = true;
            }
        }

        public void keyReleased(KeyEvent e) {
            paco.keyReleased(e);
            pareman.keyReleased(e);
        }
    }
}
