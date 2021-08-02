package com.leetcode.editor.title_daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2020/12/10 9:20
 * @version： v1.0
 * @modified By:
 */
public class LemonadeChange_1210 {
    public static void main(String[] args) {
        int [] bills = {5,5,5,10,20,10};
       boolean result =  new LemonadeChange_1210().lemonadeChange(bills);
        System.out.println(result);
        System.out.println(new LemonadeChange_1210().lemonadeChange2(bills));
    }
    public boolean lemonadeChange(int[] bills) {
        Map<Integer,Integer>  map = new HashMap<>(3);
        for (int i = 0; i < bills.length; i++) {
            int price = bills[i];
            if(price == 5){
                map.put(bills[i],map.getOrDefault(bills[i],0) + 1);
            }else if(price == 10){
                int countFive = map.getOrDefault(5,0);
                if(countFive == 0){
                    return false;
                }else {
                    map.put(bills[i],map.getOrDefault(bills[i],0) + 1);
                    map.put(5,map.get(5) - 1);
                }
            }else{
                int countFive = map.getOrDefault(5,0);
                int countTen = map.getOrDefault(10,0);
                   if(countTen > 0 && countFive > 0){
                       map.put(10,countTen-1);
                       map.put(5,countFive - 1);
                   }else if(countFive >= 3){
                       map.put(5,countFive-3);
                   }else {
                       return false;
                   }
                map.put(bills[i],map.getOrDefault(bills[i],0) + 1);

            }
        }
        return true;
    }
    public boolean lemonadeChange2(int[] bills) {
        if (bills == null || bills.length == 0) {
            return false;
        }
        int five = 5;
        int ten = 10;
        int countFive = 0;
        int countTen = 0;
        for (int i = 0; i < bills.length; i++) {
            if(bills[i] == five){
                countFive++;
            }else if(bills[i] == ten){
                if(countFive == 0){
                    return false;
                }
                countFive--;
                countTen++;
            }else{
                if(countFive > 0 && countTen > 0){
                    countFive--;
                    countTen--;
                }else if(countFive >= 3 ){
                    countFive -= 3;
                }else{
                    return false;
                }
            }

        }
        return true;
    }
}
