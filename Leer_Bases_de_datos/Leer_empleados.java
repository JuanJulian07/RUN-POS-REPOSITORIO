package Leer_Bases_de_datos;

import java.util.*;
import Empleados.*;
import java.io.*;

public class Leer_empleados {
    
    private Empleado em = null;
    private String dir = new String("Bases_de_datos\\Base_empleados.csv");
    private boolean acceso = false;


    public Leer_empleados(String usuario, String contra){
        try{
            Scanner be = new Scanner(new File(dir));
            be.nextLine();

            while(be.hasNextLine()){
                String datos_empleado = be.nextLine();
                String aux[] = datos_empleado.split(";");

                Empleado emaux = null;

                if(is_empleado(aux[3], aux[4], usuario, contra)){
                    switch(aux[2]){
                        case "Gerente": emaux = new Gerente(aux[1],Long.parseLong(aux[0]), aux[3], aux[4]); break;
                        case "Administrativo": emaux = new Administrativo(aux[1],Long.parseLong(aux[0]), aux[3], aux[4]); break;
                        case "Cocinero": emaux = new Cocinero(aux[1],Long.parseLong(aux[0]), aux[3], aux[4]); break;
                        case "Mesero": emaux = new Mesero(aux[1],Long.parseLong(aux[0]), aux[3], aux[4]); break;
                    }
                    em = emaux;
                    break;
                }
                
            }

        }
        catch(IOException em){

            String menaje = new String ("No encontramos el archivo Base_empleados.csv en la direccion " + dir);

            System.out.print("nel");
        }
    }

    private boolean is_empleado(String bsusuario, String bscontra, String usuario, String contra){

        if(bsusuario.equals(usuario)){
            if(bscontra.equals(contra)){
                return acceso = true;
            }
            
        }
        return acceso;
    }

    public boolean get_acceso(){
        return acceso;
    }

    public Empleado get_empleado(){
        if(acceso == true){
            return em;
        }
        else{
            return null;
        }
    }


}
