package homework.Module_9;

//Написать свой класс MyStack как аналог классу Stack, который работает по принципу LIFO (last-in-first-out).
//
//        Можно делать либо с помощью Node либо с помощью массива.
//
//        Методы
//
//        push(Object value) добавляет элемент в конец
//        remove(int index) удаляет элемент под индексом
//        clear() очищает коллекцию
//        size() возвращает размер коллекции
//        peek() возвращает первый элемент в стеке (LIFO)
//        pop() возвращает первый элемент в стеке и удаляет его из коллекции

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyStack <T> {
    private Node<T> top;
    private int size;

    public MyStack() {
        this.top = null;
        this.size = 0;
    }

    private static class Node<T> {
        private Node<T> next;
        private T data;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
        public Node<T> getNext(){
            return next;
        }
        public T getData(){
            return data;
        }
        public void setNext(Node<T> next){
            this.next = next;
        }
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Incorrect index value");
        }
        if (index == 0) {
            top = top.getNext();
        } else {
            Node<T> current = top;
            for(int i = 1; i < index; i++){
                current = top.getNext();
            }
            Node<T> nextNode = current.getNext();
            current.setNext(nextNode.getNext());
        }
        size--;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (top == null) {
            throw new NoSuchElementException("MyStack is empty");
        }

        return top.getData();
    }

    public T pop(){
        if (top == null) {
            throw new NoSuchElementException("MyStack is empty");
        }
        T data = top.getData();
        top = top.getNext();
        size--;

        return data;
    }



    @Override
    public String toString() {
        Object[] result = new Object[size];
        Node<T> node = top;
        int counter = 0;
        while (counter < size) {
            result[counter] = node.data;
            node = node.next;
            counter++;
        }
        return Arrays.toString(result);
    }
}