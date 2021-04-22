package hackerrank;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static int[] zerosToEnd(int[] nums) {
            int countIdx = 0;
            for(int i=0;i<nums.length;i++) {
                if(nums[i] !=0){
                    nums[countIdx++] = nums[i];
                }
            }
            while(countIdx<nums.length)
                nums[countIdx++]=0;
            return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,6,0,2,0,0,5,6};
        System.out.println(Arrays.toString(zerosToEnd(arr)));
    }

}
