
package exemploserializados;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Metodos {
    ArrayList<Alumnos> alu= new ArrayList ();
    File fich;
    PrintWriter f = null;
    Scanner scan;
    
    
    
    public String pideNome(){
        return (JOptionPane.showInputDialog("Nome do alumno: "));
    }
    public float pideNota(){
        return (Float.parseFloat(JOptionPane.showInputDialog("Nota do alumno: ")));
    }
    
    public void escribirFich (String nomfich){
      
        
        try{
            fich = new File (nomfich);
            f= new PrintWriter(fich);
            for(int i=0;i<alu.size();i++){
              f.println(alu.get(i).getNome()+alu.get(i).getNota());  
          
            }
           
        }catch (FileNotFoundException ex){
            System.out.println("Error:" + ex.getMessage());  
        }finally{
            f.close();
        }           
}
   public void lerFich(){
       
       
       try{
          scan=new Scanner(fich);
          while(scan.hasNextLine()){
          String linea=scan.nextLine();
              System.out.println(linea);
          } 
                  
      }catch(FileNotFoundException ex){
       System.out.println("error: " + ex.getMessage());
                    
      }finally{
           scan.close();
       
   } 
   }
       public void ordenar(){
        Collections.sort(alu);
       }
       public void visualizar(){
         for(int i=0;i<alu.size();i++){
          System.out.println(alu);
                     
         }
       }
} 
    

