package com.ilya.idea.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class testDifferentUtils {

    public static void testSortedList(){
        SortedList<String> testSortedList = new SortedList<>();
        System.out.println("---------------------------work with empty SortedList-----------------------------------------");
        System.out.println(testSortedList.size());
        System.out.println(testSortedList.isEmpty());
        System.out.println(testSortedList.get(9));
        System.out.println(testSortedList.get(1));
        System.out.println(testSortedList);
        System.out.println("--------------------------------------------------------------------");
        testSortedList.add("Ilya");
        System.out.println(testSortedList);
        System.out.println("--------------------------------------------------------------------");
        System.out.println(testSortedList.size());
        System.out.println(testSortedList.remove(-200));
        System.out.println(testSortedList);
        System.out.println(testSortedList.remove(100));
        System.out.println(testSortedList);
        System.out.println(testSortedList.indexOf("Ilya"));
        System.out.println("--------------------------------------------------------------------");
        testSortedList.add("Anna");
        testSortedList.add("Anna1");
        testSortedList.add("Denis");
        testSortedList.add("Klim");
        testSortedList.add("Maria");
        testSortedList.add("Andrew");
        System.out.println(testSortedList);
        System.out.println(testSortedList.indexOf("Anna"));
        System.out.println(testSortedList.indexOf("Klim"));
        System.out.println(testSortedList.indexOf("Maria"));
        System.out.println(testSortedList.indexOf("Vasya"));
        System.out.println("--------------------------------------------------------------------");
        testSortedList.add("Anna2");
        testSortedList.add("Denis1");
        testSortedList.add("Klim1");
        testSortedList.add("Maria1");
        testSortedList.add("Andrew1");
        testSortedList.add("1");
        testSortedList.add("10");
        testSortedList.add("20");
        testSortedList.add("90");
        testSortedList.add("100");
        testSortedList.add("25");
        testSortedList.add("15");
        testSortedList.add("9");
        testSortedList.add("29");
        System.out.println(testSortedList);
        System.out.println("--------------------------------------------------------------------");
        System.out.println(testSortedList.contains("Andrew"));
        System.out.println(testSortedList.contains("Maria"));
        System.out.println(testSortedList.contains("1"));
        System.out.println(testSortedList.contains("100"));
        System.out.println(testSortedList.contains("90"));
        System.out.println(testSortedList.contains("Dmitriy"));
        System.out.println(testSortedList.contains("Svetlana"));
        System.out.println(testSortedList.contains("Klim"));
        System.out.println("--------------------------------------------------------------------");
        System.out.println(testSortedList.get(testSortedList.size()));
        System.out.println(testSortedList.get(testSortedList.size() - 1));
        System.out.println(testSortedList.get(0));
        System.out.println(testSortedList.get(-1));
        System.out.println(testSortedList.get(5));
        System.out.println("--------------------------------------------------------------------");
        System.out.println(testSortedList);
        SortedList<String> testSortedList1 = new SortedList<>(testSortedList);
        System.out.println(testSortedList1);
        System.out.println(testSortedList.size());
        System.out.println(testSortedList.remove(15));
        System.out.println(testSortedList.remove(13));
        System.out.println(testSortedList.remove(3));
        System.out.println(testSortedList);
        System.out.println(testSortedList1.remove(12));
        System.out.println(testSortedList1.remove(16));
        System.out.println(testSortedList1.remove(15));
        System.out.println(testSortedList1);
        System.out.println(testSortedList);
    }

    public static void testSplitTokens(){
        //String[] test = "bla   bla blablaaaablabbblaaa    bla blaa       lkblkblaaaafdn lfndlsk    blaa   nlkgns      ".split("\\s");
        //ArrayList<String> tempList = new ArrayList<>(Arrays.asList(test));
        //tempList.removeAll(Collections.singleton(""));
        //System.out.println(tempList);

        SplitTokens st = new SplitTokens("", "");
        System.out.println(st.getTokens());
        System.out.println(st.getFinalStatistics());
        st.createStatistics();
        System.out.println(st.getFinalStatistics());
        System.out.println(st.deleteAllDuplicates());

        st.changeData("");
        System.out.println(st.getTokens());
        System.out.println(st.getFinalStatistics());
        st.createStatistics();
        System.out.println(st.getFinalStatistics());
        System.out.println(st.deleteAllDuplicates());

        // since a regular expression is supplied to the split function,
        // it is necessary to escape all special characters such as an asterisk
        st.changeData("STARS****STARS***STARS****STARS***STARS****MORE****STARS!****STARS", "\\*\\*\\*\\*");
        st.createStatistics();
        System.out.println(st.getTokens());
        System.out.println(st.getFinalStatistics());
        System.out.println(st.deleteAllDuplicates());
        System.out.println();

        st.changeData("bla\tbla\tblablaaaablabbblaaat\ttblatt\ttblatt\tbla\tbla\taaa\tbla\tbbblaaatt\t\t\t\t\tblablaaaablabbblaaat", "\t");
        st.createStatistics();
        System.out.println(st.getTokens());
        System.out.println(st.getFinalStatistics());
        System.out.println(st.deleteAllDuplicates());
        System.out.println();
    }

    public static void main(String[] args) {
        testSplitTokens();
    }
}
