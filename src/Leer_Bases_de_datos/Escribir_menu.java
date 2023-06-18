package Leer_Bases_de_datos;
import java.util.ArrayList;
import Menu.Menu;
import javax.swing.JOptionPane;
import java.io.*;


public class Escribir_menu {
    private static String dir = new String ("src\\Bases_de_datos\\Base_menu.csv");
    public Escribir_menu(ArrayList<Menu> menu){
        //Esto solo se encargara de guardar la base de datos y listo xd
        try{
            PrintWriter escribir = new PrintWriter(new FileWriter(dir, false));
            escribir.print("Item;Tipo de plato;Tipo;Descripcion;Precio");
            for(Menu aux : menu){
                escribir.print(aux.get_formatio_bd());
            }
            escribir.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "No pudimos encontrar la base de datos Menu", "Error base de datos", JOptionPane.WARNING_MESSAGE);
        }
    }
}
