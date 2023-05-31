package Inter_empleado;
import java.awt.*;


import javax.swing.*;
import Empleados.*;
import Leer_Bases_de_datos.Escribir_empleados;




public class Interface_Gerente extends JFrame{
    
    private static final int pixel_label = 460;
    private static final int pixel_buton = 100;
    private Empleado empleado = null;
    private static final Dimension DIMENSION_DEFECTO = new Dimension(1000,700);
    
    //Constructor de la ventana principal de gerente
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
        setIconImage(new ImageIcon("src\\Recursos_fotograficos\\icono_principal.jpg").getImage());
        setVisible(true);

    }
    //En este apartado registramos todas las posibles acciones que puede hacer el Gerente
    private JPanel panel(){
        JPanel p_gerente = new JPanel();

        p_gerente.setSize(1000,700);
        p_gerente.setLayout(null);

        //Mensaje de bienvenida al usuario gerente

        JLabel saludo = new JLabel("Bienvendio "+ empleado.get_nombre());
        saludo.setBounds(0, 10, 1000, 40);
        saludo.setFont(new Font("times new roman",1,20));
        saludo.setHorizontalAlignment(saludo.CENTER);
        p_gerente.add(saludo);

        //Primer apartado para registro y cambio de empleados
        JLabel ingresar_empleado = new JLabel("01. Registro y cambio de usiarios y contraseñas");
        ingresar_empleado.setFont(new Font("arial", Font.BOLD,14));
        ingresar_empleado.setBounds(20,60,pixel_label,20);
        p_gerente.add(ingresar_empleado);

        p_gerente.add(boton_bie()); //Esta funcion es la encargada del boton
        
        // Agregar los botones xd y demas para el gerente y asi mismo el resto de cuestiones xd;

        return p_gerente;
    }

    //Este metodo se encarga de crear y establecer acciones para el boton, lo cual nos despliega una ventana JDialog
    private JButton boton_bie(){

        JButton bie = new JButton("Ingresar");
        bie.setBounds(600, 60, pixel_buton, 20);
        bie.setSelected(false);
        bie.addActionListener(accion -> {
            int num_selection;
            String opciones[] = {"Ingresar Empleados", "Modificar Empleados", "Eliminar Empleados"};


            num_selection = JOptionPane.showOptionDialog(this, "Selecciona la opcion que deceas realizar", "Ingreso o cambio de empleados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, 0);

            if(num_selection == 0){
                ventana_ingreso_personal ventana_ingreso = new ventana_ingreso_personal(this,null);
                ventana_ingreso.setVisible(true);
                ventana_ingreso = null;
            }
            if(num_selection == 1){
                ventana_modificacion_personal ventana_mod = new ventana_modificacion_personal(this, null);
                ventana_mod.setVisible(true);
                ventana_mod = null;
            }
            if(num_selection == 2){
                System.out.println("eliminar");
            }
            
            
        });

        return bie;
    }

    
}

class ventana_modificacion_personal extends JDialog{
    private static final int ALINEACION = 350;
    private String usuario;
    private String contraseña;
    private long documento;

    public ventana_modificacion_personal(JFrame padre, Component componente){
        super(padre, true);
        setTitle("Cambiar usuario y contraseña");
        setResizable(false);
        setSize(500, 500);
        setLocationRelativeTo(componente);
    }
}

//Calse especifica para el apartado de ingresar empleados nuevos
class ventana_ingreso_personal extends JDialog{

    private static final int alineacion = 350;
    private Empleado empleado;
    private String valores_combobox[] = {Empleado.GERENTE,Empleado.ADMINISTRADOR,Empleado.COCINERO,Empleado.MESERO};

    public ventana_ingreso_personal(JFrame padre,Component component){
        
        super(padre,true);
        setTitle("Ingreso de personal a la base de datos");
        setSize(1000,700);
        setLocationRelativeTo(component);
        setResizable(false);
        
        
        add(panel());
        
           
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

            //En este apartado revisamos que todos los campos esten llenos correctamente
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
            
            //En caso que tengamos errores de ingreso de datos o datos nulos el programa nos avisara
            if(band == false){
                JOptionPane.showMessageDialog(this, error[0]+ error[1]+ error[2]+ error[3] + error[4], "Error en Ingreso", JOptionPane.ERROR_MESSAGE, null);

            }
            else{

                //En caso que no hayamos tenido errores, procederemos a verificar si el usuiario que se ingreso es nuevo o ya esta registrado
                String valor_auxiliar = valores_combobox[tipo.getSelectedIndex()];
                
                //Instanciamos nuestro tipo de empleado
                switch (valor_auxiliar){
                    case Empleado.GERENTE: 
                        empleado = new Gerente(ingreso_nombre.getText(),Long.parseLong(ingreso_documento.getText()),ingreso_nombre_usuario.getText(),ingreso_contraseña.getText());
                        break;
                    case Empleado.ADMINISTRADOR:
                        empleado = new Administrativo(ingreso_nombre.getText(),Long.parseLong(ingreso_documento.getText()),ingreso_nombre_usuario.getText(),ingreso_contraseña.getText());
                        break;
                    case Empleado.COCINERO:
                        empleado = new Cocinero(ingreso_nombre.getText(),Long.parseLong(ingreso_documento.getText()),ingreso_nombre_usuario.getText(),ingreso_contraseña.getText());
                        break;
                    case Empleado.MESERO:
                        empleado = new Mesero(ingreso_nombre.getText(),Long.parseLong(ingreso_documento.getText()),ingreso_nombre_usuario.getText(),ingreso_contraseña.getText());
                        break;
                }
                //Aqui verificamos que realmente es un nuevo empleado
                try{
                    Escribir_empleados escribir = new Escribir_empleados(empleado);
                    //Si no presenta un throw quiere decir que el empleado se ingreso correctamente a la base de datos y cerrara la ventana JDialog
                    JOptionPane.showMessageDialog(this, "Has ingresado correctamente el siguiente empleado:\n" + ingreso_nombre.getText() + "\n" + ingreso_documento.getText() + "\n" + ingreso_nombre_usuario.getText() + "\n" + ingreso_contraseña.getText(), "Ingreso exitoso", JOptionPane.INFORMATION_MESSAGE, null);
                
                    setVisible(false);
                }
                //En caso que tengamos el error el programa nos avisara y tendremos que digitar un empleado valido o simplemente salir de la ventana
                catch(NullPointerException ex){
                    
                    JOptionPane.showMessageDialog(this, "El usuario que intentas ingresar se encuentra registrado con los siguientes datos.\n\n"+ex.getMessage(), "Error al registrar", JOptionPane.ERROR_MESSAGE, null);
                    ingreso_nombre.setText("");
                    ingreso_documento.setText("");
                    ingreso_nombre_usuario.setText("");
                    ingreso_contraseña.setText("");
                }
                
                
            }

        });
        
        
        p_gerente.add(ingresar);
        return p_gerente;
    }

    //Metodo para los label y optimizar el codigo
    private JLabel label(String texto, int x, int y, int ancho, int largo){
        JLabel l = new JLabel(texto);
        l.setFont(new Font("arial", Font.BOLD,14));
        l.setBounds(x,y,ancho,largo);
        return l; 
    }

    //Metodo para los botones y optimizar el codigo
    private JTextField in_text(int x, int y, int ancho, int largo){
        JTextField text = new JTextField();
        text.setBounds(x, y, ancho, largo);
        return text;
    }

    
}
