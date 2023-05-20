package Inter_empleado;

import javax.swing.*;

public abstract class Interface_empleado extends JFrame{
    protected int interface_empleado;

    public Interface_empleado(int tipo_interface){
        interface_empleado = tipo_interface;
    }

    public abstract void imp_interface();
}
