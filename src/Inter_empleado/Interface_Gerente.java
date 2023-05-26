package Inter_empleado;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


import Empleados.*;
import Bases_de_datos.*;



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
        
    
        p_gerente.add(ingresar_empleado);

        
        

        p_gerente.add(boton_bie());
        
        // Agregar los botones xd y demas para el gerente y asi mismo el resto de cuestiones xd;

        return p_gerente;
    }

    private JButton boton_bie(){

        JButton bie = new JButton("Ingresar");
        bie.setBounds(600, 60, pixel_buton, 20);
        bie.setSelected(false);
        bie.addActionListener(accion -> {
            int num_selection;
            String opciones[] = {"Ingresar personas", "Modificar personas"};


            num_selection = JOptionPane.showOptionDialog(this, "Selecciona la opcion que deceas realizar", "Ingreso o cambio de empleados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, 0);

            if(num_selection == 0){
                ventana_ingreso_personal ventana_ingreso = new ventana_ingreso_personal(null);
            }
            
            //ventana_ingreso_personal ventana_aux = new ventana_ingreso_personal(null);
            
        });

        return bie;
    }

    
}
class ventana_ingreso_personal extends JFrame{
    private static final int alineacion = 350;
    public ventana_ingreso_personal(Component component){
        setTitle("Ingreso de personal a la base de datos");
        setSize(1000,700);
        setLocationRelativeTo(component);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        

        add(panel());
        setResizable(false);
        
    }

    private JPanel panel(){
        JPanel p_gerente = new JPanel();

        p_gerente.setSize(1000,700);
        p_gerente.setLayout(null);

        JLabel saludo = new JLabel("Por favor ingrese los datos de su empleado a ingresar");
        saludo.setBounds(0, 10, 1000, 40);
        saludo.setFont(new Font("times new roman",1,20));
        saludo.setHorizontalAlignment(saludo.CENTER);
        p_gerente.add(saludo);

        JLabel ingresar_tipo = label("Ingresar el tipo de empleado", alineacion, 70, 350, 20);
        p_gerente.add(ingresar_tipo);
        
        
        String valores_combobox[] = {Empleado.GERENTE,Empleado.ADMINISTRADOR,Empleado.COCINERO,Empleado.MESERO};
        JComboBox<String> tipo = new JComboBox<String>(valores_combobox);
        tipo.setBounds(alineacion, ingresar_tipo.getY()+20, 120, 20);
        p_gerente.add(tipo);
        
        //Para ingresar el nombre del empleado
        JLabel nombre = label("Ingrese el nombre del empleado", alineacion, tipo.getY()+30, 350, 20);
        p_gerente.add(nombre);
        
        JTextField ingreso_nombre = in_text(alineacion, nombre.getY()+20, 350, 20);
        p_gerente.add(ingreso_nombre);

        //Para ingresar el documento del empleado
        JLabel documento = label("Ingrese elnumero de documento del empleado", alineacion,ingreso_nombre.getY()+30, 350, 20);
        p_gerente.add(documento);
        
        JTextField ingreso_documento = in_text(alineacion, documento.getY()+20, 350, 20);
        p_gerente.add(ingreso_documento);

        //Para ingresar el nombre de usuario
        JLabel nombre_usuario = label("Ingrese el nombre de usuario", alineacion, ingreso_documento.getY()+30 , 350, 20);
        p_gerente.add(nombre_usuario);

        JTextField ingreso_nombre_usuario = in_text(alineacion, nombre_usuario.getY()+20, 350, 20);
        p_gerente.add(ingreso_nombre_usuario);

        //Para ingresar la contraseña
        JLabel contraseña = label("Ingrese la contraseña", alineacion, ingreso_nombre_usuario.getY()+30 , 350, 20);
        p_gerente.add(contraseña);

        JTextField ingreso_contraseña = in_text(alineacion, contraseña.getY()+20, 350, 20);
        p_gerente.add(ingreso_contraseña);
        
        //Boton para agregar el empleado a la base de datos

        JButton ingresar = new JButton("Ingresar");
        ingresar.setBounds(alineacion, ingreso_contraseña.getY()+40, 100, 20);
        ingresar.addActionListener(accoin -> {
            //Metodo para guardar el empleado en la base de datos
            String[] error = {"","","","",""};
            boolean band = true;

            
            if(ingreso_nombre.getText().equals("")){
                error[0] = "El ingreso del nombre es obligatorio\n";
                band = false;
            }

            if(ingreso_documento.getText().equals("")){
                error[1] = "El ingreso del documento es obligatorio\n";
                band = false;
                
                
            }
            else{
                try{
                    Long.parseLong(ingreso_documento.getText());
                }
                catch(NumberFormatException e){
                    error[2] = "El documento no tiene un formato valido\n";
                    ingreso_documento.setText("");
                    band = false;
                }
            }

            if(ingreso_nombre_usuario.getText().equals("")){
                error[3] = "El ingreso del nombre de usuario es obligatorio\n";
                band = false;
            }
            
            if(ingreso_contraseña.getText().equals("")){
                error[4] = "El ingreso de la contraseña es obligatorio";
                band = false;
            }
            //Este me bota todos los errores que se hayan recogido
            if(band == false){
                JOptionPane.showMessageDialog(this, error[0]+ error[1]+ error[2]+ error[3] + error[4], "Error en Ingreso", JOptionPane.ERROR_MESSAGE, null);

            }
        });
        
        // Agregar los botones xd y demas para el gerente y asi mismo el resto de cuestiones xd;
        p_gerente.add(ingresar);
        return p_gerente;
    }

    private JLabel label(String texto, int x, int y, int ancho, int largo){
        JLabel l = new JLabel(texto);
        l.setFont(new Font("arial", Font.BOLD,14));
        l.setBounds(x,y,ancho,largo);
        return l; 
    }

    private JTextField in_text(int x, int y, int ancho, int largo){
        JTextField text = new JTextField();
        text.setBounds(x, y, ancho, largo);
        return text;
    }
}
