package tencent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2021/1/26 10:57
 * @version： v1.0
 * @modified By:
 */
public class MajorityElement {

    public static void main(String[] args) {
        int [] nums = {2,2,1,1,1,2,2};
       int ans =  new MajorityElement().majorityElement(nums);
        System.out.println(ans);
    }

    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > (nums.length / 2)) {
                return num;
            }
        }
        return -1;
    }
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
