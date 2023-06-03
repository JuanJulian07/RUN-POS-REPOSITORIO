package Inter_empleado;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import Empleados.Empleado;
import Leer_Bases_de_datos.*;

public class Interface_ingreso extends JFrame{
    
    protected String usuario;
    protected String contra;
    protected JPanel panel;
    protected Empleado user;
    


    public Interface_ingreso(){
        super("Ventana de ingreso");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Panel_ingreso();
        setResizable(false);
        add(panel);
        
        setVisible(true);
        
        setIconImage(new ImageIcon("src\\Recursos_fotograficos\\icono_principal.jpg").getImage());
        
        
    }

    
    protected void Panel_ingreso(){
        //Retorna la configuracion del panel o la distribucion principalmente para el ingreso del personal con todos los botones
        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(getWidth(), getHeight());
        
        //Texto para el ingreso del nombre de usuario
        JLabel inUsuario = new JLabel();
        inUsuario.setText("Ingrese su nombre de Usuario");
        inUsuario.setBounds(getWidth()/2 - 100, 30, 200, 20);
        inUsuario.setForeground(new Color(255,195,0));

        panel.add(inUsuario);

        JTextField nombre_usuario = new JTextField();
        nombre_usuario.setBounds(getWidth()/2 -100,50, 200, 20);

        panel.add(nombre_usuario);

        JLabel inContra = new JLabel();
        inContra.setText("Ingrese tu contraseña");
        inContra.setBounds(getWidth()/2-100, 100, 200, 20);
        inContra.setForeground(new Color(255,195,0));

        panel.add(inContra);

       
        JPasswordField contra_usuario = new JPasswordField();
        contra_usuario.setBounds(getWidth()/2 -100,120, 200, 20);
        

        panel.add(contra_usuario);

        JButton ingreso = new JButton("Ingresar");
        ingreso.setBounds(getWidth()/2-100, 160, 100,20);
        
        ingreso.setSelected(false);
        
        
        ingreso.addKeyListener(accion_teclado(ingreso));
        contra_usuario.addKeyListener(accion_teclado(ingreso));

        ingreso.addActionListener(accion -> {
            usuario = nombre_usuario.getText();
            contra = new String(contra_usuario.getPassword());
            Leer_empleados verificacion = new Leer_empleados(usuario, contra);
            
            if(verificacion.get_acceso()== false){
                JOptionPane.showMessageDialog(this,"No pudimos encontrar tu usuario\n Intentalo nuevamente");
                nombre_usuario.setText("");
                contra_usuario.setText("");
            }
            else{
                
                JOptionPane.showMessageDialog(this,"Has ingresado correctamente " + verificacion.get_empleado().get_nombre());
                user = verificacion.get_empleado();
                this.dispose();
                
                
            }
            
        });

        panel.add(ingreso);

        //Imagen de fondo
        ImageIcon im = new ImageIcon("src\\Recursos_fotograficos\\icono_principal.jpg");
        ImageIcon im2 = new ImageIcon(im.getImage().getScaledInstance(getWidth(), getHeight(), 1));
        JLabel imagen_fondo = new JLabel(im2);
        imagen_fondo.setBounds(0, 0, getWidth(), getHeight()-30);
        panel.add(imagen_fondo);
        
    }

    
    public Empleado get_empleado(){
        if(user == null){
            return null;
        }
        return user;
    }
    
    private KeyAdapter accion_teclado (JButton boton){
        return new KeyAdapter() {
            public void keyPressed (KeyEvent e){
                if(e.getExtendedKeyCode() == 10){
                    boton.doClick();
                }
            }
        };
        
    }
}
