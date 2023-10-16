/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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
                try{
                    int a = Integer.parseInt(inicio.txtN.getText());
                    int b = Integer.parseInt(inicio.txtK.getText());
                    inicio.txtResultado.setText(""+operador.combinatoria(a, b));
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error, revise la sintaxis.");
                }
            }
        });
       
        this.inicio.btnPermutacion.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int a = Integer.parseInt(inicio.txtN.getText());
                    int b = Integer.parseInt(inicio.txtK.getText());
                    inicio.txtResultado.setText(""+operador.permutacion(a, b));
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error, revise la sintaxis.");
                }
            }
        });
        
        this.inicio.btnVariacion1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    inicio.txtResultado.setText(""+operador.variacion1(Integer.parseInt(inicio.txtN.getText()), Integer.parseInt(inicio.txtK.getText())));
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error, revise la sintaxis.");
                }
            }
        });
         
        this.inicio.btnVariacion2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    inicio.txtResultado.setText(""+operador.variacion2(Integer.parseInt(inicio.txtN.getText()), Integer.parseInt(inicio.txtK.getText())));
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error, revise la sintaxis.");
                }
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
