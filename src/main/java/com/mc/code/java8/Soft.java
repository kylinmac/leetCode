package com.mc.code.java8;

/**
 * @author macheng
 * @date 2021/3/19 14:30
 */
public class Soft implements Strategy{
    @Override
    public String approach(String msg) {
        return msg.toLowerCase()+"?";
    }
}
