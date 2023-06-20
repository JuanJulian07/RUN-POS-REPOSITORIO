package Inter_empleado;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.URL;
import java.util.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import Factura.Factura;
import Leer_Bases_de_datos.Leer_estado_mesas;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import Empleados.Empleado;
import Menu.Estado_Mesa;
import Menu.Filtrarplatos;
import Menu.Menu;

public class Interface_Empleados extends javax.swing.JFrame {
     File archivo;
    //private BufferedWriter bw;
    private javax.swing.JDialog AñadirProd;
    private javax.swing.JDialog Cocina;
    private javax.swing.JFrame Estadisticas;
    private javax.swing.JDialog Factura;
    private javax.swing.JLabel IVA;
    private javax.swing.JFrame Menu;
    private javax.swing.JFrame Mesero;
    private javax.swing.JLabel PROPINA;
    private javax.swing.JDialog Pedido;
    private javax.swing.JFrame StockIngredientes;
    private javax.swing.JLabel TOTALtot;
    private javax.swing.JComboBox<String> bebidaCant;
    private javax.swing.JComboBox<String> Pizzas;
    private javax.swing.JComboBox<String> Postrecant;
    private javax.swing.JTextField cantProdNuevo;
    private javax.swing.JTextField cedulaCli;
    private javax.swing.JButton cocinar;
    private javax.swing.JComboBox<String> Pizzascant;
    private javax.swing.JTable datosTable;
    private javax.swing.JTable datosTable2;
    private javax.swing.JComboBox<String> Postres;
    private javax.swing.JButton doPedido;
    private javax.swing.JDialog emergente;
    private javax.swing.JLabel fac;
    private javax.swing.JTable factTable;
    private javax.swing.JFileChooser fc;
    private javax.swing.JLabel fotoplato;
    private javax.swing.JButton generaFact;
    private javax.swing.JButton generar;
    private javax.swing.JButton generate;
    private javax.swing.JButton guardarInfo;
    private javax.swing.JLabel horario;
    private javax.swing.JLabel ImgBebidas;
    private javax.swing.JLabel infoFact;
    public javax.swing.JButton infoMeseros;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton terminarorden;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2Menu;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jTextField40;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    //private javax.swing.JLabel lblTime;
    private javax.swing.JList<String> listMesas;
    private javax.swing.JDialog mejorPlato;
    private javax.swing.JTextField mesaFact;
    private javax.swing.JLabel mesasAsign;
    private javax.swing.JLabel nameMesero;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField nombreArchivoTextField;
    private javax.swing.JTextField nombreCli;
    private javax.swing.JLabel nombreMese;
    private javax.swing.JLabel nombrePlato0;
    private javax.swing.JLabel nombrePlato1;
    private javax.swing.JLabel nombrePlato2;
    private javax.swing.JLabel nombrePlato3;
    private javax.swing.JLabel nombrePlato4;
    private javax.swing.JLabel nombrePlato5;
    private javax.swing.JTextField nuevoProd;
    private javax.swing.JComboBox<String> numMesa;
    private javax.swing.JLabel numMesa2;
    private javax.swing.JComboBox<String> numMeserito;
    private javax.swing.JComboBox<String> numMesero;
    private javax.swing.JButton pagos;
    private javax.swing.JComboBox<String> Especial;
    private javax.swing.JComboBox<String> Especialcant;
    private javax.swing.JComboBox<String> Ejecutivocant;
    private javax.swing.JComboBox<String> Corrientecant;
    private javax.swing.JComboBox<String> Ejecutivo;
    private javax.swing.JComboBox<String> Corriente;
    private javax.swing.JDialog resumenVentas;
    private javax.swing.JTextField telCli;
    private javax.swing.JComboBox<String> tiposBebidas;
    public javax.swing.JButton verCocina;
    public javax.swing.JButton verEstadisticas;
    public javax.swing.JButton verMenu;
    public  Empleado empleado=null;
    private javax.swing.JLabel Especiali;
    private javax.swing.JLabel Ejecutiv;
    private javax.swing.JLabel corrient;
    private javax.swing.JLabel Pizz;
    private javax.swing.JLabel Post;
    private javax.swing.JLabel Bebid;
    public Interface_Empleados(Empleado empleado){

        initComponents();
       // int totalisimo = 0;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Pedido.setLocationRelativeTo(null);
        Cocina.setLocationRelativeTo(null);
        Factura.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        setVisible(true);
        this.empleado=empleado;
        setIconImage(new ImageIcon("src\\Recursos_fotograficos\\icono_principal.jpg").getImage());
        //ESCRITURA DE PARRAFO EN UN LABEL
        fac.setText("<html><p>RESTAURANTE RUN POS </p><p>Bogotá, Colombia</p><p>Teléfono: -------</p></html>");
        horario.setText("<html><p>Lunes a Sábado 9:00 a.m a 9:00 p.m </p><p> Domingos y Festivos 10:00 a.m a 8:00 p.m</p></html>");
        
      
    }
    
