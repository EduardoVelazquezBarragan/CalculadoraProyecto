


public class ProyectoCalculadora {
    public static void main(String[] args) {
        String n= "";
        boolean valido;
        
        valido=metodosCalculadora.estaBalanceado(n);
        if(valido){
            valido=metodosCalculadora.cadenaCorrecta(n);
        }
        System.out.println(valido);
    }
    
}
