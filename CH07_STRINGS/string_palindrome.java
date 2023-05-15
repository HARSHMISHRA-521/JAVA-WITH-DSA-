public class string_palindrome {
    public static boolean isPalindrome(String str){
        int n = str.length();
        for(int i=0;i<n;i++){
            if(str.charAt(i) != str.charAt(n-1-i)){
                //not  a palindrome
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "madam";
        System.out.println(isPalindrome(str));
    }
}
