package com.zy.weibo.test.common;

import java.util.Objects;

/**
 * @Author zhouguobao
 * @Date 2020/5/20
 **/
public class Josephu {

    private Person first;


    public Person getFirst() {
        return first;
    }

    public void setFirst(Person first) {
        this.first = first;
    }

    public void addPerson(int num) {
        Person currentPerson = null;
        for (int i = 1; i <= num; i++) {
            Person person = new Person(i);
            if (Objects.isNull(first)) {
                first = person;
                first.setNext(first);
                currentPerson = first;
            } else {
                currentPerson.setNext(person);
                person.setNext(first);
                currentPerson = person;
            }
        }

    }


    public Person startCount(int stepNum) {
        Person last = first;
        Person current = first;
        while (last.getNext() != first) {
            last = last.getNext();
        }
        int idx = 1;
        while (true) {
            if (last == current) {
                return current;
            }

            if (idx == stepNum) {
                current = current.getNext();
                last.setNext(current);
                idx = 1;
            } else {
                current = current.getNext();
                last = last.getNext();
                idx++;
            }
        }
    }

    public static void main(String[] argv) {
        Josephu josephu = new Josephu();
        josephu.addPerson(6);
        Person person = josephu.startCount(3);
        System.out.println(person.getNum());
    }
}
