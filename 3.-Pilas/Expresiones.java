public class Expresiones {

    public static int evaluar(String expr){

        Stack<Integer> pila = new Stack<>();

        String[] tokens = expr.split(" ");

        for(String token : tokens){

            if(esOperador(token)){

                int b = pila.pop();
                int a = pila.pop();

                int resultado = operar(a,b,token);

                pila.push(resultado);

            }else{
                pila.push(Integer.parseInt(token));
            }
        }

        return pila.pop();
    }

    private static boolean esOperador(String t){
        return t.equals("+") || t.equals("-") || 
               t.equals("*") || t.equals("/");
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


    public static void main(String[] args) {
        String exprPost = "3 4 + 2 *";

        int resultado = Expresiones.evaluar(exprPost);

        System.out.println(exprPost + " = " + resultado);


    }
} 

