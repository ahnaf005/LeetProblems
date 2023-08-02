package com.company.implementations;

import java.util.*;

public class RandomizedSet {
    private Map<Integer,Integer>map;
    private List<Integer>list;
    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int pos=map.get(val);
        int lastElem=list.get(list.size());
        list.set(pos, lastElem);
        list.remove(list.size()-1);
        map.put(lastElem,pos);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int random=(int)(Math.random()*(list.size()-1));
        return list.get(random);
    }
}
