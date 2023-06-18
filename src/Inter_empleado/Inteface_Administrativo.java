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
    private static final Dimension DIMENSION_DEFECTO = new Dimension(700,500);
    
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
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(null);

        //Mensaje de bienvenida al usuario gerente

        JLabel saludo = new JLabel("Bienvendio "+ empleado.get_nombre());
        //saludo.setBounds(0, 10, 1000, 40);
        saludo.setFont(new Font("times new roman",1,20));
        saludo.setHorizontalAlignment(saludo.CENTER);
        panel.add(saludo,BorderLayout.NORTH);


        JButton ingresar_empleado = new JButton("01. FACTURAR PEDIDOS");
        ingresar_empleado.setFont(new Font("arial", Font.BOLD,14));
        ingresar_empleado.setBounds(250, 20, 200, 100);
        panel2.add(ingresar_empleado);

        
        //parte dos, es para visualizar la base de datos empleados
        JButton mostar_empleadosBD = new JButton("02. VISUALIZAR ESTADO PEDIDOS");
        mostar_empleadosBD.setFont(new Font("arial", Font.BOLD, 14));
        mostar_empleadosBD.setBounds(250, 130, 200, 100);
        panel2.add(mostar_empleadosBD);


        //Esta parte es para modificar el menu/ visualizarlo
        JButton modificar_menu = new JButton("03. Modificacion y visualizaicon del menu");
        
        modificar_menu.setFont(new Font("arial",Font.BOLD,14));
        modificar_menu.setBounds(250, 240, 200, 100);
        panel2.add(modificar_menu);

        /* 
        ImageIcon imagen = new ImageIcon("src\\Recursos_fotograficos\\icono.jpg");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(150, 150, 1));
        JLabel im = new JLabel(imagen);
        im.setBounds(panel2.getWidth()-167, panel2.getHeight()-110, 150, 150);
        panel2.add(im);*/
        panel.add(panel2, BorderLayout.CENTER);
        
        return panel;
    }
}
