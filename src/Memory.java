import java.lang.reflect.Array;
import java.util.*;

class Memory {
    private int size;

    List<Man> manList;
    List<Woman> womanList;

    List<Thread> manThreadList;
    List<Thread> womanThreadList;

    int[] pairs;

    Memory(int size) {
        this.manList = new ArrayList<>();
        this.womanList = new ArrayList<>();
        this.manThreadList = new ArrayList<>();
        this.womanThreadList = new ArrayList<>();
        this.pairs = new int[size];
        for (int i = 0; i < size; i++) {
            pairs[i] = 1;
        }
        this.size = size;
    }
    void addMan(Man man){
        manList.add(man);
    }
    void addWoman(Woman woman){
        womanList.add(woman);
    }
    void addThreadMan(Thread man){
        manThreadList.add(man);
    }
    void addThreadWoman(Thread woman){
        womanThreadList.add(woman);
    }
    synchronized void checkMen(Woman woman){
        System.out.println(Thread.currentThread().getName() + ": " + woman.getName());
        int indexOfwoman = womanList.indexOf(woman);
        Random random = new Random();
        for (int i = 0; i < manList.size(); i++) {
            manList.get(i).setCoastByWoman(indexOfwoman,random.nextInt(size)+1);
            System.out.println(manList.get(i).toString());
        }
    }

    synchronized void checkWomen(Man man){
        System.out.println(Thread.currentThread().getName() + ": " + man.getName());
        int indexOfman = manList.indexOf(man);
        Random random = new Random();
        for (int i = 0; i < womanList.size(); i++) {
            womanList.get(i).setCoastByMan(indexOfman,random.nextInt(size)+1);
            System.out.println(womanList.get(i).toString());
        }
    }

    public int getSize() {
        return size;
    }

    public void getPair() {
        for (int i = 0; i < manList.size()-1; i++) {
            Man man = manList.get(i);
            Woman woman = womanList.get(i);
            for (int j = i+1; j < manList.size(); j++) {
                Man man1 = manList.get(j);
                Woman woman1 = womanList.get(j);
                if (!((woman.getCoast().get(manList.indexOf(man)) > woman1.getCoast().get(manList.indexOf(man)) || man1.getCoast().get(womanList.indexOf(woman1))>man.getCoast().get(womanList.indexOf(woman1)))
                        && (woman1.getCoast().get(manList.indexOf(man1))>woman.getCoast().get(manList.indexOf(man1)) || man.getCoast().get(womanList.indexOf(woman))> man1.getCoast().get(womanList.indexOf(woman))))){
                    pairs[i] = 0;
                    break;
                }
            }
        }
        for (int i = 0; i < pairs.length; i++) {
            System.out.println(pairs[i]);
        }
    }
}
