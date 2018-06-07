import java.util.ArrayList;
import java.util.List;

class Man implements Runnable{
    Memory memory;
    String name;
    ArrayList<Integer> coast;

    public Man(String name,Memory memory) {
        this.name = name;
        this.memory = memory;
        this.coast = new ArrayList<>();
        for (int i = 0; i < this.memory.getSize(); i++) {
            coast.add(-1);
        }
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        coastWomen();
    }

    public void setCoastByWoman(int position,int coast){
        this.coast.set(position,coast);
    }

    private void coastWomen() {
        memory.checkWomen(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getCoast() {
        return coast;
    }

    public void setCoast(ArrayList<Integer> coast) {
        this.coast = coast;
    }

    @Override
    public String toString() {
        return "Man{" +
                "memory=" + memory +
                ", name='" + name + '\'' +
                ", coast=" + coast +
                '}';
    }
}