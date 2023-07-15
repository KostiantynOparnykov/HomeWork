package homework.Module_9;

//Написать свой класс MyLinkedList как аналог классу LinkedList.
//
//        Нельзя использовать массив. Каждый элемент должен быть отдельным объектом-посредникый ом(Node - нода)
//        который хранит ссылку на предыдущий и следующий элемент коллекции (двусвязный список).
//
//        Методы
//
//        add(Object value) добавляет элемент в конец
//        remove(int index) удаляет элемент под индексом
//        clear() очищает коллекцию
//        size() возвращает размер коллекции
//        get(int index) возвращает элемент под индексом

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyLinkedList <E>{
    Node<E> head;
    Node<E> tail;
    int size = 0;

    public MyLinkedList(){
        this.head = null;
        this.tail = null;
    }
    static class Node<E> {
        private Node<E> next;
        private Node<E> prev;
        private E data;

        public Node(E data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
        public Node<E> getNext(){
            return next;
        }
        public Node<E> getPrev(){
            return prev;
        }
        public E getData(){
            return data;
        }
        public void setNext(Node<E> next){
            this.next = next;
        }
        public void setPrev(Node<E> prev){
            this.prev = prev;
        }
    }

    public void add (E data){
        Node<E> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
        }
        tail = newNode;
        size++;
    }

    public void remove (int index){
        if(head == null){
            return;
        }
        if(index == 0){
            head = head.getNext();
            head.setPrev(null);
        }
        Node<E> target = getTargetNode(index);
        if(target.getNext() != null){
            target.next.setPrev(target.getPrev());
        } else {
            tail = target.getPrev();
        }
        if(target.getPrev() != null){
            target.getPrev().setNext(target.getNext());
        }else{
            head = target.getNext();
        }
        size--;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public E get(int index){
        if(head == null){
            throw new NoSuchElementException("List is empty!");
        }
        Node<E> target = getTargetNode(index);
        return target.getData();
    }

    public Node<E> getTargetNode(int index){
        Node<E> current = head;
        int counter = 0;
        if(index<0 || index > size){
            throw new IndexOutOfBoundsException("Incorrect index value");
        } else {
            while (index > counter) {
                current = current.getNext();
                counter++;
            }
        }
        return current;
    }
    @Override
    public String toString() {
        Object[] result = new Object[size];
        Node<E> node = head;
        int counter = 0;
        while(counter<size){
            result[counter] = node.data;
            node = node.next;
            counter++;
        }
        return Arrays.toString(result);
    }
}

