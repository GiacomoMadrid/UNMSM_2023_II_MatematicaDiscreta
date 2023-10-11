
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.frmMensaje;
/**
 *
 * @author usuario
 */
public class ControladorMensaje {
    protected frmMensaje mensaje;
    private boolean flag;
    
    public ControladorMensaje(frmMensaje mensaje, ControladorInicio inicio){
        this.mensaje = mensaje;
        this.flag = false;
        
        this.mensaje.btnEmpezar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                mensaje.dispose();
                inicio.iniciar();
            }
        });
    }
    
    
    
    public void iniciar(){
        this.mensaje.setVisible(true);
        this.mensaje.setLocationRelativeTo(null);
        
    } 

    public boolean isFlag() {
        return flag;
    }
    
    
}
