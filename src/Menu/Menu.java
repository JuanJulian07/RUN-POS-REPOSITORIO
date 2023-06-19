package Menu;

public class Menu {
    //Bariables estaticas para otros tipos de datos
    public static final String ESPECIAL = "Especial";
    public static final String EJECUTIVO = "Ejecutivo";
    public static final String CORRIENTE = "Corriente";
    public static final String POSTRES = "Postres";
    public static final String BEBIDAS = "Bebidas";
    public static final String PIZZAS = "Pizzas";

    private int Item;
    private String nombre;
    private String descripcion;
    private String tipo;
    private long precio;
    private String descripcion_auxiliar = "";

    public Menu(int item, String nombre, String tipo,String descripcion, long precio){
        this.Item = item;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
    }

    public int get_menu_num(){
        return Item;
    }

    public String get_nombre(){
        return nombre;
    }

    public String get_descripcion(){
        return descripcion;
    }

    public long get_precio(){
        return precio;
    }
    public String get_tipo(){
        return tipo;
    }
    public String[] get_arreglo_menu(){
        String[] arrMenu = new String[5];
        arrMenu[0] = ""+Item;
        arrMenu[1] = nombre;
        arrMenu[2] = tipo;
        arrMenu[3] = descripcion;
        arrMenu[4] = ""+precio;
        return arrMenu;
    }

    public String get_formatio_bd(){
        return ("\n" + Item + ";" + nombre + ";" + tipo + ";" + descripcion + ";" + ""+ precio);
    }


    public String Get_des_aux(){
        return descripcion_auxiliar;
    }

    public void set_des_aux(String descripcion){
        descripcion_auxiliar = descripcion;
    }

    public String toString(){
        return (nombre + ": " + precio);
    }

    
}
