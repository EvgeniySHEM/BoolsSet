package ru.avalon.javapp.devj110.boolsset;

public class Main {
    public static void main(String[] args) {
        BoolsSet bs = new IntArray();
        BoolsSet bs1 = new BooleanArray();

        System.out.println(bs.check(36));
        bs.set(0, true);
        bs.set(1, true);
        bs.set(36, true);
        bs.set(4, true);
        bs.set(152, true);
        bs.set(987, true);
        System.out.println(bs.check(36));
        bs.clear(36);
        System.out.println(bs.check(36));
        bs.flip(36);
        System.out.println(bs.check(36));
        bs.flip(36);
        System.out.println(bs.check(36));

        System.out.println(bs.count());
        System.out.println(bs.toString());

//        bs.set(2);
//        bs.set(3);
//        bs.set(4);
//
//        for (int i = 10; i < 20; i++) {
//            bs.set(i);
//        }
//
//        System.out.println(bs.check(2));
//
//        bs.clear(15);
//        bs.flip(17);
//        bs.flip(22);
//        System.out.println("---------+---------+---------+---------+---------+");
//        System.out.println(bs.toString().substring(0, 50));
    }
}
