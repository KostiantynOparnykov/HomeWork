package homework.Module_9;


public class Main {
    public static void main(String[] args) {
//        MyArrayListTest();
//        MyLinkedListTest();
//        MyQueueTest();
//        MyStackTest();
//        MyHashMapTest();
    }
    public static void MyArrayListTest(){
        System.out.println("MyArray test. \n----------");
        MyArrayList <String> myArrayList = new MyArrayList<>();
        System.out.println("Adding 12 elements (default capacity = 10)");
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        myArrayList.add("4");
        myArrayList.add("5");
        myArrayList.add("6");
        myArrayList.add("7");
        myArrayList.add("8");
        myArrayList.add("9");
        myArrayList.add("10");
        myArrayList.add("11");
        myArrayList.add("12");
        System.out.println(myArrayList);
        System.out.println("----------");
        System.out.println("test.size() = " + myArrayList.size());
        System.out.println("test.get(1) = " + myArrayList.get(1));
        myArrayList.remove(1);
        System.out.println("test.remove(1) \n" + myArrayList);
        System.out.println("test.size() = " + myArrayList.size());
        myArrayList.clear();
        System.out.println("test.clear()");
        System.out.println("test.size() = " + myArrayList.size());
        System.out.println(myArrayList);

    }
    public static void MyLinkedListTest(){
        System.out.println("MyLinkedList test. \n----------");
        MyLinkedList <String > myLinkedList = new MyLinkedList<>();
        myLinkedList.add("ONE");
        myLinkedList.add("TWO");
        myLinkedList.add("THREE");
        myLinkedList.add("FOUR");

        System.out.println("Adding " +myLinkedList.size() + " elements" + " \n" + myLinkedList);
        System.out.println("myLinkedList.size() = " + myLinkedList.size());
        myLinkedList.remove(2);
        System.out.println("myLinkedList.remove(2) => \n" + myLinkedList);
        System.out.println("myLinkedList.size() = " + myLinkedList.size());
        myLinkedList.add("FIVE");
        System.out.println(" myLinkedList.add(\"FIVE\")\n" + myLinkedList);
        System.out.println("myLinkedList.get(2) = " + myLinkedList.get(2));
        myLinkedList.remove(2);
        System.out.println("myLinkedList.remove(2) ");
        System.out.println("myLinkedList.get(2) = " + myLinkedList.get(2));
        myLinkedList.clear();
        System.out.println("myLinkedList.clear()");
        System.out.println("myLinkedList = " + myLinkedList);
    }

    public static void MyStackTest(){
        System.out.println("MyStackTest. \n----------");
        MyStack<String> stack = new MyStack<>();
        stack.push("ONE");
        stack.push("TWO");
        stack.push("THREE");
        stack.push("FOUR");
        stack.push("FIVE");
        System.out.println(stack);

        System.out.println("stack.size() = " + stack.size());
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println(stack);
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println(stack);

        stack.remove(1);
        System.out.println("stack.remove(1) =>");
        System.out.println(stack);
        System.out.println("stack.size() = " + stack.size());

        stack.clear();
        System.out.println("stack.clear() =>");
        System.out.println(stack);

    }
    public static void MyHashMapTest(){
//      MyHashMap<K,V> key value
        System.out.println("MyHashMap test \n----------");

        MyHashMap<Integer, String> passportsAndNames = new MyHashMap<>();
        passportsAndNames.put(111111, "Ivan Vasilyevich");
        passportsAndNames.put(222222, "Shurik");
        passportsAndNames.put(333333, "Trus");
        passportsAndNames.put(444444, "Balbes");
        passportsAndNames.put(555555, "Bivaliy");
        System.out.println("Putting " + passportsAndNames.size() + " elements :");
        System.out.println(passportsAndNames);

        System.out.println("passportsAndNames.size() = " + passportsAndNames.size());

        System.out.println("passportsAndNames.get(222222) = " + passportsAndNames.get(222222));

        passportsAndNames.remove(111111);
        System.out.println("passportsAndNames.remove(111111)");
        System.out.println("passportsAndNames = " + passportsAndNames);

        System.out.println("passportsAndNames.size() = " + passportsAndNames.size());

        passportsAndNames.clear();
        System.out.println("passportsAndNames.clear()");
        System.out.println("passportsAndNames = " + passportsAndNames);
        System.out.println("passportsAndNames.size() = " + passportsAndNames.size());
//        passportsAndNames.put(1111, "Ivan Vasilyevich");
//        passportsAndNames.put(2222, "Shurik");
//        passportsAndNames.put(3333, "Trus");
//        passportsAndNames.put(4444, "Balbes");
//        passportsAndNames.put(5555, "Bivaliy");
//        passportsAndNames.put(11111, "Ivan Vasilyevich");
//        passportsAndNames.put(22222, "Shurik");
//        passportsAndNames.put(33333, "Trus");
//        passportsAndNames.put(44444, "Balbes");
//        passportsAndNames.put(55555, "Bivaliy");
//        passportsAndNames.put(1111111, "Ivan Vasilyevich");
//        passportsAndNames.put(2222221, "Shurik");
//        passportsAndNames.put(3333331, "Trus");
//        passportsAndNames.put(4444441, "Balbes");
//        passportsAndNames.put(5555551, "Bivaliy");
//
//        System.out.println("passportsAndNames.size() = " + passportsAndNames.size()); //size 19 resize() acts as it should.
    }
    public static void MyQueueTest(){
        System.out.println("MyQueueTest. \n----------");
        MyQueue<String> test = new MyQueue<>();
        test.add("ONE");
        test.add("TWO");
        test.add("THREE");
        test.add("FOUR");
        System.out.println("test = " + test);
        System.out.println("test.size() = " + test.size());
        System.out.println("test.peek() = " + test.peek());
        System.out.println("test = " + test);
        System.out.println("test.poll() = " + test.poll());
        System.out.println("test = " + test);
        System.out.println("test.size() = " + test.size());
        test.clear();
        System.out.println("test.clear()");
        System.out.println("test.size() = " + test.size());

    }
}

