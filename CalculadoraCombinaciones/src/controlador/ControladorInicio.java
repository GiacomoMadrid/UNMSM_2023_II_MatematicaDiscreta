/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.frmInicio;
import modelo.Operador;
/**
 *
 * @author usuario
 */
public class ControladorInicio {
    protected frmInicio inicio;
    private Operador operador;
    
    public ControladorInicio(frmInicio inicio, Operador operador){
        this.inicio = inicio;
        this.operador = operador;
        this.inicio.setIconImage(getIconImage());
        
        this.inicio.btnCombinatoria.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                inicio.txtResultado.setText(""+operador.combinatoria(Integer.parseInt(inicio.txtN.getText()), Integer.parseInt(inicio.txtK.getText())));
                
            }
        });
       
        this.inicio.btnPermutacion.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                inicio.txtResultado.setText(""+operador.permutacion(Integer.parseInt(inicio.txtN.getText()), Integer.parseInt(inicio.txtK.getText())));
                
            }
        });
        
        this.inicio.btnVariacion1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                inicio.txtResultado.setText(""+operador.variacion1(Integer.parseInt(inicio.txtN.getText()), Integer.parseInt(inicio.txtK.getText())));
                
            }
        });
         
        this.inicio.btnVariacion2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                inicio.txtResultado.setText(""+operador.variacion2(Integer.parseInt(inicio.txtN.getText()), Integer.parseInt(inicio.txtK.getText())));
                
            }
        });
    }
    
    
    public void iniciar(){
        this.inicio.setVisible(true);
        this.inicio.setLocationRelativeTo(null);
        limpiarComponentes();
    }
    
    public void limpiarComponentes(){
        this.inicio.txtK.setText("");
        this.inicio.txtN.setText("");
        this.inicio.txtResultado.setText("");
    }
    
    public Image getIconImage(){
        Image redValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/Logo.png"));
        return redValue;
    }
    
}
