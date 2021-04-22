package hackerrank.medium;

import java.util.Arrays;

public class MakeArrayComplementary {
    public int minMoves(int[] nums, int limit) {
        int len = nums.length;
        int[] cnt = new int[limit*2+2];
        for(int i=0; i<len/2; i++){
            int a = Math.min(nums[i], nums[len-1-i]);
            int b = Math.max(nums[i], nums[len-1-i]);
            cnt[2]+=2;
            cnt[a+1]--;
            cnt[a+b]--;
            cnt[a+b+1]++;
            cnt[b+limit+1]++;
            System.out.println(Arrays.toString(cnt));
        }
        int min = len;
        int prefix = 0;
        for(int i=2; i<2*limit+2; i++){
            prefix+=cnt[i];
            min = Math.min(min, prefix);
        }
        return min;
    }

    public static void main(String args[]) {
        MakeArrayComplementary s = new MakeArrayComplementary();
        System.out.println(s.minMoves(new int[]{1,2,4,3}, 4));
        System.out.println(s.minMoves(new int[]{1,2,2,1}, 2));
        System.out.println(s.minMoves(new int[]{1,2,1,2}, 2));
    }
}
