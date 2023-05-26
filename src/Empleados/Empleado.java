package Empleados;

public abstract class Empleado {
    public static final String GERENTE = "Gerente";
    public static final String MESERO = "Mesero";
    public static final String ADMINISTRADOR = "Administrador";
    public static final String COCINERO = "Cocinero";
    protected String nombre;
    protected long numero_documento;
    protected String tipo_empleado;
    protected String contraseña;
    protected String nombre_usuario;
    
    
    //Constructor para ingresar datos 
    protected Empleado(String nombre, long documento, String nombre_usuario, String contraseña){
        this.nombre = nombre;
        this.numero_documento = documento;
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
    }

    //Constructor para cargar el objeto de tipo empleado
    protected Empleado(Empleado em){
        nombre = em.nombre;
        numero_documento = em.numero_documento;
        tipo_empleado = em.tipo_empleado;
        nombre_usuario = em.nombre_usuario;
        contraseña = em.contraseña;
    }

    //Metodo a implementar
    abstract public int tipo_inter_grafica();

    public String get_nombre(){
        return nombre;
    }

    public long get_num_documento(){
        return numero_documento;
    }

    public String get_tipo_empleado(){
        return tipo_empleado;
    }

    public String get_usuario(){
        return nombre_usuario;
    }

    public String get_contraseña(){
        return contraseña;
    }
}
