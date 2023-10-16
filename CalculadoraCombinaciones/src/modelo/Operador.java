
package modelo;

/**
 *
 * @author usuario
 */
public class Operador {
    private int n;
    private int k;
    private int resultado;
    
    public Operador(){
            
    }
    
    
    public int combinatoria(int a, int b){
        return factorial(a)/(factorial(b)*factorial(a-b));
    }
    
    public int permutacion(int a, int b){
        return factorial(a)/(factorial(a-b));
    }
    
    public int variacion2(int a, int b){                               
        return (int) Math.pow(a, b);
    }
    
    public int variacion1(int a, int b){
        return factorial(a)/(factorial(a-b));
    }
    
    public int factorial(int num){
        if(num > 1){
            return (num * factorial(num-1));
            
        }else{
            return 1;      
        }        
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
    
    
}

