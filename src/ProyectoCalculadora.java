


public class ProyectoCalculadora {
    public static void main(String[] args) {
        String n= "";
        String pruebaGro = "((9+7*3)+9/3)"
        boolean valido;
        
        valido=metodosCalculadora.estaBalanceado(n);
        if(valido){
            valido=metodosCalculadora.cadenaCorrecta(n);
        }
        System.out.println(valido);
    }
    
}
