package CG00_MISCLLENEOUS;
/*
Bob is an electrician ,but sometimes he messes up connecting the wires. He connected some bulbs together and found interesting.
There are bulbs, numbered from 1 ton, arranged in a row from left to right Initially, all the bulbs are turned off
At moment (for from 0 to 1), Bob turns on the ght bulb, A bulb changes colour to blue only if it is on and all the
Previous bulbs (to the left) are turned on too.
He wants you to find out the number of moments in which all turned-on bulbs are blue. You have to return thE same

"https://www.youtube.com/watch?v=YOgFN-HAH-w"
 */
import java.util.*;

public class BULB_SWITCHER_3 {
        public static int bulbs(int n, int[] arr) {
            int res = 0;
            int maxOn = 0;

            for (int i = 0; i < n; i++) {
                maxOn = Math.max(maxOn, arr[i]);

                if (i + 1 == maxOn) {
                    res++;
                }
            }

            return res;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int result = bulbs(n, arr);
            System.out.println(result);

            scanner.close();
        }
    }
//5
//2
//1
//4
//3
//5
//3