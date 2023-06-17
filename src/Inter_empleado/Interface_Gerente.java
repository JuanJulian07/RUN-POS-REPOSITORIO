package Inter_empleado;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Empleados.*;
import Leer_Bases_de_datos.Escribir_empleados;
import Leer_Bases_de_datos.Escribir_menu;
import Leer_Bases_de_datos.Leer_Menu;
import Leer_Bases_de_datos.Leer_empleados;
import Menu.Menu;



public class Interface_Gerente extends JFrame{
    
    private static final int pixel_label = 460;
    private static final int pixel_buton = 150;
    private Empleado empleado = null;
    private Empleado empleado_aux = null;
    private static final Dimension DIMENSION_DEFECTO = new Dimension(1000,700);
    
    //Constructor de la ventana principal de gerente
    public Interface_Gerente(Empleado empleado){
        super("Gerente");
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
        
        //parte dos, es para visualizar la base de datos empleados
        JLabel mostar_empleadosBD = new JLabel("02. Visualisacion de empleados en base de datos");
        mostar_empleadosBD.setFont(new Font("arial", Font.BOLD, 14));
        mostar_empleadosBD.setBounds(20, ingresar_empleado.getY()+40, pixel_label, 20);
        p_gerente.add(mostar_empleadosBD);

        p_gerente.add(boton_mbd(mostar_empleadosBD.getY()));

        //Esta parte es para modificar el menu/ visualizarlo
        JLabel modificar_menu = new JLabel("03. Modificacion y visualizaicon del menu");
        modificar_menu.setBounds(20, mostar_empleadosBD.getY()+40, pixel_label, 20);
        modificar_menu.setFont(new Font("arial",Font.BOLD,14));

        p_gerente.add(modificar_menu);
        p_gerente.add(boton_menu(modificar_menu.getY()));
        // Esta es la imagen que sale en la parte del gerente

        ImageIcon imagen = new ImageIcon("src\\Recursos_fotograficos\\icono.jpg");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(150, 150, 1));
        JLabel im = new JLabel(imagen);
        im.setBounds(p_gerente.getWidth()-167, p_gerente.getHeight()-189, 150, 150);
        
