package com.leetcode.editor.title_daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2020/9/9 11:36
 * @version： v1.0
 * @modified By:
 */
public class CombinationSum_20200909 {
    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 10;
        List<List<Integer>>  list =  new  CombinationSum_20200909().combinationSum(candidates,target);
        System.out.println(list.size());
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates,target,ans,combine,0);
        return  ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int index) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0){
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        dfs(candidates,target,ans,combine,index+1);
        if (target - candidates[index] >= 0){
            combine.add(candidates[index]);
            dfs(candidates,target-candidates[index],ans,combine,index);
            combine.remove(combine.size()-1);
        }
    }

}
