package Inter_empleado;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import Empleados.Empleado;
import Leer_Bases_de_datos.Leer_estado_mesas;
import Menu.Estado_Mesa;

public class Inteface_Administrativo extends JFrame{
    private JFrame padre;
    private static final int x_boton = 200;
    private Empleado empleado = null;
    private static final Dimension DIMENSION_DEFECTO = new Dimension(600,600);
    private static final Color COLOR_BOTON = new Color(66, 66, 66);
    
    //Constructor de la ventana principal de gerente
    public Inteface_Administrativo(Empleado empleado, JFrame padre){
        super("Administrativo");
        this.empleado = empleado;
        this.padre = padre;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        panel2.setOpaque(false);
        

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
        

        
        //Esta parte es para visualizar la base de datos empleados
        JButton visualizar = new JButton("Visualizar pedidos");
        visualizar.setFont(new Font("arial", Font.BOLD, 14));
        visualizar.setForeground(Color.WHITE);
        visualizar.setBounds(x_boton, facturar.getY()+120, 200, 100);//130
        visualizar.setBackground(COLOR_BOTON);

        //Esta parte es para modificar el menu/ visualizarlo
        JButton eliminar = new JButton("Eliminar Pedidos");
        eliminar.setFont(new Font("arial",Font.BOLD,14));
        eliminar.setForeground(Color.WHITE);
        eliminar.setBounds(x_boton, visualizar.getY()+120, 200, 100);
        eliminar.setBackground(COLOR_BOTON);
        
        JButton volver = new JButton(new ImageIcon(getClass().getResource("/Img/atras.png")));
        volver.setBounds(10, 440, 80, 80);
        volver.setContentAreaFilled(false);
        volver.setOpaque(false);
        volver.addActionListener(accion ->{
            this.dispose();
            padre.setVisible(true);
        });

        //En esta parte establecemos que al presionar enter el boton seleccionado se presiona
        facturar.addKeyListener(Adaptador.accion_teclado(facturar));
        visualizar.addKeyListener(Adaptador.accion_teclado(visualizar));
        eliminar.addKeyListener(Adaptador.accion_teclado(eliminar));

        //Escuchador de facturar
        facturar.addActionListener(accion ->{
           Facturar fac = new Facturar(this);
           setVisible(true);
           fac = null; 
        });

        //Escuchador de Ver_pedidos
        visualizar.addActionListener(accion -> {
            Ver_pedidos ver = new Ver_pedidos(this);
            setVisible(true);
            ver = null;
        });

        eliminar.addActionListener(accion -> {
            Eliminar_pedidos eli = new Eliminar_pedidos(this);
            setVisible(true);
            eli = null;
        });
        //Este apartado es para volver al sector anterior
        
        panel2.add(volver);
        panel2.add(facturar);
        panel2.add(visualizar);
        panel2.add(eliminar);
        panel.add(panel2, BorderLayout.CENTER);
        
        return panel;
    }
    
}

//Esta clase nos pertmite facturar los pedidos realizados
class Facturar extends JDialog{
    public Facturar(JFrame padre){
        super(padre, true);
        setLocation(padre.getLocationOnScreen());
        setVisible(true);
    }
}

// Esta es la clase que nos permite ver el estado de los pedidos
class Ver_pedidos extends JDialog{
    public Ver_pedidos(JFrame padre){

        super(padre, true);
        
        setTitle("Ver pedidos");
        setPreferredSize(new Dimension(500,500));
        setLocation(padre.getLocationOnScreen());
        setResizable(true);
        add(panel_ver_nombre());
        pack();
        //padre.setVisible(false);
        setVisible(true);
    }

    public JPanel panel_ver_nombre(){
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
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton[] botones = botones();
             
        if(botones != null){
                for(int i = 0 ; i < botones.length; i++){
                panel.add(botones[i]);
            }
        }
        else{
            panel.add(new JLabel("Actualmente no hay nada para mostrar"));
        }
            
        return panel;
    }
        
    private JButton[] botones(){
        //instanciamos las variables que vamos a utilizar
        JButton[] botones = null;
        ArrayList<Estado_Mesa> mesas;
            
        Leer_estado_mesas leer = new Leer_estado_mesas(Leer_estado_mesas.MESAS_ACTIVAS);
        mesas = leer.get_mesas();
        if(mesas.size()>0){
            botones = new JButton[mesas.size()];
            for(int i = 0; i < botones.length;i++){
                botones[i] = new JButton("Mesa"+mesas.get(i).get_num_mesa());
                botones[i].addKeyListener(Adaptador.accion_teclado(botones[i]));
                botones[i].setPreferredSize(new Dimension(100, 40));
                botones[i].setBackground(new Color(66, 66, 66));
                botones[i].setForeground(Color.WHITE);
                int num = i; 
                botones[i].addActionListener((accion) ->{
                    
                    new Tabla_mesas(this,mesas.get(num));
                });
            }
        }
            
        return botones;
    }
    
    class Tabla_mesas extends JDialog{
        public Tabla_mesas(JDialog padre,Estado_Mesa mesa){
            super(padre, false);
            setLocation(padre.getLocationOnScreen());
            setPreferredSize(new Dimension(500, 300));
            setResizable(false);
            add(paneltable(mesa));
            pack();
            setVisible(true);
        }
        private JPanel paneltable(Estado_Mesa mesa){
            String[] cabeza_tabla = {"item","Producto","Cantidad"};
            String[][] contenido_mesa = Leer_estado_mesas.get_contenido_mesa(mesa.get_num_mesa());

            JPanel panel = new JPanel(new BorderLayout());
            JPanel panel2 = new JPanel(new GridLayout(2, 1));

            //Pare de la tabla
            DefaultTableModel modelo = new DefaultTableModel(contenido_mesa, cabeza_tabla){
                //Esto es para que la tabla no sea editable
                @Override
                public boolean isCellEditable(int row, int column){
                    return column != 0 && column !=1 && column != 2;
                }
            };
            
            JTable tabla = new JTable(modelo);
            tabla.getTableHeader().setReorderingAllowed(false);
            tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
            //Establecemos el tamaño
            tabla.getColumnModel().getColumn(0).setPreferredWidth(45);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(350);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(70);
            //Hacemos que no se pueda cambiar el tamaño
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            //Lo agregamos a un scrolpane
            JScrollPane scrollpane = new JScrollPane(tabla);
            panel.add(scrollpane,BorderLayout.CENTER);

            //Parte del comentario
            JLabel label = new JLabel(mesa.get_comentario());
            label.setHorizontalAlignment(JLabel.CENTER);
            panel.add(label,BorderLayout.NORTH);

            //parte del estado de los meseros
            JLabel label_mesero = new JLabel("El pedido ya fue atendido por el mesero");
            JLabel label_cocinero = new JLabel(estado_cocinero(mesa.get_estado_cocinero()));
            panel2.add(label_mesero);
            panel2.add(label_cocinero);
            panel.add(panel2,BorderLayout.SOUTH);
            return panel;
        }
        private String estado_cocinero(boolean estado){
            return estado?"El pedido ya fue despachado por el cocinero":"El pedido sigue en preparacion";
        }
    }
        
}

class Eliminar_pedidos extends JDialog{
    public Eliminar_pedidos(JFrame padre){
        super(padre, true);
        setLocation(padre.getLocationOnScreen());
        setVisible(true);
    }
}