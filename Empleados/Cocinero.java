package Empleados;

public class Cocinero extends Empleado {
    
    public Cocinero(String nombre, long documento, String nombre_usuario, String contraseña){
        super(nombre, documento, nombre_usuario, contraseña);
        tipo_empleado = Empleado.COCINERO;
    }

    @Override
    public int tipo_inter_grafica(){
        return 3;
    }
}
