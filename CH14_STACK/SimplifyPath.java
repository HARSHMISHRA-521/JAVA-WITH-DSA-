package CH14_STACK;
//Time Complexity : o(n)
//        Space Complexity: 0(1)

//Question 2 :
//        Simplify Path
//        We hava an absolute path for a file (Unix-style), simplify it. Note that absolute path always begin
//        with '/' ( root directory a dot in path represent current directory and double dot represents
//        parent directory.
//        Sample Input 1 : /harshmishra/
//        Sample Output I : /harshmishra
//        Sample Input I : /a/..
//        Sample Output : /
import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        // Split the path by '/' to separate directory names
        String[] dirs = path.split("/");

        // Create a stack to store the simplified path
        Stack<String> stack = new Stack<>();

        // Iterate through the directory names
        for (int i = 0; i < dirs.length; i++) {
            String dir = dirs[i];

            // Ignore empty strings and current directory symbol (".")
            if (dir.isEmpty() || dir.equals(".")) {
                continue;
            }
            // If the directory is the parent directory symbol (".."),
            // pop the top directory from the stack (if it's not empty)
            else if (dir.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            }
            // Otherwise, push the directory onto the stack
            else {
                stack.push(dir);
            }
        }

        // Build the simplified path using the directories in the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.insert(0, "/" + stack.pop());
        }

        // If the stack is empty, return the root directory "/"
        // Otherwise, return the simplified path
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        String path1 = "/harshMishra/";
        System.out.println("Input: " + path1);
        System.out.println("Output: " + simplifyPath(path1));

        String path2 = "/a/b/..";                             //Input: /harshMishra/
        System.out.println("Input: " + path2);                 //Output: /harshMishra
        System.out.println("Output: " + simplifyPath(path2));   //Input: /a/b/..
    }                                                            //Output: /a
}

//reason of time complexity
//The time complexity of the provided solution for simplifying the absolute file path using a stack is O(N),
//        where N represents the length of the input path.
//
//        The time complexity is determined by the number of directories in the input path. In the worst case,
//        we need to iterate through all the directories in the path once.
//
//        The splitting of the path using path.split("/") takes O(N) time as it splits the string into an array
//        of directory names based on the delimiter '/'.
//
//        After splitting, the for loop iterates through each directory once, performing constant-time operations
//        such as comparisons and stack operations.
//
//        The while loop that builds the simplified path using the directories in the stack also takes linear
//        time, as it iterates over the stack elements once to append them to the StringBuilder.
//
//        Overall, the time complexity is dominated by the splitting operation, making the solution O(N).
//



