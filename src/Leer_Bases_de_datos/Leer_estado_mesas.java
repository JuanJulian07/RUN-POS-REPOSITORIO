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
                mesas.add(new Estado_Mesa(i, Boolean.parseBoolean(valores[4]), Boolean.parseBoolean(valores[5])));
                
                valor = null;
                valores = null;
                leer.close();
            }
            
        }
        catch(IOException e){
            System.out.println("cagaste");
        }
    }
}
