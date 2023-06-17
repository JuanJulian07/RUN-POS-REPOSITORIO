package Menu;

public class Menu {
    //Bariables estaticas para otros tipos de datos
    public static final String ESPECIAL = "Especial";
    public static final String EJECUTIVO = "Ejecutivo";
    public static final String CORRIENTE = "Corriente";
    public static final String POSTRES = "Postres";
    public static final String BEBIDAS = "Bebidas";
    public static final String PIZZAS = "Pizzas";

    private int menu;
    private String nombre;
    private String descripcion;
    private String tipo;
    private long presio;
    private String descripcion_auxiliar = "";

    public Menu(int menu, String nombre, String tipo,String descripcion, long presio){
        this.menu = menu;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.presio = presio;
        this.tipo = tipo;
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
    public String get_tipo(){
        return tipo;
    }
    public String[] get_arreglo_menu(){
        String[] arrMenu = new String[5];
        arrMenu[0] = ""+menu;
        arrMenu[1] = nombre;
        arrMenu[2] = tipo;
        arrMenu[3] = descripcion;
        arrMenu[4] = ""+presio;
        return arrMenu;
    }

    public String get_formatio_bd(){
        return ("\n" + menu + ";" + nombre + ";" + tipo + ";" + descripcion + ";" + ""+ presio);
    }


    public String Get_des_aux(){
        return descripcion_auxiliar;
    }

    public void set_des_aux(String descripcion){
        descripcion_auxiliar = descripcion;
    }

    public String toString(){
        return (menu + " " + nombre + " " + tipo + " " +descripcion + " " + descripcion_auxiliar + " " + presio);
    }

    
}