        p_gerente.add(im);
        return p_gerente;
    }

    //Este metodo se encarga de crear y establecer acciones para el boton, lo cual nos despliega una ventana JDialog
    private JButton boton_bie(){

        JButton bie = new JButton("Ingresar");
        bie.setBounds(600, 60, pixel_buton, 20);
        bie.setSelected(false);
        bie.addActionListener(accion -> {
            int num_selection;
            String opciones[] = {"Ingresar Empleado", "Modificar datos empleado", "Eliminar Empleado"};


            num_selection = JOptionPane.showOptionDialog(this, "Selecciona la opcion que deceas realizar", "Ingreso o cambio de empleados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, 0);

            if(num_selection == 0){//En este apartado es par aingresar un nuevo empleado
                ventana_ingreso_personal ventana_ingreso = new ventana_ingreso_personal(this,null);//Nos envia a una ventana de dialogo para ingresar a un empleado
                ventana_ingreso.setVisible(true);
                ventana_ingreso = null;
            }
            if(num_selection == 1){//En este apartado es para modificar los empleados, entonces primero lo buscamos con el numero de documento
                long documento_aux = 0;
                boolean value = true;
                while(value){
                    try{
                        
                        String auxiliar = JOptionPane.showInputDialog(this,"Ingresa el documento del empleado a modificar", "Modificar empleado", JOptionPane.INFORMATION_MESSAGE);

                        
                        if(auxiliar == null){//Esto es para evitar errores cuando se cierre la ventana con la x
                            value = false;
                            break;
                        }
                        documento_aux = Long.parseLong(auxiliar);
                        Leer_empleados leer = new Leer_empleados(documento_aux);
                        empleado_aux = leer.get_empleado();
                        leer = null;
                        break;
                    }
                    catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(this, "El dato que ingresaste no es un numero","Error tipo de dato", JOptionPane.ERROR_MESSAGE);
                    }
                    catch(NullPointerException e){
                        JOptionPane.showMessageDialog(this, e.getMessage(), "Error Busqueda", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
                if(value){
                    //Nos envia a una ventana de dialogo para modificar el usuario y contraseña del empleado encontrado
                    ventana_modificacion_personal ventana_mod = new ventana_modificacion_personal(this,empleado_aux, null);
                    ventana_mod.setVisible(true);
                    ventana_mod = null;
                }
                
            }
            if(num_selection == 2){
                //En este apartado eliminamos a los empleados con solo ingresar el numero de documento
                long documento_aux = 0;
                boolean value = true;

                while(value){
                    try{
                        
                        String auxiliar = JOptionPane.showInputDialog(this,"Ingresa el documento del empleado a eliminar", "Eliminar empleado", JOptionPane.INFORMATION_MESSAGE);

                        
                        if(auxiliar == null){//Esto es para evitar errores cuando se cierre la ventana con la x
                            value = false;
                            break;
                        }
                        documento_aux = Long.parseLong(auxiliar);
                        Leer_empleados leer = new Leer_empleados(documento_aux);
                        empleado_aux = leer.get_empleado();
                        leer = null;
                        break;
                    }
                    catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(this, "El dato que ingresaste no es un numero","Error tipo de dato", JOptionPane.ERROR_MESSAGE);
                    }
                    catch(NullPointerException e){
                        JOptionPane.showMessageDialog(this, e.getMessage(), "Error Busqueda", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
                if(value){
                    Escribir_empleados escribir = new Escribir_empleados(empleado_aux, Escribir_empleados.REM_EMPLEADO);
                    JOptionPane.showMessageDialog(this, "El empleado:\n\nDocumento: " + empleado_aux.get_num_documento() + "\nNombre: " + empleado_aux.get_nombre() + "\n\n\tEliminado Satisfacotriamente", "Eliminacion Satisfactoria", JOptionPane.INFORMATION_MESSAGE, null);
                    escribir = null;
                }
                
            }
            
            
        });
        return bie;
    }

    //Este es el metodo para el boton que va a mostrar la base de datos de los empleados
    private JButton boton_mbd(int y_boton){
        JButton boton = new JButton("ver Info");
        boton.setBounds(600, y_boton, pixel_buton, 20);

        boton.addKeyListener(Adaptador.accion_teclado(boton));
        boton.addActionListener(accion -> {

            ver_base_empleados ver = new ver_base_empleados(this, null);
            ver.setVisible(true);
            ver = null;
        
        });

        return boton;
        
    }
    
    //Este es el metodo para el boton que va a mostrar y modificar la base de datos menu
    private JButton boton_menu(int y_boton){
        JButton boton = new JButton("Ver/modificar");
        boton.setBounds(600, y_boton, pixel_buton,20);
        boton.addKeyListener(Adaptador.accion_teclado(boton));
        boton.addActionListener(accion -> {
            String[] opciones = {"Ver menu","Modificar Menu"};
            int opcion;
            opcion = JOptionPane.showOptionDialog(this, "Seleccione una opcion", "Modificar o visulaizar menu", 1, 1, null, opciones, null);
            if(opcion == 0){
                Visulaizar_modificar_menu visualizar = new Visulaizar_modificar_menu(this, false);
                visualizar.setVisible(true);
                visualizar = null;
            }
            if(opcion == 1){
                Visulaizar_modificar_menu visualizar = new Visulaizar_modificar_menu(this, true);
                visualizar.setVisible(true);
                visualizar = null;
            }
        });
        return boton;
    }
}

//Calse para modifica los datos del usuario
class ventana_modificacion_personal extends JDialog{
    private static final int ALINEACION = 100;
    private Empleado empleado;

    public ventana_modificacion_personal(JFrame padre, Empleado empleado, Component componente){
        super(padre, true);
        this.empleado = empleado;
        setTitle("Por favor modifica los datos de tu empleado");
        setResizable(false);
        setSize(500, 400);
        setLocationRelativeTo(componente);

        add(panel());
    }

    public JPanel panel(){
        JPanel panel = new JPanel(null);
        panel.setSize(this.getSize());

        JLabel prin = new JLabel("Por favor cambie los datos del empleado:");
        prin.setBounds(0, 10, getWidth(), 20);
        prin.setFont(new Font("times new roman",1,20));
        prin.setHorizontalAlignment(prin.CENTER);
        panel.add(prin);

        JLabel prin2 = new JLabel(empleado.get_nombre());
        prin2.setBounds(0, prin.getY()+25, getWidth(), 20);
        prin2.setFont(new Font("times new roman",1,20));
        prin2.setHorizontalAlignment(prin2.CENTER);
        panel.add(prin2);
        
        //Cambio del nombre
        JLabel lusuario = label("Cambiar usuario", ALINEACION, prin2.getY()+50,200,20);
        panel.add(lusuario);
        
        JTextField usuario = in_text(ALINEACION,lusuario.getY()+20,250,20);
        usuario.setText(empleado.get_usuario());
        usuario.selectAll();
        panel.add(usuario);

        //Cambio de contraseña
        JLabel lcontraseña = label("Cambiar contraseña", ALINEACION, usuario.getY()+30,200,20);
        panel.add(lcontraseña);
        
        JTextField contraseña = in_text(ALINEACION,lcontraseña.getY()+20,250,20);
        contraseña.setText(empleado.get_usuario());
        contraseña.selectAll();
        panel.add(contraseña);

        //Agregacion del boton y sus acciones
        JButton boton = new JButton("Cambiar");
        boton.setBounds(ALINEACION, contraseña.getY()+40, 100, 20);
        panel.add(boton);

        boton.addKeyListener(Adaptador.accion_teclado(boton));
        contraseña.addKeyListener(Adaptador.accion_teclado(boton));
        boton.addActionListener(accion -> {
            
            String error[] = {"",""};
            boolean error_aux = true;
            if(usuario.getText().equals("")){
                error[0] = "Debes rellenar el campo del usuario\n";
                error_aux = false;
            }
            if(contraseña.getText().equals("")){
                error[1] = "Debes rellenar el campo contraseña";
                error_aux = false;
            }
            if(error_aux == false){
                JOptionPane.showMessageDialog(this, error[0]+error[1], "Error en el cambio de usuario y contraseña", JOptionPane.ERROR_MESSAGE, null);
                usuario.setText(empleado.get_usuario());
                usuario.selectAll();
                contraseña.setText(empleado.get_contraseña());
                contraseña.selectAll();
            }
            else{
                if(usuario.getText().equals(empleado.get_usuario())){
                    empleado.set_contraseña(contraseña.getText());
                    
                    //Implementar funcion cambir usuario y contraseña
                    Escribir_empleados escribir = new Escribir_empleados(empleado, Escribir_empleados.SOB_EMPLEADO);
                    escribir = null;
                    

                    JOptionPane.showMessageDialog(this, "La contraseña ha sido acutalizada exitosamente", "Cambio exitoso", JOptionPane.INFORMATION_MESSAGE, null);
                    setVisible(false);
                }
                else{
                    Leer_empleados leer = new Leer_empleados(usuario.getText());
                    if(leer.get_acceso()){
                        empleado.set_contraseña(contraseña.getText());
                        empleado.set_usuario(usuario.getText());

                        //Este objetto de por si modifica a los empleados
                        Escribir_empleados escribir = new Escribir_empleados(empleado, Escribir_empleados.SOB_EMPLEADO);
                        escribir = null;

                        JOptionPane.showMessageDialog(this, "El Usuario y la contraseña han sido acutalizados exitosamente", "Cambio exitoso", JOptionPane.INFORMATION_MESSAGE, null);
                        setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "El usuario que ingresaste, ya esta \nregistrado en la base de datos", "Error usuarios repetidos", JOptionPane.INFORMATION_MESSAGE, null);
                    }
                    leer = null;
                }
                
                
            }
            
            
        });
        return panel;
    }

    //Metodo para genera un label generico
    private JLabel label(String texto, int x, int y, int ancho, int largo){
        JLabel l = new JLabel(texto);
        l.setFont(new Font("arial", Font.BOLD,14));
        l.setBounds(x,y,ancho,largo);
        return l; 
    }

    //Metodo para leer texto genericos
    private JTextField in_text(int x, int y, int ancho, int largo){
        JTextField text = new JTextField();
        text.setBounds(x, y, ancho, largo);
        return text;
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
        
        //Escuchadores del boton
        ingresar.addKeyListener(Adaptador.accion_teclado(ingresar));
        ingreso_contraseña.addKeyListener(Adaptador.accion_teclado(ingresar));
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
                    Escribir_empleados escribir = new Escribir_empleados(empleado,Escribir_empleados.ADD_EMPLEADO);
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

//Clase para visualizar la base de datos empleado
class ver_base_empleados extends JDialog{
    private static final String[] ENCABEZADO = {"N_documento","Nombre","Tipo","Usuario","Contraseña"};
    private String[][] empleados_tab;
    private JFrame padre;

    public ver_base_empleados (JFrame padre, Component componente){
        
        super(padre, true);
        setLocationRelativeTo(null);
        this.padre = padre;
        
        setTitle("Base de Datos Empleados");
        setResizable(false);
        add(panel());
        
        pack();
        setLocation(padre.getX()+padre.getWidth()/2-this.getWidth()/2,padre.getY()+(padre.getHeight()-this.getHeight())/2);
    }
    private JPanel panel(){
        JPanel panel = new JPanel();
        //Agregando tabla para visualizar a los empleados
        ini_empleados_tab();
        JTable BDEmpleados = new JTable(empleados_tab,ENCABEZADO);
        BDEmpleados.setPreferredScrollableViewportSize(new Dimension(800,500));
        BDEmpleados.setEnabled(false);
        BDEmpleados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel model = BDEmpleados.getColumnModel();
        model.getColumn(0).setPreferredWidth(100);
        model.getColumn(1).setPreferredWidth(300);
        model.getColumn(2).setPreferredWidth(100);
        model.getColumn(3).setPreferredWidth(150);
        model.getColumn(4).setPreferredWidth(150);
        //Pendiente mostrar mejor el contenido de las columnas
        
        JScrollPane scrollpane  = new JScrollPane(BDEmpleados);
        panel.add(scrollpane);
        return panel;

        
    }
    private void ini_empleados_tab(){
        Leer_empleados leer = new Leer_empleados();
        ArrayList<Empleado> arrem = leer.get_empleados();

        empleados_tab = new String[arrem.size()][];

        for(int i = 0; i < arrem.size(); i++){
            empleados_tab[i] = arrem.get(i).datos_empleado();
        }
    }
}

class Visulaizar_modificar_menu extends JDialog{
    private String[][] menu_convertido;
    private String[] encabezado_menu = {"Item","Tipo de plato","Descripcion", "Presio"};
    public Visulaizar_modificar_menu(JFrame padre, boolean editable){
        super(padre, true);
        
        extraer_tabla(editable);
        setResizable(false);
        
        if(editable){
            setTitle("Modifiacion menu");
            add(panel_mod());
        }
        else{
            setTitle("Visualizacion menu");
            add(panel_vis());
            
        }
        setLocation(padre.getLocationOnScreen());
        pack();
    }

    private JPanel panel_mod(){
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new GridLayout(1, 2));
        JTable tabla = new JTable(menu_convertido, encabezado_menu);
        //ESTABLECEMOS UN MODELO EL CUAL NOS DEJA AGREGAR COLUMNAS Y HACER CIERTAS MODIFICACIONES A LA TABLA
        DefaultTableModel m = new DefaultTableModel(menu_convertido, encabezado_menu){
            @Override
            public boolean isCellEditable(int row, int column){
                return column !=0;
            }
        };
        //dEFINIMOS EL TAMAÑO DEL PANEL
        panel.setSize(900, 600);
        //ESTABLECEMOS UN MODELO PARA EDITAR MAS FACIL LA TABLA
        tabla.setModel(m);

        tabla.setPreferredScrollableViewportSize(new Dimension(900,500));
        tabla.setEnabled(true);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.getTableHeader().setReorderingAllowed(false);
        
        TableColumnModel modelo = tabla.getColumnModel();
        modelo.getColumn(0).setPreferredWidth(30);
        modelo.getColumn(1).setPreferredWidth(150);
        modelo.getColumn(2).setPreferredWidth(560);
        modelo.getColumn(3).setPreferredWidth(145);
        modelo.getColumn(0).setResizable(false);
        
        
        //Creamos un panel donde se puede hacer scroll por si la tabla es demasiado grande xd
        JScrollPane pscroll = new JScrollPane(tabla);
        
        
        
        //Este boton se encarga de agregar filas
        JButton add_colum = new JButton("Agregar columnas");
        add_colum.addKeyListener(Adaptador.accion_teclado(add_colum));
        add_colum.addActionListener(accion ->{
            int num = 0;
            num = m.getRowCount()+1;
            m.addRow(new Object[]{num,null,null,null});
        });
        //Este boton se encarga de verificar y guardar la info en la base de datos menu
        JButton save = new JButton("Guardar");
        save.addKeyListener(Adaptador.accion_teclado(save));
        save.addActionListener(accion ->{
            //Esto es por si hay celdas en modificacion al momento de pulsar el boton
            if(tabla.isEditing()){
                tabla.getCellEditor().stopCellEditing();
            }
            tabla.clearSelection();
            //En este apartado se eliminan las celdas vacias
            boolean aux = eliminar_campos_vacios(this, m);
            System.out.println(aux);
            if(aux){
                try{//Aqui se comprueba que los datos del presio sean correctos o mas bien validos
                    Escribir_menu escribir = new Escribir_menu(convertir_arreglo_menu(this, m));
                    escribir = null;
                    JOptionPane.showMessageDialog(this, "Menu Guardado Exitosamente", "El menu se ha guardado de forma exitosa", JOptionPane.INFORMATION_MESSAGE, null);
                    setVisible(false);
                }
                catch(NumberFormatException e){//Estado de prueba, pero la idea es que devuelva los datos que son
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Error con tipos de datos", JOptionPane.ERROR_MESSAGE, null);
                }
            }
            
           //ver que todo este piola antes de guardar
        });
        tabla.addKeyListener(Adaptador.accion_teclado_tablas_guardar(save));
        tabla.addKeyListener(Adaptador.accion_teclado_tablas(add_colum));
        
        
        panel2.add(add_colum);
        panel2.add(save);
        panel.add(pscroll,BorderLayout.CENTER);
        panel.add(panel2, BorderLayout.SOUTH);
        
        return panel;
    }
    private JPanel panel_vis(){
        JPanel panel = new JPanel();
        JTable tabla = new JTable(menu_convertido, encabezado_menu);
        
        tabla.setPreferredScrollableViewportSize(new Dimension(900,500));
        tabla.setEnabled(false);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

        TableColumnModel modelo = tabla.getColumnModel();
        modelo.getColumn(0).setPreferredWidth(30);
        modelo.getColumn(1).setPreferredWidth(150);
        modelo.getColumn(2).setPreferredWidth(560);
        modelo.getColumn(3).setPreferredWidth(160);
        
        
        JScrollPane pscroll = new JScrollPane(tabla);
        panel.add(pscroll);
        return panel;
    }


    private void extraer_tabla(boolean ver_editar){
        Leer_Menu leer = new Leer_Menu();
        ArrayList<Menu> menu = leer.get_menu_listado();
        menu_convertido = new String [menu.size()][];
        
        for(int i = 0; i < menu.size(); i++){
            menu_convertido[i] = menu.get(i).get_arreglo_menu();
            if(!ver_editar)
                menu_convertido[i][3] = "$" + menu_convertido[i][3];
            

        }
    }
    private boolean eliminar_campos_vacios(JDialog padre,DefaultTableModel tabla){
        ArrayList<Integer> casos_especiales = new ArrayList<Integer>();
        int dato;
        boolean band = true;
        //Esto es para eliminar las fias
        for(int i = 0; i < tabla.getRowCount(); i++){
            if((tabla.getValueAt(i, 1) == null)&&(tabla.getValueAt(i, 2) == null)&&(tabla.getValueAt(i, 3) == null)){
                tabla.removeRow(i);
                i--;
            }
            else if(tabla.getValueAt(i, 1) == null){
                casos_especiales.add(i+1);
                band = false;
            }
            else if(tabla.getValueAt(i, 2)== null){
                casos_especiales.add(i+1);
                band = false;
            } 
            else if(tabla.getValueAt(i, 3)== null){
                casos_especiales.add(i+1);
                band = false;
            }
        }

        for(int i = 0; i < tabla.getRowCount(); i++){
            tabla.setValueAt(i+1, i, 0);
        }
        
        if(!band){
            dato = JOptionPane.showConfirmDialog(padre, "Tienes los campos "+ casos_especiales+", Incompleto\nDeceas eliminarlo para proceder a guardar?", "Campos Incompletos", JOptionPane.OK_CANCEL_OPTION);
                if(dato == 0){
                    //revisar este apartado
                    for(int i = 0; i < casos_especiales.size(); i++){
                        tabla.removeRow(casos_especiales.get(i)-1-i);
                        
                    }
                    for(int i = 0; i < tabla.getRowCount(); i++){
                        tabla.setValueAt(i+1, i, 0);
                    }
                    
                }
                else{
                    
                    return false;
                }
                
        }
            
        
        
        casos_especiales.clear();
        casos_especiales = null;
        return true;
    }

    private ArrayList<Menu> convertir_arreglo_menu(JDialog padre, DefaultTableModel tabla){
        ArrayList<Menu> menu = new ArrayList<Menu>();
        ArrayList<Integer> errores = new ArrayList<Integer>();
        
        boolean band = true;
        int item = 0;
        String nombre = "";
        String descripcion = "";
        long presio = 0;

        for(int i = 0; i < tabla.getRowCount(); i++){
            
            try{
                item = (Integer)tabla.getValueAt(i, 0);
                nombre = (String) tabla.getValueAt(i, 1);
                descripcion = (String) tabla.getValueAt(i, 2);
                presio = Long.parseLong((String) tabla.getValueAt(i, 3));
                menu.add(new Menu(item,nombre, descripcion, presio));
            }
            catch(NumberFormatException e){
                errores.add((i+1));
                band = false;
            }
            
        }
        if(band){
            return menu;
        }
        else{
            NumberFormatException error = new NumberFormatException("El presio de las filas\n"+ errores.toString() + "\nSon incorrectos");
            throw error;
        }
        
    }
}