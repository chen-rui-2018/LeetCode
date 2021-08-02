package tencent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author： chenr
 * @date： Created on 2021/2/20 11:35
 * @version： v1.0
 * @modified By:
 */
public class ContainsDuplicate {
    public static void main(String[] args) {

    }
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {

          set.add(nums[i]);
        }
        return set.size()!= nums.length;
    }
    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }
}
