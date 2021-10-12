package com.ilya.idea.lab3;

import java.util.ListIterator;

public class MergerLists {
    public static <T extends Comparable<T>> boolean isSorted(TemplateList<T> listToCheck){
        if (listToCheck.isEmpty()) { return true; }
        ListIterator<T> iter = listToCheck.iterator();
        iter.next();
        while (iter.hasNext()){
            if (iter.previous().compareTo(iter.next()) < 0){
                return false;
            }
            iter.next();
        }
        return true;
    }

    // improved bubble-sort :-)
    public static <T extends Comparable<T>> void sort(TemplateList<T> listToSort){
        boolean flag = true;
        while (flag){
            flag = false;
            TemplateList.Node<T> tempNode = listToSort.getHead();
            while (tempNode.getNext() != null){
                if (tempNode.getData().compareTo(tempNode.getNext().getData()) > 0){
                    flag = true;
                    T dub = tempNode.getData();
                    tempNode.setData(tempNode.getNext().getData());
                    tempNode.getNext().setData(dub);
                }
                tempNode = tempNode.getNext();
            }
        }
    }

    public static <T extends Comparable<T>> TemplateList<T> merge(TemplateList<T> list1, TemplateList<T> list2){
        TemplateList<T> readyList = new TemplateList<>();
        if (!isSorted(list1)) {
            sort(list1);
        }
        if (!isSorted(list2)){
            sort(list2);
        }

        TemplateList.Node<T> tempNode1 = list1.getHead();
        TemplateList.Node<T> tempNode2 = list2.getHead();
        while (tempNode1 != null && tempNode2 != null){
            if (tempNode1.getData().compareTo(tempNode2.getData()) < 0){
                readyList.addBack(tempNode1.getData());
                tempNode1 = tempNode1.getNext();
            }
            else{
                readyList.addBack(tempNode2.getData());
                tempNode2 = tempNode2.getNext();
            }
        }
        while (tempNode1 != null){
            readyList.addBack(tempNode1.getData());
            tempNode1 = tempNode1.getNext();
        }
        while (tempNode2 != null){
            readyList.addBack(tempNode2.getData());
            tempNode2 = tempNode2.getNext();
        }
        return readyList;
    }
}
