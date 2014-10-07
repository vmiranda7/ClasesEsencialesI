package dsa.grupo1.tema3.ClasesEsencialesI.ESBásica5;

import java.io.*;
import java.util.Date;

/**
 * Ejercicio 5.- E/S Básica
 * Similar al ejercicio 4.- pero leemos un fichero tipo JPG y contamos el número de
 * bytes.
 */

public class App 
{
    public static void main( String[] args ) {
    	File imagen = null;
    	FileInputStream fr = null;
        BufferedInputStream br = null;
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try {
           imagen = new File ("foto.jpg");
           fr = new FileInputStream (imagen);
           br = new BufferedInputStream(fr);
           
        	   System.out.println("El fichero tiene " + imagen.length() +" carácteres");
        	   
        	   Date date = new Date();
        	   fichero = new FileWriter("registro2.txt");
               pw = new PrintWriter(fichero);
               pw.println(date+ " Nombre: " +imagen.getName() +" Caracteres: " + imagen.length());

        }
        catch(Exception e){
           e.printStackTrace();
        }
        finally{
           try{   
        	   if (null!= fichero)
        		   fichero.close();
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
        }
    }