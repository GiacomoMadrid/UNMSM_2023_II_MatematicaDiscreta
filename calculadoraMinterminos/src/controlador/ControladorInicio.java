/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.frmInicio;



public class ControladorInicio {
    protected frmInicio inicio;
    private String texto;
    
    public ControladorInicio (frmInicio inicio){
        this.inicio = inicio;
        this.texto = "";
        //------------------------------------------ Agregar variables:
        this.inicio.btnA.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = inicio.lblCircuito.getText();
                inicio.lblCircuito.setText(texto+"a");
            }
        });
        
        this.inicio.btnB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = inicio.lblCircuito.getText();
                inicio.lblCircuito.setText(texto+"b");    
            }
        });
        
        this.inicio.btnC.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = inicio.lblCircuito.getText();
                inicio.lblCircuito.setText(texto+"c");
            }
        });
        
        this.inicio.btnD.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = inicio.lblCircuito.getText();
                inicio.lblCircuito.setText(texto+"d");
            }
        });
        
        //------------------------------------ Operadores
        this.inicio.btnNot.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = inicio.lblCircuito.getText();
                inicio.lblCircuito.setText(texto+"¬");
            }
        });
        
        this.inicio.btnAnd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = inicio.lblCircuito.getText();
                inicio.lblCircuito.setText(texto+"∧");
            }
        });
        
        
        this.inicio.btnOr.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               texto = inicio.lblCircuito.getText();
               inicio.lblCircuito.setText(texto+"∨"); 
            }
        });
        
        this.inicio.btnNand.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = inicio.lblCircuito.getText();
                inicio.lblCircuito.setText(texto+"↑");
            }
        });
        
        this.inicio.btnNor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = inicio.lblCircuito.getText();
                inicio.lblCircuito.setText(texto+"↓");
            }
        });
        
        this.inicio.btnXor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = inicio.lblCircuito.getText();
                inicio.lblCircuito.setText(texto+"⊕");
            }
        });
        
        
        this.inicio.btnXnor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = inicio.lblCircuito.getText();
                inicio.lblCircuito.setText(texto+"⊙");
            }
        });
        
        //---------------------------------------- Agrupadores
        this.inicio.btnParentesisAbierto.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = inicio.lblCircuito.getText();
                inicio.lblCircuito.setText(texto+"(");
            }
        });
        
        this.inicio.btnParentesisCerrado.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = inicio.lblCircuito.getText();
                inicio.lblCircuito.setText(texto+")");
            }
        });
        
        this.inicio.btnCorcheteAbierto.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = inicio.lblCircuito.getText();
                inicio.lblCircuito.setText(texto+"[");
            }
        });
        
        this.inicio.btnCorcheteCerrado.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = inicio.lblCircuito.getText();
                inicio.lblCircuito.setText(texto+"]");
            }
        });
        
        this.inicio.btnResolver.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
            }
        });
        
        this.inicio.btnBorrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(inicio.lblCircuito.getText().length() >0){
                    texto = inicio.lblCircuito.getText().substring(0, inicio.lblCircuito.getText().length()-1);
                    inicio.lblCircuito.setText(texto);
                }
                
            }
        });
        
        
    }
    
    public void iniciar(){
        this.inicio.setLocationRelativeTo(null);
        this.inicio.setVisible(true);
        this.inicio.lblCircuito.setText("");
    }
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
    
}
