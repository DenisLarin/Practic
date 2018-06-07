import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int size = 2;
        Memory memory = new Memory(size);
        for (int i = 0; i < size; i++) {
            Man man = new Man("Man"+i,memory);
            Woman woman = new Woman("Woman"+i,memory);

            memory.addMan(man);
            memory.addWoman(woman);

            Thread thread_man = new Thread(man);
            Thread thread_woman = new Thread(woman);

            memory.addThreadMan(thread_man);
            memory.addThreadWoman(thread_woman);

            thread_man.start();
            thread_woman.start();
        }
        for (int i = 0; i < size; i++) {
            memory.manThreadList.get(i).join();
            memory.womanThreadList.get(i).join();
        }
        memory.getPair();
    }
}


