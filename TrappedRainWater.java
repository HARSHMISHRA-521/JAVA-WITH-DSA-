public class TrappedRainWater {

    public static int volmofwater(int height[]){ //O(n)
        int n = height.length;
//        claculate max left boundary -array
        int maxleft[]=new int[n];
        maxleft[0]=height[0];
        for(int i=1;i<n;i++){
            maxleft[i]=Math.max(height[i],maxleft[i-1]);
        }

//        calculate right max boundary -array
        int maxright[]=new int[n];
        maxright[n-1]=height[n-1];
        for(int i=n-2   ;i>=0;i--){
            maxright[i]=Math.max(height[i],maxright[i+1]);
        }

        int trappedwater=0;
        //loop
        for(int i=0;i<n;i++){
//        calculate waterlevel = min(maxright bound,maxleft bound);
            int waterlevel=Math.min(maxright[i],maxleft[i]);

//            claculate trapped water = waterlevel - height[i]
            trappedwater+= (waterlevel-height[i]);//note that width of boundary is 1
//            the real vol is (waterlevel-height[i]) * width
        }
        return trappedwater;
    }

    public static void main(String[] args) {
        int height[]={4,2,0,6,3,2,5};
        System.out.println("The volume of trapped water is :");
        System.out.println(volmofwater(height));
    }
}
