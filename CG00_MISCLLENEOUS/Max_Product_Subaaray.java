package CG00_MISCLLENEOUS;
/*
152. Maximum Product Subarray

Given an integer array nums' find a subarray that has the largest product, and return
the product.
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
integer.

question: " https://leetcode.com/problems/maximum-product-subarray/description/ "
soln:" https://www.youtube.com/watch?v=hnswaLJvr6g "
 */

public class Max_Product_Subaaray {    //O(n)
    public int maxProduct(int[] nums) {
        int maxp = Integer.MIN_VALUE;
        int n = nums.length;
        int prefix =1;
        int suffix =1;


        for(int i=0;i<n;i++){
            if(prefix ==0) prefix =1;
            if(suffix == 0) suffix =1;

            prefix *= nums[i];
            suffix *= nums[n-i-1];

            maxp = Math.max(maxp,Math.max(prefix,suffix));

        }
        return maxp;
    }
}
