package com.essri.algorithm;

public class StackExample {
    private int top;
    private int maxSize;
    private Object[] stackArr;

    public StackExample(int maxSize) {
        this.maxSize = maxSize;
        this.stackArr = new Object[maxSize];
        this.top = -1;
    }

    public boolean full() {
        return (top == maxSize-1);
    }

    public void push(Object item) {
        if(full()) {
            throw new ArrayIndexOutOfBoundsException((top+1)+">=" + maxSize);
        }

        stackArr[++top] = item;
    }

    public boolean empty() {
        return (top==-1);
    }

    public Object peek() {
        if(empty()) {
            throw new ArrayIndexOutOfBoundsException(top);
        }
        return stackArr[top];
    }

    public Object pop() {
        Object item = peek();
        top--;
        return item;
    }
}
