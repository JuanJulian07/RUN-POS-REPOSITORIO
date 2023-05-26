package Carpeta_de_ejecucion;

import Empleados.*;
import Inter_empleado.*;
import javax.swing.*;




public class Main {

    
    public static void main(String[] args)throws NullPointerException{

        //Enlace de los diagramas
        //https://lucid.app/lucidchart/e688b790-61e5-4f3c-b4fe-9bc67ce1aa03/edit?invitationId=inv_fa273c72-f1d5-47cb-a82a-f0f1505e27bd&page=0GSVd8AeXx9V#
        
        Empleado empleado = null;
        Interface_ingreso ingreso = new Interface_ingreso();
        
        
        while(empleado == null){
            empleado = ingreso.get_empleado();
            try{
                Thread.sleep(100);
                
                
            }
            catch(InterruptedException a){}
            
            //Esto es solamente para el puncionamiento del programa y evitar el ciclo infinito
        }
        
        ingreso = null;

        if(empleado instanceof Gerente){
            Interface_Gerente gerente = new Interface_Gerente(empleado);
        }
        if(empleado instanceof Administrativo){
            //Implementar interface grafica
            System.out.println("admin");
        }
        if(empleado instanceof Cocinero){
            //Implementar interface grafica
            System.out.println("concinero");
        }
        if(empleado instanceof Mesero){
            //Implementar interface grafica
            System.out.println("mesero");
        }
    }
}
