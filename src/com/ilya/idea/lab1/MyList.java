package com.ilya.idea.lab1;

public class MyList {
    private static class Node {
        Node next;
        Node prev;
        Object data;

        Node(Object data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        Node(Object data){
            this(data, null, null);
        }

        Node(){
            this(null, null, null);
        }
    }

    private int length;
    private Node head;
    private Node tail;

    public MyList() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    public MyList(MyList lstToCopy){
        if (lstToCopy == null){
            this.head = this.tail = null;
            this.length = 0;
        }
        this.length = lstToCopy.size();
        Node temp = lstToCopy.head;
        Node createTemp = new Node(temp.data, null, null);
        this.head = createTemp;
        while (temp.next != null){
            temp = temp.next;
            createTemp.next = new Node(temp.data, null, createTemp);
            createTemp = createTemp.next;
        }
        this.tail = createTemp;
    }

    private Node getNode(int index){
        var temp = new Node();
        if (index < length / 2){
            temp = head;
            for (int i = 0; i < index; ++i){
                temp = temp.next;
            }
        }
        else {
            temp = tail;
            for (int i = length - 1; i > index; --i){
                temp = temp.prev;
            }
        }
        return temp;
    }

    public  int size(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void addFront(Object itemToAdd){
        if (length == 0){
            head = new Node(itemToAdd);
            tail = head;
        }
        else{
            head.prev = new Node(itemToAdd, head, null);
            head = head.prev;
        }
        ++length;
    }

    public void addBack(Object itemToAdd){
        if (length == 0){
            head = new Node(itemToAdd);
            tail = head;
        }
        else{
            tail.next = new Node(itemToAdd, null, tail);
            tail = tail.next;
        }
        ++length;
    }

    public void add(Object itemToAdd, int index){
        if (length == 0){
            head = new Node(itemToAdd);
            tail = head;
            ++length;
            return;
        }
        if (index <= 0){
            head.prev = new Node(itemToAdd, head, null);
            head = head.prev;
        }
        else if (index < length){
            var temp = new Node();
            if (index < length / 2){
                temp = head;
                for (int i = 0; i < index - 1; ++i){
                    temp = temp.next;
                }
                temp.next.prev = new Node(itemToAdd, temp.next, temp);
                temp.next = temp.next.prev;
            }
            else {
                temp = tail;
                for (int i = length - 1; i > index; --i){
                    temp = temp.prev;
                }
                temp.prev.next = new Node(itemToAdd, temp, temp.prev);
                temp.prev = temp.prev.next;
            }
        }
        else{
            tail.next = new Node(itemToAdd, null, tail);
            tail = tail.next;
        }
        ++length;
    }

    public Object remove(int index){
        var removed = new Node();
        if (length == 0){
            return null;
        }
        else if (length == 1){
            removed = head;
            head = tail = null;
            --length;
            return removed.data;
        }

        if (index <= 0){
            removed = head;
            head.next.prev = null;
            head = head.next;
        }
        else if (index < length - 1){
            var temp = getNode(index);
            removed = temp;
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
            temp.next = null;
            temp.prev = null;
        }
        else{
            removed = tail;
            tail.prev.next = null;
            tail = tail.prev;
        }
        --length;
        return removed.data;
    }

    public Object get(int index){
        var temp = getNode(index);
        return temp.data;
    }

    public void set(Object itemToSet, int index){
        var temp= getNode(index);
        temp.data = itemToSet;
    }

    public boolean contains(Object value){
        var temp = head;
        while (temp != null){
            if (temp.data.equals(value)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(Object value){
        int index = 0;
        var temp = head;
        while(temp != null){
            if (temp.data.equals(value)){
                return index;
            }
            ++index;
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public String toString() {
        if (length == 0){
            return "[]";
        }
        StringBuilder toOut = new StringBuilder("[");
        var temp = head;
        while (temp != null){
            if (temp.next == null){
                toOut.append(temp.data);
            }
            else{
                toOut.append(temp.data).append(", ");
            }
            temp = temp.next;
        }
        return toOut + "]";
    }
}
