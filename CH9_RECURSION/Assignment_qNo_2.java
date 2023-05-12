//Question 2 :
//        You are given a number (eg - 201 9), convert it into a String of english like
//        "two zero one nine". Use a recursive function to solve this problem.

//        NOTE - The digits of the number will only be in the range 0-9 and the last digit of a number
//        can't be 0.

//        Sample Input : 1947
//        Sample Output : "one nine four seven

package CH9_RECURSION;

public class Assignment_qNo_2 {
    public static void intToStr(int num){
        if(num==0){
            return;
        }
        String arr[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
        int mod = num%10;

        intToStr(num/10);
        System.out.print(arr[mod]+" ");
    }

    public static void main(String[] args) {
        intToStr(1947);
    }
}
