package com.mc.code;

/**
 * @author macheng
 * @date 2021/3/23 15:42
 */
public class MyHashet {

    private int[] set = new int[32000];

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(0x80000000));
        MyHashet myHashet = new MyHashet();
        myHashet.remove(88);
        myHashet.remove(56);
        myHashet.add(17);
        myHashet.add(20);
        myHashet.contains(83);
        myHashet.add(43);
        myHashet.add(27);
        myHashet.add(20);
        myHashet.remove(21);
        myHashet.contains(15);
        myHashet.add(90);
        myHashet.add(69);
        myHashet.add(95);
        myHashet.remove(12);
        myHashet.add(60);
        myHashet.remove(78);
        myHashet.add(94);
        myHashet.add(85);
        myHashet.add(70);
        myHashet.remove(45);
        myHashet.add(84);
        myHashet.remove(89);
        myHashet.contains(17);
        myHashet.add(12);
        myHashet.add(47);
        myHashet.add(26);
        myHashet.add(90);
        myHashet.add(26);
        myHashet.add(63);
        myHashet.add(88);
        myHashet.remove(83);
        myHashet.remove(51);
        myHashet.remove(10);
        myHashet.add(71);
        myHashet.add(85);
        myHashet.remove(38);
        myHashet.add(1);
        myHashet.contains(87);
        myHashet.contains(27);
        myHashet.add(26);
        myHashet.remove(30);
        myHashet.add(44);
        myHashet.add(39);
        myHashet.add(89);
        myHashet.add(54);
        myHashet.add(18);
        myHashet.contains(84);
        myHashet.contains(94);
        myHashet.add(63);
        myHashet.add(41);
        myHashet.add(77);
        myHashet.add(31);
        myHashet.add(9);
        myHashet.remove(76);
        myHashet.contains(85);
        myHashet.remove(80);
        myHashet.add(6);
        myHashet.add(85);
        myHashet.add(13);
        myHashet.add(89);
        myHashet.add(49);
        myHashet.remove(12);
        myHashet.add(35);
        myHashet.add(81);
        myHashet.add(32);
        myHashet.add(75);
        boolean contains1 = myHashet.contains(48);
        myHashet.add(33);
        myHashet.add(33);
        myHashet.add(0);
        myHashet.add(6);
        myHashet.add(97);
        myHashet.remove(3);
        myHashet.add(94);
        myHashet.add(90);
        myHashet.contains(9);
        myHashet.add(87);
        myHashet.add(68);
        myHashet.add(32);
        myHashet.remove(3);
        myHashet.remove(85);
        myHashet.remove(13);
        myHashet.remove(89);
        boolean contains = myHashet.contains(18);
        boolean contains2 = myHashet.contains(78);
        myHashet.add(57);
        myHashet.add(47);
        boolean contains3 = myHashet.contains(85);
        myHashet.add(94);
        myHashet.add(53);
        myHashet.add(14);
        myHashet.add(12);
        myHashet.add(62);
        myHashet.contains(44);
        myHashet.contains(31);
        myHashet.add(10);
        myHashet.remove(69);
        myHashet.add(48);
        myHashet.remove(38);
        myHashet.add(54);
        System.out.println("32");
    }

    public void add(int key) {
        int add = key % 32;
        int or = Integer.MIN_VALUE;
        or = or >>> add;

        set[(key+1) / 32] = set[(key+1) / 32] | or;
    }

    public void remove(int key) {

        if (contains(key)) {
            int add = key % 32;
            int or = Integer.MIN_VALUE;
            or = or >>> add;
            set[(key + 1) / 32] = set[(key + 1) / 32] ^ or;
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int add = key % 32;
        int or = Integer.MIN_VALUE;
        or = or >>> add;
        return (set[(key+1) / 32] & or) != 0;
    }
}
