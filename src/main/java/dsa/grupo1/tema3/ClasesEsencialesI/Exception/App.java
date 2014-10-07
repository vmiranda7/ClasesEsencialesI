package dsa.grupo1.tema3.ClasesEsencialesI.Exception;

import java.io.*;
/**
 * Ejercicio 1.- Exceptions
 * Queremos que la salida por consola de un programa en Java sea la lista de números
 * enteros leídos de numeros.txt y los mensajes de todos los posibles errores del 
 * proceso capturados con catch. 
 *
 * Ejercicio 2.- Exceptions
 * Añade al ejercicio 1.- un nuevo tipo de excepción BigNumberException que salte
 * cuando el entero leído es superior a 1000.
 * 
 * Ejercicio 3.- Exceptions
 * Añade al ejercicio 1.- el uso de finally para garantizar que siempre cerramos
 * correctamente el fichero.
 */
public class App 
{
    public static void main( String[] args ) {
    	File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
   
        try {
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine()).
           archivo = new File ("C:\\archivo.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);
   
           // Lectura del fichero
           String linea;
           while((linea=br.readLine())!=null){
        	   String[] partes = linea.split(" ");
        	   for(int i = 0; i<partes.length-1; i++){
        		   int num = Integer.parseInt(partes[i]);
        		   if (num >=1000){
        			   System.out.println("El valor "+partes[i]+ " es mayor de 1000");
        			   throw new BigNumberException("Numero fuera de rango");
        		   }
        	   }

              System.out.println(linea);
           }
        }
        catch(Exception e){
           e.printStackTrace();
        }
        finally{
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }

    }
}
