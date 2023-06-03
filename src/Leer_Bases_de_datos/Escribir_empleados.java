package Leer_Bases_de_datos;

import Empleados.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;



public class Escribir_empleados {
    
    public static final int ADD_EMPLEADO = 0;
    public static final int SOB_EMPLEADO = 1;
    public static final int REM_EMPLEADO = 2;
    private Empleado empleado;
    private String dir;
    
    public Escribir_empleados(Empleado empleado, int accion){
        this.empleado = empleado;

        switch (accion){
        case 0: 
        Leer_empleados leer = new Leer_empleados(empleado.get_num_documento(), empleado.get_usuario());
        if(!leer.get_acceso()){
            empleado = leer.get_empleado();
            NullPointerException ex = new NullPointerException("Nombre: " + empleado.get_nombre() + ".\nNumero de documento: " + empleado.get_num_documento() + ".\nUsuario: " + empleado.get_usuario() + ".");
            throw ex;
        }

        dir = leer.get_dir();
        leer = null;

        guardar_empleado();
        break;
        }
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
            JOptionPane.showMessageDialog(null, "No encontramos el archivo Base_empleados.csv en la direccion " + dir, "Error Base de datos Empleado", JOptionPane.ERROR_MESSAGE,null);
            System.exit(0);
        }
        
    }

    public Empleado get_Empleado(){
        return empleado;
    }
    
}
