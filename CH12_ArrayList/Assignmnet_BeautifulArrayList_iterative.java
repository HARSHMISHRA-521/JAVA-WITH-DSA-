package CH12_ArrayList;

import java.util.ArrayList;

//Certainly! Let's go through the approach step by step:
//
//        The goal is to create a "beautiful" ArrayList of size n.
//
//        The approach used in the solution is to separate odd and even
//        numbers because they don't violate the rules with each other.
//
//        We start by adding the odd numbers to the beautifulArrayList.
//        The loop for (int i = 1; i <= n + 1; i += 2) iterates from 1 to n + 1 with a step size of 2,
//        ensuring that we only consider odd numbers. We add each odd number i to the beautifulArrayList.
//
//        Next, we add the even numbers to the beautifulArrayList. The loop for (int i = 2; i <= n; i += 2)
//            iterates from 2 to n with a step size of 2, ensuring that we only consider even numbers.
//        We add each even number i to the beautifulArrayList.
//
//        By adding the odd numbers first and then the even numbers, we ensure that the resulting
//        beautifulArrayList satisfies the conditions mentioned in the question.
//
//        The resulting beautifulArrayList is returned as the output.
//
//        To illustrate this approach with an example:
//        If n = 4, the process would be as follows:
//
//        Adding odd numbers: [1, 3, 5]
//        Adding even numbers: [1, 3, 5, 2, 4]
//        The resulting beautifulArrayList would be [1, 3, 5, 2, 4].
//        This approach ensures that the resulting beautifulArrayList is valid and meets
//        the conditions mentioned in the question.


    class Assignment_BeautifulArrayList_iterative {
    public static ArrayList<Integer> generateBeautifulArray(int n) {
        ArrayList<Integer> beautifulArrayList = new ArrayList<>();

        // Adding odd numbers to the beautifulArrayList
        for (int i = 1; i <= n + 1; i += 2) {
            beautifulArrayList.add(i);
        }

        // Adding even numbers to the beautifulArrayList
        for (int i = 2; i <= n; i += 2) {
            beautifulArrayList.add(i);
        }

        return beautifulArrayList;
    }

    public static void main(String[] args) {
        int n = 4;
        ArrayList<Integer> result = generateBeautifulArray(n);
        System.out.println("Beautiful ArrayList: " + result);
    }
}
