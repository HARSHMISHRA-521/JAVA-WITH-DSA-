//BINARY STRING PROBLEM
//print all binary strings of size N without consecutive ones

package CH09_RECURSION;

public class binary_string_cons1 {
    public static void printBinStr(int size,int lastPlace,String str){
        //BASE CASE
            if(size == 0){
                System.out.println(str);
                return;
            }

        //work
        printBinStr(size - 1,0,str+"0");
            if(lastPlace == 0){
                printBinStr(size - 1,1,str+"1");
            }
    }

    public static void main(String[] args) {
        printBinStr(3,0,"");
    }
}
 // Explanation of stack analysis for this input " printBinStr(3,0,"");"
//        Here’s the stack analysis for each of the outputs:
//
//        000: As explained in my previous message, the first call to printBinStr(3,0,"") results in three more
//                recursive calls, each adding a “0” to the binary string. This results in the output "000".
//
//        001: After printing "000", the function returns to the third call to printBinStr, where size = 1,
//                lastPlace = 0, and str = "00". Since lastPlace = 0, the function makes another recursive call with
//                arguments size - 1 = 0, lastPlace = 1, and str + "1" = "001". This call represents adding a “1” to
//                the binary string. Since size is now equal to 0, the function enters the base case and prints the
//                binary string "001".
//
//        010: After printing "001", the function returns to the second call to printBinStr, where size = 2,
//                lastPlace = 0, and str = "0". Since lastPlace = 0, the function makes another recursive call with
//                arguments size - 1 = 1, lastPlace = 1, and str + "1" = "01". This call represents adding a “1” to
//                the binary string. The next recursive call has arguments size - 1 = 0, lastPlace = 0, and
//                str + "0" = "010". This call represents adding a “0” to the binary string. Since size is now equal to 0,
//                the function enters the base case and prints the binary string "010".
//
//        100: After printing "010", the function returns to the first call to printBinStr(3,0,""). Since
//                lastPlace = 0, it makes another recursive call with arguments size - 1 = 2, lastPlace = 1, and
//                str + "1" = "1". This call represents adding a “1” to the binary string. The next two recursive
//                calls add two "0"s to the binary string, resulting in the output "100".
//
//        101: After printing "100", the function returns to where it left off with arguments size = 2,
//                lastPlace = 1, and str = "1". Since it cannot add another “1”, it makes a recursive call
//                with arguments size - 1 = 1, lastPlace = 0, and str + "0" = "10". This call represents
//                adding a “0” to the binary string. The next recursive call adds a final “1”, resulting
//                 in the output "101".