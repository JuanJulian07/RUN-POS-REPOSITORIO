package Leer_Bases_de_datos;
import java.util.*;

import Menu.Menu;
import java.io.*;
import javax.swing.JOptionPane;

public class Leer_Menu {
    //La ide es guardarlo en objetos de tipo menu
    private ArrayList<Menu> menu = new ArrayList<Menu>();
    private String dir = new String ("src\\Bases_de_datos\\Base_menu.csv");

    //Este constructor lee todo el archivo y lo almacena en un Arraylist
    public Leer_Menu(){
        try{
            Scanner leer = new Scanner(new File(dir));
            String auxiliar;
            String dividido[];
            leer.nextLine();
            
            while(leer.hasNextLine()){
                
                auxiliar = leer.nextLine();
                dividido = auxiliar.split(";");
                Menu m = new Menu(Integer.parseInt(dividido[0]),dividido[1],dividido[2],dividido[3],Long.parseLong(dividido[4]));
                menu.add(m);

            }
            leer.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "No pudimos encontrar la bases de datos en " + dir, "Base_menu not foud", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }


    public Menu get_menu_item(int num){
        return menu.get(num);
    }
    public ArrayList<Menu> get_menu_listado(){
        return menu;
    }
}
