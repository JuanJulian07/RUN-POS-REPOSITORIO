package Inter_empleado;
import javax.swing.*;

import org.netbeans.lib.awtextra.AbsoluteLayout;

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
        JPanel panel2 = new JPanel(null);
        panel.setLayout(new BorderLayout());

        //Mensaje de bienvenida al usuario gerente

        JLabel saludo = new JLabel("Bienvendio "+ empleado.get_nombre());
        //saludo.setBounds(0, 10, 1000, 40);
        saludo.setFont(new Font("times new roman",1,20));
        saludo.setHorizontalAlignment(saludo.CENTER);
        panel.add(saludo,BorderLayout.NORTH);

        panel2.setSize(1000, 600);
        JLabel label1 = new JLabel("Hola hijos de puta");
        label1.setBounds(50, 50, 300, 20);
        panel2.add(label1);
        ImageIcon imagen = new ImageIcon("src\\Recursos_fotograficos\\icono.jpg");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(150, 150, 1));
        JLabel im = new JLabel(imagen);
        im.setBounds(panel2.getWidth()-167, panel2.getHeight()-110, 150, 150);
        panel2.add(im);
        panel.add(panel2, BorderLayout.CENTER);
        return panel;
    }
}
