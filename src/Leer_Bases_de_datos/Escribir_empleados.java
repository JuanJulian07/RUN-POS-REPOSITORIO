package Leer_Bases_de_datos;

import Empleados.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class Escribir_empleados {
    
    Empleado empleado;
    String dir;
    public Escribir_empleados(Empleado empleado){
        this.empleado = empleado;

        Leer_empleados leer = new Leer_empleados(empleado.get_num_documento());
        if(!leer.get_acceso()){
            NullPointerException ex = new NullPointerException();
            throw ex;
        }

        dir = leer.get_dir();
        leer = null;

        guardar_empleado();
    }

    private void guardar_empleado(){
        try{
            PrintWriter guardar = new PrintWriter(new FileWriter(dir,true));
            guardar.print("\n" + empleado.get_num_documento() + ";");
            guardar.print(empleado.get_nombre()+ ";");
            guardar.print(empleado.get_tipo_empleado()+ ";");
            guardar.print(empleado.get_usuario()+ ";");
            guardar.print(empleado.get_contraseña());

            guardar.close();
        }
        catch(IOException e){
            String mensaje = new String ("No encontramos el archivo Base_empleados.csv en la direccion " + dir);
            System.out.print(mensaje); // implementar joption pane
        }
        
    }
    
}
