package org.kosta.etc;

import java.util.*;

public class MapSort {

    public MapSort(){}
    private static MapSort mapSort = new MapSort();

    public static List<Integer> sortByValue(final Map<Integer, Integer> map) {
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(map.keySet());
        Collections.sort(list, new Comparator<Object>() {
            @SuppressWarnings("unchecked")
            public int compare(Object o1, Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                return ((Comparable<Object>) v1).compareTo(v2);
            }
        });
        //Collections.reverse(list); // 주석시 오름차순
        return list;
    }

    public static List<Integer> ListIdx(Map<Integer,Integer> sumList){
        List<Integer> list = new ArrayList<>();
        Iterator<Integer> it = mapSort.sortByValue(sumList).iterator();
        while (it.hasNext()) {
            int temp = (Integer) it.next();
            list.add(temp);
        }
        return list;
    }

}

