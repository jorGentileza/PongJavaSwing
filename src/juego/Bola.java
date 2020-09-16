/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author NegroLC
 */
public class Bola {

    private String bola;
    private int direccionX = 3;
    private int direccionY = 2;
    private int x;
    private int y;
    private Image imagen;
    private int puntuacionIzquierda = 0;
    private int puntuacionDerecha = 0;
    

    public Bola() {

        x = 475;
        y = 225;
        bola = "Bola.png";
        ImageIcon img = new ImageIcon(this.getClass().getResource(bola));
        imagen = img.getImage();

    }

    public void mover() {
        x += direccionX;
        y += direccionY;
        if (x >= 1000 - 50) {
            puntuacionIzquierda++;
            x = 475;
            y = 225;
            if (direccionX == 3) {
                direccionX = -3;
                direccionY = -2;
            } else {
                direccionX = 3;
                direccionY = 3;

            }
        }
        if (x <= 0) {
            x = 475;
            y = 225;
            puntuacionDerecha++;
            if (direccionX == 3) {
                direccionX = -3;
                direccionY = -2;
            } else {
                direccionX = 3;
                direccionY = 2;
            }
        }
                if (y < 0) {
            direccionY = -direccionY;
        }
        if (y > 500 - 50) {
            direccionY = -direccionY;
        }

    }

    public int tenerX() {
        return x;
    }

    public int tenerY() {
        return y;
    }

    public Image tenerImagen() {
        return imagen;
    }
    
    public int tenerDireccionX(){
        return direccionX;
    }
    public int tenerDireccionY(){
        return direccionY;
    }
    public int cambiarDireccionX(){
        direccionX = -direccionX;
        return direccionX;
    }
    public int tenerPuntuacionIzquerda(){
        return puntuacionIzquierda;
    }
    public int tenerPuntuacionDerecha(){
        return puntuacionDerecha;
    }
}
