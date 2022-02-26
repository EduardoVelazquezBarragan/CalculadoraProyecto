
import java.util.ArrayList;




public class ProyectoCalculadora {
    public static void main(String[] args) {
        String n= "9^(8+7*6+2)/3+(31*7)";
        ArrayList<String> a = new ArrayList();
        boolean valido;
        
        valido=metodosCalculadora.estaBalanceado(n);
        if(valido){
            valido=metodosCalculadora.cadenaCorrecta(n);
            if(valido){
                a=metodosCalculadora.convertirPostfija(n);
            }
        }
        System.out.println(a.toString());
        
    }
    
}
