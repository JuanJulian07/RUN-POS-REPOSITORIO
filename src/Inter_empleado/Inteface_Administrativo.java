package Inter_empleado;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import Empleados.Empleado;
import Factura.Factura;
import Leer_Bases_de_datos.Escribir_estado_mesas;
import Leer_Bases_de_datos.Leer_Menu;
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
           Facturar fac = new Facturar(this,null,0);
           fac = null; 
        });

        //Escuchador de Ver_pedidos
        visualizar.addActionListener(accion -> {
            new Ver_pedidos(this);
            setVisible(true);
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
    private JFrame padre;
    private int contador = 0;
    private Estado_Mesa mesa;
    private int suma = 0;
    private JTable datosTable;
    private JScrollPane jScrollPane2 = new JScrollPane();
    private JTable datosTable2 = new JTable();
    private JPanel jPanel9 = new JPanel();
    private JScrollPane jScrollPane4 = new JScrollPane();

    public Facturar(JFrame padre, Estado_Mesa mesa, int opcion){

        super(padre, true);
        setTitle("FACTURA");
        this.padre = padre;
        this.mesa = mesa;
        switch(opcion){
            case 0:
                
                setPreferredSize(new Dimension(500,500));
                setLocation(padre.getLocationOnScreen());
                setResizable(true);
                add(panel_ver_nombre());
                pack();
                setVisible(true);
                break;
            
            case 1:
                setMinimumSize(new java.awt.Dimension(680, 694));
                setLocation(padre.getLocationOnScreen());
                setResizable(false);
                initdatos();
                add(panel());
                setVisible(true);
                
        }
        

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
            
        Leer_estado_mesas leer = new Leer_estado_mesas(Leer_estado_mesas.MESAS_SATISFECHAS);
        mesas = leer.get_mesas();
        
        if(mesas.size()>0){
            botones = new JButton[mesas.size()];
            for(int i = 0; i < botones.length;i++){
                int num = i;
                botones[i] = new JButton("Mesa"+mesas.get(i).get_num_mesa());
                botones[i].addKeyListener(Adaptador.accion_teclado(botones[i]));
                botones[i].setPreferredSize(new Dimension(100, 40));
                botones[i].setBackground(new Color(66, 66, 66));
                botones[i].setForeground(Color.WHITE); 
                botones[i].addActionListener((accion) ->{
                    
                    new Facturar(padre, mesas.get(num), 1);
                    this.setVisible(false);
                });
            }
        }
            
        return botones;
    }
    private void initdatos(){
        jPanel9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel9.setMaximumSize(new java.awt.Dimension(781, 393));
        jPanel9.setMinimumSize(new java.awt.Dimension(781, 393));
        jPanel9.setLayout(null);

        datosTable2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        datosTable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        datosTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM" ,"NOMBRE", "CANTIDAD", "MESA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class,java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false,false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(datosTable2);

        jPanel9.add(jScrollPane4);
        jScrollPane4.setBounds(90, 50, 310, 300);
         
        datosTable = new JTable();
        datosTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        datosTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        datosTable.setModel(new javax.swing.table.DefaultTableModel(new String[][]{},new String [] {"ITEM","NOMBRE", "VALOR", "CANTIDAD"}) {
            Class[] types = new Class [] {
                java.lang.String.class,java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false,false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        
        jScrollPane2.setViewportView(datosTable);
    }
    private void limpiarTabla(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }
    private JPanel panel(){
        JPanel panel = new JPanel(null);
        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel.setMaximumSize(new java.awt.Dimension(620, 400));
        panel.setMinimumSize(new java.awt.Dimension(620, 400));

        JPanel jPanel11 = new JPanel();
        JTextField telCli = new JTextField();
        JTextField cedulaCli = new JTextField();
        //pendiente porque es una tabla
        JScrollPane jScrollPane5 = new JScrollPane();
        JTable factTable = new JTable();
        String val[][] = Leer_estado_mesas.get_contenido_mesa(mesa.get_num_mesa(), true);
        factTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        factTable.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        factTable.setModel(new javax.swing.table.DefaultTableModel(val,
            new String [] {
                "ITEM","NOMBRE", "VALOR", "CANTIDAD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        factTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(factTable);
        if (factTable.getColumnModel().getColumnCount() > 0) {
            factTable.getColumnModel().getColumn(0).setResizable(false);
            factTable.getColumnModel().getColumn(1).setResizable(false);
            factTable.getColumnModel().getColumn(2).setResizable(false);
            factTable.getColumnModel().getColumn(3).setResizable(false);
        }

        panel.add(jScrollPane5);
        jScrollPane5.setBounds(50, 330, 590, 150);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        jPanel11.setLayout(null);

        telCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                int k = (int) evt.getKeyChar();
                if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
                evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
            }
        });
        jPanel11.add(telCli);
        telCli.setBounds(110, 70, 160, 20);

        cedulaCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                int k = (int) evt.getKeyChar();
                if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
                    evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                }
            }
        });
        jPanel11.add(cedulaCli);
        cedulaCli.setBounds(110, 40, 160, 20);
        JLabel infoFact = new JLabel();
        JLabel jLabel32 = new JLabel();
        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel32.setText("Telefono:");
        jPanel11.add(jLabel32);
        jLabel32.setBounds(10, 70, 90, 20);

        JLabel jLabel37 = new JLabel();
        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel37.setText("Cedula:");
        jPanel11.add(jLabel37);
        jLabel37.setBounds(10, 44, 90, 20);

        JLabel jLabel29 = new JLabel();
        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel29.setText("Nombre Cliente:");
        jPanel11.add(jLabel29);
        jLabel29.setBounds(10, 14, 90, 20);

        JTextField nombreCli = new JTextField();
        nombreCli.setText("");
        nombreCli.addActionListener(accion ->{
            JOptionPane.showMessageDialog(null, "El pago se ha realizado satisfactoriamente.");
                cedulaCli.setText("");
                nombreCli.setText("");
                telCli.setText("");
                infoFact.setText("");
        });

        
        jPanel11.add(nombreCli);
        nombreCli.setBounds(110, 10, 160, 20);

        panel.add(jPanel11);
        jPanel11.setBounds(50, 120, 310, 110);

        JButton jButton10 = new JButton();
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/back.png"))); // NOI18N
        jButton10.setToolTipText("Volver");
        jButton10.setContentAreaFilled(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setVisible(false);
                padre.setVisible(true);
                
            }
        });
        panel.add(jButton10);
        jButton10.setBounds(50, 570, 70, 70);

        
        infoFact.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        infoFact.setText("Atendido por: Run Pos");
        infoFact.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel.add(infoFact);
        infoFact.setBounds(340, 290, 200, 30);

        JLabel fac = new JLabel();
        fac.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        fac.setText("RESTAURANTE RUN POS");
        panel.add(fac);
        fac.setBounds(50, 10, 340, 80);

        JLabel jLabel38 = new JLabel();
        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Teléfono: 6014000");
        panel.add(jLabel38);
        jLabel38.setBounds(50, 70, 200, 30);

        JLabel jLabel39 = new JLabel();
        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setText("       Factura:            001         Serie:            1             Fecha:   ");
        jLabel39.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel.add(jLabel39);
        jLabel39.setBounds(50, 250, 410, 30);

        JLabel logo = new JLabel();
        ImageIcon im = new ImageIcon(getClass().getResource("/Recursos_fotograficos/icono.jpg"));
        logo.setIcon(new javax.swing.ImageIcon(im.getImage().getScaledInstance(210, 150, Image.SCALE_SMOOTH))); // NOI18N
        panel.add(logo);
        logo.setBounds(410, 30, 210, 150);

        JLabel jTextField40 = new JLabel();
        jTextField40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField40.setText("Mesa: ");
        jTextField40.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel.add(jTextField40);
        jTextField40.setBounds(50, 290, 60, 30);

        JLabel numMesa2 = new JLabel("Mesa " + mesa.get_num_mesa());
        numMesa2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numMesa2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel.add(numMesa2);
        numMesa2.setBounds(120, 290, 100, 30);

        JLabel horario = new JLabel();
        horario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        horario.setText("Lunes a Sábado 9:00 am a 9:00 pm");
        panel.add(horario);
        horario.setBounds(60, 510, 240, 60);

        JLabel jLabel33 = new JLabel();
        jLabel33.setFont(new java.awt.Font("Vrinda", 0, 14)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("HORARIO DE ATENCION");
        panel.add(jLabel33);
        jLabel33.setBounds(100, 490, 170, 21);

        JLabel jLabel16 = new JLabel();
        jLabel16.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel16.setText("+PROPINA");
        panel.add(jLabel16);
        jLabel16.setBounds(360, 510, 90, 20);

        JLabel jLabel18 = new JLabel();
        jLabel18.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel18.setText("+IVA");
        panel.add(jLabel18);
        jLabel18.setBounds(360, 490, 90, 20);

        JLabel jLabel19 = new JLabel();
        jLabel19.setFont(new java.awt.Font("Courier New", 3, 12)); // NOI18N
        jLabel19.setText("TOTAL COMPRA");
        panel.add(jLabel19);
        jLabel19.setBounds(360, 540, 110, 20);

        double total = 0;
        for(int i = 0; i < factTable.getRowCount(); i++){
            total += Double.parseDouble((String)factTable.getValueAt(i, 2)) * Double.parseDouble((String)factTable.getValueAt(i, 3));
        }
        JLabel TOTALtot = new JLabel();
        TOTALtot.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        TOTALtot.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TOTALtot.setText(""+total);
        panel.add(TOTALtot);
        TOTALtot.setBounds(530, 540, 80, 17);

        JLabel IVA = new JLabel();
        IVA.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        IVA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        IVA.setText("0.0");
        panel.add(IVA);
        IVA.setBounds(520, 490, 80, 14);

        JButton jButton19 = new JButton();
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pay-per-click (1).png"))); // NOI18N
        jButton19.setContentAreaFilled(false);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                        //BOTON FINALIZA FACTURA
                Factura f = new Factura();
                f.numventas = 0;
                
                if ((nombreCli.getText().equals("")) && (cedulaCli.getText().equals("")) && (telCli.getText().equals(""))) {
                    JOptionPane.showMessageDialog(null, "No ha llenado la informacion del cliente");
                    
                } 
                
                if (((!nombreCli.getText().equals("")) && (!cedulaCli.getText().equals("")) && (!telCli.getText().equals("")))) {
                    contador++;
                    suma = (int) (suma + Double.parseDouble(TOTALtot.getText()));
                f.numventas = f.numventas + 1;
                    JOptionPane.showMessageDialog(null, "El pago se ha realizado satisfactoriamente. HASTA LUEGO");
                    String[] aux = new String[0];
                    Escribir_estado_mesas escribir = new Escribir_estado_mesas(mesa, aux, "Descripcion auxiliar", false, false);
                    setVisible(false);

                    padre.setVisible(true);
                    
                    nombreCli.setText("");
                    cedulaCli.setText("");
                    telCli.setText("");
                    numMesa2.setText("");
                    limpiarTabla(datosTable);
                    limpiarTabla(factTable);
                    limpiarTabla(datosTable2);

                }
            }
        });
        panel.add(jButton19);
        jButton19.setBounds(550, 590, 70, 70);

        
        return panel;
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
                    
                    Tabla_mesas t = new Tabla_mesas(this,mesas.get(num),Tabla_mesas.ADMIN);
                });
            }
        }
            
        return botones;
    }
    
        
}
// Esta clase nos permite eliminar pedidos siempre y cuando no hayan salido de cocina o no esten en preparacion
class Eliminar_pedidos extends JDialog{
    public Eliminar_pedidos (JFrame padre){

        super(padre, true);
        
        setTitle("Eliminar Pedidos");
        setPreferredSize(new Dimension(500,500));
        setLocation(padre.getLocationOnScreen());
        setResizable(true);
        add(panel_ver_nombre());
        pack();
        
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
            
        Leer_estado_mesas leer = new Leer_estado_mesas(Leer_estado_mesas.MESAS_INSATISFECHAS);
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
                    
                    Tabla_mesas t = new Tabla_mesas(this,mesas.get(num),Tabla_mesas.ADMIN_ELIMINAR);

                });
            }
        }
            
        return botones;
    }
    
        
}
class Tabla_mesas extends JDialog{
    public static final int MESERO = 1;
    public static final int ADMIN = 0;
    public static final int ADMIN_ELIMINAR = 2;
    private Estado_Mesa mesa_mesero; 
    private String[] valores_mesa_llenos;
    private JDialog padre;
        public Tabla_mesas(JDialog padre,Estado_Mesa mesa,int opcion){
            
            super(padre);
            this.padre = padre;
            switch (opcion){
                case 0:
                    setModal(false);
                    add(paneltableadmin(mesa));
                    break;
                case 1:
                    setModal(true);
                    add(paneltablames(mesa));
                    break;
                case 2:
                    setModal(true);
                    add(paneltableadmin_eli(mesa));
                    break;
            }
            setLocation(padre.getLocationOnScreen());
            setPreferredSize(new Dimension(500, 300));
            setResizable(false);
            pack();
            setVisible(true);
        }
        private JPanel paneltableadmin(Estado_Mesa mesa){
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
            label_mesero.setOpaque(true);
            label_mesero.setBackground(Color.green);
            JLabel label_cocinero = new JLabel();
            label_cocinero.setText(estado_cocinero(mesa.get_estado_cocinero(), label_cocinero));

            panel2.add(label_mesero);
            panel2.add(label_cocinero);
            panel.add(panel2,BorderLayout.SOUTH);
            return panel;
        }
        private JPanel paneltablames(Estado_Mesa mesa){
            String[] cabeza_tabla = {"item","Producto","Cantidad"};
            String[][] contenido_mesa = Leer_estado_mesas.get_contenido_mesa(mesa.get_num_mesa());

            JPanel panel = new JPanel(new BorderLayout());

            //Pare de la tabla
            DefaultTableModel modelo = new DefaultTableModel(contenido_mesa, cabeza_tabla){
                //Esto es para que la tabla no sea editable
                @Override
                public boolean isCellEditable(int row, int column){
                    return column != 0;
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
            JTextField comentario = new JTextField(mesa.get_comentario());
            panel.add(comentario,BorderLayout.NORTH);

            //Parte para guardar la info
            JButton guardar = new JButton("Guardar");
            guardar.addActionListener(accion ->{
                set_mesa(mesa, comentario.getText());
                set_valores(tabla);
                setVisible(false);
            });

            JButton Añadir = new JButton("Añadir");
            guardar.addActionListener(accion ->{
                set_mesa(mesa, comentario.getText());
                set_valores(tabla);
                setVisible(false);
            });


            panel.add(guardar,BorderLayout.SOUTH);
            return panel;
        }
        private JPanel paneltableadmin_eli(Estado_Mesa mesa){
            String[] cabeza_tabla = {"item","Producto","Cantidad"};
            String[][] contenido_mesa = Leer_estado_mesas.get_contenido_mesa(mesa.get_num_mesa());

            JPanel panel = new JPanel(new BorderLayout());
            JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
            //Pare de la tabla
            DefaultTableModel modelo = new DefaultTableModel(contenido_mesa, cabeza_tabla){
                //Esto es para que la tabla no sea editable
                @Override
                public boolean isCellEditable(int row, int column){
                    return column != 0;
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
            JTextField comentario = new JTextField(mesa.get_comentario());
            panel.add(comentario,BorderLayout.NORTH);

            //Parte para guardar la info
            JButton guardar = new JButton("Guardar");
            guardar.addActionListener(accion ->{
                boolean band = false;
                set_mesa(mesa, comentario.getText());
                set_valores(tabla);
                if(valores_mesa_llenos.length == 0){
                    new Escribir_estado_mesas(mesa, valores_mesa_llenos, mesa.get_comentario(), false, false);
                    band = true;
                }
                else{
                    new Escribir_estado_mesas(mesa, valores_mesa_llenos, mesa.get_comentario(), true, false);
                }
                
                setVisible(false);
                if(band){
                    padre.setVisible(false);
                    padre = new Eliminar_pedidos((JFrame)padre.getParent());
                }
                
            });

            //limpia todo lo seleccionado xd 
            JButton des = new JButton("Limpiar seleccion");
            des.addActionListener(accion ->{
                tabla.clearSelection();
            });

            // Esto nos permite remover un item seleccionado
            JButton eleminar_item = new JButton("Remover item");
            eleminar_item.addActionListener(accion ->{
                int num[] = tabla.getSelectedRows();
                int acumulado = 0;
                if(num.length == 0){
                    JOptionPane.showMessageDialog(this, "No has seleccionado ninguna fila", "Sin seleccion", JOptionPane.INFORMATION_MESSAGE, null);
                }
                else if(num.length == 1){
                    modelo.removeRow(num[0]);
                }
                else{
                    for(int i = 0; i < num.length; i++){
                        
                        acumulado++;
                        if(i< num.length-1){
                            num[i+1] -= acumulado;
                        }
                        
                        modelo.removeRow(num[i]);
                        

                    }
                }
                
                
            });
            
            //Esto elimina toda la orden y setea el archivo a false false
            JButton Eliminar_orden = new JButton("Eliminar orden");
            Eliminar_orden.addActionListener(accion ->{
                comentario.setText("Descripcion auxiliar");
                remover_items_tabla(modelo);
                set_valores(tabla);
                new Escribir_estado_mesas(mesa, valores_mesa_llenos,comentario.getText(), false, false);
                JOptionPane.showMessageDialog(this, "Eliminacion del pedido de la mesa satisfacotriamente", "Eliminaicon pedido", JOptionPane.INFORMATION_MESSAGE, null);
                setVisible(false);
                padre.setVisible(false);
                padre = new Eliminar_pedidos((JFrame)padre.getParent());
            });
            
            panel2.add(guardar);
            panel2.add(des);
            panel2.add(eleminar_item);
            panel2.add(Eliminar_orden);
            panel.add(panel2,BorderLayout.SOUTH);
            return panel;
        }
        private void remover_items_tabla(DefaultTableModel tabla){
            for(int i = 0; i < tabla.getRowCount(); i++){
                tabla.removeRow(i);
                i--;
            }
        }
        private void set_mesa(Estado_Mesa mesa, String comentario){
            mesa.set_comentario(comentario);
            mesa.set_estado_mesero(true);
            this.mesa_mesero = mesa;
        }
        private void set_valores(JTable tabla){
            //Inicializamos los valores de la columna
            String[] valores_mesa = new String[tabla.getRowCount()];
            
            for(int i = 0; i < tabla.getRowCount(); i++){
                
                
                valores_mesa[i] = (String)tabla.getValueAt(i, 0) + ";" +(String)tabla.getValueAt(i, 2);;
                
            }
            
            valores_mesa_llenos = valores_mesa;
        }
        public String[] get_valores_mesa(){
            return valores_mesa_llenos;
        }
        public Estado_Mesa get_mesa(){
            return mesa_mesero;
        }
        private String estado_cocinero(boolean estado, JLabel label){
            label.setOpaque(true);
            if(estado){
                label.setBackground(Color.green);
                return "El pedido ya fue despachado por el cocinero";
            }
            else{
                label.setBackground(new Color(255, 195, 0));
                return "El pedido sigue en preparacion";
            }
        }
    }
    

