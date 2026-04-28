public class Evaluacion {
    public static int evaluacionPostfijo(String expr){
        Stack<Integer> pila = new Stack<>();
        
        String[] tokens = expr.split(" ");
        
        for(String token :  tokens){
            if(esOperador(token)){
                int b = pila.pop();
                int a = pila.pop();

                int resultado = operar(a,b, token);
                pila.push(resultado);
            }else{
                pila.push(Integer.parseInt(token));
            }

        } 
        return pila.pop();
    }

    private static boolean esOperador(String op){
        return op.equals("+") ||
                op.equals("-") ||
                op.equals("*") || 
                op.equals("/");
    }


    private static int operar(int a, int b, String op){
        switch(op){
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
        }
        return 0;

    }


    public static int evaluarPrefijo(String expr){
        Stack<Integer> pila = new Stack<>();
        String[] tokens = expr.split(" ");

        for(int i = tokens.length -1; i >= 0; i--){
            String token = tokens[i];

            if(esOperador(token)){
                int a = pila.pop();
                int b = pila.pop();

                int resultado = operar(a,b, token);

                pila.push(resultado);
            }else{
                pila.push(Integer.parseInt(token));
            }
        }
        return pila.pop();

    }

    public static int evaluarInfijo(String expr){
        Stack<Integer> valores = new Stack<>();
        Stack<Character> operadores = new Stack<>();


        for(int i = 0; i < expr.length(); i ++){
            char c = expr.charAt(i);
            if(c == ' ')continue;

            if(Character.isDigit(c)){
                int num = 0;
                while(i < expr.length() && Character.isDigit(expr.charAt(i))){
                    num = num * 10 + (expr.charAt(i) - '0');
                    i++;
                }
                valores.push(num);
            }

            else if(c == '('){
                operadores.push(c);
            }
            else if(c == ')'){
                while(operadores.top() != '('){
                    aplicarOperacion(valores, operadores );
                }
                operadores.pop();
            }

            else if (esOperador(c+"")){
                while(!operadores.isEmpty()&& precedencia(operadores.top()) >= precedencia(c)){
                    aplicarOperacion(valores, operadores);
                }
                operadores.push(c);

            }
        }

        while(!operadores.isEmpty()){
            aplicarOperacion(valores, operadores);
        }
        return valores.pop();
    
    }
    


    private static int precedencia(char op){
        if(op == '+' || op == '-') return 1;
        if(op == '*' || op == '/') return 2;

        return 0;
    }

    private static void aplicarOperacion(Stack<Integer> valores, Stack<Character> operadores){
        int b = valores.pop();
        int a = valores.pop();
        char op = operadores.pop();

        int resultado = 0;

        switch (op) {
            case '+': resultado = a + b; break;
            case '-': resultado = a - b; break;
            case '*': resultado = a * b; break;
            case '/': resultado = a / b; break;
        }

        valores.push(resultado);
    }





    public static void main(String[] args) {
        System.out.println("Postfijo");
        String post = "3 4 - 2 +";
        System.out.println(post + " =" + evaluacionPostfijo(post));
    
        System.out.println("Prefijo");
        String pre = "* 3 + 4 2";
        System.out.println(pre + " =" + evaluarPrefijo(pre));

        System.out.println("Infijo");
        String infijo = "2 + 3 * 4";
        System.out.println(infijo + " = " + evaluarInfijo(infijo));
    }


}