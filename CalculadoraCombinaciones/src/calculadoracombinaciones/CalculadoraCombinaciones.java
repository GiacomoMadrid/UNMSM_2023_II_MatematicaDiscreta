/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadoracombinaciones;

import modelo.Operador;

/**
 *
 * @author usuario
 */
public class CalculadoraCombinaciones {

    public static void main(String[] args) {
        System.out.println("Hola, mundo");
        
        
        Operador operador = new Operador(4, 3);
        
        int num = operador.factorial(4);
        System.out.println("Hola");
        
        System.out.println(""+num);
        System.out.println(""+operador.factorial(6));
        System.out.println(""+operador.factorial(10));
    }
    
}
