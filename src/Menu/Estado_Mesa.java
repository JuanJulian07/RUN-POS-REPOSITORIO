package Menu;

public class Estado_Mesa {
    
    private int num_mesa;
    private boolean estado_mesero;
    private boolean estado_cocinero;

    public Estado_Mesa(int num_mesa, boolean estado_mesero, boolean estado_cocinero){
        
        this.num_mesa = num_mesa;
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
    public String toString(){
        return(num_mesa + " " + estado_mesero + " "+estado_cocinero);
    }
}
