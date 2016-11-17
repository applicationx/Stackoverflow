package com.stackoverflow.stack;

import org.junit.Test;

import java.util.Queue;
import java.util.Stack;

import static org.junit.Assert.*;

public class CopierTest {

    @Test
    public void testReturnAsQueue() throws Exception {

        Stack<String> stringStack = new Stack<>();
        stringStack.push("Jonas");
        stringStack.push("Lars");
        stringStack.push("Veronica");
        stringStack.push("Elliot");

        System.out.println(stringStack);

        Copier<String> copier = new Copier(stringStack);
        Queue<String> stringQueue = copier.returnAsQueue();

        System.out.println(stringQueue);
        System.out.println(stringStack);


    }
}