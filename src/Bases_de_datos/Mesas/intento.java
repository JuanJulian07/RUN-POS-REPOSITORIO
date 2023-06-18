package Bases_de_datos.Mesas;
import java.util.*;
import java.io.*;

public class intento{
    public static void main(String[] args) {
        for(int i = 0; i < 20; i++){
            try{
                 PrintWriter archiivo = new PrintWriter(new FileWriter("src\\Bases_de_datos\\Mesas\\Mesa"+(i+1)+".csv",false));
                 archiivo.print("Item;Descripcion auxiliar;mesa;false;false");
                 archiivo.print("\nDefault description;"+(i+1));

                archiivo.close();
            }
            catch(IOException e){
                System.out.println("nothing");
            }
           
        }
        
    }
}