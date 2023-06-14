package CH14_STACK; //O(n)
import java.util.*;

//Valid Parentheses
//        Given a string s containing just the characters '(', ')', '{', '}, '[' and ']', determine if the
//        input string is valid.
//        An input string is valid If
//        1. Open brackets must be closed by the same type of brackets.
//        2. Open brackets must be closed in the correct order.
//        3. Every close bracket has a corresponding open bracket of the same type.
// eg:    "([{}])"  is valid
//        "(({])}"  is invalid

public class Valid_PARANTHESES {
    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
             //opening brackets
            if(ch == '(' || ch =='{' || ch=='['){
                s.push(ch);
            }
            else{
                //closing brackets
                if(s.isEmpty()){
                    return false; // for conditions : "))))}]"
                }
                if((s.peek()=='(' && ch == ')') ||(s.peek()=='{' && ch == '}') ||(s.peek()=='[' && ch == ']')){
                    s.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "({})[]"; //true
        System.out.println(isValid(str));
    }
}
