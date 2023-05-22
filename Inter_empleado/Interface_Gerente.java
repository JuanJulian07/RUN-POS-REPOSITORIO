package Inter_empleado;
import java.awt.*;

import javax.swing.*;
import Empleados.*;

public class Interface_Gerente extends JFrame{
    
    Empleado empleado = null;
    

    public Interface_Gerente(Empleado empleado){
        super("Gerente");
        this.empleado = empleado;
        
        ventana();
    }

    private void ventana(){
        setSize(1000,700);
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

        JLabel ingresar_empleado = new JLabel("01. Ingresar nuevo empleado  la base de datos Empleados");
        ingresar_empleado.setFont(new Font("arial", Font.BOLD,14));
        ingresar_empleado.setBounds(20,60,400,20);
        ingresar_empleado.setOpaque(true);
        
        
        p_gerente.add(ingresar_empleado);
        // Agregar los botones xd y demas para el gerente y asi mismo el resto de cuestiones xd;

        return p_gerente;
    }

    

}
