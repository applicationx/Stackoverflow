package com.stackoverflow.stack;


import java.io.*;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class Copier<E extends Serializable> {

    private final Stack<E> stack;

    public Copier(Stack<E> stack) {
        this.stack = stack;
    }

    public Queue<E> returnAsQueue() {
        Queue<E> queue = new LinkedBlockingQueue<>();
        ByteArrayOutputStream bos;
        ObjectOutputStream oos;
        ByteArrayInputStream bis;
        ObjectInputStream ois;
        for (E e : stack) {
            try {
                bos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(bos);
                oos.writeObject(e);
                bis = new ByteArrayInputStream(bos.toByteArray());
                ois = new ObjectInputStream(bis);
                queue.add((E) ois.readObject());
            } catch (IOException ioex) {
                ioex.printStackTrace();
            } catch (ClassNotFoundException cnfex) {
                cnfex.printStackTrace();
            }
        }
        return queue;
    }
}
