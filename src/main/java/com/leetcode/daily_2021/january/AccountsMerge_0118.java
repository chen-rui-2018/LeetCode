package com.leetcode.daily_2021.january;

import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2021/1/18 10:03
 * @version： v1.0
 * @modified By:
 */
public class AccountsMerge_0118 {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        List<String> john = new ArrayList<>();
        john.add(0,"John");
        john.add("johnsmith@mail.com");
        john.add("john00@mail.com");
        List<String> john2 = new ArrayList<>();
        john2.add(0,"John");
        john2.add("johnnybravo@mail.com");
         List<String> john3 = new ArrayList<>();
        john3.add(0,"John");
        john3.add("johnsmith@mail.com");
        john3.add("john_newyork@mail.com");
          List<String> mary = new ArrayList<>();
        mary.add(0,"Mary");
        mary.add("mary@mail.com");
        list.add(john);
        list.add(john2);
        list.add(john3);
        list.add(mary);


        List<List<String>> ans =  new AccountsMerge_0118().accountsMerge(list);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.println(ans.get(i).get(j));
            }
            System.out.println();
        }
    }

    Map<String,String> emailMap;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        emailMap = new HashMap<>();
        Map<String,String> nameMap = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                if (!emailMap.containsKey(account.get(i))) {
                    emailMap.put(account.get(i), account.get(i));
                }
                nameMap.put(account.get(i),account.get(0));
                if (i > 1){
                    emailMap.put(find(account.get(i)),find(account.get(i-1)));
                }
            }
        }
        Map<String,List<String>> temporary = new HashMap<>();
        for (String email : emailMap.keySet()) {
            String root = find(email);
            if( ! temporary.containsKey(root)){
                temporary.put(root,new ArrayList<>());
            }
            temporary.get(root).add(email);
        }
        List<List<String>> ans = new ArrayList<>();
        for (String root : temporary.keySet()) {
            List<String> list = temporary.get(root);
            Collections.sort(list);
            list.add(0,nameMap.get(root));
            ans.add(list);
        }

        return ans;

    }

    private String find(String s) {
        if(s != emailMap.get(s)){
            emailMap.put(s,find(emailMap.get(s)));
        }
        return emailMap.get(s);
    }


}
