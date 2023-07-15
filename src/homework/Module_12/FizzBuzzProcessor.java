package homework.Module_12;

public class FizzBuzzProcessor {
    private int n;
    private int currentNumber;
    private static final Object MONITOR = new Object();

    public FizzBuzzProcessor(int n) {
        this.n = n;
        this.currentNumber = 1;
    }

    public void fizz() {
        synchronized (MONITOR) {
            while (currentNumber <= n){
                if(currentNumber % 3 == 0 && currentNumber % 5 != 0) {
                    System.out.println("Fizz");
                    currentNumber++;
                    MONITOR.notifyAll();
                }else{
                    try {
                        MONITOR.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
    public void buzz()  {
        synchronized (MONITOR){
            while(currentNumber <= n){
                if(currentNumber % 5 == 0 && currentNumber % 3 != 0) {
                    System.out.println("Buzz");
                    currentNumber++;
                    MONITOR.notifyAll();
                }else{
                    try {
                        MONITOR.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
    public void fizzBuzz() {
        synchronized (MONITOR){
            while(currentNumber <= n){
                if(currentNumber % 5 == 0 && currentNumber % 3 == 0) {
                    System.out.println("FizzBuzz");
                    currentNumber++;
                    MONITOR.notifyAll();
                }else{
                    try {
                        MONITOR.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
    public void number() {
        synchronized (MONITOR){
            while(currentNumber <= n){
                if(currentNumber % 5 != 0 && currentNumber % 3 != 0) {
                    System.out.println(currentNumber);
                    currentNumber++;
                    MONITOR.notifyAll();
                }else{
                    try {
                        MONITOR.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        FizzBuzzProcessor fizzBuzzMethods = new FizzBuzzProcessor(15);
        Thread threadA = new Thread(fizzBuzzMethods::fizz);
        Thread threadB = new Thread(fizzBuzzMethods::buzz);
        Thread threadC = new Thread(fizzBuzzMethods::fizzBuzz);
        Thread threadD = new Thread(fizzBuzzMethods::number);

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

