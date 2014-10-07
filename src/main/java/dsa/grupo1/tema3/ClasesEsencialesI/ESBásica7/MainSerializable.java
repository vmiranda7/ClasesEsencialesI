package dsa.grupo1.tema3.ClasesEsencialesI.ESBásica7;

/**
 * Ejercicio 7.- E/S Básica
 * Crea una clase Dato que tenga tres atributos (uno int, otro String y finalmente
 * char) e implemente Serializable. El programa principal instanciará varios objetos
 * de tipo Dato, los guardará a fichero y los volverá a recuperar.
 */

import java.io.*;

public class MainSerializable
{
   public static void main (String [] args)
   {
	  Empleados a = null;
	  Empleados e = new Empleados("Victor Miranda", 1);
	    
      
      try
      {
    	  FileOutputStream fileOut = new FileOutputStream("empleado.ser");
    	  ObjectOutputStream out = new ObjectOutputStream(fileOut);
    	  out.writeObject(e);
    	  out.close();
    	  fileOut.close();
    	  System.out.printf("El Serializable esta salvado.\n"); 
         
         
    	  FileInputStream fileIn = new FileInputStream("empleado.ser");
    	  ObjectInputStream in = new ObjectInputStream(fileIn);
 	 	  a = (Empleados) in.readObject();
 	 	  in.close();
 	 	  fileIn.close();
 	 	  
 	 	  System.out.println("Empleado Serializable...");
 	 	  System.out.println("Nombre: " + a.name);
 	 	  System.out.println("Número: " + a.number);	
      }
      catch(IOException i)
      {
          i.printStackTrace();
      }
      catch(ClassNotFoundException c)
      {
         System.out.println("El empleado no se lee");
         c.printStackTrace();
         return;
      }
   }
}

