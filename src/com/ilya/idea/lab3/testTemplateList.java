package com.ilya.idea.lab3;

import com.ilya.idea.utils.SortedList;

import java.util.Iterator;
import java.util.ListIterator;

public class testTemplateList {
    public static void main(String[] args) {
        TemplateList<String> testTemplateList = new TemplateList<>();
        System.out.println("---------------------------work with empty TemplateList-----------------------------------------");
        System.out.println(testTemplateList.size());
        System.out.println(testTemplateList.isEmpty());
        System.out.println(testTemplateList.get(9));
        System.out.println(testTemplateList.get(1));
        System.out.println(testTemplateList);
        System.out.println("--------------------------------------------------------------------");
        testTemplateList.addFront("Ilya");
        System.out.println(testTemplateList);
        System.out.println("--------------------------------------------------------------------");
        System.out.println(testTemplateList.size());
        System.out.println(testTemplateList.remove(-200));
        System.out.println(testTemplateList);
        System.out.println(testTemplateList.remove(100));
        System.out.println(testTemplateList);
        System.out.println(testTemplateList.indexOf("Ilya"));
        System.out.println("--------------------------------------------------------------------");
        testTemplateList.addBack("Anna");
        testTemplateList.addFront("Anna1");
        testTemplateList.addBack("Denis");
        testTemplateList.addFront("Klim");
        testTemplateList.addBack("Maria");
        testTemplateList.addBack("Andrew");
        System.out.println(testTemplateList);
        System.out.println(testTemplateList.indexOf("Anna"));
        System.out.println(testTemplateList.indexOf("Klim"));
        System.out.println(testTemplateList.indexOf("Maria"));
        System.out.println(testTemplateList.indexOf("Vasya"));
        System.out.println("--------------------------------------------------------------------");
        testTemplateList.add("Anna2", 5);
        testTemplateList.add("Denis1", 10);
        testTemplateList.add("Klim1", -1);
        testTemplateList.add("Maria1", 100);
        testTemplateList.add("Andrew1", 10);
        System.out.println(testTemplateList);
        testTemplateList.add("1", 8);
        testTemplateList.add("10", testTemplateList.size() - 1);
        testTemplateList.add("20", 0);
        testTemplateList.add("90", testTemplateList.size());
        System.out.println("--------------------------------------------------------------------");
        System.out.println(testTemplateList);
        testTemplateList.add("100", 1);
        testTemplateList.add("25", 3);
        testTemplateList.add("15", 9);
        testTemplateList.add("9", 4);
        testTemplateList.add("29", 18);
        System.out.println(testTemplateList);
        System.out.println("--------------------------------------------------------------------");
        System.out.println(testTemplateList.contains("Andrew"));
        System.out.println(testTemplateList.contains("Maria"));
        System.out.println(testTemplateList.contains("1"));
        System.out.println(testTemplateList.contains("100"));
        System.out.println(testTemplateList.contains("90"));
        System.out.println(testTemplateList.contains("Dmitriy"));
        System.out.println(testTemplateList.contains("Svetlana"));
        System.out.println(testTemplateList.contains("Klim"));
        System.out.println("--------------------------------------------------------------------");
        System.out.println(testTemplateList.get(testTemplateList.size()));
        System.out.println(testTemplateList.get(testTemplateList.size() - 1));
        System.out.println(testTemplateList.get(0));
        System.out.println(testTemplateList.get(-1));
        System.out.println(testTemplateList.get(5));
        System.out.println("--------------------------------------------------------------------");
        System.out.println(testTemplateList);
        SortedList<String> testSortedList1 = new SortedList<>(testTemplateList);
        System.out.println(testSortedList1);
        System.out.println(testTemplateList.size());
        System.out.println(testTemplateList.remove(15));
        System.out.println(testTemplateList.remove(13));
        System.out.println(testTemplateList.remove(3));
        System.out.println(testTemplateList);
        System.out.println("--------------------------------------------------------------------");
        System.out.println(testSortedList1.remove(12));
        System.out.println(testSortedList1.remove(16));
        System.out.println(testSortedList1.remove(15));
        System.out.println(testSortedList1);
        System.out.println(testTemplateList);

        System.out.println("-------------------------------------------tests merging----------------------------------------------");
        TemplateList<String> stringTemplateList = new TemplateList<>(testTemplateList);
        TemplateList<String> stringTemplateList1 = new TemplateList<>();
        stringTemplateList1.addBack("777");
        stringTemplateList1.addBack("Gena");
        stringTemplateList1.addFront("Ilia");
        stringTemplateList1.addBack("Danila");
        stringTemplateList1.addFront("Petr");
        stringTemplateList1.addBack("Andrew");
        stringTemplateList1.addBack("001");
        System.out.println(stringTemplateList);
        System.out.println(stringTemplateList1);
        TemplateList<String> mergedList = MergerLists.merge(stringTemplateList, stringTemplateList1);
        System.out.println(mergedList);

        TemplateList<Integer> mergedList1 = MergerLists.merge(new TemplateList<Integer>(), new TemplateList<Integer>());
        System.out.println(mergedList1);


    }
}
