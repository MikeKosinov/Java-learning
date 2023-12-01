package stonesApp;

public class NecklaceStone extends Stone {
    private boolean isPrecious;
//конструктор
    public NecklaceStone(boolean isPrecious) {
        this.isPrecious = isPrecious;
    }

    public NecklaceStone(String name, double weight, double cost, double transparency, boolean isPrecious) {
        super(name, weight, cost, transparency);
        this.isPrecious = isPrecious;
    }

    //геттери та сеттери

    public boolean isPrecious() {
        return isPrecious;
    }

    public void setPrecious(boolean precious) {
        isPrecious = precious;
    }

    @Override
    public String toString() {
        return "NecklaceStone{" +
                "isPrecious=" + isPrecious +
                "} " + super.toString();
    }
}
