/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.packt.cifrado_mono;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author stalin
 */
public class Cifrado_mono {
    public static void main(String[] args) throws FileNotFoundException, IOException {

    Scanner sn = new Scanner(System.in);
   sn.useDelimiter("\n");
         long startTime = System.nanoTime();
        String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

        System.out.println("ingrese la ruta del archivo");
        String ruta = sn.next();
        File archivo = new File (ruta);
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         String frase ="";
         while((linea=br.readLine())!=null)
            frase=frase + linea ;
         long endTime = System.nanoTime();
  long timeElapsed = endTime - startTime;
System.out.println("se ejecuto el ingreso en milisegundosegundos " + timeElapsed / 1000000);
        
        String texto = codificar(letras, frase);
        System.out.println("Texto codificado: " + texto);
        
        texto = descodificar(letras, texto);
        System.out.println("Texto descodificado: " + texto);
        
    }
    
    public static String codificar(String letras, String texto){
    long startTime = System.nanoTime();

        String textoCodificado = "";
        
        texto = texto.toUpperCase();
        
        char caracter;
        for (int i = 0; i < texto.length(); i++) {
            caracter = texto.charAt(i);
            
            int pos = letras.indexOf(caracter);
         
            if(pos == -1){
                textoCodificado += caracter;
            }else{
                textoCodificado += letras.charAt( (pos + 3) % letras.length() );
            }
            
        }
                 long endTime = System.nanoTime();
  long timeElapsed = endTime - startTime;
System.out.println("se ejecuto la codificacion en milisegundosegundos " + timeElapsed / 1000000);
        return textoCodificado;

    }
    
    public static String descodificar(String letras, String texto){
            long startTime = System.nanoTime();
        String textoDescodificado = "";
        
        texto = texto.toUpperCase();
        
        char caracter;
        for (int i = 0; i < texto.length(); i++) {
            caracter = texto.charAt(i);
            
            int pos = letras.indexOf(caracter);
         
            if(pos == -1){
                textoDescodificado += caracter;
            }else{
                if(pos - 3 < 0){
                    textoDescodificado += letras.charAt( letras.length() + (pos - 3) );
                }else{
                    textoDescodificado += letras.charAt( (pos - 3) % letras.length() );
                }
            }
            
        }
                       long endTime = System.nanoTime();
  long timeElapsed = endTime - startTime;
System.out.println("se ejecuto la decodificacion en milisegundosegundos " + timeElapsed / 1000000);
        
        return textoDescodificado;
    }
}
