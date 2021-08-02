package tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2021/2/23 11:25
 * @version： v1.0
 * @modified By:
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
         new Subsets().subsets(nums);
    }
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return ans;

    }

    private void dfs(int curr, int[] nums) {
        if (curr == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[curr]);
        dfs(curr + 1,nums);
        t.remove(t.size() - 1);
        dfs(curr + 1, nums);
    }
}