    private void initComponents() {
        ImageIcon im;
        Menu = new javax.swing.JFrame();
        jPanel2Menu = new javax.swing.JPanel();
        ImgBebidas = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tiposBebidas = new javax.swing.JComboBox<>();
        terminarorden = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Corriente = new javax.swing.JComboBox<>();
        Especial = new javax.swing.JComboBox<>();
        Postrecant = new javax.swing.JComboBox<>();
        Corrientecant = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        Especialcant = new javax.swing.JComboBox<>();
        Ejecutivocant = new javax.swing.JComboBox<>();
        Pizzascant = new javax.swing.JComboBox<>();
        bebidaCant = new javax.swing.JComboBox<>();
        Pizzas = new javax.swing.JComboBox<>();
        Ejecutivo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        Postres = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        StockIngredientes = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        nombreArchivoTextField = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        fc = new javax.swing.JFileChooser();
        Mesero = new javax.swing.JFrame();
        jPanel8 = new javax.swing.JPanel();
        nameMesero = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        numMesero = new javax.swing.JComboBox<>();
        guardarInfo = new javax.swing.JButton();
        generar = new javax.swing.JButton();
        mesasAsign = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Pedido = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        numMesa = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        datosTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        numMeserito = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        AñadirProd = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        cantProdNuevo = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        nuevoProd = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        Cocina = new javax.swing.JDialog();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        datosTable2 = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        generaFact = new javax.swing.JButton();
        cocinar = new javax.swing.JButton();
        //lblTime = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        Factura = new javax.swing.JDialog();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        factTable = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        telCli = new javax.swing.JTextField();
        cedulaCli = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        nombreCli = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        infoFact = new javax.swing.JLabel();
        fac = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jTextField40 = new javax.swing.JLabel();
        nombreMese = new javax.swing.JLabel();
        numMesa2 = new javax.swing.JLabel();
        horario = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        TOTALtot = new javax.swing.JLabel();
        IVA = new javax.swing.JLabel();
        PROPINA = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        Estadisticas = new javax.swing.JFrame();
        jPanel5 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        emergente = new javax.swing.JDialog();
        jPanel12 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        mesaFact = new javax.swing.JTextField();
        generate = new javax.swing.JButton();
        resumenVentas = new javax.swing.JDialog();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMesas = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jButton28 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        mejorPlato = new javax.swing.JDialog();
        jPanel13 = new javax.swing.JPanel();
        nombrePlato0 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        fotoplato = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        nombrePlato1 = new javax.swing.JLabel();
        nombrePlato2 = new javax.swing.JLabel();
        nombrePlato3 = new javax.swing.JLabel();
        nombrePlato4 = new javax.swing.JLabel();
        nombrePlato5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        verMenu = new javax.swing.JButton();
        doPedido = new javax.swing.JButton();
        verCocina = new javax.swing.JButton();
        verEstadisticas = new javax.swing.JButton();
        infoMeseros = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        pagos = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        Especiali= new javax.swing.JLabel();
        Ejecutiv= new javax.swing.JLabel();
        corrient= new javax.swing.JLabel();
        Pizz= new javax.swing.JLabel();
        Post= new javax.swing.JLabel();
        Bebid= new javax.swing.JLabel();


        Menu.setTitle("MENU RUN POS");
        Menu.setMinimumSize(new java.awt.Dimension(850, 611));
        Menu.setResizable(false);

         Filtrarplatos init =new Filtrarplatos();

        jPanel2Menu.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImgBebidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/gaseosa.png"))); // NOI18N
        jPanel2Menu.add(ImgBebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, 100, 90));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/damablanca.png"))); // NOI18N
        jPanel2Menu.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 235, 100, 90));

        jButton1.setBackground(java.awt.Color.white);
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("VOLVER A OPCIONES");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2Menu.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 540, 190, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pSiciliana.jpg"))); // NOI18N
        jPanel2Menu.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 120, 90));

        tiposBebidas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tiposBebidas.setModel(new javax.swing.DefaultComboBoxModel<>());
        tiposBebidas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tiposBebidas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        for(Menu c: Filtrarplatos.bebidas){
        tiposBebidas.addItem(c.toString());}
        /*tiposBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiposBebidasActionPerformed(evt);
            }
        });*/
        jPanel2Menu.add(tiposBebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, -1, 20));


        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/brasilia.png"))); // NOI18N
        jPanel2Menu.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 120, 90));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pOpera.jpg"))); // NOI18N
        jPanel2Menu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 235, 120, 90));

        Corriente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        //psici.setForeground(new java.awt.Color(255, 255, 255));
        Corriente.setModel(new javax.swing.DefaultComboBoxModel<>());
        Corriente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Corriente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        for(Menu c: Filtrarplatos.corriente){
        Corriente.addItem(c.toString());}
        jPanel2Menu.add(Corriente, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, 140, -1));

        Especial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
       // pgriega.setForeground(new java.awt.Color(255, 255, 255));
        Especial.setModel(new javax.swing.DefaultComboBoxModel<>());
        Especial.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Especial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        for(Menu c: Filtrarplatos.especial){
        Especial.addItem(c.toString());}
        jPanel2Menu.add(Especial, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 150, 30));

        Pizzascant.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Pizzascant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" }));
        Pizzascant.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2Menu.add(Pizzascant, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, -1, 40));

        Corrientecant.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Corrientecant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" }));
        Corrientecant.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2Menu.add(Corrientecant, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 40, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pgriega.jpg"))); // NOI18N
        jPanel2Menu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 120, 90));

        Especialcant.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        Especialcant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" }));
        Especialcant.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Especialcant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pitaGriegaActionPerformed(evt);
            }
        });

        jPanel2Menu.add(Especialcant, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 40, 40));

        Ejecutivocant.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Ejecutivocant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" }));
        Ejecutivocant.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2Menu.add(Ejecutivocant, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 275, 40, 40));

        Postrecant.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Postrecant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" }));
        Postrecant.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Postrecant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                damaBlancaActionPerformed(evt);
            }
        });
        jPanel2Menu.add(Postrecant, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 275, 40, 40));

        bebidaCant.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bebidaCant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" }));
        bebidaCant.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bebidaCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebidaCantActionPerformed(evt);
            }
        });
        jPanel2Menu.add(bebidaCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 430, 40, 40));

        Pizzas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        //brasi.setForeground(new java.awt.Color(255, 255, 255));
        Pizzas.setModel(new javax.swing.DefaultComboBoxModel<>());
        Pizzas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Pizzas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        for(Menu c: Filtrarplatos.pizzas){
        Pizzas.addItem(c.toString());}
        jPanel2Menu.add(Pizzas, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, -1, -1));

        Ejecutivo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
       // popera.setForeground(new java.awt.Color(255, 255, 255));
        Ejecutivo.setModel(new javax.swing.DefaultComboBoxModel<>());
        Ejecutivo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Ejecutivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        for(Menu c: Filtrarplatos.ejecutivo){
        Ejecutivo.addItem(c.toString());}
        jPanel2Menu.add(Ejecutivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 335, 130, -1));

        Especiali.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Especiali.setForeground(new java.awt.Color(255, 255, 255));
        Especiali.setText(" ESPECIALES ");
        Especiali.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2Menu.add(Especiali, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 130, 20));

         Ejecutiv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Ejecutiv.setForeground(new java.awt.Color(255, 255, 255));
        Ejecutiv.setText(" EJECUTIVOS ");
        Ejecutiv.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2Menu.add(Ejecutiv, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 130, -1));

         corrient.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        corrient.setForeground(new java.awt.Color(255, 255, 255));
        corrient.setText(" CORRIENTES ");
        corrient.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2Menu.add(corrient, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 130, -1));

         Pizz.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Pizz.setForeground(new java.awt.Color(255, 255, 255));
        Pizz.setText(" PIZZAS ");
        Pizz.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2Menu.add(Pizz, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, -1, -1));

         Post.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Post.setForeground(new java.awt.Color(255, 255, 255));
        Post.setText(" POSTRES ");
        Post.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2Menu.add(Post, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, -1, -1));

         Bebid.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Bebid.setForeground(new java.awt.Color(255, 255, 255));
        Bebid.setText(" BEBIDAS ");
        Bebid.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2Menu.add(Bebid, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, -1, -1));

// Adición de selccionador de numero de mesa al menú
//
        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Numero de mesa: ");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2Menu.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 160, -1));

        numMesa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        numMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        numMesa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        /*numMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numMesaActionPerformed(evt);
            }
        });*/
        jPanel2Menu.add(numMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 100, -1));

        jButton3.setBackground(java.awt.Color.white);
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton3.setText("AÑADIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt); //Antiguo llenar tabla de la cocina 
            }
        });
        jPanel2Menu.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 190, 30));
    /*  jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("mesero:"+empleado.toString());
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2Menu.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 160, -1));*/


        jLabel1.setBackground(new java.awt.Color(51, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/MENÚRUNPOS.jpg"))); // NOI18N
        jPanel2Menu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 5, 580, 570));

        Postres.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        //dblanca.setForeground(new java.awt.Color(255, 255, 255));
        Postres.setModel(new javax.swing.DefaultComboBoxModel<>());
        Postres.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Postres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        for(Menu c: Filtrarplatos.postres){
        Postres.addItem(c.toString());}
        //dblanca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2Menu.add(Postres, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 335, -1, -1));
