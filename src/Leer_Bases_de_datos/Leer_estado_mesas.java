package Leer_Bases_de_datos;

import java.io.IOException;
import java.io.File;
import java.util.*;
import Menu.Estado_Mesa;

public class Leer_estado_mesas {
    ArrayList <Estado_Mesa> mesas = new ArrayList<Estado_Mesa>();
    public static final int TODOS = 0;
    public static final int MESAS_ACTIVAS = 1;
    public static final int MESAS_SATISFECHAS = 2;
    //public static final int MESAS_INACTIVAS=3;

    public Leer_estado_mesas(int opcion){
        leer_guardar();
        switch(opcion){
            case 0:
                break;
            case 1:
                for(int i = 0; i < mesas.size(); i++){
                    if(!mesas.get(i).get_estado_mesero()){
                        mesas.remove(i);
                        i--;
                    }
                }
                
                break;
            case 2:
                for(int i = 0; i < mesas.size(); i++){
                    if(!mesas.get(i).get_estado_cocinero()){
                        mesas.remove(i);
                        i--;
                    }
                }
        }
    }

    public ArrayList<Estado_Mesa> get_mesas(){
        return mesas;
    }
    private void leer_guardar(){
        String valor;
        String[] valores;
        try{
            for(int i = 1; i <= 20; i++ ){
                Scanner leer = new Scanner(new File("src\\Bases_de_datos\\Mesas\\Mesa"+i+".csv"));
                
                valor = leer.nextLine();
                valores = valor.split(";");
                mesas.add(new Estado_Mesa(i,valores[2] ,Boolean.parseBoolean(valores[4]), Boolean.parseBoolean(valores[5])));
                
                valor = null;
                valores = null;
                leer.close();
            }
            
        }
        catch(IOException e){
            System.out.println("cagaste");
        }
    }
    public static String[][] get_contenido_mesa(int num_mesa){
        
        String[][] contenido = null;
        String [] contenido_aux = null;
        ArrayList<String[]> aux = new ArrayList<String[]>();
        try{
            Scanner leer = new Scanner(new File("src\\Bases_de_datos\\Mesas\\Mesa"+num_mesa+".csv"));
            leer.nextLine();
            while(leer.hasNextLine()){
                contenido_aux = leer.nextLine().split(";");
                Valor valor = new Valor(Integer.parseInt(contenido_aux[0]), contenido_aux[1]);
                aux.add(valor.get_valor());
                
            }
            contenido_aux = null;
        }
        catch(IOException e){
            System.out.println("NO se pudo encontrar el archivo mesa");
        }

        if(aux.size()>0){
            contenido = new String[aux.size()][];

            for(int i = 0; i < aux.size(); i++){
                contenido[i] = aux.get(i);
            }
            aux.clear();
            aux = null;
        }

        return contenido;
    }

    private static class Valor{
        private String item;
        private String valor1;
        private String valor2;

        public Valor(int item, String valor2){//val 2 es la cantidad
            Leer_Menu leer = new Leer_Menu();
            this.item = ""+item;
            this.valor1 = leer.get_menu_item(item-1).get_nombre();
            this.valor2 = valor2;
        }

        public String[] get_valor(){
            String[] v = {item,valor1,valor2};
            return v;
        }

    }
}
