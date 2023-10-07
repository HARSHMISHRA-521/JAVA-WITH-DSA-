package CH20_GRAPHS;
//kickdrum
import java.util.HashMap;
import java.util.*;
public class practise {
    public static void sol(ArrayList<Integer> arr,int n,int k) {
        HashMap<Integer,Integer> f = new HashMap<>();
        HashMap<Integer,Integer> d = new HashMap<>();
        int curr =0;
        int ans =0;
        int maxs =-1;

        for(int i=0;i<n;i++){
            curr += arr.get(i);
            if(curr == k){
                ans+=1;
                maxs =Math.max(maxs,i+1);
            }

            if(f.containsKey(curr -k)){
                ans += f.get(curr-k);
                maxs =Math.max(maxs, i - d.get(curr-k));
            }

            f.put(curr,f.getOrDefault(curr,0)+1);

            if(!d.containsKey(curr)){
                d.put(curr,i);
            }
        }
        System.out.println(ans);
        System.out.println(n -maxs);

    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i =0;i< n;i++){
            arr.add(sc.nextInt());
        }
        sol(arr,n,k);
    }
}
