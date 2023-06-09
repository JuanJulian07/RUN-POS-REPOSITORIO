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

    //Metodos para obtener la informacion del empleado
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

    //Metodos para setear la informacion del empleado

    public void set_nombre(String nombre){
        this.nombre = nombre;
    }

    public void set_documento(long documento){
        numero_documento = documento;
    }

    public void set_tipo_empleado(String tipo){
        tipo_empleado = tipo;
    }

    public void set_usuario(String usuario){
        nombre_usuario = usuario;
    }

    public void set_contraseña(String contraseña){
        this.contraseña = contraseña;
    }

    //Metodo para ver los empleados
    public String toString(){
        return("\n"+get_num_documento() + ";" + get_nombre() + ";" + get_tipo_empleado() +";" + get_usuario() + ";" + get_contraseña());
    }
    //Metodo que retorna un arreglo de strings con los datos del empleado
    public String[] datos_empleado(){
        String[] datos = new String[5];
        datos[0] = new String(""+numero_documento);
        datos[1] = nombre;
        datos[2] = tipo_empleado;
        datos[3] = nombre_usuario;
        datos[4] = contraseña;

        return datos;
    }
}
