package homework.Module_9;

//Написать свой класс MyArrayList как аналог классу ArrayList.
//
//        Можно использовать 1 массив для хранения данных.
//
//        Методы
//
//        add(Object value) добавляет элемент в конец
//        remove(int index) удаляет элемент под индексом
//        clear() очищает коллекцию
//        size() возвращает размер коллекции
//        get(int index) возвращает элемент под индексом


import java.util.Arrays;



public class MyArrayList<E> {
    private final int DEFAULT_CAPACITY = 10;
    private Object[] array = new Object[DEFAULT_CAPACITY];
    private int size = 0;

    public void add(E element) {
        if (size == array.length){
            resize();
        }
        array[size] = element;
        size++;
    }

    public void remove(int index) {
        if(index < 0 || index > size -1){
            throw new IndexOutOfBoundsException("Incorrect index value");
        }
        for (int i = index; i<size - 1; i++){
            array[i] = array[i+1];
        }
        array[size-1] = null;
        size--;
    }

    public void clear(){

        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if(index < 0 || index > size -1){
            throw new IndexOutOfBoundsException("Incorrect index value");
        }
        return array[index];
    }

    private void resize(){
        int newCapacity = array.length * 2;
        array = Arrays.copyOf(array, newCapacity);
    }

    @Override
    public String toString() {
        Object[] newArray = Arrays.copyOf(array, size);
        System.arraycopy(array, 0, newArray, 0, size);
        return Arrays.toString(newArray);
    }
}

