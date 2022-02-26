


public class ProyectoCalculadora {
    public static void main(String[] args) {
        String n= "1.5+(7+9*(678-098.993+9))";
        boolean valido;
        
        valido=metodosCalculadora.estaBalanceado(n);
        if(valido){
            valido=metodosCalculadora.cadenaCorrecta(n);
        }
        System.out.println(valido);
    }
    
}
