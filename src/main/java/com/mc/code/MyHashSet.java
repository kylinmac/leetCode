package com.mc.code;

import java.util.TreeSet;

/**
 * @author macheng
 * @date 2021/3/13 18:16
 */
public class MyHashSet {

   private  TreeSet<Integer>[] treeSets=new TreeSet[16];

    /** Initialize your data structure here. */
    public MyHashSet() {
        for (int i = 0; i < 16; i++) {
            treeSets[i]=new TreeSet<>();
        }
    }

    public void add(int key) {
        treeSets[key&16].add(key);
    }

    public void remove(int key) {
        treeSets[key&16].remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return treeSets[key&16].contains(key);
    }
}
