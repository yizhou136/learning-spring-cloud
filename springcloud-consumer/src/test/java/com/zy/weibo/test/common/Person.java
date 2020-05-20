package com.zy.weibo.test.common;

/**
 * @Author zhouguobao
 * @Date 2020/5/20
 **/
public class Person {
    private int num;
    private Person next;

    public Person(int num) {
        this.num = num;
    }

    public Person(int num, Person next) {
        this.num = num;
        this.next = next;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Person getNext() {
        return next;
    }

    public void setNext(Person next) {
        this.next = next;
    }
}
