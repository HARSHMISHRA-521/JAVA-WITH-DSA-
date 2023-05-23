package CH12_ArrayList;
import java.util.*;

public class multi_dimensional_ArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> List1 = new ArrayList<>();
        ArrayList<Integer> List2 = new ArrayList<>();
        ArrayList<Integer> List3 = new ArrayList<>();

        for(int i=1;i<=5;i++){
            List1.add(i*1);//1 2 3 4 5
            List2.add(i*2);//2 4 6 8 10
            List3.add(i*3);//3 6 9 12 15
        }

        mainList.add(List1);
        mainList.add(List2);
        mainList.add(List3);
        System.out.println("MainList is: "+mainList);

        //nested loop
        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer> currList = mainList.get(i);
            System.out.printf("Current List%d is: ",i);
            for(int j=0;j<currList.size();j++){
                System.out.print(currList.get(j)+" ");
            }
                System.out.println();
        }
    }
}
