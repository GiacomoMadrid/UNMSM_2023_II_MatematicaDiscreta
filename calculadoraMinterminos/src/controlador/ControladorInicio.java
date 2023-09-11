/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JOptionPane;
import vista.frmInicio;
import modelo.Operador;



public class ControladorInicio {
    protected frmInicio inicio;
    private String texto;
    private Operador operador;
    private boolean a = false,b = false, c = false, d = false;
    private ArrayList<Boolean> variables;
    
    public ControladorInicio (frmInicio inicio){
        this.inicio = inicio;
        this.texto = "";
        this.operador = new Operador(inicio.txtTabla);
        this.variables = new ArrayList();
        
        
        
        //------------------------------------------ Agregar variables:
        this.inicio.btnA.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = inicio.lblCircuito.getText();
                inicio.lblCircuito.setText(texto+"a");
                a = true;
                
            }
        });
        
        this.inicio.btnB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = inicio.lblCircuito.getText();
                inicio.lblCircuito.setText(texto+"b");  
                b = true;
            }
        });
        
        this.inicio.btnC.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = inicio.lblCircuito.getText();
                inicio.lblCircuito.setText(texto+"c");
                c = true;
            }
        });
        
        this.inicio.btnD.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = inicio.lblCircuito.getText();
                inicio.lblCircuito.setText(texto+"d");
                d = true;
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
                inicio.txtTabla.setText("");
                if(verificarAgrupacion(inicio.lblCircuito.getText())==true){
                    llenarLista();                
                    operador.imprimirTabla(variables, inicio.txtTabla);
                    vaciarLista();
                }else{
                    JOptionPane.showMessageDialog(null, "Error: Verifique el balanceo de los signos de agrupación.");
                }
                
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
        
        this.inicio.btnBorrarTodo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(inicio.lblCircuito.getText().length() >0){
                   inicio.lblCircuito.setText("");
                   vaciarLista();
                }
                
            }
        });
        
        
    }
    
    //------------------------------------------ Métodos --------------------------------------
    
    public void iniciar(){
        this.inicio.setLocationRelativeTo(null);
        this.inicio.setVisible(true);
        this.inicio.lblCircuito.setText("");
        this.inicio.txtTabla.setText("");
       this.inicio.txtTabla.setEditable(false);
    }
        
    public void llenarLista(){
        if(this.a == true){
            variables.add(a);
            this.a = false;
        }
        
        if(this.b == true){
            variables.add(b);
            this.b = false;
        }else{
        }
        
        if(this.c == true){
            variables.add(c);
            this.c = false;
        }else{
        }
        
        if(this.d == true){
            variables.add(d);  
            this.d = false;
        }else{
        }
    }
    
     public void vaciarLista(){
        for(int i = variables.size()-1; i == 0; i--){            
            variables.remove(i);            
        }
        variables.remove(a);
        variables.remove(b);
        variables.remove(c);
        variables.remove(d);

        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        
    }
    
     
    public boolean verificarAgrupacion(String texto){
        int cont = 0;
        Stack<Character> parentesis = new Stack();
        Stack<Character> corchetes = new Stack();
        
        for(int i=0; i<texto.length(); i++){
            switch (texto.charAt(i)) {
                case '(':
                    parentesis.push('(');
                    cont++;
                    break;
                    
                case ')':
                    if(parentesis.isEmpty()){
                        break;
                    }else{
                        parentesis.pop();
                    }
                    cont--;
                    break;
                    
                case '[':
                    corchetes.push('[');
                    cont++;
                    break;
                    
                case ']':                    
                    if(corchetes.isEmpty()){
                        break;
                    }else{
                        corchetes.pop();
                    }
                    cont--;
                    break;
                    
                default:
                    break;
                
            }
            
        } 
        
        return ((parentesis.isEmpty() == true) && (corchetes.isEmpty() == true) && (cont == 0));
        
    }
    
    
    
    
    
    
    
    
    
    //------------------------------------------ Get & Set ------------------------------------
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
}
