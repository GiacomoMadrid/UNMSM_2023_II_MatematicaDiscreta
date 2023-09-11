package modelo;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
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
    
    //------------------------ Operadores Lógicos -------------------------
    
    public boolean and(boolean var1, boolean var2){
        return var1 && var2;
    }
    
    public boolean or(boolean var1, boolean var2){
        return var1 || var2;
    }
            
    public boolean nand(boolean var1, boolean var2){
        return !(var1 && var2);
    } 
    
    public boolean nor(boolean var1, boolean var2){
        return !(var1 || var2);
    } 
    
    public boolean xor(boolean var1, boolean var2){
        return (var1 && !var2) || (var2 && !var1);
    } 
    
    public boolean xnor(boolean var1, boolean var2){
        return !((var1 && !var2) || (var2 && !var1));
    }
    //------------------------------------- Métodos --------------------------------
    
    public int binario(boolean valorDeVerdad){
        if(valorDeVerdad == true){
            return 1;
            
        }else{
            return 0;
        }
    }
    
    public boolean resultado(boolean var1, boolean var2, String funcion){
        boolean respuesta;
        
        respuesta = xor(var1, var2);
        
        return respuesta;       
    }
    
    public boolean resolverFuncion(String funcion){
    
        return false;
    }
    
    //------------------------ Imprimir Tabla de Verdad -------------------------
    
    public  void imprimirTabla(ArrayList<Boolean> variables, JTextArea areaTexto){
        numVariables = variables.size();
        numOperaciones = (int) Math.pow(2, numVariables);

        switch(variables.size()){
            case 1:{
                variables.set(0, false);
                areaTexto.append("Tabla Logica\n");

                for(int i = 0; i<2; i++){ 
                    areaTexto.append(""+binario(variables.get(0))+"\n");
                    variables.set(0, !variables.get(0));

                }
                
                
                break;
            
            }
            
            case 2:{
                variables.set(0, false);
                variables.set(1, false);
                areaTexto.append("Tabla Logica\n");

                for(int i = 0; i<numOperaciones/2; i++){ 
                    for(int j = 0; j<numOperaciones/2; j++){
                        areaTexto.append(""+binario(variables.get(0))+"\t"+binario(variables.get(1))+"\n");
                        variables.set(1, !variables.get(1));
                    }
                    variables.set(0, !variables.get(0));  
                    
                }
                
                break;
            
            }
            
            case 3:{
                variables.set(0, false);
                variables.set(1, false);
                variables.set(2, false);
                areaTexto.append("Tabla Logica\n");
                for(int k = 0; k<2; k++){ 
                    for(int i = 0; i<2; i++){ 
                        for(int j = 0; j<2; j++){
                            areaTexto.append(""
                                    +binario(variables.get(0))+"\t"+binario(variables.get(1))+"\t"+binario(variables.get(2))+
                                    "\n");
                            variables.set(2, !variables.get(2)); 
                        }
                        variables.set(1, !variables.get(1)); 

                    }
                    variables.set(0, !variables.get(0)); 

                }
                break;
            
            }
            
             case 4:{
                variables.set(0, false);
                variables.set(1, false);
                variables.set(2, false);
                variables.set(3, false);
                areaTexto.append("Tabla Logica\n");
                for(int l = 0; l<2; l++){ 
                    for(int k = 0; k<2; k++){ 
                        for(int i = 0; i<2; i++){ 
                            for(int j = 0; j<2; j++){
                                areaTexto.append(""
                                    +binario(variables.get(0))+"\t"+binario(variables.get(1))+"\t"+binario(variables.get(2))+
                                    "\t"+binario(variables.get(3))+
                                    "\n");
                                
                                variables.set(3, !variables.get(3)); 
                            }
                            variables.set(2, !variables.get(2));   

                        }
                        variables.set(1, !variables.get(1));  

                    }
                    variables.set(0, !variables.get(0));   
                }
                break;
            
            }            
        }  
    }
    
    
    public void evaluarPares(String texto){
        Boolean resp;
        String regexChar = "[abcd]";
        String regexOperador = "[abcd][∧∨↑↓⊕⊙][abcd]";
        String regexNegacion = "[¬][abcd]";
        String regexAgrupacion = "[([{}])]";
        
        Pattern pChar = Pattern.compile(regexChar);
        Pattern pOperador = Pattern.compile(regexOperador);
        Pattern pNegacion = Pattern.compile(regexNegacion);
        Pattern pAgrupacion = Pattern.compile(regexAgrupacion);
        
        Matcher mChar = pChar.matcher(texto);
        Matcher mOperador = pOperador.matcher(texto);
        Matcher mNegacion = pNegacion.matcher(texto);
        Matcher mAgrupacion = pAgrupacion.matcher(texto);
        
        for(int i=0; i<texto.length();i++){
            
            if(mNegacion.find()){
                resp = !Boolean.valueOf(""+pNegacion.toString().charAt(1));
            
            }else if(mOperador.find()){
                switch(mOperador.toString().charAt(1)){
                    case '∧':{
                        resp = and(Boolean.parseBoolean(""+pNegacion.toString().charAt(0)),Boolean.parseBoolean(""+pNegacion.toString().charAt(2)));
                        break;
                    }
                    
                    case '∨':{
                        resp = or(Boolean.parseBoolean(""+pNegacion.toString().charAt(0)),Boolean.parseBoolean(""+pNegacion.toString().charAt(2)));
                        break;
                    
                    }
                    
                    case '↑':{
                        resp = nand(Boolean.parseBoolean(""+pNegacion.toString().charAt(0)),Boolean.parseBoolean(""+pNegacion.toString().charAt(2)));
                        break;
                    }
                    
                    case '↓':{
                        resp = nor(Boolean.parseBoolean(""+pNegacion.toString().charAt(0)),Boolean.parseBoolean(""+pNegacion.toString().charAt(2)));
                        break;
                    }
                    
                    case '⊕':{
                        resp = xor(Boolean.parseBoolean(""+pNegacion.toString().charAt(0)),Boolean.parseBoolean(""+pNegacion.toString().charAt(2)));
                        break;
                    }
                    
                    case '⊙':{
                        resp = xnor(Boolean.parseBoolean(""+pNegacion.toString().charAt(0)),Boolean.parseBoolean(""+pNegacion.toString().charAt(2)));
                        break;
                    }
                }
            
            }else if(mChar.find()){
                resp = Boolean.valueOf(mChar.toString());
            
            }else if(mAgrupacion.find()){
                
            
            }else{
                JOptionPane.showMessageDialog(null, "Operador desconocido: "+texto.charAt(i));
            }
                 
            
        }
        
    }
    
    
    
}
