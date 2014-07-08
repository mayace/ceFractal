

package com.github.ceFractal.graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JPanel;


public class Shape extends javax.swing.JPanel implements IShape ,Serializable{
    
            
    @Override
    public void FLinea(int x1, int y1, int x2, int y2,int r1,int g1,int b1,Graphics2D g,ArrayList lista) {
        ConsShape linea = new ConsShape();
        linea.tipo = 1;
        linea.line_x1 = x1;
        linea.line_y1 = y1;
        linea.line_x2 = x2;
        linea.line_y2 = y2;
        linea.line_r = r1;
        linea.line_g = g1;
        linea.line_b = b1;
        lista.add(linea);
       g.setColor(new Color(r1, g1, b1));
       g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void FTexto(String Cadena, int x1, int y1, int r2, int g2, int b2, Graphics2D g,ArrayList lista) {
        
        Font fuente=new Font("Monospaced", Font.BOLD, 36);
        ConsShape texto = new ConsShape();
        texto.funte = fuente;
        texto.txt_x1c = x1;
        texto.txt_y1c = y1;
        texto.txt_Cadena = Cadena;
        texto.txt_r = r2;
        texto.txt_g = g2;
        texto.txt_b = b2;
        texto.tipo = 2;
        lista.add(texto);
        g.setColor(new Color(r2, g2, b2));
        g.setFont(fuente);
        g.drawString(Cadena, x1, y1);
        
    }

    @Override
    public void FArco(int x, int y, int alto, int ancho, int ang_ini, int grados, int r3, int g3, int b3, Boolean fill, Graphics2D g,ArrayList lista) {
        ConsShape arco = new ConsShape();
        arco.tipo = 3;
        arco.arcox = x;
        arco.arcoy = y;
        arco.arcoalto = alto;
        arco.arcoancho = ancho;
        arco.arco_ang_ini = ang_ini;
        arco.arco_grados = grados;
        arco.arco_r = r3;
        arco.arco_g = g3;
        arco.arco_b = b3;
        arco.arco_fill = fill;
        lista.add(arco);
        g.setColor(new Color(r3, g3, b3));
        if(fill){

            g.fillArc(x, y, alto, ancho, ang_ini, grados);

        }else{

            g.drawArc(x, y, alto, ancho,ang_ini,grados);

        }
      
      
    }

    @Override
    public void FRectangulo(int x, int y, int alto, int ancho, int r4, int g4, int b4, Boolean fill, Graphics2D g,ArrayList lista) {
        ConsShape rectan = new ConsShape();
        rectan.tipo=4;
        rectan.rectan_x = x;
        rectan.rectan_y = y;
        rectan.rectan_alto = alto;
        rectan.rectan_ancho = ancho;
        rectan.recta_fill = fill;
        rectan.rectan_r = r4;
        rectan.rectan_g = g4;
        rectan.rectan_b = b4;
        lista.add(rectan);
        g.setColor(new Color(r4, g4, b4));
        if(fill){
            g.fillRect(x, y, ancho,alto);
        }else{
            g.drawRect(x, y, ancho, alto);
        }
        
    }

    @Override
    public void FOvalo(int x, int y, int ancho,int alto,int r5,int g5,int b5,Boolean fill, Graphics2D g,ArrayList lista) {
        
      ConsShape ovalo = new ConsShape();
      ovalo.tipo =5;
      ovalo.ovalo_tem =Color.MAGENTA;
      ovalo.ovalo_x1=x;
      ovalo.ovalo_y1=y;
      ovalo.ovalo_ancho = ancho;
      ovalo.ovalo_alto = alto;
      ovalo.ovalo_r = r5;
      ovalo.ovalo_g = g5;
      ovalo.ovalo_b = b5;
      ovalo.ovalo_fill = fill;
      lista.add(ovalo);
      g.setColor(new Color(r5, g5, b5));
      if(fill){
          g.fillOval(x,y,ancho,alto);
      }else{
          g.drawOval(x, y,ancho, alto);
      }
      
    }

    @Override
    public void FPoligono(int[] x, int[] y, int r6, int g6, int b6, Boolean fill, Graphics2D g,ArrayList lista) {
        ConsShape polig = new ConsShape();
        polig.tipo = 6;
        polig.polig_x = x;
        polig.polig_y = y;
        polig.polig_r = r6;
        polig.polig_g = g6;
        polig.polig_b = b6;
        polig.polig_fill = fill;
        Polygon poli = new Polygon(x, y, 2);
        polig.polig_ob = poli;
        lista.add(polig);
        g.setColor(new Color(r6, g6, b6));
        if(fill){
            g.fillPolygon(poli);
        }else{
            g.drawPolygon(poli);
        }
       
    }
    @Override
    public void Flienzo(int x, int y, int r,int g, int b,ArrayList lista){
        ConsShape lienzo = new ConsShape();
        lienzo.tipo = 7;
        lienzo.lien_ancho = x;
        lienzo.lien_alto = y;
        lienzo.lien_r = r;
        lienzo.lien_g = g;
        lienzo.lien_b = b;
        lista.add(lienzo);
    }

    public Shape() {
    repaint();
    }
    
    

}
