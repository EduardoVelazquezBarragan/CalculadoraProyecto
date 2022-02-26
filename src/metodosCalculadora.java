

import java.util.ArrayList;
import pilas.PilaA;


public class metodosCalculadora {
    public static boolean estaBalanceado(String cadena){
        boolean valido=true;
        PilaA <String> a= new PilaA();
        int i=0;
        
        while(i<cadena.length()&&valido){
            if(cadena.charAt(i)=='('){
                a.push("(");
            }
            else{
                if(cadena.charAt(i)==')'){
                    try{
                        a.pop();
                    }catch(Exception e){
                        valido=false;
                    }
                }
            }
            i++;
        }
        if(!a.isEmpty()){
            valido=false;
        }
        return valido;
    }
    
    public static boolean cadenaCorrecta(String cadena){
        boolean valido =true;
        int i=0, n;
        
        n=cadena.length();
        if(n>0&&(cadena.charAt(0)=='-'||cadena.charAt(0)=='+'||cadena.charAt(0)=='/'||cadena.charAt(0)=='*'||cadena.charAt(0)=='^')){
            valido=false;
        }
        if(n>0&&(cadena.charAt(n-1)=='-'||cadena.charAt(n-1)=='+'||cadena.charAt(n-1)=='/'||cadena.charAt(n-1)=='*'||cadena.charAt(n-1)=='^'||cadena.charAt(n-1)=='.'||cadena.charAt(n-1)=='$')){
            valido=false;
        }
        while(i<n&&valido){
            if(cadena.charAt(i)=='+'||cadena.charAt(i)=='('||cadena.charAt(i)=='*'||cadena.charAt(i)=='-'||cadena.charAt(i)=='/'||cadena.charAt(i)=='^'){
                if(cadena.charAt(i+1)=='+'||cadena.charAt(i+1)==')'||cadena.charAt(i+1)=='*'||cadena.charAt(i+1)=='-'||cadena.charAt(i+1)=='/'||cadena.charAt(i+1)=='^'){
                    valido=false;
                }
            }
            else{
                if(cadena.charAt(i)=='.'||cadena.charAt(i)=='$'){
                    if(cadena.charAt(i+1)=='+'||cadena.charAt(i+1)==')'||cadena.charAt(i+1)=='*'||cadena.charAt(i+1)=='-'||cadena.charAt(i+1)=='/'||cadena.charAt(i+1)=='^'||cadena.charAt(i+1)=='('){
                        valido=false;
                    }
                }
            }
            i++;
        }
        return valido;
    } 
    public static ArrayList<String> convertirPostfija(String cadena){
        ArrayList<String> postfija =new ArrayList();
        int i=0,n=cadena.length();
        PilaA <String> pilaSignos = new PilaA();
        
        
        while(i<n){
            
            i++;
        }
        return postfija;
    }
}
