package CH9_RECURSION;
// remove the duplicates in a string for(a-z)characters only

public class remove_duplicates_string {
    public static void remDup(String str , int idx, StringBuilder newStr, boolean map[]){
        //base case
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }
        // work
        char currChar = str.charAt(idx);
        if( map[currChar-'a'] == true){
            //duplicate
            remDup(str,idx+1,newStr,map);
        }
        else{
            map[currChar-'a'] = true;
            remDup(str,idx+1,newStr.append(currChar),map);
        }
    }

    public static void main(String[] args) {
//        String str = "apnacollege";
        String str = "harshmishra";
        remDup(str,0,new StringBuilder(""),new boolean[26]);
    }
}
