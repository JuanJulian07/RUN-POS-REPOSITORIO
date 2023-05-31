package Inter_empleado;
import javax.swing.JProgressBar;
public class Ventanapresentación extends javax.swing.JFrame {
    Cargar hilo;
    public Interface_ingreso vp; 
    public Ventanapresentación() {
        initComponents();
        iniciar();
        setVisible(true);
    }

    public void iniciar() {
        setLocationRelativeTo(null);
        hilo = new Cargar(getProgress());
        hilo.start();
        hilo = null;
        this.setLocationRelativeTo(null);

    }

                        
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        progress = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 376));
        setMinimumSize(new java.awt.Dimension(600, 376));
        setUndecorated(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_fotograficos/icono_principal.jpg"))); // NOI18N

        progress.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                progressStateChanged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DISEÑADO POR: JUAN DAVID Y JUAN JULIÁN");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(270, 4, 320, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                        

    public  Interface_ingreso ejecutarIngreso(){ 
        return(vp = new Interface_ingreso()); 
    }

    private void progressStateChanged(javax.swing.event.ChangeEvent evt) {                                      
        if (progress.getValue() == 100) {
            
            ejecutarIngreso();         

            this.dispose();
        }
    }                                     

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar progress;
    // End of variables declaration                   

    /**
     * @return the progress
     */
    public javax.swing.JProgressBar getProgress() {
        return progress;
    }

    
   
}
class Cargar extends Thread {
    JProgressBar progress;
    
    public Cargar(JProgressBar progress){
        super();
        this.progress = progress; 
    }
    
    @Override
    public void run(){
        for (int i = 1; i <= 100; i++) {
            progress.setValue(i);
            pausa(30);
        }
    }
    public void pausa(int mlSeg){
        try {
            Thread.sleep(mlSeg);
        }
        catch(Exception e){
            
        }
    }
}

