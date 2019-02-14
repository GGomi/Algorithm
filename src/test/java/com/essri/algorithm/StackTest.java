package com.essri.algorithm;

import org.junit.Test;

public class StackTest {
    private StackExample stackExample = new StackExample(10);

    @Test
    public void test() {
        stackExample.push(1);
        stackExample.push(10);
        stackExample.push(4);
        stackExample.push(3);
        System.out.println(stackExample.peek());
//        assertTrue("1", );


    }
}
