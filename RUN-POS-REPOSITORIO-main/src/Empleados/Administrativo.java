package Empleados;

public class Administrativo extends Empleado{
    public Administrativo(String nombre, long documento, String nombre_usuario, String contraseña){
        super(nombre, documento, nombre_usuario, contraseña);
        tipo_empleado = "Administrativo";
    }
    public Administrativo (Administrativo em){
        super(em);
    }

    @Override
    public int tipo_inter_grafica(){
        return 2;
    }
}
