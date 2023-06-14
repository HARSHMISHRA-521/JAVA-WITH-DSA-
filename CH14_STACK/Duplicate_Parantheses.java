package CH14_STACK; // O(n)
import java.util.*;

//Question:
//        Given a balanced expression, determine whether it contains duplicate parentheses or not.
//        Duplicate parentheses refer to the situation where the same subexpression is surrounded
//        by multiple pairs of parentheses.
//
//        Write a function has_duplicate_parentheses(expression) that takes a string expression as input
//        and returns True if it contains duplicate parentheses, and False otherwise.
//
//        expression1 = "((a + (c * d)))"
//        expression2 = "((a + ((c * d))))"
//        expression3 = "(a + ((c * d)))"
//
//        print(has_duplicate_parentheses(expression1))  # True
//        print(has_duplicate_parentheses(expression2))  # True
//        print(has_duplicate_parentheses(expression3))  # False


public class Duplicate_Parantheses {
    public static boolean isDuplicate(String str){
        Stack<Character> s =new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch= str.charAt(i);
            //closing parenthesis
            if(ch ==')'){
                int count =0;
                while(s.pop() !='('){
                    count++;
                }
                if(count <1){
                    return true; // duplicate
                }
            }
            //opening
            else{
                s.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //valid string
        String str = "((a+b))"; //true;
        String str1 = "((a+b)+c)"; //false;
        System.out.println(isDuplicate(str));
        System.out.println(isDuplicate(str1));
    }
}
