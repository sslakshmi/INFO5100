package edu.northeastern;

import java.util.ArrayList;
import java.util.List;

public class Question5 {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();

        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));            // returns 1
        System.out.println(hashMap.get(3));            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        System.out.println(hashMap.get(2));            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        System.out.println(hashMap.get(2));            // returns -1 (not found)
    }
}

class MyHashMap {
    public static final int SIZE = 1000;
    List<KeyValue>[] data;

    public MyHashMap() {
        data = new List[SIZE];
    }
    
    public void put(int key, int value) {
        int hashCode = Integer.valueOf(key).hashCode() % SIZE;
        if (data[hashCode] == null) {
            data[hashCode] = new ArrayList<>();
        }
        else{
            for (KeyValue keyValue : data[hashCode]) {
                if (keyValue.key == key){
                    keyValue.value = value;
                    return;
                }
            }
        }
        data[hashCode].add(new KeyValue(key, value));
    }

    public int get(int key) {
        int hashCode = Integer.valueOf(key).hashCode() % SIZE;
        if (data[hashCode] != null) {
            for (KeyValue keyValue : data[hashCode]) {
                if (keyValue.key == key) return keyValue.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hashCode = Integer.valueOf(key).hashCode() % SIZE;
        if (data[hashCode] != null) {
            for (KeyValue keyValue : data[hashCode]) {
                if (keyValue.key == key) {
                    data[hashCode].remove(keyValue);
                    return;
                }
            }
        }
    }
}

class KeyValue {
    int key;
    int value;

    KeyValue(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
