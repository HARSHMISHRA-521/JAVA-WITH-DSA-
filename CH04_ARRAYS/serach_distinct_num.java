//        Given an integer array nums,
//        return true if any value appears at least twice in the array,
//        and return false if every element is distinct.
//Constraints:
// •1 <= nums .  lengtth <=10^5
// 10^5 <= nums [ i ] <= 10^9

public class serach_distinct_num { // O(n^2)
    public static boolean search(int arr[]){
        int n = arr.length;
        while (arr.length >= 1) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] == arr[j]) {
                        return true;
                    }
                }
            }
        }
        System.out.println("Invalid size of array!");
        return false;
    }

    public static void main(String[] args) {
//        int arr[] = {5, 6, 7, 8, 9, 1, 0, 11, 12, 12, 10};
        int arr[] = {};
        if (arr.length < 1) {
            System.out.println("Invalid size of array !");
        } else {
            boolean result = search(arr);
            if (result == true) {
                System.out.println(result);
                System.out.println("Any one of the element of array is more than one time");
            } else {
                System.out.println(result);
                System.out.println("All elemnets in the array are distinct");
            }
        }
    }

    }

