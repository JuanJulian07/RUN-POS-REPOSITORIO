package Carpeta_de_ejecucion;

import Empleados.*;
import Inter_empleado.*;
import javax.swing.*;




public class Main {

    
    public static void main(String[] args)throws NullPointerException{

        //Enlace de los diagramas
        //https://lucid.app/lucidchart/e688b790-61e5-4f3c-b4fe-9bc67ce1aa03/edit?invitationId=inv_fa273c72-f1d5-47cb-a82a-f0f1505e27bd&page=0GSVd8AeXx9V#
        
        Empleado empleado = null;
        Interface_ingreso ingreso = new Interface_ingreso(true);
        
        
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
            Interface_Empleados gerente = new Interface_Empleados(empleado);
            gerente.verEstadisticas.setEnabled(false);
        }
        if(empleado instanceof Administrativo){
            Interface_Empleados admin = new Interface_Empleados(empleado);
            admin.infoMeseros.setEnabled(false);
            admin.verCocina.setEnabled(false);
            admin.verMenu.setEnabled(false);
            
        }
        if(empleado instanceof Cocinero){
            Interface_Empleados cocinero = new Interface_Empleados(empleado);
            cocinero.verEstadisticas.setEnabled(false);
            cocinero.infoMeseros.setEnabled(false);
        }
        if(empleado instanceof Mesero){
            Interface_Empleados mesero= new Interface_Empleados(empleado);
            mesero.verCocina.setEnabled(false);
            mesero.verEstadisticas.setEnabled(false);
            mesero.infoMeseros.setEnabled(false);
            
        }
    }
}
