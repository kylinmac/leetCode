package com.mc.code.java8;

import java.util.function.Function;

/**
 * @author macheng
 * @date 2021/3/19 15:33
 */
class One{
    @Override
    public String toString() {
        return "One{}";
    }
}
class Two{
    @Override
    public String toString() {
        return "Two{}";
    }
}
class Three{
    @Override
    public String toString() {
        return "Three{}";
    }
}
public class ConsumeFunction {
   static Function<Two, One> consume(Function<Two,One> onetwo){
       return onetwo.andThen(o->{
           System.out.println(o);
           return new One();
       });
   }

    public static void main(String[] args) {
        Function<Two,One> o=consume(i->{
            int x=0;
            x++;
            System.out.println(i);
            
            return new One();
        });

        o.apply(new Two());
    }
}
