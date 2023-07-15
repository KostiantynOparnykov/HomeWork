package homework.Module_9;

//Написать свой класс MyQueue как аналог классу Queue, который будет работать по принципу FIFO (first-in-first-out).
//
//        Можно делать либо с помощью Node либо с помощью массива.
//
//        Методы
//
//        add(Object value) добавляет элемент в конец
//        clear() очищает коллекцию
//        size() возвращает размер коллекции
//        peek() возвращает первый элемент в очереди (FIFO)
//        poll() возвращает первый элемент в очереди и удаляет его из коллекции

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyQueue<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public MyQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (size == 0) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;

        size++;
    }

    public void clear(){
        last = null;
        size = 0;
    }

    public int size() {

        return size;
    }

    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        return first.getData();
    }

    public T poll() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }

        T data = first.getData();
        first = first.getNext();
        size--;

        if (size == 0) {
            last = null;
        }

        return data;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
    @Override
    public String toString() {
        Object[] result = new Object[size];
        Node<T> node = first;
        int counter = 0;
        while(counter<size){
            result[counter] = node.getData();
            node = node.getNext();
            counter++;
        }
        return Arrays.toString(result);
    }
}

