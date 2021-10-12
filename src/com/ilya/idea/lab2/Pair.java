package com.ilya.idea.lab2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class Pair {
    private final Object key;
    private Object value;

    public Pair(Object key, Object value){
        this.key = key;
        this.value = value;
    }

    public Pair(Object key){
        this(key, null);
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || this.key == null) return false;
        Pair pair = (Pair) o;
        if (pair.key == null) return false;
        return Objects.equals(key, pair.key); // сравниваются строго ссылки, то есть одинаковые ключи-массивы по значениям,
        // под которые память была выделена в разных частях кучи, в результате дадут false
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return "Pair{ " +
                "key = " + key +
                ", value = " + value +
                " }";
    }
}
