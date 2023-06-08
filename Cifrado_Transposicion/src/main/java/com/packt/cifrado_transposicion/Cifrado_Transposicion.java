
package com.packt.cifrado_transposicion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author stalin
 */
public class Cifrado_Transposicion {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Hello World!");
        int cont=0;
        int filas=0;
                int columnas=0;

        
         int division = 0;
         int[] clave = {4,2,1,3,9,8,5,6,7,0,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        Cifrados c =new Cifrados();
      c.num_Columnas();
       /* File archivo = new File ("C:\\Users\\stalin\\Desktop\\650.txt");
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         String texto ="";
         while((linea=br.readLine())!=null)
            texto=texto + linea ;
   System.out.println(texto);
   
   
         System.out.println(texto.length()); 
                  System.out.println(clave.length); 
         division=(texto.length()/clave.length);
         filas=division+1;
                  System.out.println(filas); 
                  columnas=(texto.length()/filas);
                                    System.out.println(columnas); 
        char[][] arreglo_texto = new char[filas][columnas];
         for (int i = 0 ; i < filas ; i++) {
    for (int j = 0 ; j < columnas; j++) {
        arreglo_texto[i][j] = texto.charAt(cont);
        cont=cont+1;
    } 
    }
                  for (int i = 0 ; i < filas ; i++) {
                       for (int j = 0 ; j < columnas; j++) {
                         System.out.print(arreglo_texto[i][j]);
                                                    } 
                                     System.out.println("");
                                                }   
*/
}
}