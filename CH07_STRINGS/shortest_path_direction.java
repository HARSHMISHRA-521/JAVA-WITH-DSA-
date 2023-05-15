public class shortest_path_direction {
    public static float isshortestpath(String path){
        int x =0,y=0;
        for(int i =0;i< path.length();i++){
            char dir = path.charAt(i);

            //north
            if(dir =='N'){
                y++;
            }
            //south
            else if(dir=='S'){
                y--;
            }
            //east
            else if(dir =='E'){
                x++;
            }
            //west
            else{
                x--;
            }
        }
        int X2 =x*x;
        int Y2 =y*y;
        return (float)Math.sqrt(X2+Y2); // as D = root under (x2-x1)^2 + (y2-y1)^2
                                        // but here ,x1 and y1 are 0 as it is origin
    }

    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(isshortestpath(path));
    }
}
