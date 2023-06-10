package Menu;

public class Menu {
    private int menu;
    private String nombre;
    private String descripcion;
    private long presio;
    private String descripcion_auxiliar = "";

    public Menu(int menu, String nombre, String descripcion, long presio){
        this.menu = menu;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.presio = presio;
    }

    public int get_menu_num(){
        return menu;
    }

    public String get_nombre(){
        return nombre;
    }

    public String get_descripcion(){
        return descripcion;
    }

    public long get_presio(){
        return presio;
    }

    public String[] get_arreglo_menu(){
        String[] arrMenu = new String[4];
        arrMenu[0]= ""+menu;
        arrMenu[1]= nombre;
        arrMenu[2]= descripcion;
        arrMenu[3]= "$"+presio;
        return arrMenu;
    }

    public String get_formatio_bd(){
        return ("\n" + menu + ";" + nombre + ";" + descripcion + ";" + ""+ presio);
    }


    public String Set_des_aux(){
        return descripcion_auxiliar;
    }

    public void set_des_aux(String descripcion){
        descripcion_auxiliar = descripcion;
    }

    public String toString(){
        return (menu + " " + nombre + " " + descripcion + " " + descripcion_auxiliar + " " + presio);
    }

    
}
