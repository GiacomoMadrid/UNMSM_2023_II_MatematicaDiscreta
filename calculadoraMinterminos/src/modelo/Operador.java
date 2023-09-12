package modelo;

import java.util.ArrayList;
import java.util.Stack;
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
    
    public  void imprimirTabla(ArrayList<Boolean> variables, JTextArea areaTexto, String texto){
        numVariables = variables.size();
        numOperaciones = (int) Math.pow(2, numVariables);
        
        switch(variables.size()){
            case 1:{
                variables.set(0, false);
                areaTexto.append("Tabla Logica\n");

                for(int i = 0; i<2; i++){ 
                    a = variables.get(0);
                    areaTexto.append(""+binario(variables.get(0))+"\t"+binario(resolverExpresion(texto, variables))+"\n");
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
                        a = variables.get(0);
                        b = variables.get(1);
                        areaTexto.append(""+binario(variables.get(0))+"\t"+binario(variables.get(1))+"\t"
                                +binario(resolverExpresion(texto, variables))
                                +"\n");
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
                            a = variables.get(0);
                            b = variables.get(1);
                            c = variables.get(2);
                            areaTexto.append(""
                                    +binario(variables.get(0))+"\t"+binario(variables.get(1))+"\t"+binario(variables.get(2))
                                    +"\t"+binario(resolverExpresion(texto, variables))+"\n");
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
                                a = variables.get(0);
                                b = variables.get(1);
                                c = variables.get(2);
                                d = variables.get(3);
                                
                                areaTexto.append(""
                                    +binario(variables.get(0))+"\t"+binario(variables.get(1))+"\t"+binario(variables.get(2))+
                                    "\t"+binario(variables.get(3))+"\t"+binario(resolverExpresion(texto, variables))+
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
    
    public void miau(){/*
        //Falta Completar, probar, validar, implementar, ver si funciona, todo:
        public Boolean evaluarPares(String texto, int iterador){
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


            if(mNegacion.find()){
                return !Boolean.valueOf(""+pNegacion.toString().charAt(iterador+1));

            }else if(mOperador.find()){
                switch(mOperador.toString().charAt(iterador+1)){
                    case '∧':{
                        return and(Boolean.parseBoolean(""+pNegacion.toString().charAt(iterador)),Boolean.parseBoolean(""+pNegacion.toString().charAt(iterador+2)));
                    }

                    case '∨':{
                        return or(Boolean.parseBoolean(""+pNegacion.toString().charAt(iterador)),Boolean.parseBoolean(""+pNegacion.toString().charAt(iterador+2)));
                    }

                    case '↑':{
                        return nand(Boolean.parseBoolean(""+pNegacion.toString().charAt(iterador)),Boolean.parseBoolean(""+pNegacion.toString().charAt(iterador+2)));
                    }

                    case '↓':{
                        return nor(Boolean.parseBoolean(""+pNegacion.toString().charAt(iterador)),Boolean.parseBoolean(""+pNegacion.toString().charAt(iterador+2)));
                    }

                    case '⊕':{
                        return xor(Boolean.parseBoolean(""+pNegacion.toString().charAt(iterador)),Boolean.parseBoolean(""+pNegacion.toString().charAt(iterador+2)));
                    }

                    case '⊙':{
                        return xnor(Boolean.parseBoolean(""+pNegacion.toString().charAt(iterador)),Boolean.parseBoolean(""+pNegacion.toString().charAt(iterador+2)));
                    }
                }

            }else if(mChar.find()){
                return Boolean.valueOf(mChar.toString());

            }else if(mAgrupacion.find()){

            }else{
                JOptionPane.showMessageDialog(null, "Operador desconocido: "+texto.charAt(iterador));
                return null;
            }

            return null;

        }
    */
    } 
    
    //---------------------------------------------------------------------------------
    
    public boolean resolverExpresion(String expresion, ArrayList<Boolean> var) {
        Stack<Boolean> variables = new Stack<>();
        Stack<Character> agrupadores = new Stack<>();
        Stack<Character> operadores = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char letra = expresion.charAt(i);
            
            if (Character.isAlphabetic(letra)) {
                StringBuilder variable = new StringBuilder();
                
                while (i < expresion.length() && (Character.isAlphabetic(expresion.charAt(i)))) {
                    variable.append(expresion.charAt(i));
                    i++;
                }
                
                variables.push(Boolean.parseBoolean(variable.toString()));
                i--;
                
            } else if (letra == '(' || letra == '[') {
                agrupadores.push(letra);
                
            } else if (letra == ')' || letra == ']') {
                while (!agrupadores.isEmpty() && agrupadores.peek() != '(' && agrupadores.peek() != '[') {
                    calcularOperacion(variables, operadores);
                    
                }
                
                agrupadores.pop(); // Eliminar el paréntesis o corchete abierto
                
            } else if (esOperador(letra)) {
                while (!operadores.isEmpty() && precedencia(operadores.peek(), letra)) {
                    calcularOperacion(variables, operadores);
                    
                }
                
                operadores.push(letra);
            }
        }

        while (!operadores.isEmpty()) {
            calcularOperacion(variables, operadores);
        }

        return variables.pop();
    }

    public boolean esOperador(char letra) {
        return letra == '¬' || letra == '∧' || letra == '∨' || letra == '↑' || letra == '↓' || letra == '⊕' || letra == '⊙';
    }

    public boolean precedencia(char op1, char op2) {
        if ((op1 == '¬' ) && (op2 == '∧' || op2 == '∨' || op2 == '↑' || op2 == '↓' || op2 == '⊕' || op2 == '⊙')) {
            return true;
        }
        
        if ((op1 == '∧' || op1 == '∨') && (op2 == '↑' || op2 == '↓' || op2 == '⊕' || op2 == '⊙')) {
            return true;
        }
        
        if ((op1 == '↑' || op1 == '↓') && (op2 == '⊕' || op2 == '⊙')) {
            return true;
        }
        return false;
    }

    public void calcularOperacion(Stack<Boolean> variables, Stack<Character> operadores) {
        char operador = operadores.pop();
        boolean valor1 = variables.pop();
        boolean valor2;
        boolean resultado = true;

        switch (operador) {
            case '¬':
                resultado = !valor1;
                break; 
            case '∧':
                valor2 = variables.pop();
                resultado = and(valor1, valor2);
                break;
            case '∨':
                valor2 = variables.pop();
                resultado = or(valor1, valor2);
                break;
            case '↑':
                valor2 = variables.pop();
                resultado = nand(valor1, valor2);
                break;
            case '↓':
                valor2 = variables.pop();
                resultado = nor(valor1, valor2);
                break;
            case '⊕':
                valor2 = variables.pop();
                resultado = xor(valor1, valor2);
                break;
            case '⊙':
                valor2 = variables.pop();
                resultado = xnor(valor1, valor2);
                break;  
            
                
        }

        variables.push(resultado);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
