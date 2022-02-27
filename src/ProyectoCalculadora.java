
import java.util.ArrayList;




public class ProyectoCalculadora {
    public static void main(String[] args) {
        String n= "2^(2-$3.5)-76*(1/3)";
        ArrayList<String> a = new ArrayList();
        boolean valido;
        double res=0;
        
        valido=metodosCalculadora.estaBalanceado(n);
        if(valido){
            valido=metodosCalculadora.cadenaCorrecta(n);
            if(valido){
                a=metodosCalculadora.convertirPostfija(n);
                res=metodosCalculadora.evalua(a);
            }
        }
        System.out.println(res);
        
    }
    
}
