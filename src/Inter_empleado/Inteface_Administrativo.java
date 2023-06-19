package Inter_empleado;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import Empleados.Empleado;
import Leer_Bases_de_datos.Leer_estado_mesas;
import Menu.Estado_Mesa;


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
        
        //En esta parte establecemos que al presionar enter el boton seleccionado se presiona
        facturar.addKeyListener(Adaptador.accion_teclado(facturar));
        visualizar.addKeyListener(Adaptador.accion_teclado(visualizar));
        eliminar.addKeyListener(Adaptador.accion_teclado(eliminar));

        //Escuchador de facturar
        facturar.addActionListener(accion ->{
           Facturar fac = new Facturar(this);
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
            
            eli = null;
        });
        panel2.add(facturar);
        panel2.add(visualizar);
        panel2.add(eliminar);
        panel.add(panel2, BorderLayout.CENTER);
        
        return panel;
    }

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
            padre.setVisible(false);
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
        
    }
    class Tabla_mesas extends JDialog{
        public Tabla_mesas(JDialog padre,Estado_Mesa mesa){
            super(padre, true);
            setVisible(true);
            setResizable(false);
            add(paneltable());
            pack();
        }
        private JPanel paneltable(){
            JPanel panel = new JPanel();

            return panel;
        }
    }
    class Eliminar_pedidos extends JDialog{
        public Eliminar_pedidos(JFrame padre){
            super(padre, true);
            setLocation(padre.getLocationOnScreen());
            setVisible(true);
        }
    }
    
}
