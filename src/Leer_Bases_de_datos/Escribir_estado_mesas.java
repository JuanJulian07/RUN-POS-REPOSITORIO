package Leer_Bases_de_datos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import Menu.Estado_Mesa;

public class Escribir_estado_mesas {
    private Estado_Mesa mesa;
    private String[] datos;

    public Escribir_estado_mesas(Estado_Mesa mesa, String[] datos, String comentario, boolean estado_mesero, boolean estado_cocinero){
        
        mesa.set_estado_mesero(estado_mesero);
        mesa.set_estado_cocinero(estado_cocinero);
        mesa.set_comentario(comentario);
        this.mesa = mesa;
        this.datos = datos;
        guardar();

    }
    private void guardar(){
        try{
            PrintWriter escribir = new PrintWriter(new FileWriter("src\\Bases_de_datos\\Mesas\\Mesa"+mesa.get_num_mesa()+".csv", false));
            escribir.print(mesa.get_mesa_format());
            if(!(datos.length == 0)){
                
            }
            escribir.close();
            
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Archivo Mesa"+mesa.get_num_mesa()+", no encontrado", "Mesa no encontrada", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("guardado exitoso");
    }
}
