

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
        if(n==0||cadena.contains(")(")){
            valido=false;
        }
        else{
            if(cadena.charAt(0)=='-'||cadena.charAt(0)=='+'||cadena.charAt(0)=='/'||cadena.charAt(0)=='*'||cadena.charAt(0)=='^'){
                valido=false;
            }
            else{
                if(cadena.charAt(n-1)=='-'||cadena.charAt(n-1)=='+'||cadena.charAt(n-1)=='/'||cadena.charAt(n-1)=='*'||cadena.charAt(n-1)=='^'||cadena.charAt(n-1)=='.'||cadena.charAt(n-1)=='$'){
                    valido=false;
                }
            }
        }
        while(i<n&&valido){
            if(cadena.charAt(i)=='+'||cadena.charAt(i)=='*'||cadena.charAt(i)=='-'||cadena.charAt(i)=='/'||cadena.charAt(i)=='^'){
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
                else{
                    if(i>=1&&cadena.charAt(i)=='('){
                        if(cadena.charAt(i+1)=='+'||cadena.charAt(i+1)==')'||cadena.charAt(i+1)=='*'||cadena.charAt(i+1)=='-'||cadena.charAt(i+1)=='/'||cadena.charAt(i+1)=='^'||cadena.charAt(i-1)=='0'||cadena.charAt(i-1)=='1'||cadena.charAt(i-1)=='2'||cadena.charAt(i-1)=='3'||cadena.charAt(i-1)=='4'||cadena.charAt(i-1)=='5'||cadena.charAt(i-1)=='6'||cadena.charAt(i-1)=='7'||cadena.charAt(i-1)=='8'||cadena.charAt(i-1)=='9'){
                            valido=false;
                        }
                    }
                    else{
                        if(i<n-1&&cadena.charAt(i)==')'){
                            if(cadena.charAt(i+1)=='0'||cadena.charAt(i+1)=='1'||cadena.charAt(i+1)=='2'||cadena.charAt(i+1)=='3'||cadena.charAt(i+1)=='4'||cadena.charAt(i+1)=='5'||cadena.charAt(i+1)=='6'||cadena.charAt(i+1)=='7'||cadena.charAt(i+1)=='8'||cadena.charAt(i+1)=='9'||cadena.charAt(i+1)=='$'||cadena.charAt(i+1)=='.'){
                                valido=false;
                            }
                        }
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
                    if(cadena.charAt(i)=='/'||cadena.charAt(i)=='*'){
                        postfija.add(sb.toString());
                        sb = new StringBuilder();
                        try{
                           while(pilaSignos.peek()=='^'||pilaSignos.peek()=='/'){
                               c=pilaSignos.pop();
                               postfija.add(String.valueOf(c));
                           } 
                           pilaSignos.push(cadena.charAt(i));
                        }catch(Exception e){
                           pilaSignos.push(cadena.charAt(i));
                        }
                    }
                    else{
                        if(cadena.charAt(i)=='-'||cadena.charAt(i)=='+'){
                            postfija.add(sb.toString());
                            sb = new StringBuilder();
                            try{
                                while(pilaSignos.peek()=='^'||pilaSignos.peek()=='*'||pilaSignos.peek()=='/'||pilaSignos.peek()=='-'){
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
                            /*if(cadena.charAt(i)=='+'){
                                postfija.add(sb.toString());
                                sb = new StringBuilder();
                                try{
                                    while(pilaSignos.peek()=='^'||pilaSignos.peek()=='*'||pilaSignos.peek()=='/'||pilaSignos.peek()=='-'){
                                        c=pilaSignos.pop();
                                        postfija.add(String.valueOf(c));
                                    }
                                    pilaSignos.push(cadena.charAt(i));
                                }catch(Exception e){
                                    pilaSignos.push(cadena.charAt(i));
                                }
                            }
                            else{*/
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
                            //}
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
                j--;
            }
        }
        return postfija;
    }
    public static double evalua(ArrayList<String> postfija){
        PilaA<Double> pila = new PilaA();
        double x1,x2, temp;
        String valor;
        
        for(int i=0; i<postfija.size();i++){
            if(postfija.get(i).equals("+")){
                x1=pila.pop();
                x2=pila.pop();
                temp=x1+x2;
                pila.push(temp);
            }
            else{
                 if(postfija.get(i).equals("*")){
                    x1=pila.pop();
                    x2=pila.pop();
                    temp=x1*x2;
                    pila.push(temp);
                }
                else{
                     if(postfija.get(i).equals("/")){
                        x1=pila.pop();
                        x2=pila.pop();
                        temp=x2/x1;
                        pila.push(temp);
                    }
                     else{
                         if(postfija.get(i).equals("-")){
                             x1=pila.pop();
                             x2=pila.pop();
                             temp=x2-x1;
                             pila.push(temp);
                         }
                         else{
                           if(postfija.get(i).equals("^")){
                             x1=pila.pop();
                             x2=pila.pop();
                             temp=Math.pow(x2, x1);
                             pila.push(temp);
                           }
                           else{
                              valor=postfija.get(i);
                              valor=valor.replace('$', '-');
                              temp=Double.parseDouble(valor);
                              pila.push(temp);
                           }
                        }
                    }
                }
            }
        }
        temp=pila.pop();
        return temp;
    }
}
