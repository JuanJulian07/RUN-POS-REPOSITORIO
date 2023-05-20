package Inter_empleado;

import javax.swing.*;
import Empleados.Empleado;


public class Interface_ingreso extends JFrame{
    
    protected String usuario;
    protected String contrasñea;
    protected JPanel panel;
    protected Empleado user;


    public Interface_ingreso(){
        super("Ventana de ingreso");
        this.setSize(800,800);
        panel = Panel_ingreso();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Aprender lamdas para hacer el boton y repasar interfaces
        add(panel);
        pack();
        setVisible(true);

    }

    protected JPanel Panel_ingreso(){
        //Retorna la configuracion del panel o la distribucion principalmente para el ingreso del personal con todos los botones
        JPanel p = new JPanel(/*Ingresar el layout */);
        
        return p;
    }
    
}
