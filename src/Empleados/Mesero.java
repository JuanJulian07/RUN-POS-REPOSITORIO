package Empleados;

public class Mesero extends Empleado {
    public Mesero(String nombre, long documento, String nombre_usuario, String contraseña){
        super(nombre, documento, nombre_usuario, contraseña);
        tipo_empleado = Empleado.MESERO;
    }

    @Override
    public int tipo_inter_grafica(){
        return 4;
    }
}
