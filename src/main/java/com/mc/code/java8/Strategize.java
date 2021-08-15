package com.mc.code.java8;

/**
 * @author macheng
 * @date 2021/3/19 14:33
 */
public class Strategize {
    Strategy strategy;
    String msg;

    public Strategize(String msg) {
        this.msg = msg;
        strategy=new Soft();
    }
}
