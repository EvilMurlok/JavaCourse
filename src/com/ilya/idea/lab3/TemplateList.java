package com.ilya.idea.lab3;
import java.util.ListIterator;

public class TemplateList<T> implements Iterable<T> {
    public static class Node<T>{
        private Node<T> next;
        private Node<T> prev;
        private T data;

        Node(T data, Node<T> next, Node<T> prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        Node(T data){
            this(data, null, null);
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

        public void setData(T dataToSet){ this.data = dataToSet; }
    }

    private int length;
    private Node<T> head;
    private Node<T> tail;

    public TemplateList(){
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    public TemplateList(TemplateList<T> listToCopy){
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

    //решил попробовать реализовать итератор для удобства
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
                currentPosition.data = itemToSet;
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

    public void addFront(T itemToAdd){
        if (length == 0){
            head = tail = new Node<>(itemToAdd);
        }
        else{
            head.prev = new Node<>(itemToAdd, head, null);
            head = head.prev;
        }
        ++length;
    }

    public void addBack(T itemToAdd){
        if (length == 0){
            head = tail = new Node<>(itemToAdd);
        }
        else{
            tail.next = new Node<>(itemToAdd, null, tail);
            tail = tail.next;
        }
        ++length;
    }

    public void add(T itemToAdd, int index){
        if (this.length == 0){
            this.head = this.tail = new Node<>(itemToAdd);
            ++length;
            return;
        }
        if (index <= 0){
            this.head = new Node<>(itemToAdd, this.head, null);
            this.head.next.prev = this.head;
        }
        else if(index >= this.length - 1){
            this.tail = new Node<>(itemToAdd, null, this.tail);
            this.tail.prev.next = this.tail;
        }
        else{
            Node<T> tempNode = getNode(index);
            tempNode.prev.next = new Node<>(itemToAdd, tempNode, tempNode.prev);
            tempNode.prev = tempNode.prev.next;
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
            this.head = this.head.next;
            this.head.prev.next = null;
            this.head.prev = null;
        }
        else if (index >= this.length - 1){
            removedData = this.tail.data;
            this.tail = this.tail.prev;
            this.tail.next.prev = null;
            this.tail.next = null;
        }
        else {
            Node<T> removedNode = getNode(index);
            removedData = removedNode.data;
            removedNode.prev.next = removedNode.next;
            removedNode.next.prev = removedNode.prev;
            removedNode.next = removedNode.prev = null;
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
            if (temp.data.equals(itemToCheck)){
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
            if (temp.data.equals(itemToFind)){
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
