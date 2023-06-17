package Empleados;

public class Gerente extends Empleado {

    public Gerente(String nombre, long documento, String nombre_usuario, String contraseña){
        super(nombre, documento, nombre_usuario, contraseña);
        tipo_empleado = Empleado.GERENTE;
    }
    
    @Override
    public int tipo_inter_grafica(){
        return 1;
    }
}
