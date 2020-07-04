package Stack;

import java.util.Stack;

//https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
public class ParenthesesChecker {

    public static void main(String[] args) {
        System.out.println(isParenthesesBalanced("[]{"));
        System.out.println(isParenthesesBalanced("[]"));
    }
    public static boolean isParenthesesBalanced(String s)
    {
        Stack<Character> st = new Stack<>();
        char c;
        for (int i = 0 ; i < s.length(); i++){
            c = s.charAt(i);
            if (c == '[' || c == '{' || c == '('){
                st.push(c);
            } else{
                if (st.pop() != getMatchingParentheses(c))
                    return false;
            }
        }
        return st.isEmpty();
    }

    private static char getMatchingParentheses(char c){
        switch (c){
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
        }
        return '[';
    }
}
