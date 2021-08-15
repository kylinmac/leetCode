package com.mc.code;

import org.apache.commons.compress.utils.Lists;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

interface NestedInteger {

    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}

/**
 * @author macheng
 * @date 2021/3/23 9:56
 */
public class NestedIterator implements Iterator<Integer> {

    List<NestedInteger> nestedList;
    int index = 0;
    NestedIterator subIterator;

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(9));
    }
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
    }

    @Override
    public Integer next() {
        if (nestedList.get(index).isInteger()) {
            return nestedList.get(index++).getInteger();
        } else {
           return subIterator.next();
        }
    }

    @Override
    public boolean hasNext() {
        if (index>=nestedList.size()){
            return false;
        }
        if (!nestedList.get(index).isInteger()) {
            if (subIterator == null) {
                subIterator = new NestedIterator(nestedList.get(index).getList());
            }
            if (subIterator.hasNext()){
                return true;
            }else {
                index++;
                subIterator = null;
                return hasNext();
            }
        }
        return true;
    }
}
