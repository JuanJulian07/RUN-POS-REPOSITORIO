package Leer_Bases_de_datos;

import java.util.*;
import Empleados.*;
import java.io.*;

public class Leer_empleados {
    
    //Atributos
    private Empleado em = null; //Guarda el empleado encontrado
    private String dir = new String("src\\Bases_de_datos\\Base_empleados.csv"); //Esta es la direccion por defecto del archivo de la base de datos
    private boolean acceso = false; //Sirve para verificar si podemos obtener acceso

    //Este constructor busque si hay un empleado registrado con el numero de identificacion
    public Leer_empleados(long documento){

        try{
            Scanner be = new Scanner(new File(dir));
            be.nextLine();

            while(be.hasNextLine()){
                String datos_empleado = be.nextLine();
                String aux[] = datos_empleado.split(";"); //Obtenemos un arreglo de Strings donde tenemos por separado cada tipo de dato

                

                if(documento == Long.parseLong(aux[0])){//Verificamos que si coincida algun usuario y procedemos a guardarlo dependiendo de su rol
                    
                    break;
                }
                else{
                    acceso = true;
                }
                
            }

        }
        catch(IOException exepcion){
            //Falta implementar un throw para la interface grafica
            String mensaje = new String ("No encontramos el archivo Base_empleados.csv en la direccion " + dir);
            System.out.print(mensaje);
            
        }

    }
    //Este constructor lee si hay un empleado con concidencias de usuario y contraseña
    public Leer_empleados(String usuario, String contra){
        try{
            Scanner be = new Scanner(new File(dir));
            be.nextLine();

            while(be.hasNextLine()){
                String datos_empleado = be.nextLine();
                String aux[] = datos_empleado.split(";"); //Obtenemos un arreglo de Strings donde tenemos por separado cada tipo de dato

                Empleado emaux = null;

                if(is_empleado(aux[3], aux[4], usuario, contra)){//Verificamos que si coincida algun usuario y procedemos a guardarlo dependiendo de su rol
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
        catch(IOException exepcion){
            //Falta implementar un throw para la interface grafica
            String mensaje = new String ("No encontramos el archivo Base_empleados.csv en la direccion " + dir);
            System.out.print(mensaje);
            
        }
    }

    //Este metodo nos reestablece la variable booleana acceso
    private boolean is_empleado(String bsusuario, String bscontra, String usuario, String contra){

        if(bsusuario.equals(usuario)){
            if(bscontra.equals(contra)){
                return acceso = true;
            }
            
        }
        return acceso;
    }

    public boolean get_acceso(){//retorna el valor de nuestra variable acceso
        return acceso;
    }

    public Empleado get_empleado(){//retorna el empleado que fue encontrado segun sea el caso
        if(acceso == true){
            return em;
        }
        else{
            return null;
        }
    }


}
