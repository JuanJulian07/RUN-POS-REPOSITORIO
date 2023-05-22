package Carpeta_de_ejecucion;
import Empleados.*;
import Inter_empleado.*;




public class Main {

    
    public static void main(String[] args)throws NullPointerException{

        //Enlace de los diagramas
        //https://lucid.app/lucidchart/e688b790-61e5-4f3c-b4fe-9bc67ce1aa03/edit?invitationId=inv_fa273c72-f1d5-47cb-a82a-f0f1505e27bd&page=0GSVd8AeXx9V#
        
        Empleado usuario = null;
        Interface_ingreso ingreso = new Interface_ingreso();
        
        
        while(usuario == null){
            usuario = ingreso.get_empleado();
            try{
                Thread.sleep(1000);
                
            }
            catch(InterruptedException a){}
            
            //Esto es solamente para el puncionamiento del programa y evitar el ciclo infinito
        }

        Interface_Gerente gerente = new Interface_Gerente(usuario);
        
        
        
    }
}
