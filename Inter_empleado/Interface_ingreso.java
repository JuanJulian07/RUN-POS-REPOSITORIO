package Inter_empleado;



import javax.swing.*;
import Empleados.Empleado;
import Leer_Bases_de_datos.*;
import Carpeta_de_ejecucion.*;

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
        
        add(panel);
        
        setVisible(true);
        
        
    }

    protected void Panel_ingreso(){
        //Retorna la configuracion del panel o la distribucion principalmente para el ingreso del personal con todos los botones
        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(getWidth(), getHeight());
        

        JLabel inUsuario = new JLabel();
        inUsuario.setText("Ingrese su nombre de Usuario");
        inUsuario.setBounds(getWidth()/2 - 100, 30, 200, 20);

        panel.add(inUsuario);

        JTextField nombre_usuario = new JTextField();
        nombre_usuario.setBounds(getWidth()/2 -100,50, 200, 20);

        panel.add(nombre_usuario);

        JLabel inContra = new JLabel();
        inContra.setText("Ingrese su nombre de Usuario");
        inContra.setBounds(getWidth()/2-100, 100, 200, 20);

        panel.add(inContra);

        JTextField contra_usuario = new JTextField();
        contra_usuario.setBounds(getWidth()/2 -100,120, 200, 20);

        panel.add(contra_usuario);

        JButton ingreso = new JButton("Ingresar");
        ingreso.setBounds(getWidth()/2-100, 160, 100,20);
        
        ingreso.addActionListener(accion -> {
            usuario = nombre_usuario.getText();
            contra = contra_usuario.getText();
            Leer_empleados verificacion = new Leer_empleados(usuario, contra);
            
            if(verificacion.get_acceso()== false){
                JOptionPane.showMessageDialog(this,"No pudimos encontrar tu usuario\n Intentalo nuevamente");
                nombre_usuario.setText("");
                contra_usuario.setText("");
            }
            else{
                user = verificacion.get_empleado();
                JOptionPane.showMessageDialog(this,"Has ingresado correctamente " + user.get_nombre());
                this.dispose();
                
                
            }
            
        });

        panel.add(ingreso);
    }

    public Empleado get_empleado(){
        if(user == null){
            return null;
        }
        return user;
    }
    
}
