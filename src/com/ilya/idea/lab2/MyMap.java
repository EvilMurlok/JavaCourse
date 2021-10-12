package com.ilya.idea.lab2;

import com.ilya.idea.lab1.MyList;

public class MyMap {
    MyList data;
    int length;

    public MyMap(MyList listToCopy, int length){
        if (listToCopy == null){
            this.data = new MyList();
        }
        else{
            this.data = new MyList(listToCopy);
        }
        this.length = length;
    }

    public MyMap(){
        this(null, 0);
    }

    public int size(){ return this.length; }

    public boolean isEmpty() { return this.length == 0; }

    // здесь и далее ключи со значением null просто игнорируются
    public void put(Object key, Object value){
        if (key == null){
            return; // тут бы я бросил исключение, но они запрещены,
            // поэтому программа просто проигнорирует попытку вставки с ключом со значением null
        }
        Pair temp = new Pair(key, value);
        int indexOfTemp = this.data.indexOf(temp);
        if (indexOfTemp < 0){
            this.data.addBack(temp);
            ++this.length;
        }
        else{
            this.data.set(temp, indexOfTemp);
        }
    }

    public Object get(Object key){
        if (key == null) return null;
        Pair temp = new Pair(key);
        int indexOfTemp = this.data.indexOf(temp);
        if (indexOfTemp < 0) return null;
        else {
            return ((Pair) this.data.get(indexOfTemp)).getValue();
        }
    }

    public Object get(Object key, Object byDefault){
        if (key == null) return null;
        Pair temp = new Pair(key, byDefault);
        int indexOfTemp = this.data.indexOf(temp);
        if (indexOfTemp < 0){
            this.data.addBack(temp);
            ++this.length;
            return byDefault;
        }
        else{
            return ((Pair) this.data.get(indexOfTemp)).getValue();
        }
    }

    public Object remove(Object key){
        if (this.length == 0){ return null; }
        if (key == null) return null;
        Pair temp = new Pair(key);
        int indexOfTemp = this.data.indexOf(temp);
        if (indexOfTemp < 0) return null;
        else {
            --this.length;
            return this.data.remove(indexOfTemp);
        }
    }

    public boolean keyContains(Object key){
        if (key == null) { return false; }
        Pair temp = new Pair(key);
        int indexOfTemp = this.data.indexOf(temp);
        return indexOfTemp > -1;
    }

    public MyList getKeys(){
        MyList tempList = new MyList();
        for (int i = 0; i < this.data.size(); ++i){
            tempList.addBack(((Pair) this.data.get(i)).getKey());
        }
        return tempList;
    }

    public MyList getValues(){
        MyList tempList = new MyList();
        for (int i = 0; i < this.data.size(); ++i){
            tempList.addBack(((Pair) this.data.get(i)).getValue());
        }
        return tempList;
    }

    public MyList getEntries(){
        MyList tempList = new MyList();
        for (int i = 0; i < this.data.size(); ++i){
            tempList.addBack(this.data.get(i));
        }
        return tempList;
    }

    @Override
    public String toString() {
        return "MyMap{ " +
                "data = " + data +
                ", length = " + length +
                " }";
    }
}
