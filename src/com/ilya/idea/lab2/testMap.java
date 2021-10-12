package com.ilya.idea.lab2;

public class testMap {
    public static void main(String[] args) {
        MyMap mapToTest = new MyMap();
        // сразу протестируем работу при словаре из 0 элементов;
        System.out.println(mapToTest.get(8));
        System.out.println(mapToTest.remove(90));
        System.out.println(mapToTest.isEmpty());
        System.out.println(mapToTest.size());
        System.out.println(mapToTest.keyContains(23));
        System.out.println(mapToTest.getKeys());
        System.out.println(mapToTest.getValues());
        System.out.println(mapToTest.getEntries());
        System.out.println(mapToTest.get("Rodion", "Ivanov"));
        System.out.println("-------------------------------------------------------------------");

        mapToTest.put(1, "Pavel");
        mapToTest.put(2, "Alena");
        mapToTest.put(3, "Ivan");
        mapToTest.put(4, "Olga");
        mapToTest.put(4, "Daniil");
        mapToTest.put(5, "Artyom");
        mapToTest.put(6, "Alina");
        System.out.println(mapToTest.keyContains(5));
        System.out.println(mapToTest.keyContains(1));
        System.out.println(mapToTest.keyContains(89));
        System.out.println(mapToTest);
        System.out.println("-------------------------------------------------------------------");

        mapToTest.put("Ilya", "Oblomov");
        mapToTest.put("Denis", "Maksimov");
        mapToTest.put("Alina", "Ivanova");
        mapToTest.put("Ilya", "Panin");
        System.out.println();
        System.out.println(mapToTest);
        System.out.println(mapToTest.keyContains("Ilya"));
        System.out.println(mapToTest.keyContains("Alina"));
        System.out.println("-------------------------------------------------------------------");

        System.out.println(mapToTest.get(3));
        System.out.println(mapToTest.get(10));
        System.out.println(mapToTest.get("Denis"));
        System.out.println(mapToTest.get("Rodion", "Raskolnikov"));
        System.out.println(mapToTest);
        System.out.println("-------------------------------------------------------------------");

        System.out.println(mapToTest.getKeys());
        System.out.println(mapToTest.getValues());
        System.out.println(mapToTest.getEntries());
        System.out.println("-------------------------------------------------------------------");

        System.out.println(mapToTest.remove(4));
        System.out.println(mapToTest.remove(1));
        System.out.println(mapToTest.remove(2));
        System.out.println(mapToTest.remove(3));
        System.out.println(mapToTest.remove(6));
        System.out.println(mapToTest.remove(5));
        System.out.println(mapToTest.remove(90));
        System.out.println(mapToTest);
        System.out.println("-------------------------------------------------------------------");

        System.out.println(mapToTest.remove("Rodion"));
        System.out.println(mapToTest.remove("Ilya"));
        System.out.println(mapToTest.remove("Denis"));
        System.out.println(mapToTest.remove("Vasiliy"));
        System.out.println(mapToTest.remove("Alina"));
        System.out.println(mapToTest);
        System.out.println("-------------------------------------------------------------------");
    }
}
