package modelo;

import javax.swing.JTextArea;

/**
 *
 * @author Giacomo Salvador
 */
public class Operador {
    private boolean a,b,c,d;
    private int numVariables;
    private int numOperaciones;
    private String funcion;
    
    
    public Operador(JTextArea areaOperacion){
     this.funcion = areaOperacion.getText();
        
        
    }
    
    public boolean and(boolean var1, boolean var2){
        return var1 && var2;
    }
    
    public boolean or(boolean var1, boolean var2){
        return var1 || var2;
    }
            
    public boolean nand(boolean a, boolean b){
        return !(a && b);
    } 
    
    public boolean nor(boolean a, boolean b){
        return !(a || b);
    } 
    
    public boolean xor(boolean a, boolean b){
        return (a && !b) || (b && !a);
    } 
    
    public boolean xnor(boolean a, boolean b){
        return !((a && !b) || (b && !a));
    }
    
    
    
}
