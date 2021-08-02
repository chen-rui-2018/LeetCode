package com.leetcode.daily_2021.july;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author： chenr
 * @date： Created on 2021/7/6 9:13
 * @version： v1.0
 * @modified By:
 */
public class DisplayTable_0706 {
    public static void main(String[] args) {
        String [][] orders = {
                {"David","3","Ceviche"},
                {"Corina","10","Beef Burrito"},
                {"David","3","Fried Chicken"},
                {"Carla","5","Water"},
                {"Carla","5","Ceviche"},
                {"Rous","3","Ceviche"}};
        
        List<List<String>> orderList = new ArrayList<>();
        orderList.add(Arrays.asList(orders[0]));
        orderList.add(Arrays.asList(orders[1]));
        orderList.add(Arrays.asList(orders[2]));
        orderList.add(Arrays.asList(orders[3]));
        orderList.add(Arrays.asList(orders[4]));
        orderList.add(Arrays.asList(orders[5]));

        List<List<String>> resultList = new DisplayTable_0706().displayTable(orderList);



    }
    public List<List<String>> displayTable1(List<List<String>> orders) {
        TreeMap<String,Map<String,Integer>> map = new TreeMap<>();
        TreeSet<String> foodSet = new TreeSet<>();
        List<List<String>> result = new ArrayList<>();
        List<List<String>> resultEnd = new ArrayList<>();
        List<String> listHead = new ArrayList<>();
        for (List<String> order : orders) {
            String tableNumber = order.get(1);
            String food = order.get(2);
            foodSet.add(food);
            Map<String, Integer> foodItem = map.get(tableNumber);
            if (foodItem == null) {
                foodItem = new TreeMap<>();
                map.put(tableNumber,foodItem);
            }
            foodItem.put(food,foodItem.getOrDefault(food,0)+1);

        }
        listHead.add("Table");
        for (String food : foodSet) {
            listHead.add(food);
            for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                Map<String, Integer> temp= entry.getValue();
                if(temp.containsKey(food)) {
                    continue;
                }else {
                    temp.put(food,0);
                }
            }
        }
        resultEnd.add(listHead);

        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            List<String> list = new ArrayList<>();
            list.add(entry.getKey());
            Map<String, Integer> temp= entry.getValue();
            for (Map.Entry<String, Integer> tempEntry : temp.entrySet()) {
                list.add(String.valueOf(tempEntry.getValue()));
            }
            result.add(list);
        }
        result.sort(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
               return Integer.valueOf(o1.get(0)) - Integer.valueOf(o2.get(0));
            }
        });
        resultEnd.addAll(result);
        return resultEnd;
    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> nameSet = new HashSet<String>();
        Map<Integer,Map<String,Integer>> foodsCnt = new HashMap<>();
        for (List<String> order : orders) {
            nameSet.add(order.get(2));
            int id = Integer.parseInt(order.get(1));
            Map<String,Integer> map    = foodsCnt.getOrDefault(id,new HashMap<>());
            map.put(order.get(2),map.getOrDefault(order.get(2),0)+1);
            foodsCnt.put(id,map);
        }
        int n = nameSet.size();
        List<String> names = new ArrayList<>();
        for (String name : nameSet) {
            names.add(name);
        }
        Collections.sort(names);
        int m = foodsCnt.size();
        List<Integer> ids = new ArrayList<>();
        for (int id : foodsCnt.keySet()) {
            ids.add(id);
        }
        Collections.sort(ids);
        List<List<String>> table = new ArrayList<List<String>>();
        List<String> header = new ArrayList<String>();
        header.add("Table");
        for (String name : names) {
            header.add(name);
        }
        table.add(header);
        for (int i = 0; i < m; i++) {
            int id = ids.get(i);
            Map<String,Integer> map = foodsCnt.get(id);
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(id));
            for (int j = 0; j < n; j++) {
                row.add(String.valueOf(map.getOrDefault(names.get(j),0)));
            }
            table.add(row);
        }
        return table;
    }

}
