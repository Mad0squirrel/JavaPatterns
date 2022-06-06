package Task3;
import java.util.*;
import java.util.concurrent.Semaphore;
public class Main {
    static final Semaphore Set = new Semaphore(1);
    static List arrayList = Collections.synchronizedList(new ArrayList());
    static int buf = 0;
    synchronized static void ElementArrayList() {
        arrayList.add(arrayList.size());
    }
    static void ElementSet() {
        try {
            Set.acquire();
            buf++;
            Set.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                ElementSet();
            }
        });
        Thread two = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                ElementArrayList();
            }
        });
        one.start();
        two.start();
        Thread.sleep(1000);
        System.out.println(buf);
        System.out.println(arrayList.size());
    }

}
