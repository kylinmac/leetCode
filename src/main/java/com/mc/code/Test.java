package com.mc.code;

import lombok.Data;
import org.apache.activemq.ActiveMQConnection;
import org.apache.commons.lang3.StringUtils;


/**
 * @author macheng
 * @date 2020/12/16 9:14
 */
@Data
public class Test {
    private Byte test;


    public static void main(String[] args) throws Throwable {
        System.out.println(ts());
        System.out.println(ti());
    }

    private static StringBuilder ts() {
        StringBuilder s = new StringBuilder("sss");
        try {
            return s;
        } finally {
            s.append("d");
        }
    }

    public static int ti() {
        int a=1;
        try {
            return a;
        } finally {
            a=2;
            return a;
        }
    }

    public static String email(String email, String mask) {
        if (StringUtils.isBlank(email)) {
            return "";
        }
        int index = StringUtils.indexOf(email, "@");
        if (index <= 1) {
            return email;
        } else {
            return StringUtils.rightPad(StringUtils.left(email, 2), 10, mask).concat(StringUtils.mid(email, index - 1, StringUtils.length(email)));
        }

    }

    private void gctest() throws Throwable {

        int i = 0;
        while (true) {
            i++;

            if (i % 1000 == 0) {
                System.out.println(i + "gc");

            }
            new TH("s", "d");

        }
    }


}

class TH {
    private String s1;
    private String s2;

    public TH(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }
}