//numMesa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/MENÚRUNPOS.jpg"))); // NOI18N
        jPanel2Menu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 5, 600, 570));



        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu.getContentPane());
        Menu.getContentPane().setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2Menu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(jPanel2Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        StockIngredientes.setTitle("STOCK");
        StockIngredientes.setMinimumSize(new java.awt.Dimension(622, 433));
        StockIngredientes.setResizable(false);

        jPanel4.setMaximumSize(new java.awt.Dimension(623, 418));
        jPanel4.setMinimumSize(new java.awt.Dimension(623, 418));
        jPanel4.setPreferredSize(new java.awt.Dimension(622, 418));

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setMaximumSize(new java.awt.Dimension(622, 418));
        jPanel6.setMinimumSize(new java.awt.Dimension(622, 418));
        jPanel6.setName(""); // NOI18N
        jPanel6.setLayout(null);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/VER PROD.png"))); // NOI18N
        jButton4.setText("VER INGREDIENTES");
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4);
        jButton4.setBounds(350, 90, 250, 60);

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Archivo:");
        jPanel6.add(jLabel27);
        jLabel27.setBounds(30, 60, 60, 20);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/AÑADIR PROD.png"))); // NOI18N
        jButton5.setText("AÑADIR INGREDIENTES");
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton5);
        jButton5.setBounds(350, 160, 250, 60);

        nombreArchivoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreArchivoTextFieldActionPerformed(evt);
            }
        });
        jPanel6.add(nombreArchivoTextField);
        nombreArchivoTextField.setBounds(90, 60, 240, 20);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/MODIF PROD.png"))); // NOI18N
        jButton6.setText("ELIMINAR INGREDIENTE");
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6);
        jButton6.setBounds(350, 240, 250, 60);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/back (1).png"))); // NOI18N
        jButton9.setContentAreaFilled(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton9);
        jButton9.setBounds(20, 340, 50, 50);

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INGREDIENTE", "CANTIDAD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 0));
        jScrollPane3.setViewportView(jTable1);

        jPanel6.add(jScrollPane3);
        jScrollPane3.setBounds(30, 90, 300, 230);

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/kitchenthis.jpg"))); // NOI18N
        jPanel6.add(jLabel24);
        jLabel24.setBounds(0, 0, 620, 420);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout StockIngredientesLayout = new javax.swing.GroupLayout(StockIngredientes.getContentPane());
        StockIngredientes.getContentPane().setLayout(StockIngredientesLayout);
        StockIngredientesLayout.setHorizontalGroup(
            StockIngredientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        StockIngredientesLayout.setVerticalGroup(
            StockIngredientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Mesero.setTitle("INFO.MESERO");
        Mesero.setMinimumSize(new java.awt.Dimension(544, 481));
        Mesero.setResizable(false);

        jPanel8.setLayout(null);

        nameMesero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameMesero.setForeground(new java.awt.Color(255, 255, 255));
        nameMesero.setText("Nombre: ");
        jPanel8.add(nameMesero);
        nameMesero.setBounds(40, 100, 70, 20);

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        jPanel8.add(nombre);
        nombre.setBounds(210, 100, 100, 20);

        label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setText("Numero de mesero:");
        jPanel8.add(label);
        label.setBounds(40, 180, 150, 20);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel8.add(jTextField1);
        jTextField1.setBounds(210, 140, 100, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Asignacion de mesas: ");
        jPanel8.add(jLabel10);
        jLabel10.setBounds(40, 230, 180, 17);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/back (1).png"))); // NOI18N
        jButton16.setText("jButton16");
        jButton16.setContentAreaFilled(false);
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton16);
        jButton16.setBounds(20, 410, 60, 41);

        label1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Numero identificacion: ");
        jPanel8.add(label1);
        label1.setBounds(40, 140, 160, 20);

        numMesero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        numMesero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        jPanel8.add(numMesero);
        numMesero.setBounds(230, 180, 60, 20);

        guardarInfo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        guardarInfo.setText("Guardar");
        guardarInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarInfoActionPerformed(evt);
            }
        });
        jPanel8.add(guardarInfo);
        guardarInfo.setBounds(120, 380, 120, 30);


        mesasAsign.setBackground(new java.awt.Color(255, 255, 255));
        mesasAsign.setForeground(new java.awt.Color(255, 255, 255));
        mesasAsign.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel8.add(mesasAsign);
        mesasAsign.setBounds(40, 300, 270, 60);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/JE_opt (3).jpg"))); // NOI18N
        jPanel8.add(jLabel15);
        jLabel15.setBounds(0, 0, 550, 480);

        javax.swing.GroupLayout MeseroLayout = new javax.swing.GroupLayout(Mesero.getContentPane());
        Mesero.getContentPane().setLayout(MeseroLayout);
        MeseroLayout.setHorizontalGroup(
            MeseroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );
        MeseroLayout.setVerticalGroup(
            MeseroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
        );

        Pedido.setTitle("PEDIDOS");
        Pedido.setMinimumSize(new java.awt.Dimension(700, 600));
        Pedido.setModal(false);
        Pedido.setResizable(false);

        jPanel3.setBackground(new java.awt.Color(105, 92, 100));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
