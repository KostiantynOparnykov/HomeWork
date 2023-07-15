package homework.Module_12;

public class TimeThreads {
    public static void main(String[] args) {
        Thread one = new Thread(()->{
            for (int i = 0;; i++) {
                if (i%5==0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    continue;
                }
                System.out.println(i + " секунд минуло від запуску");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread two =new Thread(()->{
            while(true){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Минуло 5 секунд");
            }
        });
        one.start();
        two.start();
    }
}
