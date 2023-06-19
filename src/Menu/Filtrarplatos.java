package Menu;
import java.util.ArrayList;

import java.util.Iterator;
import Menu.Menu;
import Leer_Bases_de_datos.Leer_Menu;
public class Filtrarplatos {
    public static ArrayList<Menu> menu;
    public static ArrayList<Menu> especial=new ArrayList<>();
    public static ArrayList<Menu> ejecutivo=new ArrayList<>();
    public static ArrayList<Menu> corriente=new ArrayList<>();
    public static ArrayList<Menu> pizzas=new ArrayList<>();
    public static ArrayList<Menu> postres=new ArrayList<>();
    public static ArrayList<Menu> bebidas=new ArrayList<>();
     public Filtrarplatos(){
        Menu aux;
        Leer_Menu elemMenu= new Leer_Menu();
        menu=elemMenu.get_menu_listado();
        Iterator<Menu> it=menu.iterator();
        String temp;
        while(it.hasNext()){
            aux=it.next();
            temp=aux.get_tipo();
            if(temp.equals(Menu.ESPECIAL)){
                especial.add(aux);
            }else{
                if(temp.equals(Menu.EJECUTIVO)){
                    ejecutivo.add(aux);
                }else{
                    if(temp.equals(Menu.CORRIENTE)){
                        corriente.add(aux);
                    }else{
                        if(temp.equals(Menu.PIZZAS)){
                            pizzas.add(aux);
                        }else{
                            if(temp.equals(Menu.POSTRES)){
                                postres.add(aux);
                            }else{
                                if(temp.equals(Menu.BEBIDAS)){
                                    bebidas.add(aux);
                                }
                            }
                        }
                    }
                }
            }
        }
     }
     public static ArrayList<Menu> getejecutivo(){
        return ejecutivo;
     }
     public static ArrayList<Menu> getespecial(){
        return especial;
     }
     public static ArrayList<Menu> getcorriente(){
        return corriente;
     }
     public static ArrayList<Menu> getpizzas(){
        return pizzas;
     }
     public static  ArrayList<Menu> getpostres(){
        return postres;
     }
     public static ArrayList<Menu> getbebidas(){
        return bebidas;
     }

}