// tabla de pedidos
datosTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        datosTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        datosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM","NOMBRE", "VALOR", "CANTIDAD"
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
        jScrollPane2.setViewportView(datosTable);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 400, 130));
        Tabla_mesas c=null;
        ArrayList<Estado_Mesa> mesas;
        Leer_estado_mesas leer = new Leer_estado_mesas(0);
        mesas = leer.get_mesas();
        JButton botonetab = new JButton();
                botonetab.addKeyListener(Adaptador.accion_teclado(botonetab));
                botonetab.setPreferredSize(new Dimension(100, 40));
                botonetab.setBackground(new Color(66, 66, 66));
                botonetab.setForeground(Color.WHITE);
                botonetab.addActionListener((accion) ->{
                    botonetab.setText("Mesa"+mesas.get(Integer.parseInt((String)numMesa.getSelectedItem())-1).get_num_mesa());
                    Tabla_mesas t = new Tabla_mesas(Pedido,mesas.get(Integer.parseInt((String)numMesa.getSelectedItem())-1),Tabla_mesas.MESERO);
                    //c=t;
                });
        jPanel3.add(botonetab,new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 100, 70));
                //c.get_valores_mesa();
        

        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/atras.png"))); // NOI18N
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 70, 70));

        
        //jScrollPane2.setViewportView(datosTable);

        //jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 400, 230));


        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 240, -1));
        

        javax.swing.GroupLayout PedidoLayout = new javax.swing.GroupLayout(Pedido.getContentPane());
        Pedido.getContentPane().setLayout(PedidoLayout);
        PedidoLayout.setHorizontalGroup(
            PedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );
        PedidoLayout.setVerticalGroup(
            PedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        AñadirProd.setTitle("AÑADIR");
        AñadirProd.setMinimumSize(new java.awt.Dimension(403, 214));
        AñadirProd.setResizable(false);

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setLayout(null);

        cantProdNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantProdNuevoKeyTyped(evt);
            }
        });
        jPanel7.add(cantProdNuevo);
        cantProdNuevo.setBounds(210, 100, 130, 20);

        jButton8.setBackground(java.awt.Color.white);
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setText("AÑADIR");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton8);
        jButton8.setBounds(110, 140, 130, 30);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("NUEVO PRODUCTO: ");
        jPanel7.add(jLabel14);
        jLabel14.setBounds(40, 60, 140, 20);

        /*nuevoProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoProdActionPerformed(evt); //MÉTODO SIN DEFINICIÓN 
            }
        });*/
        nuevoProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nuevoProdKeyTyped(evt);
            }
        });
        jPanel7.add(nuevoProd);
        nuevoProd.setBounds(210, 60, 130, 20);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/kitchenthis.jpg"))); // NOI18N
        jPanel7.add(jLabel25);
        jLabel25.setBounds(0, -40, 410, 270);

        javax.swing.GroupLayout AñadirProdLayout = new javax.swing.GroupLayout(AñadirProd.getContentPane());
        AñadirProd.getContentPane().setLayout(AñadirProdLayout);
        AñadirProdLayout.setHorizontalGroup(
            AñadirProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );
        AñadirProdLayout.setVerticalGroup(
            AñadirProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
        );

        Cocina.setTitle("COCINA");
        Cocina.setMinimumSize(new java.awt.Dimension(928, 393));
        Cocina.setResizable(false);

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

        jButton11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton11.setText("REGISTRAR OTRO PEDIDO");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton11);
        jButton11.setBounds(440, 240, 230, 40);

        generaFact.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        generaFact.setText("GENERAR FACTURA");
        generaFact.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        generaFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generaFactActionPerformed(evt);
            }
        });
        jPanel9.add(generaFact);
        generaFact.setBounds(440, 180, 230, 40);

        cocinar.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        cocinar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cocinar.setText("COCINAR");
        cocinar.setToolTipText("");
        cocinar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cocinar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cocinarMouseMoved(evt);
            }
        });
        cocinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cocinarActionPerformed(evt);
            }
        });
        jPanel9.add(cocinar);
        cocinar.setBounds(440, 110, 230, 30);

        /*lblTime.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setText("00:00:00");
        lblTime.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jPanel9.add(lblTime);
        lblTime.setBounds(440, 50, 230, 40);*/

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/kitchen2.jpg"))); // NOI18N
        jPanel9.add(jLabel26);
        jLabel26.setBounds(343, 0, 590, 390);

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("PEDIDOS:");
        jPanel9.add(jLabel28);
        jLabel28.setBounds(90, 30, 100, 17);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/back (1).png"))); // NOI18N
        jButton15.setText("jButton15");
        jButton15.setContentAreaFilled(false);
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton15);
        jButton15.setBounds(10, 331, 60, 50);

        javax.swing.GroupLayout CocinaLayout = new javax.swing.GroupLayout(Cocina.getContentPane());
        Cocina.getContentPane().setLayout(CocinaLayout);
        CocinaLayout.setHorizontalGroup(
            CocinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
        );
        CocinaLayout.setVerticalGroup(
            CocinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
        );

        Factura.setTitle("FACTURA");
        Factura.setMinimumSize(new java.awt.Dimension(680, 694));
        Factura.setModal(true);
        Factura.setResizable(false);
        Factura.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel10.setMaximumSize(new java.awt.Dimension(620, 400));
        jPanel10.setMinimumSize(new java.awt.Dimension(620, 400));
        jPanel10.setLayout(null);

        factTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        factTable.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        factTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "         CONCEPTO", "            PRECIO", "             UNDS", "         SUBTOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
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

        jPanel10.add(jScrollPane5);
        jScrollPane5.setBounds(50, 330, 590, 150);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        jPanel11.setLayout(null);

        telCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telCliKeyTyped(evt);
            }
        });
        jPanel11.add(telCli);
        telCli.setBounds(110, 70, 160, 20);

        cedulaCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cedulaCliKeyTyped(evt);
            }
        });
        jPanel11.add(cedulaCli);
        cedulaCli.setBounds(110, 40, 160, 20);

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel32.setText("Telefono:");
        jPanel11.add(jLabel32);
        jLabel32.setBounds(10, 70, 90, 20);

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel37.setText("Cedula:");
        jPanel11.add(jLabel37);
        jLabel37.setBounds(10, 44, 90, 20);

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel29.setText("Nombre Cliente:");
        jPanel11.add(jLabel29);
        jLabel29.setBounds(10, 14, 90, 20);

        nombreCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreCliActionPerformed(evt);
            }
        });
        nombreCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreCliKeyTyped(evt);
            }
        });
        jPanel11.add(nombreCli);
        nombreCli.setBounds(110, 10, 160, 20);

        jPanel10.add(jPanel11);
        jPanel11.setBounds(50, 120, 310, 110);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/back.png"))); // NOI18N
        jButton10.setToolTipText("Volver");
        jButton10.setContentAreaFilled(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton10);
        jButton10.setBounds(50, 570, 70, 70);

        infoFact.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        infoFact.setText("Atendido por:");
        infoFact.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.add(infoFact);
        infoFact.setBounds(340, 290, 110, 30);

        fac.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        fac.setText("RESTAURANTE RUN POS");
        jPanel10.add(fac);
        fac.setBounds(50, 10, 340, 80);

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Teléfono: 6014000");
        jPanel10.add(jLabel38);
        jLabel38.setBounds(50, 70, 200, 30);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setText("       Factura:            001         Serie:            1             Fecha:   ");
        jLabel39.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.add(jLabel39);
        jLabel39.setBounds(50, 250, 410, 30);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/store.png"))); // NOI18N
        jButton14.setContentAreaFilled(false);
        jPanel10.add(jButton14);
        jButton14.setBounds(410, 30, 210, 150);

        jTextField40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField40.setText("Mesa: ");
        jTextField40.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.add(jTextField40);
        jTextField40.setBounds(50, 290, 60, 30);

        nombreMese.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nombreMese.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.add(nombreMese);
        nombreMese.setBounds(470, 290, 170, 30);

        numMesa2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numMesa2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.add(numMesa2);
        numMesa2.setBounds(120, 290, 60, 30);

        horario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        horario.setText("Lunes a Sábado 9:00 am a 9:00 pm");
        jPanel10.add(horario);
        horario.setBounds(60, 510, 240, 60);

        jLabel33.setFont(new java.awt.Font("Vrinda", 0, 14)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("HORARIO DE ATENCION");
        jPanel10.add(jLabel33);
        jLabel33.setBounds(100, 490, 170, 21);

        jLabel16.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel16.setText("+PROPINA");
        jPanel10.add(jLabel16);
        jLabel16.setBounds(360, 510, 90, 20);

        jLabel18.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel18.setText("+IVA");
        jPanel10.add(jLabel18);
        jLabel18.setBounds(360, 490, 90, 20);

        jLabel19.setFont(new java.awt.Font("Courier New", 3, 12)); // NOI18N
        jLabel19.setText("TOTAL COMPRA");
        jPanel10.add(jLabel19);
        jLabel19.setBounds(360, 540, 110, 20);

        TOTALtot.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        TOTALtot.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TOTALtot.setText("jLabel20");
        jPanel10.add(TOTALtot);
        TOTALtot.setBounds(530, 540, 80, 17);

        IVA.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        IVA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        IVA.setText("jLabel20");
        jPanel10.add(IVA);
        IVA.setBounds(520, 490, 80, 14);

        PROPINA.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        PROPINA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PROPINA.setText("jLabel20");
        jPanel10.add(PROPINA);
        PROPINA.setBounds(520, 510, 80, 14);

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pay-per-click (1).png"))); // NOI18N
        jButton19.setContentAreaFilled(false);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton19);
        jButton19.setBounds(550, 590, 70, 70);

        Factura.getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 710));

        Estadisticas.setTitle("ESTADISTICAS");
        Estadisticas.setMinimumSize(new java.awt.Dimension(505, 428));
        Estadisticas.setResizable(false);

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(null);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/bars-chart.png"))); // NOI18N
        jButton13.setContentAreaFilled(false);
        jButton13.setRolloverEnabled(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton13);
        jButton13.setBounds(360, 50, 100, 80);

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/profits.png"))); // NOI18N
        jButton17.setContentAreaFilled(false);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton17);
        jButton17.setBounds(350, 150, 100, 80);

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/line-chart.png"))); // NOI18N
        jButton18.setContentAreaFilled(false);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton18);
        jButton18.setBounds(350, 240, 97, 80);

        jButton20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("RESUMEN DE VENTAS - MESAS ");
        jButton20.setContentAreaFilled(false);
        jButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton20);
        jButton20.setBounds(50, 70, 270, 40);

        jButton21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setText("NUMERO DE VENTAS REALIZADAS");
        jButton21.setContentAreaFilled(false);
        jButton21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton21);
        jButton21.setBounds(50, 130, 280, 40);

        jButton22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("PLATO MAS VENDIDO");
        jButton22.setContentAreaFilled(false);
        jButton22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton22);
        jButton22.setBounds(50, 190, 270, 40);

        jButton23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("MESERO DEL DIA");
        jButton23.setContentAreaFilled(false);
        jButton23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton23);
        jButton23.setBounds(50, 260, 270, 40);

        javax.swing.GroupLayout EstadisticasLayout = new javax.swing.GroupLayout(Estadisticas.getContentPane());
        Estadisticas.getContentPane().setLayout(EstadisticasLayout);
        EstadisticasLayout.setHorizontalGroup(
            EstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );
        EstadisticasLayout.setVerticalGroup(
            EstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        emergente.setMinimumSize(new java.awt.Dimension(366, 181));
        emergente.setUndecorated(true);
        emergente.setResizable(false);

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));
        jPanel12.setLayout(null);

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("FACTURA DE LA MESA NO. ");
        jPanel12.add(jLabel30);
        jLabel30.setBounds(40, 40, 190, 30);

        mesaFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesaFactActionPerformed(evt);
            }
        });
        mesaFact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mesaFactKeyTyped(evt);
            }
        });
        jPanel12.add(mesaFact);
        mesaFact.setBounds(230, 40, 70, 30);

        generate.setBackground(java.awt.Color.white);
        generate.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        generate.setText("GENERAR");
        generate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateActionPerformed(evt);
            }
        });
        jPanel12.add(generate);
        generate.setBounds(110, 90, 140, 30);

        javax.swing.GroupLayout emergenteLayout = new javax.swing.GroupLayout(emergente.getContentPane());
        emergente.getContentPane().setLayout(emergenteLayout);
        emergenteLayout.setHorizontalGroup(
            emergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        emergenteLayout.setVerticalGroup(
            emergenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
        );

        resumenVentas.setTitle("VENTAS");
        resumenVentas.setMinimumSize(new java.awt.Dimension(451, 377));
        resumenVentas.setResizable(false);

        jPanel14.setBackground(new java.awt.Color(153, 153, 0));
        jPanel14.setForeground(new java.awt.Color(204, 204, 204));
        jPanel14.setLayout(null);

        listMesas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        listMesas.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        listMesas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Mesa 1", "Mesa 2", "Mesa 3", "Mesa 4", "Mesa 5", "Mesa 6", "Mesa 7", "Mesa 8", "Mesa 9", "Mesa 10", "Mesa 11", "Mesa 12", "Mesa 13", "Mesa 14", "Mesa 15", "Mesa 16", "Mesa 17", "Mesa 18", "Mesa 19", "Mesa 20" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listMesas.setSelectionBackground(new java.awt.Color(102, 153, 0));
        jScrollPane1.setViewportView(listMesas);

        jPanel14.add(jScrollPane1);
        jScrollPane1.setBounds(40, 70, 270, 210);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("RESUMEN DE VENTAS pitaks");
        jPanel14.add(jLabel3);
        jLabel3.setBounds(40, 40, 270, 22);

        jButton28.setBackground(java.awt.Color.white);
        jButton28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton28.setText("VER VENTAS");
        jButton28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton28);
        jButton28.setBounds(110, 300, 120, 40);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/kitchen2.jpg"))); // NOI18N
        jPanel14.add(jLabel20);
        jLabel20.setBounds(0, 0, 470, 390);

        javax.swing.GroupLayout resumenVentasLayout = new javax.swing.GroupLayout(resumenVentas.getContentPane());
        resumenVentas.getContentPane().setLayout(resumenVentasLayout);
        resumenVentasLayout.setHorizontalGroup(
            resumenVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
        );
        resumenVentasLayout.setVerticalGroup(
            resumenVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
        );

        mejorPlato.setMinimumSize(new java.awt.Dimension(547, 301));
        mejorPlato.setResizable(false);

        jPanel13.setBackground(new java.awt.Color(0, 0, 0));
        jPanel13.setLayout(null);

        nombrePlato0.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombrePlato0.setForeground(new java.awt.Color(255, 255, 255));
        nombrePlato0.setText("Pita Griega");
        jPanel13.add(nombrePlato0);
        nombrePlato0.setBounds(40, 180, 210, 40);

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("MEJOR PLATO");
        jLabel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel13.add(jLabel21);
        jLabel21.setBounds(190, 40, 320, 70);

        fotoplato.setForeground(new java.awt.Color(255, 255, 255));
        fotoplato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        fotoplato.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel13.add(fotoplato);
        fotoplato.setBounds(260, 140, 220, 110);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/first.png"))); // NOI18N
        jPanel13.add(jLabel22);
        jLabel22.setBounds(50, 30, 160, 140);

        nombrePlato1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombrePlato1.setForeground(new java.awt.Color(255, 255, 255));
        nombrePlato1.setText("Pita Opera");
        jPanel13.add(nombrePlato1);
        nombrePlato1.setBounds(40, 180, 210, 40);

        nombrePlato2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombrePlato2.setForeground(new java.awt.Color(255, 255, 255));
        nombrePlato2.setText("Pita Siciliana");
        jPanel13.add(nombrePlato2);
        nombrePlato2.setBounds(40, 180, 210, 40);

        nombrePlato3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombrePlato3.setForeground(new java.awt.Color(255, 255, 255));
        nombrePlato3.setText("Postre Brasilia");
        jPanel13.add(nombrePlato3);
        nombrePlato3.setBounds(40, 180, 210, 40);

        nombrePlato4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombrePlato4.setForeground(new java.awt.Color(255, 255, 255));
        nombrePlato4.setText("Postre Dama Blanca");
        jPanel13.add(nombrePlato4);
        nombrePlato4.setBounds(40, 180, 210, 40);

        nombrePlato5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombrePlato5.setForeground(new java.awt.Color(255, 255, 255));
        nombrePlato5.setText("Bebidas");
        jPanel13.add(nombrePlato5);
        nombrePlato5.setBounds(40, 180, 210, 40);

        javax.swing.GroupLayout mejorPlatoLayout = new javax.swing.GroupLayout(mejorPlato.getContentPane());
        mejorPlato.getContentPane().setLayout(mejorPlatoLayout);
        mejorPlatoLayout.setHorizontalGroup(
            mejorPlatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );
        mejorPlatoLayout.setVerticalGroup(
            mejorPlatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(540, 411));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        verMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/menu.png"))); // NOI18N
        verMenu.setContentAreaFilled(false);
        verMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        verMenu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                verMenuMouseMoved(evt);
            }
        });
        verMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verMenuActionPerformed(evt);
            }
        });
        jPanel1.add(verMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 140, 140));

        doPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/notas.png"))); // NOI18N
        doPedido.setContentAreaFilled(false);
        doPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        doPedido.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                doPedidoMouseMoved(evt);
            }
        });
        doPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doPedidoActionPerformed(evt);
            }
        });
        jPanel1.add(doPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 150, 140));

        verCocina.setForeground(new java.awt.Color(204, 204, 204));
        verCocina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cocinero.png"))); // NOI18N
        verCocina.setBorderPainted(false);
        verCocina.setContentAreaFilled(false);
        verCocina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        verCocina.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                verCocinaMouseMoved(evt);
            }
        });
        verCocina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCocinaActionPerformed(evt);
            }
        });
        jPanel1.add(verCocina, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 150, 140));

        verEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/estadisticas.png"))); // NOI18N
        verEstadisticas.setContentAreaFilled(false);
        verEstadisticas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        verEstadisticas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                verEstadisticasMouseMoved(evt);
            }
        });
        verEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verEstadisticasActionPerformed(evt);
            }
        });
        jPanel1.add(verEstadisticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 150, 140));
        im = new ImageIcon(getClass().getResource("/Recursos_fotograficos/imagen_gerencial.jpeg"));
        infoMeseros.setIcon(new javax.swing.ImageIcon(im.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH))); // NOI18N
        infoMeseros.setContentAreaFilled(false);
        infoMeseros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        infoMeseros.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                infoMeserosMouseMoved(evt);
            }
        });
        infoMeseros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoMeserosActionPerformed(evt);
            }
        });
        jPanel1.add(infoMeseros, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 140, 140));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/exit.png"))); // NOI18N
        jButton12.setContentAreaFilled(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 60, 50));

        pagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/dinero.png"))); // NOI18N
        pagos.setContentAreaFilled(false);
        pagos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pagos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pagosMouseMoved(evt);
            }
        });
        pagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagosActionPerformed(evt);
            }
        });
        jPanel1.add(pagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 150, 140));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/JE_opt (3).jpg"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    int contador = 0;
    int suma = 0;
    
    private void verMenuActionPerformed(java.awt.event.ActionEvent evt) {                                        
        Menu.setVisible(true);
        Menu.setLocationRelativeTo(null);
        Menu.setDefaultCloseOperation(EXIT_ON_CLOSE);// Al cerrar la pestaña termina la ejecución
        this.dispose();
    }                                       

    private void pagosActionPerformed(java.awt.event.ActionEvent evt) {                                      
        Factura.setVisible(true);
        Factura.setDefaultCloseOperation(DISPOSE_ON_CLOSE);// arreglar el cerrado de páginas
        Cocina.dispose();
    }                                     

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Menu.setVisible(false);
        this.setVisible(true);
    }                                        

    private void verMenuMouseMoved(java.awt.event.MouseEvent evt) {                                   
        verMenu.setToolTipText("*VER MENÚ DE PLATOS");
    }                                  

    private void doPedidoMouseMoved(java.awt.event.MouseEvent evt) {                                    
        doPedido.setToolTipText("*INGRESO DE PEDIDOS");
    }                                   

    private void verCocinaMouseMoved(java.awt.event.MouseEvent evt) {                                     
        verCocina.setToolTipText("*ACCEDER A COCINA/STOCK");
    }                                    

    private void infoMeserosMouseMoved(java.awt.event.MouseEvent evt) {                                       
        infoMeseros.setToolTipText("*ACCEDER SECTOR GERENCIAL");
    }                                      

    private void verEstadisticasMouseMoved(java.awt.event.MouseEvent evt) {                                           
        verEstadisticas.setToolTipText("*ACCEDER SECTOR ADMINISTRATIVO");
    }                                          

    private void pagosMouseMoved(java.awt.event.MouseEvent evt) {                                 
        pagos.setToolTipText("*REGISTRAR PAGO");
    }                                


    private void tiposBebidasActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if (tiposBebidas.getSelectedIndex() == 0) { // Cambiar imagenes en las bebidas
            String icon = "/Img/gaseosa.png";
            URL url = this.getClass().getResource(icon);
            ImageIcon icono = new ImageIcon(url);

            ImgBebidas.setIcon(icono);
        } else if (tiposBebidas.getSelectedIndex() == 1) {
            String icon = "/Img/te_opt.png";
            URL url = this.getClass().getResource(icon);
            ImageIcon icono = new ImageIcon(url);

            ImgBebidas.setIcon(icono);
        } else {
            String icon = "/Img/agua_opt.png";
            URL url = this.getClass().getResource(icon);
            ImageIcon icono = new ImageIcon(url);

            ImgBebidas.setIcon(icono);
        }

    }                                            

    void actualizarImagen() {
        tiposBebidas.addItemListener((ItemEvent arg0) -> {
            // TODO
        });
    }

    private void doPedidoActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Pedido.setVisible(true);
        Pedido.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Pedido.setLocationRelativeTo(null);
    }                                                                 


    private void damaBlancaActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          


    private void bebidaCantActionPerformed(java.awt.event.ActionEvent evt) {                                           


    }                                          

    private void verEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {                                                
        Inteface_Administrativo administrativo = new Inteface_Administrativo(empleado, this);
        this.dispose();
        
    }                                               

    private void verCocinaActionPerformed(java.awt.event.ActionEvent evt) {                                          

        Interface_ingreso vp = new Interface_ingreso();// la ventaa principal es el interface ingreso

        vp.nombre_usuario.setText("");
        vp.contra_usuario.setText("");
        StockIngredientes.setVisible(true);
        this.dispose();
        StockIngredientes.setLocationRelativeTo(null);
        StockIngredientes.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }                                         

    private void infoMeserosActionPerformed(java.awt.event.ActionEvent evt) {                                            
        Interface_Gerente gerente = new Interface_Gerente(empleado, this);
        //Interface_Infomesero meserosin =new Interface_Infomesero(empleado);
        this.dispose();
    }                                           

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Pedido.setVisible(false);
        Menu.setVisible(true);
    }                                        

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //AÑADIMOS INGREDIENTES A TABLA STOCK

        // Tomar el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        String name = nuevoProd.getText();
        int cantidad = Integer.parseInt(cantProdNuevo.getText());

        model.addRow(new Object[]{name, cantidad});

        if (!name.isEmpty()) {
            if (cantidad != 0) {
                JOptionPane.showMessageDialog(null, "Ingrediente se ha añadido satisfactoriamente.");
                AñadirProd.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se han ingresado datos.");
        }
    }                                        
                                                       

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         

        DefaultTableModel model = (DefaultTableModel) datosTable.getModel();
        if(numMesa.getSelectedIndex()!=0){
        if (Especialcant.getSelectedIndex() > 0) {
            String x =(String) (Especial.getSelectedItem());
            String[] y;
            y = x.split(":");

            model.addRow(new Object[]{y[0], y[1],y[2],Especialcant.getSelectedIndex()});
        }

        if (Corrientecant.getSelectedIndex() > 0) {
            String x = (String)Corriente.getSelectedItem();
            String[] y;
            y = x.split(":");
            model.addRow(new Object[]{y[0], y[1],y[2],Corrientecant.getSelectedIndex()});
        }
        if (Ejecutivocant.getSelectedIndex() > 0) {
            String x = (String)Ejecutivo.getSelectedItem();
            String[] y;
            y = x.split(":");

            model.addRow(new Object[]{y[0], y[1],y[2],Ejecutivocant.getSelectedIndex()});
        }
        if (Pizzascant.getSelectedIndex() > 0) {
            String x =(String) Pizzas.getSelectedItem();
            String[] y;
            y = x.split(":");

            model.addRow(new Object[]{y[0], y[1],y[2], Pizzascant.getSelectedIndex()});
        }
        if (Pizzascant.getSelectedIndex() > 0) {
            String x =(String)Postres.getSelectedItem();
            String[] y;
            y = x.split(":");

            model.addRow(new Object[]{y[0], y[1],y[2], Pizzascant.getSelectedIndex()});

        }
        if (bebidaCant.getSelectedIndex() > 0) {
            String x = (String) tiposBebidas.getSelectedItem();
            String[] y;
            y = x.split(":");

            model.addRow(new Object[]{y[0], y[1],y[2], bebidaCant.getSelectedIndex()});
        }

        Pedido.setVisible(true);
        Pedido.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // probar que pasa al hacer pedidos
        Menu.dispose();
    
    }else{
         JOptionPane.showMessageDialog(this,"Seleccione un numero de mesa válido");
         numMesa.setSelectedIndex(0);
    }

    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {                                     


    }                                    

  /*  private void numMesaActionPerformed(java.awt.event.ActionEvent evt) {                                        
   
    }    */                                   

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        StockIngredientes.setVisible(false);
        this.setVisible(true);
    }                                        

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Hallar fila
        int fila = jTable1.getSelectedRow();

        // Tomar modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Eliminar fila
        model.removeRow(fila);
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        AñadirProd.setVisible(true);
        AñadirProd.setLocationRelativeTo(null);

    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //STOCK INGREDIENTES ARCHIVO        
        // Agregar filtro a FileChooser
        FileNameExtensionFilter filter
                = new FileNameExtensionFilter("Archivos.csv", "csv", "C\u00F3digo Seguro de Verificaci\u00F3n");
        fc.setFileFilter(filter);

        // Mostrar el FileChooser
        int opcion = fc.showOpenDialog(this);

        // Si el usuario escogió abrir
        if (opcion == JFileChooser.APPROVE_OPTION) {
            // Asignar archivo y nombre.
            archivo = fc.getSelectedFile();
            nombreArchivoTextField.setText(archivo.getAbsolutePath());

            // Tomar el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            try (Scanner lector = new Scanner(archivo)) {
                // Mientras el archivo tenga otra línea.
                while (lector.hasNextLine()) {
                    // Pedir la linea
                    String linea = lector.nextLine();

                    // Separar los datos
                    String[] datos = linea.split(" ");

                    // Convertir los datos
                    String ingrediente = datos[0];
                    int cantidad = Integer.parseInt(datos[1]);

                    // Agregamos datos a la tabla
                    model.addRow(new Object[]{ingrediente, cantidad});

                }
            } catch (FileNotFoundException ex) {
                mostrarError("Archivo no existe", "No se pudo encontrar el archivo");
            } catch (NullPointerException ex) {
                mostrarError("Formato equivocado", "El archivo no tiene el formato correcto");
                limpiarTabla(jTable1);

            }
        }

    }                                        

    private void cocinarActionPerformed(java.awt.event.ActionEvent evt) {                                        
        int filas = datosTable2.getRowCount();

        


    }                                       

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {                                          

        //Reset valores de pedido tabla de pedidos
        limpiarTabla(datosTable);
        numMesa.setSelectedIndex(0);
        numMeserito.setSelectedIndex(0);
        Menu.setVisible(true);
        Cocina.setVisible(false);
        Especialcant.setSelectedIndex(0);
        Ejecutivocant.setSelectedIndex(0);
        Corrientecant.setSelectedIndex(0);
        Pizzascant.setSelectedIndex(0);
        Pizzascant.setSelectedIndex(0);
        bebidaCant.setSelectedIndex(0);


    }                                         

    private void cocinarMouseMoved(java.awt.event.MouseEvent evt) {                                   
        cocinar.setToolTipText("Debe seleccionar un plato de la tabla para cocinar.");
    }                                  

    private void nombreArchivoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        // TODO add your handling code here:
    }                                                      
    
    
    
    
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Factura.setVisible(false);
        this.setVisible(true);
    }                                         

    private void nombreCliActionPerformed(java.awt.event.ActionEvent evt) {                                          
        JOptionPane.showMessageDialog(null, "El pago se ha realizado satisfactoriamente.");
        cedulaCli.setText("");
        nombreCli.setText("");
        telCli.setText("");
        infoFact.setText("");
    }                                         

    private void generateActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //FACTURA
        int contTotal = 0;
        int c1 = numMesa.getSelectedIndex(), c2 = Integer.parseInt(mesaFact.getText());
        int cant6 = bebidaCant.getSelectedIndex(), cant = Especialcant.getSelectedIndex(), cant5 = Pizzascant.getSelectedIndex();
        int cant2 = Corrientecant.getSelectedIndex(), cant3 = Ejecutivocant.getSelectedIndex(), cant4 = Pizzascant.getSelectedIndex();

        if (c1 == c2) {
            if (cant > 0) {

                String x =(String)Especial.getSelectedItem();
                String[] y;
                y = x.split(":");

                Factura fact = new Factura();
                fact.setConcepto(y[0]);

                Double precio = Double.parseDouble(y[1].substring(2));
                fact.setPrecio(precio);

                fact.setCantidad(cant);

                Double total = precio * cant;
                fact.setTotal(total);
                contTotal = contTotal + total.intValue(); //contador total

                //Asignamos valores a cada columna de la tabla
                DefaultTableModel model3 = (DefaultTableModel) factTable.getModel();
                model3.addRow(new Object[]{fact.getConcepto(), fact.getPrecio(), fact.getCantidad(), fact.getTotal()});
                factTable.setModel(model3);
            }

            if (cant2 > 0) {

                String x = (String)Corriente.getSelectedItem();;
                String[] y;
                y = x.split(":");

                Factura fact = new Factura();
                fact.setConcepto(y[0]);

                Double precio = Double.parseDouble(y[1].substring(2));
                fact.setPrecio(precio);

                fact.setCantidad(cant2);

                Double total = cant2 * precio;
                fact.setTotal(total);
                contTotal = contTotal + total.intValue();

                DefaultTableModel model3 = (DefaultTableModel) factTable.getModel();
                model3.addRow(new Object[]{fact.getConcepto(), fact.getPrecio(), fact.getCantidad(), fact.getTotal()});
                factTable.setModel(model3);
            }

            if (cant3 > 0) {
                String x = (String)Ejecutivo.getSelectedItem();;
                String[] y;
                y = x.split(":");

                Factura fact = new Factura();
                fact.setConcepto(y[0]);

                Double precio = Double.parseDouble(y[1].substring(2));
                fact.setPrecio(precio);

                fact.setCantidad(cant3);

                Double total = cant3 * precio;
                fact.setTotal(total);
                contTotal = contTotal + total.intValue();

                DefaultTableModel model3 = (DefaultTableModel) factTable.getModel();
                model3.addRow(new Object[]{fact.getConcepto(), fact.getPrecio(), fact.getCantidad(), fact.getTotal()});
                factTable.setModel(model3);

            }

            if (cant4 > 0) {
                String x = (String)Pizzas.getSelectedItem();;
                String[] y;
                y = x.split(":");

                Factura fact = new Factura();
                fact.setConcepto(y[0]);

                Double precio = Double.parseDouble(y[1].substring(2));
                fact.setPrecio(precio);

                fact.setCantidad(cant4);

                Double total = cant4 * precio;
                fact.setTotal(total);
                contTotal = contTotal + total.intValue();

                DefaultTableModel model3 = (DefaultTableModel) factTable.getModel();
                model3.addRow(new Object[]{fact.getConcepto(), fact.getPrecio(), fact.getCantidad(), fact.getTotal()});
                factTable.setModel(model3);
            }

            if (cant5 > 0) {
                String x = (String)Postres.getSelectedItem();;
                String[] y;
                y = x.split(":");

                Factura fact = new Factura();
                fact.setConcepto(y[0]);

                Double precio = Double.parseDouble(y[1].substring(2));
                fact.setPrecio(precio);

                fact.setCantidad(cant5);

                Double total = cant5 * precio;
                fact.setTotal(total);
                contTotal = contTotal + total.intValue();

                DefaultTableModel model3 = (DefaultTableModel) factTable.getModel();
                model3.addRow(new Object[]{fact.getConcepto(), fact.getPrecio(), fact.getCantidad(), fact.getTotal()});
                factTable.setModel(model3);
            }

            if (cant6 > 0) {
                String x = (String) tiposBebidas.getSelectedItem();
                String[] y;
                y = x.split(":");

               Factura fact = new Factura();
                fact.setConcepto(y[0]);

                Double precio = Double.parseDouble(y[1].substring(2));
                fact.setPrecio(precio);

                fact.setCantidad(cant6);

                Double total = precio * cant6;
                fact.setTotal(total);
                contTotal = contTotal + total.intValue();

                DefaultTableModel model3 = (DefaultTableModel) factTable.getModel();
                model3.addRow(new Object[]{fact.getConcepto(), fact.getPrecio(), fact.getCantidad(), fact.getTotal()});
                factTable.setModel(model3);
            }

            //Asignacion de iva prop y total a labels factura
            Double iva = contTotal * 0.19;
            Double prop = contTotal * 0.10;
            Double tot = iva + prop + contTotal;
            IVA.setText(String.valueOf(iva));
            PROPINA.setText(String.valueOf(prop));
            TOTALtot.setText(String.valueOf(tot));

            Interface_ingreso vp = new Interface_ingreso();
            String c = mesaFact.getText();
            numMesa2.setText(c);
            nombreMese.setText(vp.usuario);
            Factura.setVisible(true);
            Factura.setLocationRelativeTo(null);
            emergente.setVisible(false);
            //String fecha1 = (new Date()).toString();

        } else {
            JOptionPane.showMessageDialog(null, "No coinciden las mesas, verifique nuevamente");
            mesaFact.setText("");
        }

        if (mesaFact.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No ha ingresa numero de mesa para generar factura.");
        }
    }                                        


    private void generaFactActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int filas = datosTable2.getRowCount();

        emergente.setVisible(true);
        emergente.setLocationRelativeTo(null);
        Cocina.setVisible(false);


    }                                          


    private void mesaFactKeyTyped(java.awt.event.KeyEvent evt) {                                  
        int k = (int) evt.getKeyChar();
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }                                 

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Cocina.setVisible(false);
        Menu.setVisible(true);
    }                                         

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Mesero.setVisible(false);
        this.setVisible(true);
    }                                         

    private void nuevoProdKeyTyped(java.awt.event.KeyEvent evt) {                                   
        //Bloqueo de numeros en textField
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && ((c < 'A') | c > 'Z')) {
            evt.consume();
        }
    }                                  

    private void mesaFactActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Interface_ingreso vp = new Interface_ingreso();
        vp.nombre_usuario.setText("");
        vp.contra_usuario.setText("");
    }                                         

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {                                       

    }                                      

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {                                
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && ((c < 'A') | c > 'Z')) {
            evt.consume();
        }
    }                               

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {                                     
        //Bloqueo de letras en textField
        int k = (int) evt.getKeyChar();
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }                                    

    private void nombreCliKeyTyped(java.awt.event.KeyEvent evt) {                                   
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && ((c < 'A') | c > 'Z')) {
            evt.consume();
        }
    }                                  

    private void cedulaCliKeyTyped(java.awt.event.KeyEvent evt) {                                   
        int k = (int) evt.getKeyChar();
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }                                  

    private void telCliKeyTyped(java.awt.event.KeyEvent evt) {                                
        int k = (int) evt.getKeyChar();
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }                               

    private void cantProdNuevoKeyTyped(java.awt.event.KeyEvent evt) {                                       
        int k = (int) evt.getKeyChar();
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }                                      

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         


    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        resumenVentas.setVisible(true);
        resumenVentas.setLocationRelativeTo(null);
    }                                         


    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        JOptionPane.showMessageDialog(null, "En el dia de hoy se realizaron" + contador + " ventas. De un total de: " + suma, "PITAKS", JOptionPane.INFORMATION_MESSAGE);
    }                                         

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {                                          
//creo que esto es lo de el plato más vendido
        int[] vector;
        vector = new int[5];
        int contg = 0, conts = 0, conto = 0, contp1 = 0, contp2 = 0, contb = 0;

        mejorPlato.setVisible(true);
        mejorPlato.setLocationRelativeTo(null);

        if (Especialcant.getSelectedIndex() > 0) {
            contg = contg + Especialcant.getSelectedIndex();
            vector[0] = contg;
        }

        if (Corrientecant.getSelectedIndex() > 0) {
            conts = conts + Corrientecant.getSelectedIndex();
            vector[1] = conts;
        }
        if (Ejecutivocant.getSelectedIndex() > 0) {
            conto = conto + Ejecutivocant.getSelectedIndex();
            vector[2] = conto;
        }

        if (Pizzascant.getSelectedIndex() > 0) {
            contp1 = contp1 + Pizzascant.getSelectedIndex();
            vector[3] = contp1;
        }
        if (Pizzascant.getSelectedIndex() > 0) {
            contp2 = contp2 + Pizzascant.getSelectedIndex();
            vector[4] = contp2;
        }

        if (bebidaCant.getSelectedIndex() > 0) {
            contb = contb + bebidaCant.getSelectedIndex();
            vector[5] = contb;
        }

        int max;
        max = 0;
        String icon;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > max) {
                switch (i) {
                    case 0: {
                        nombrePlato0.setVisible(true);
                        nombrePlato1.setVisible(false);
                        nombrePlato2.setVisible(false);
                        nombrePlato3.setVisible(false);
                        nombrePlato4.setVisible(false);
                        nombrePlato5.setVisible(false);
                        icon = "/Img/pgriega.jpg";
                        URL url0 = this.getClass().getResource(icon);
                        ImageIcon icono = new ImageIcon(url0);
                        fotoplato.setIcon(icono);
                        max = vector[i];
                        break;
                    }
                    case 1: {

                        icon = "/Img/pOpera.jpg";
                        URL url1 = this.getClass().getResource(icon);
                        ImageIcon icono = new ImageIcon(url1);
                        fotoplato.setIcon(icono);
                        nombrePlato0.setVisible(false);
                        nombrePlato1.setVisible(true);
                        nombrePlato2.setVisible(false);
                        nombrePlato3.setVisible(false);
                        nombrePlato4.setVisible(false);
                        nombrePlato5.setVisible(false);
                        max = vector[i];
                        break;
                    }
                    case 2: {

                        icon = "/Img/pSiciliana.jpg";
                        URL url2 = this.getClass().getResource(icon);
                        ImageIcon icono = new ImageIcon(url2);
                        fotoplato.setIcon(icono);
                        nombrePlato0.setVisible(false);
                        nombrePlato1.setVisible(false);
                        nombrePlato2.setVisible(true);
                        nombrePlato3.setVisible(false);
                        nombrePlato4.setVisible(false);
                        nombrePlato5.setVisible(false);
                        max = vector[i];
                        break;
                    }
                    case 3: {
                        nombrePlato0.setVisible(false);
                        nombrePlato1.setVisible(false);
                        nombrePlato2.setVisible(false);
                        nombrePlato3.setVisible(true);
                        nombrePlato4.setVisible(false);
                        nombrePlato5.setVisible(false);
                        icon = "/Img/brasilia.png";
                        URL url3 = this.getClass().getResource(icon);
                        ImageIcon icono = new ImageIcon(url3);
                        fotoplato.setIcon(icono);
                        max = vector[i];
                        break;
                    }
                    case 4: {
                        nombrePlato0.setVisible(false);
                        nombrePlato1.setVisible(false);
                        nombrePlato2.setVisible(false);
                        nombrePlato3.setVisible(false);
                        nombrePlato4.setVisible(true);
                        nombrePlato5.setVisible(false);
                        icon = "/Img/damablanca.png";
                        URL url4 = this.getClass().getResource(icon);
                        ImageIcon icono = new ImageIcon(url4);
                        fotoplato.setIcon(icono);
                        max = vector[i];
                        break;
                    }
                    default: {
                        icon = "/Img/bebidastodas.png";
                        URL url5 = this.getClass().getResource(icon);
                        ImageIcon icono = new ImageIcon(url5);
                        fotoplato.setIcon(icono);
                        nombrePlato0.setVisible(false);
                        nombrePlato1.setVisible(false);
                        nombrePlato2.setVisible(false);
                        nombrePlato3.setVisible(false);
                        nombrePlato4.setVisible(false);
                        nombrePlato5.setVisible(true);
                        max = vector[i];
                        break;
                    }
                }
            }
        }
        if (max == 0) {
            JOptionPane.showMessageDialog(null, "No existe ningun maximo.");
        }


    }   
  private void guardarInfoActionPerformed(java.awt.event.ActionEvent evt) {                                            
        //GUARDAMOS ARCHIVO DE MESEROS
        /*String n = nombre.getText();
        int i = Integer.parseInt(jTextField1.getText());
        int mesero;
        mesero = numMesero.getSelectedIndex();
        mesero = mesero + 1;
        String mesa = mesasAsign.getText();

        NodoMesero p = new NodoMesero();
        ptr = agregarInfoMesero(ptr, n, i, mesero, mesa);
        String archivo1;
        archivo1 = "Mesero.txt";
        JOptionPane.showMessageDialog(null, "La informacion del mesero " + n + " se ha guardado en archivo");
        try {
            GuardarInfoMesero(ptr);

        } catch (IOException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }             

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         


    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int index = listMesas.getSelectedIndex() + 1;
        String t = TOTALtot.getText();

        if (Integer.parseInt(numMesa2.getText()) == index) {
            JOptionPane.showMessageDialog(null, "La mesa " + index + " tuvo ventas de " + t, "PITAKS", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "La mesa " + index + " no ha realizdo ventas. TOTAL = 0", "PITAKS", JOptionPane.INFORMATION_MESSAGE);
        }


    }                                         

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int cont = 0, cont1 = 0, cont2 = 0, cont3 = 0;
        int[] vector2;
        vector2 = new int[4];

        if (numMeserito.getSelectedIndex() == 1) {
            cont = cont + 1;
            vector2[0] = cont;
        }
        if (numMeserito.getSelectedIndex() == 2) {
            cont1 = cont1 + 1;
            vector2[1] = cont1 + 1;
        }
        if (numMeserito.getSelectedIndex() == 3) {
            cont2 = cont2 + 1;
            vector2[2] = cont2 + 1;
        }
        if (numMeserito.getSelectedIndex() == 4) {
            cont3 = cont3 + 1;
            vector2[3] = cont3 + 1;
        }

        String mayor2 = null;
        int max;
        max = 0;

        for (int i = 0; i < vector2.length; i++) {
            if (vector2[i] > max) {
                max = vector2[i];
                switch (i) {
                    case 0:
                        mayor2 = ("JESUS F");
                        break;
                    case 1:
                        mayor2 = ("MIGUEL J");
                        break;
                    case 2:
                        mayor2 = ("MARLENE D");
                        break;
                    default:
                        mayor2 = ("AUGUSTO S");
                        break;
                }

            }
        }

        JOptionPane.showMessageDialog(null, "El mesero que mas ventas realizo fue: " + mayor2, "PITAKS", JOptionPane.INFORMATION_MESSAGE);
    }                                         

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {                                          

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
            Factura.setVisible(false);
            this.setVisible(true);
            
             nombreCli.setText("");
            cedulaCli.setText("");
            telCli.setText("");
            numMesa2.setText("");
            limpiarTabla(datosTable);
            limpiarTabla(factTable);
            limpiarTabla(datosTable2);

        }
    }                                         

    private void pitaGriegaActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          
 

    public synchronized boolean isContinuar(boolean continuar) {
        return continuar;
    }
    void mostrarError(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(this,
                mensaje,
                titulo,
                JOptionPane.ERROR_MESSAGE);
    }

    void guardarArchivo() throws IOException {
        // Crear un nuevo escritor
        try (BufferedWriter bwr = new BufferedWriter(
                new FileWriter(archivo))) {
            // Hallamos el numero de filas
            int filas = datosTable.getRowCount();

            // Tomamos el modelo
            DefaultTableModel model = (DefaultTableModel) datosTable.getModel();

            for (int i = 0; i < filas; ++i) {
                Object ingrediente = model.getValueAt(i, 0);
                Object cantidad = model.getValueAt(i, 1);

                bwr.write(ingrediente + "," + cantidad);
                bwr.newLine();
            }
        }
    }

    void limpiarTabla(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    
}
