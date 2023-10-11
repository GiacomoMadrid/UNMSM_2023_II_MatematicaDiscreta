
package modelo;

/**
 *
 * @author usuario
 */
public class Operador {
    private int n;
    private int k;
    private int resultado;
    
    public Operador(int n, int k){
        this.n = n;
        this.k = k;
        this.resultado = 0;
    
    }
    
    
    
    public int combinatoria(int a, int b){
        int retorno = 0;
        
        if(a >= b){
            retorno = factorial(a)/(factorial(b)*factorial(a-b));        
        }
                
        return retorno;
    }
    
    public int permutacion(int a, int b){
        int retorno = 0;
        
        if(a >= b){
            retorno = factorial(a)/(factorial(a-b));        
        }
                
        return retorno;
    }
    
    public int variacion2(int a, int b){
                               
        return (int) Math.pow(a, b);
    }
    
    public int variacion1(int a, int b){
        int retorno = 0;
        
        if(a >= b){
            retorno = factorial(a)/(factorial(a-b));        
        }
                
        return retorno;
    }
    
    public int factorial(int num){
        if(num == 0 || num == 1){
            return 1;
            
        }else{
            return num * factorial(num-1);        
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

