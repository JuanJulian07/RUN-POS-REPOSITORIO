package Leer_Bases_de_datos;

import Empleados.*;
import java.util.Scanner;


public class Escribir_empleados {
    
    Empleado empleado;

    public Escribir_empleados(Empleado empleado){
        this.empleado = empleado;

        Leer_empleados leer = new Leer_empleados(empleado.get_num_documento());
        System.out.println(leer.get_acceso());//retornar un trows
    }
    
}
