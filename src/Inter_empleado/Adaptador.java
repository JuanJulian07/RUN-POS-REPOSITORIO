package Inter_empleado;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

public class Adaptador {
    

    public static KeyAdapter accion_teclado (JButton boton){
        return new KeyAdapter() {
            public void keyPressed (KeyEvent e){
                if(e.getExtendedKeyCode() == 10){
                    boton.doClick();
                }
            }
        };
    }
    
}
