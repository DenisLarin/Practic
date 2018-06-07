import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Woman implements Runnable{
    Memory memory;
    String name;


    ArrayList <Integer> coast;

    public Woman(String name, Memory memory) {
        this.name = name;
        this.memory = memory;
        this.coast = new ArrayList<>();
        for (int i = 0; i < this.memory.getSize(); i++) {
            coast.add(-1);
        }
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
    public void setCoastByMan(int position,int coast){
        this.coast.set(position,coast);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        coastMan();
    }
    private void coastMan() {
        memory.checkMen(this);
    }

    @Override
    public String toString() {
        return "Woman{" +
                "memory=" + memory +
                ", name='" + name + '\'' +
                ", coast=" + coast +
                '}';
    }
}