package Carpeta_de_ejecucion;
import Empleados.*;
import java.util.*;
import Inter_empleado.*;
import Leer_Bases_de_datos.*;

public class Main {
    public static void main(String[] args){

        //Enlace de los diagramas
        //https://lucid.app/lucidchart/e688b790-61e5-4f3c-b4fe-9bc67ce1aa03/edit?invitationId=inv_fa273c72-f1d5-47cb-a82a-f0f1505e27bd&page=0GSVd8AeXx9V#
        
        
        Scanner t = new Scanner (System.in);
        Empleado am = null;
        String nombre = t.nextLine(); 
        String documento = t.nextLine();

        
        Leer_empleados emplea = new Leer_empleados(nombre, documento);

        System.out.println(emplea.get_acceso());
        am = emplea.get_empleado();
    }
}
