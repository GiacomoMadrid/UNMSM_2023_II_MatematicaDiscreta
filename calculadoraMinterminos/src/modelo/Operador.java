package modelo;

import java.util.ArrayList;
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
    //------------------------------------- Métodos --------------------------------
    
    public int binario(boolean valorDeVerdad){
        if(valorDeVerdad == true){
            return 1;
            
        }else{
            return 0;
        }
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
    
    
}
