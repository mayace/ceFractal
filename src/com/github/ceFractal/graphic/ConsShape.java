/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.ceFractal.graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Polygon;

/**
 *
 * 
 */
public class ConsShape {
   
    /**
     * tipo = 1 linea
     * tipo = 2 texto
     * tipo = 3 arco
     * tipo = 4 rectangulo
     * tipo = 5 ovalo
     * tipo = 6 poligono
     * tipo = 7 lienzo
    */
    public int tipo;
    //parametros de una line
    public int line_x1,line_y1,line_x2,line_y2 = 0;
    public int line_r,line_g,line_b = 0;
    //parametros texto
    public String txt_Cadena ="";
    public int txt_x1c,txt_y1c=0;
    public int txt_r,txt_g,txt_b=0;
    public Font funte;
    
    //parametros arco
    public int arcox,arcoy, arcoalto,arcoancho,arco_ang_ini,arco_grados=0;
    public int arco_r,arco_g,arco_b=0;
    public Boolean arco_fill = false;
    
    //parametros recatangulo
    public int rectan_x,rectan_y,rectan_alto,rectan_ancho=0;
    public int rectan_r,rectan_g,rectan_b = 0;
    public Boolean recta_fill = false;
    
    //parametros ovalo
    public int ovalo_x1,ovalo_y1,ovalo_ancho,ovalo_alto=0;
    public int ovalo_r,ovalo_g,ovalo_b =0;
    public Boolean ovalo_fill=false;
    public Color ovalo_tem;
    
    //parametros poligono
    public int[] polig_x = new int[3];
    public int[] polig_y = new int[3];
    public int polig_r,polig_g,polig_b=0;
    public Boolean polig_fill =false;
    public Polygon polig_ob;
    
    //parametros para el lienzo
    public int lien_ancho,lien_alto = 0;
    public int lien_r,lien_g,lien_b = 0;

    public ConsShape() {
     polig_ob = new Polygon();
    }
    
}
