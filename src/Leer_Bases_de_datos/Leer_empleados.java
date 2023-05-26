package Leer_Bases_de_datos;

import java.util.*;
import Empleados.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Leer_empleados {
    
    //Atributos
    private Empleado em = null; //Guarda el empleado encontrado
    private String dir = new String("src\\Bases_de_datos\\Base_empleados.csv"); //Esta es la direccion por defecto del archivo de la base de datos
    private boolean acceso = false; //Sirve para verificar si podemos obtener acceso
    private boolean acceso2 = false; //Para que nos retorne un usuario encontrado

    //Este constructor busque si hay un empleado registrado con el numero de identificacion
    public Leer_empleados(long documento, String nombre_usuario){

        try{
            Scanner be = new Scanner(new File(dir));
            be.nextLine();

            while(be.hasNextLine()){
                String datos_empleado = be.nextLine();
                String aux[] = datos_empleado.split(";"); //Obtenemos un arreglo de Strings donde tenemos por separado cada tipo de dato

                switch(aux[2]){
                    case "Gerente": em = new Gerente(aux[1],Long.parseLong(aux[0]), aux[3], aux[4]); break;
                    case "Administrativo": em = new Administrativo(aux[1],Long.parseLong(aux[0]), aux[3], aux[4]); break;
                    case "Cocinero": em = new Cocinero(aux[1],Long.parseLong(aux[0]), aux[3], aux[4]); break;
                    case "Mesero": em = new Mesero(aux[1],Long.parseLong(aux[0]), aux[3], aux[4]); break;
                }

                if(documento == Long.parseLong(aux[0])){//Verificamos que si coincida algun usuario y procedemos a guardarlo dependiendo de su rol
                    acceso = false;
                    acceso2 = true;
                    
                    break;
                }
                if(nombre_usuario.equals(aux[3])){
                    acceso = false;
                    acceso2 = true;
                    break;
                }
                else{
                    acceso = true;
                }
                
            }
            be.close();

        }
        catch(IOException exepcion){
            
            JOptionPane.showMessageDialog(null, "No encontramos el archivo Base_empleados.csv en la direccion " + dir, "Error Base de datos Empleado", JOptionPane.ERROR_MESSAGE,null);
            System.exit(0);
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
            be.close();

        }
        catch(IOException exepcion){
            
            JOptionPane.showMessageDialog(null, "No encontramos el archivo Base_empleados.csv en la direccion " + dir, "Error Base de datos Empleado", JOptionPane.ERROR_MESSAGE,null);
            System.exit(0);
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
        if(acceso)
            return em;
        else{
            if(acceso2)
                return em;
            
            else
                return null;
        }
    }

    public String get_dir(){
        return dir;
    }


}
