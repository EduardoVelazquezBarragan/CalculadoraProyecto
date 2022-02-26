

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
        PilaA <Character> pilaSignos = new PilaA();
        StringBuilder sb = new StringBuilder();
        char c;

        
        while(i<n){
            if(cadena.charAt(i)=='('){
                pilaSignos.push('(');
                postfija.add(sb.toString());
                sb = new StringBuilder();
            }
            else{
                if(cadena.charAt(i)=='^'){
                    pilaSignos.push('^');
                    postfija.add(sb.toString());
                    sb = new StringBuilder();
                }
                else{
                    if(cadena.charAt(i)=='*'||cadena.charAt(i)=='/'){
                        postfija.add(sb.toString());
                        sb = new StringBuilder();
                        try{
                           while(pilaSignos.peek()=='^'){
                               c=pilaSignos.pop();
                               postfija.add(String.valueOf(c));
                           } 
                           pilaSignos.push(cadena.charAt(i));
                        }catch(Exception e){
                           pilaSignos.push(cadena.charAt(i));
                        }
                    }
                    else{
                        if(cadena.charAt(i)=='+'||cadena.charAt(i)=='-'){
                            postfija.add(sb.toString());
                            sb = new StringBuilder();
                            try{
                                while(pilaSignos.peek()=='^'||pilaSignos.peek()=='*'||pilaSignos.peek()=='/'){
                                    c=pilaSignos.pop();
                                    postfija.add(String.valueOf(c));
                                }
                                pilaSignos.push(cadena.charAt(i));
                            }
                            catch(Exception e){
                                pilaSignos.push(cadena.charAt(i));
                            }
                        }
                        else{
                            if(cadena.charAt(i)==')'){
                                postfija.add(sb.toString());
                                sb = new StringBuilder();
                                while(pilaSignos.peek()!='('){
                                    c=pilaSignos.pop();
                                    postfija.add(String.valueOf(c));
                                }
                                pilaSignos.pop();
                            }
                            else{
                                sb.append(cadena.charAt(i));
                            }
                        }
                    }
                }
            }
            i++;
        }
        postfija.add(sb.toString());
        while(!pilaSignos.isEmpty()){
            c=pilaSignos.pop();
            postfija.add(String.valueOf(c));
        }
        for(int j=0;j<postfija.size();j++){
            if(postfija.get(j).equals("")){
                postfija.remove(j);
            }
        }
        return postfija;
    }
}
