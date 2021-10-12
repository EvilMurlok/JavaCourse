package com.ilya.idea.lab1;

public class testList {
    public static void main(String[] args) {
        MyList lst = new MyList();
        System.out.println(lst.isEmpty());
        lst.addBack("IlyaIlyaIlya");
        lst.addFront("hflkfakh");
        Integer afd = 432;
        lst.add("afd", 9);
        lst.add(afd, 2);
        System.out.println(lst);
        lst.addFront(543);
        lst.addBack(236);
        lst.addFront("543");
        lst.addBack(4654);
        System.out.println(lst);
        System.out.println(lst.remove(10));
        System.out.println(lst.remove(0));
        System.out.println(lst);
        System.out.println(lst.get(432));
        System.out.println(lst.contains(236));
        System.out.println(lst.indexOf("afd"));
        System.out.println(lst.size());
        lst.set("8423846", 100);
        System.out.println(lst);
        System.out.println(lst.isEmpty());

        MyList lst1 = new MyList(lst);
        System.out.println(lst1);
        System.out.println(lst.remove(6));
        System.out.println(lst);
        System.out.println(lst.remove(-1));
        System.out.println(lst);
        System.out.println(lst.remove(3));
        System.out.println(lst);
        System.out.println(lst.remove(0));
        System.out.println(lst);
        System.out.println(lst.remove(1));
        System.out.println(lst);
        System.out.println(lst.remove(-13));
        System.out.println(lst);
        System.out.println(lst.remove(13));
        System.out.println(lst.remove(-123));
        System.out.println(lst);
        System.out.println(lst.indexOf(6746));
        lst.addFront(543);
        lst.addBack(236);
        lst.addFront("543");
        lst.addBack(4654);
        System.out.println(lst);
        lst.set(444444, -100);
        System.out.println(lst);
    }
}
