package com.zlinks.samples.creator.impl;

/**
 * Copyright (C), 2018-2018, BBG
 * FileName: Test
 * Author: zhangjh
 * Date: 2018/7/10 下午3:48
 * Description:
 */
public class Test {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.getValue());
    }

    static class A {
        protected int value;

        public A(int v) {
            setValue(v);
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            try {
                value++;
                return value;
            } catch (Exception e) {
                System.out.println(e.toString());
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
            return value;
        }
    }

    static class B extends A {
        public B() {
            super(5);
            setValue(getValue() - 3);
        }

        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }

}
