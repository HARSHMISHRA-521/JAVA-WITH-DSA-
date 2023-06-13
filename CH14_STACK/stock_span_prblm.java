package CH14_STACK; // O(n)
import java.util.*;

//
// Question 4
// Stock Span Problem
//

public class stock_span_prblm {
    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1; // The first element has a span of 1 since there are no previous elements

        s.push(0); // Push the index of the first element into the stack

        // Calculate the span for each element
        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];

            // Pop elements from the stack as long as they are smaller than or equal to the current price
            while (!s.isEmpty() && currPrice >= stocks[s.peek()]) {
                s.pop();
            }

            // If the stack becomes empty, it means there is no element to the left greater than the current price
            if (s.isEmpty()) {
                span[i] = i + 1; // Set the span as the current index + 1
            } else {
                // Get the index of the highest price to the left of the current element
                int priceHigh = s.peek();
                span[i] = i - priceHigh; // Set the span as the difference between the current index and the highest price index
            }

            s.push(i); // Push the current index into the stack for future calculations
        }
    }

    public static void main(String[] args) {
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];

        stockSpan(stocks, span); // Calculate the span for each stock price

        // Print the span values
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
    }
}
