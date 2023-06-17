package Inter_empleado;
import javax.swing.*;
import java.awt.*;

import Empleados.Empleado;


public class Inteface_Administrativo extends JFrame{

    private static final int pixel_label = 460;
    private static final int pixel_buton = 150;
    private Empleado empleado = null;
    private Empleado empleado_aux = null;
    private static final Dimension DIMENSION_DEFECTO = new Dimension(1000,700);
    
    //Constructor de la ventana principal de gerente
    public Inteface_Administrativo(Empleado empleado){
        super("Administrativo");
        this.empleado = empleado;
        setResizable(false);
        
        ventana();
        
    }

    private void ventana(){
        setSize(DIMENSION_DEFECTO);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel());
        setIconImage(new ImageIcon("src\\Recursos_fotograficos\\icono_principal.jpg").getImage());
        setVisible(true);

    }
    private JPanel panel(){
        JPanel panel = new JPanel();
        panel.setSize(1000,700);
        panel.setLayout(new BorderLayout());

        //Mensaje de bienvenida al usuario gerente

        JLabel saludo = new JLabel("Bienvendio "+ empleado.get_nombre());
        //saludo.setBounds(0, 10, 1000, 40);
        saludo.setFont(new Font("times new roman",1,20));
        saludo.setHorizontalAlignment(saludo.CENTER);
        panel.add(saludo,BorderLayout.NORTH);


        return panel;
    }
}
