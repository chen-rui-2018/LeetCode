package tencent;

/**
 * @author： chenr
 * @date： Created on 2021/2/20 14:14
 * @version： v1.0
 * @modified By:
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(new MaxSubArray().maxSubArray(arr));
    }
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(nums[i],pre + nums[i]);
            maxCount = Math.max(maxCount,pre);
        }
        return maxCount;
    }
}
