package dsa.grupo1.tema3.ClasesEsencialesI.ESBásica6;

import java.io.*;
import java.util.Date;


/**
 * Ejercicio 4.- E/S Básica
 * Haz un programa que lea un fichero de texto y cuente el número de caracteres que
 * tiene. Además debe añadir al fichero registro.txt la fecha y hora actuales
 * (formato “27/09/2013 20:01:23”) el nombre del fichero de texto y el número de
 * caracteres. En este ejercicio usar Buffered Streams.
 * 
 * Ejercicio 5.- E/S Básica
 * Similar al ejercicio 4.- pero leemos un fichero tipo JPG y contamos el número de
 * bytes.
 * 
 * Ejercicio 6.- E/S Basica
 * Haz un programa que lea el fichero registro.txt de los ejercicios 5.- y 6.- y
 * muestre en consola el fichero de mayor tamaño de caracteres o bytes.
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	File archivo = null;
    	File comparar = null;
    	File comparar2 = null;
        FileReader fr = null;
        BufferedReader br = null;
        FileReader fr2 = null;
        BufferedReader br2 = null;
        FileWriter fichero = null;
        FileWriter fichero2 = null;
        PrintWriter pw = null;
        
        File imagen = null;

   
        try {
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine()).
           archivo = new File ("archivo.txt");
           imagen = new File ("foto.jpg");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);
           Date date = new Date();
   
           // Lectura del fichero
           String linea;
           while((linea=br.readLine())!=null){
        	   System.out.println("El fichero tiene " + linea.length() +" carácteres");
           }       
           // Escritura de registro
           fichero = new FileWriter("registro.txt");
           pw = new PrintWriter(fichero);
           pw.println(date+ " Nombre: " +archivo.getName() +" Caracteres: " + archivo.length());
           
           //****************************//
           
           System.out.println("El fichero tiene " + imagen.length() +" carácteres");
           // Escritura de registro2 
           fichero2 = new FileWriter("registro2.txt");
           pw = new PrintWriter(fichero2);
           pw.println(date+ " Nombre: " +imagen.getName() +" Caracteres: " + imagen.length());
           
           
        	  
        }
        catch(Exception e){
           e.printStackTrace();
        }
        finally{
           try{   
        	   if (null!= fichero)
        		   fichero.close();
        	   if (null!= fichero)
        		   fichero2.close();
        	   comparar = new File ("registro.txt");
               fr = new FileReader (comparar);
               br = new BufferedReader(fr);
               
               comparar2 = new File ("registro2.txt");
               fr2 = new FileReader (comparar2);
               br2 = new BufferedReader(fr);
              
               
               if (comparar.length() >  comparar2.length()){
            	   System.out.println("El registro1 tiene mas caracteres");
            	   }
               if (comparar.length() <  comparar2.length() ){
            	   System.out.println("El registro2 tiene mas caracteres");
            	   }
               if (comparar.length() ==  comparar2.length() )
               {
            	   System.out.println("El fichero tiene los mismos caracteres"+ comparar.length()+"  "+comparar2.length());
               }
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }

    }
}
