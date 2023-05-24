package Inter_empleado;
import java.awt.*;

import javax.swing.*;
import Empleados.*;
import Bases_de_datos.*;
import java.io.*;
import java.util.Scanner;


public class Interface_Gerente extends JFrame{
    
    private static final int pixel_label = 460;
    private static final int pixel_buton = 100;
    private Empleado empleado = null;
    private static final Dimension DIMENSION_DEFECTO = new Dimension(1000,700);
    

    public Interface_Gerente(Empleado empleado){
        super("Gerente");
        this.empleado = empleado;
        
        ventana();
    }

    private void ventana(){
        setSize(DIMENSION_DEFECTO);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel());
        setVisible(true);

    }

    private JPanel panel(){
        JPanel p_gerente = new JPanel();

        p_gerente.setSize(1000,700);
        p_gerente.setLayout(null);

        JLabel saludo = new JLabel("Bienvendio "+ empleado.get_nombre());
        saludo.setBounds(0, 10, 1000, 40);
        saludo.setFont(new Font("times new roman",1,20));
        saludo.setHorizontalAlignment(saludo.CENTER);
        p_gerente.add(saludo);

        JLabel ingresar_empleado = new JLabel("01. Registro y cambio de usiarios y contraseñas");
        ingresar_empleado.setFont(new Font("arial", Font.BOLD,14));
        ingresar_empleado.setBounds(20,60,pixel_label,20);
        ingresar_empleado.setOpaque(true);
    
        p_gerente.add(ingresar_empleado);

        
        

        p_gerente.add(boton_bie());
        
        // Agregar los botones xd y demas para el gerente y asi mismo el resto de cuestiones xd;

        return p_gerente;
    }

    private JButton boton_bie(){

        JButton bie = new JButton("Ingresar");
        bie.setBounds(600, 60, pixel_buton, 20);
        bie.addActionListener(accion -> {
            int num_selection;
            String opciones[] = {"Ingresar personas", "Modificar personas"};


            num_selection = JOptionPane.showOptionDialog(this, "Selecciona la opcion que deceas realizar", "Ingreso o cambio de empleados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, 0);

            
            //ventana_ingreso_personal ventana_aux = new ventana_ingreso_personal(null);
            
        });

        return bie;
    }

    public class ventana_ingreso_personal extends JFrame{

        public ventana_ingreso_personal(Component component){
            setTitle("Ingreso de personal a la base de datos");
            setSize(600,400);
            setLocationRelativeTo(component);
            setVisible(true);
            
        }
    }
}
