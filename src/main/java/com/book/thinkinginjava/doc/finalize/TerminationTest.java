package com.book.thinkinginjava.doc.finalize;

/**
 * @Author jojo
 * @create 2020/2/1 下午5:39
 */
public class TerminationTest {

    public static void main(String[] args) {
        Book book = new Book(true);
        book.checkin();
        new Book(true);
        System.gc();
    }
}