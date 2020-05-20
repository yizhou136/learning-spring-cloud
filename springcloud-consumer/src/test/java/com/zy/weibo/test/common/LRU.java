package com.zy.weibo.test.common;

import java.util.LinkedList;

/**
 * @Author zhouguobao
 * @Date 2020/5/20
 **/
public class LRU {
    private LinkedList<Person> cache;

    public LRU() {
        this.cache = new LinkedList<>();
    }

    public void put(Person person) {
        boolean find = cache.remove(person);
        cache.addFirst(person);
    }

    public Person getLasted() {
        Person person = cache.getFirst();
        return person;
    }


    public static void main(String[] argv) {
        String str = "abcacba";
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
    }
}
