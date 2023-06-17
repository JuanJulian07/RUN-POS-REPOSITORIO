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
    public static KeyAdapter accion_teclado_tablas (JButton boton){
        return new KeyAdapter() {
            public void keyPressed (KeyEvent e){
                if(e.getExtendedKeyCode() == KeyEvent.VK_PLUS){
                    boton.doClick();
                }
            }
        };
    }
    public static KeyAdapter accion_teclado_tablas_guardar (JButton boton){
        return new KeyAdapter() {
            public void keyPressed (KeyEvent e){
                if(e.getExtendedKeyCode() == KeyEvent.VK_F7){

                    boton.doClick();
                }
            }
        };
    }
    
}
