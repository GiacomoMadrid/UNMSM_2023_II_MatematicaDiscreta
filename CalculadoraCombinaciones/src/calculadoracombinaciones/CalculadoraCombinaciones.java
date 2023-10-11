/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadoracombinaciones;

import controlador.ControladorInicio;
import modelo.Operador;
import vista.frmInicio;

/**
 *
 * @author usuario
 */
public class CalculadoraCombinaciones {

    public static void main(String[] args) {
        frmInicio inicio = new frmInicio();
        Operador operador = new Operador();
        ControladorInicio contInicio = new ControladorInicio(inicio, operador);
        
        contInicio.iniciar();
        
        
    }
    
}
