import java.util.Stack;

public class PrefixToPostfix {
    public static String approach(String s){
        Stack<String> stack = new Stack<>();

        for(int i=s.length()-1; i>0; i--){
            char c = s.charAt(i);

            if(Character.isLetterOrDigit(c)){
                stack.push(String.valueOf(c));
            }else{
                String op1 = stack.pop();
                String op2 = stack.pop();

                stack.push(op1+op2+c);
            }
        }

        return stack.peek();
    }
    public static void main(String[] args) {
        String prefix = "*-A/BC-/AKL";
        
    }
}
