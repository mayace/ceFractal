/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prueba_pintar;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author erick
 */
public class Prueba_pintar {

    /**
     * @param args the command line arguments
     */
    //public static void main(String[] args) {
        // TODO code application logic here
        /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_paint().setVisible(true);
            }
        });*/
        	/*File fichero = new File("foto.jpg");
		String formato = "jpg";

		// Creamos la imagen para dibujar en ella.
		BufferedImage imagen = new BufferedImage(100, 100,BufferedImage.TYPE_INT_RGB);

		// Hacemos el dibujo
		Graphics g = imagen.getGraphics();
		g.setColor(Color.red);
		g.fillRect(50, 50, 100, 100);
		g.setColor(Color.green);
		g.fillRect(0, 0, 50, 50);
		g.setColor(Color.yellow);
		g.fillOval(25, 25, 50, 50);

		// Escribimos la imagen en el archivo.
		try {
			ImageIO.write(imagen, formato, fichero);
		} catch (IOException e) {
			System.out.println("Error de escritura");
		}*/
       /* JFrame unaVentana = new JFrame("la ventana");
		unaVentana.getContentPane().setLayout(new FlowLayout());
		unaVentana.getContentPane().add(new JLabel("etiqueta"));
		unaVentana.getContentPane().add(new JButton("boton"));
		unaVentana.getContentPane().add(new JTextField(20));
		unaVentana.pack();
		unaVentana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		unaVentana.setVisible(true);

		File fichero = new File("foto.jpg");
		String formato = "jpg";

		// Creamos la imagen para dibujar en ella.
		BufferedImage imagen = new BufferedImage(unaVentana.getContentPane().getWidth(),unaVentana.getContentPane().getHeight(), BufferedImage.TYPE_INT_RGB);

		// Hacemos el dibujo
		Graphics g = imagen.getGraphics();
		unaVentana.getContentPane().paint(g);

		// Escribimos la imagen en el archivo.
		try {
			ImageIO.write(imagen, formato, fichero);
		} catch (IOException e) {
			System.out.println("Error de escritura");
		}*/
   // }
    
}
