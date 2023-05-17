package Inter_empleado;

import javax.swing.*;


public class Interface_ingreso extends JFrame{
    
    protected String usuario;
    protected String contrasñea;
    protected JPanel panel;


    public Interface_ingreso(){
        super("Ventana de ingreso");
        this.setSize(800,800);
        panel = new JPanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);
        setVisible(true);

    }
    
}
