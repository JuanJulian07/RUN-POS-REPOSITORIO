package Inter_empleado;
import javax.imageio.ImageIO;
import javax.swing.*;

import org.netbeans.lib.awtextra.AbsoluteLayout;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import Empleados.Empleado;


public class Inteface_Administrativo extends JFrame{

    private static final int x_boton = 200;
    private Empleado empleado = null;
    private static final Dimension DIMENSION_DEFECTO = new Dimension(600,600);
    private static final Color COLOR_BOTON = new Color(66, 66, 66);
    
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
        JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                
                // Carga la imagen de fondo
                ImageIcon im = new ImageIcon("src\\Recursos_fotograficos\\icono.jpg");
                im = new ImageIcon(im.getImage().getScaledInstance(getWidth(), getHeight(),Image.SCALE_SMOOTH));
                Image imagen_fondo = im.getImage();
                g.drawImage(imagen_fondo, 0, 0, getWidth(), getHeight(), this);
                
            }
        };
        panel.setLayout(new BorderLayout());
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        
        panel2.setBackground(new Color(0, 0, 0, Color.OPAQUE));

        //Mensaje de bienvenida al usuario gerente

        JLabel saludo = new JLabel("Bienvendio "+ empleado.get_nombre());
        //saludo.setBounds(0, 10, 1000, 40);
        saludo.setFont(new Font("times new roman",1,20));
        saludo.setHorizontalAlignment(saludo.CENTER);
        panel.add(saludo,BorderLayout.NORTH);

        //Boton para facutar pedidos
        JButton facturar = new JButton("Facturar pedidos");
        facturar.setFont(new Font("arial", Font.BOLD,14));
        facturar.setForeground(Color.WHITE);
        facturar.setBounds(x_boton, 50, 200, 100);
        facturar.setBackground(COLOR_BOTON);
        facturar.setFocusPainted(false);


        
        //parte dos, es para visualizar la base de datos empleados
        JButton visualizar = new JButton("Visualizar pedidos");
        visualizar.setFont(new Font("arial", Font.BOLD, 14));
        visualizar.setForeground(Color.WHITE);
        visualizar.setBounds(x_boton, facturar.getY()+120, 200, 100);//130
        visualizar.setBackground(COLOR_BOTON);
        visualizar.setFocusPainted(false);

        //Esta parte es para modificar el menu/ visualizarlo
        JButton eliminar = new JButton("Eliminar Pedidos");
        eliminar.setFont(new Font("arial",Font.BOLD,14));
        eliminar.setForeground(Color.WHITE);
        eliminar.setBounds(x_boton, visualizar.getY()+120, 200, 100);
        eliminar.setBackground(COLOR_BOTON);
        eliminar.setFocusPainted(false);
        

        panel2.add(facturar);
        panel2.add(visualizar);
        panel2.add(eliminar);
        panel.add(panel2, BorderLayout.CENTER);
        
        return panel;
    }
}
