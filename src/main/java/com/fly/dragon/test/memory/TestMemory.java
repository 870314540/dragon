package com.fly.dragon.test.memory;

import java.util.ArrayList;
import java.util.List;

public class TestMemory {

    public static void main(String[] args) {
//        outOfMemory();
        count();
    }

    public static void outOfMemory() {
        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        List<Object> listObj = new ArrayList<Object>();
        for (int i = 0; i < 1000000000; i++) {
            Byte[] bytes = new Byte[1 * 1024 * 1024];
            listObj.add(bytes);
        }
        System.out.println("添加success");
    }

    private static int count;

    public static void count() {
        // java.lang.StackOverflowError
        try {
            count++;
            count();
        } catch (Throwable e) {
            System.out.println("最大深度:" + count);
            e.printStackTrace();
        }
    }

}

