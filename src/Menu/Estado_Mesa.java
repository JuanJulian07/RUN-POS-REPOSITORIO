package Menu;

public class Estado_Mesa {
    
    private int num_mesa;
    private String comentario;
    private boolean estado_mesero;
    private boolean estado_cocinero;

    public Estado_Mesa(int num_mesa,String comentario, boolean estado_mesero, boolean estado_cocinero){
        
        this.num_mesa = num_mesa;
        this.comentario = comentario;
        this.estado_mesero = estado_mesero;
        this.estado_cocinero = estado_cocinero;
    }

    
    public int get_num_mesa(){
        return num_mesa;
    }
    public boolean get_estado_mesero(){
        return estado_mesero;
    }
    public boolean get_estado_cocinero(){
        return estado_cocinero;
    }
    public String get_comentario(){
        return comentario;
    }
    public String toString(){
        return(num_mesa + " " + estado_mesero + " "+estado_cocinero);
    }
}
