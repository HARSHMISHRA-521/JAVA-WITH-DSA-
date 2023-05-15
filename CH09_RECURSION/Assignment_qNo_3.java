//Question 3 : Write a program to find Length of a string using Recursion.

package CH09_RECURSION;

public class Assignment_qNo_3 {
    public static int length(String str){
        if(str.length()==0){
            return 0;
        }

        return length(str.substring(1))+1;
    }

    public static void main(String[] args) {
        System.out.println("length of  string is "+length("harsh mishra"));
    }
}
