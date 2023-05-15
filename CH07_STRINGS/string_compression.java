public class string_compression {
    public static String compression(String str){  //O(n)

        StringBuilder newstr = new StringBuilder("");
        for(int i=0;i<str.length();i++){
            Integer count =1; //Integer is used because count will be converted into string
            //with the help of"toString" and it converts only objects

            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            newstr.append(str.charAt(i));
            if(count>1){
                newstr.append(count.toString());
            }
        }
        return newstr.toString();
    }

    public static void main(String[] args) {
//        String str = "aaabbccccdd";
        String str = "abcd";
        System.out.println(compression(str));
    }
}
