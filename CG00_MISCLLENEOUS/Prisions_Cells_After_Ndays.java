package CG00_MISCLLENEOUS;
import java.util.*;
/*
957. Prison Cells After N Days

There are 8 prison cells in a row and each cell is either occupied or vacant.
Each day, whether the cell is occupied or vacant changes according to the following rules:
• If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
• Otherwise, it becomes vacant.
Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.
1 if the ith cell is occupied and cells [i]
if the ith
You are given an integer array cells where cells [i]
cell is vacant, and you are given an integer n .
Return the state of the prison after n days (i.e., n such changes described above)

constrains:
cells . length ==  8
cells [i] is either 0 or 1'
1<= n <= 10^9
 */

public class Prisions_Cells_After_Ndays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(cells==null || cells.length==0 || N<=0) return cells;
        boolean hasCycle = false;
        int cycle = 0;
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<N;i++){
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if(!set.contains(key)){ //store cell state
                set.add(key);
                cycle++;
            }
            else{ //hit a cycle
                hasCycle = true;
                break;
            }
            cells = next;
        }
        if(hasCycle){
            N%=cycle;
            for(int i=0;i<N;i++){
                cells = nextDay(cells);
            }
        }
        return cells;
    }

    private int[] nextDay(int[] cells){
        int[] tmp = new int[cells.length];
        for(int i=1;i<cells.length-1;i++){
            tmp[i]=cells[i-1]==cells[i+1]?1:0;
        }
        return tmp;
    }
}
