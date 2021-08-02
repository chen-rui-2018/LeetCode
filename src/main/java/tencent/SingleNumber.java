package tencent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2021/1/20 11:13
 * @version： v1.0
 * @modified By:
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println( new SingleNumber().singleNumber(nums));
    }
    public int singleNumber1(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        int res = 0;
        for (Integer integer : map.keySet()) {
            if(map.get(integer) == 1){
                res =  integer;
            }
        }
        return res;
    }
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
