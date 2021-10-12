package com.ilya.idea.utils;

import com.ilya.idea.lab3.TemplateList;

import java.util.ListIterator;

public class SortedList<T extends Comparable<T>> implements Iterable<T> {
    public static class Node<T extends Comparable<T>>{
        private Node<T> next;
        private Node<T> prev;
        private final T data;

        Node(T data, Node<T> next, Node<T> prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public Node<T> getNext(){
            return this.next;
        }

        public Node<T> getPrev(){
            return this.prev;
        }

        public T getData(){
            return this.data;
        }
    }

    private int length;
    private Node<T> head;
    private Node<T> tail;

    public SortedList(){
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    public SortedList(SortedList<T> listToCopy){
        if (listToCopy == null){
            this.head = this.tail = null;
            this.length = 0;
        }
        this.length = listToCopy.size();
        var tempCopy = listToCopy.head;
        var newTemp = new Node<>(tempCopy.data, null, null);
        this.head = newTemp;
        while (tempCopy.next != null){
            tempCopy = tempCopy.next;
            newTemp.next = new Node<>(tempCopy.data, null, newTemp);
            newTemp = newTemp.next;
        }
        this.tail = newTemp;
    }

    public SortedList(TemplateList<T> listToSort){
        if (listToSort.isEmpty()){
            this.head = this.tail = null;
            this.length = 0;
            return;
        }
        SortedList<T> tempSortedList = new SortedList<>();
        TemplateList.Node<T> tempNode = listToSort.getHead();
        for (int i = 0; i < listToSort.size(); ++i){
            tempSortedList.add(tempNode.getData());
            tempNode = tempNode.getNext();
        }
        this.head = tempSortedList.head;
        this.tail = tempSortedList.tail;
        this.length = tempSortedList.length;
    }

    @Override
    public ListIterator<T> iterator(){
        ListIterator<T> it = new ListIterator<>() {
            private Node<T> currentPosition = head;
            private int currentIndex = 0;

            @Override
            public boolean hasNext(){
                return currentPosition != null;
            }

            @Override
            public boolean hasPrevious(){
                return currentPosition != null;
            }

            @Override
            public T next(){
                T temp = currentPosition.data;
                currentPosition = currentPosition.next;
                ++currentIndex;
                return temp;
            }

            @Override
            public T previous(){
                T temp = currentPosition.data;
                currentPosition = currentPosition.prev;
                --currentIndex;
                return temp;
            }

            @Override
            public void add(T itemToAdd){
                throw new UnsupportedOperationException();
            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }

            @Override
            public void set(T itemToSet){
                throw new UnsupportedOperationException();
            }

            @Override
            public int nextIndex(){
                return currentIndex + 1; // так написано в документации к методам из интерфейса ListIterator<T>
            }

            @Override
            public int previousIndex(){
                return currentIndex - 1; // так написано в документации к методам из интерфейса ListIterator<T>
            }
        };
        return it;
    }

    private Node<T> getNode(int index){
        Node<T> temp;
        if (index < this.length / 2){
            temp = this.head;
            for (int i = 0; i < index; ++i){
                temp = temp.next;
            }
        }
        else{
            temp = this.tail;
            for (int i = this.length - 1; i > index; --i){
                temp = temp.prev;
            }
        }
        return temp;
    }

    public int size(){ return this.length; }
    public boolean isEmpty() { return this.length == 0; }
    public Node<T> getHead() { return this.head; }
    public Node<T> getTail() { return this.tail; }

    public void add(T itemToAdd){
        if (this.length == 0){
            this.head = this.tail = new Node<>(itemToAdd, null, null);
            ++length;
            return;
        }
        if (itemToAdd.compareTo(this.head.data) <= 0){
            this.head = new Node<>(itemToAdd, this.head, null);
            this.head.next.prev = this.head;
        }
        else if (itemToAdd.compareTo(this.tail.data) >= 0){
            this.tail = new Node<>(itemToAdd, null, this.tail);
            this.tail.prev.next = this.tail;
        }
        else{
            Node<T> temp = this.head;
            while (itemToAdd.compareTo(temp.data) > 0){
                temp = temp.next;
            }
            temp.prev.next = new Node<>(itemToAdd, temp, temp.prev);
            temp.prev = temp.prev.next;
        }
        ++length;
    }

    public T remove(int index){
        T removedData;
        if (this.length == 0){
            return null;
        }
        else if (this.length == 1){
            removedData = this.head.data;
            this.tail = this.head = null;
        }
        else if (index <= 0){
            removedData = this.head.data;
            this.head.next.prev = null;
            this.head = this.head.next;
        }
        else if (index >= this.length - 1){
            removedData = this.tail.data;
            this.tail.prev.next = null;
            this.tail = this.tail.prev;
        }
        else {
            Node<T> removedNode = getNode(index);
            removedData = removedNode.data;
            removedNode.prev.next = removedNode.next;
            removedNode.next.prev = removedNode.prev;
        }
        --this.length;
        return removedData;
    }

    public T get(int index){
        var temp = getNode(index);
        return (temp != null) ? getNode(index).data : null;
    }

    public boolean contains(T itemToCheck){
        var temp = this.head;
        while (temp != null){
            if (temp.data.compareTo(itemToCheck) == 0){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(T itemToFind){
        int index = 0;
        var temp = this.head;
        while(temp != null){
            if (temp.data.compareTo(itemToFind) == 0){
                return index;
            }
            ++index;
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public String toString(){
        if (this.isEmpty()){
            return "[]";
        }
        StringBuilder theHoleList = new StringBuilder("[");
        var temp = this.head;
        while(temp != null){
            if (temp.next == null){
                theHoleList.append(temp.data).append("]");
            }
            else{
                theHoleList.append(temp.data).append(", ");
            }
            temp = temp.next;
        }
        return theHoleList.toString();
    }
}
