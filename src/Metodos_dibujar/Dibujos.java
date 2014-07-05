
package Metodos_dibujar;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;


public interface Dibujos {
    
        public void FLinea(int x1, int y1, int x2, int y2,int r1,int g1,int b1,Graphics2D g,ArrayList lista);
        public void FTexto(String Cadena,int x, int y, int r2, int g2,int b2,Graphics2D g,ArrayList lista);
        public void FArco(int x, int y, int alto, int ancho, int ang_ini, int grados, int r3,int g3,int b3,Boolean fill,Graphics2D g,ArrayList lista);
        public void FRectangulo(int x, int y, int alto, int ancho,int r4,int g4,int b4,Boolean fill,Graphics2D g,ArrayList lista);
        public void FOvalo(int x, int y, int ancho, int alto,int r5,int g5,int b5,Boolean fill,Graphics2D g,ArrayList lista);
        public void FPoligono(int x[],int y[],int r6, int g6, int b6, Boolean fill,Graphics2D g,ArrayList lista);
        public void Flienzo(int x, int y, int r,int g, int b,ArrayList lista);
        
        
        
    
}
