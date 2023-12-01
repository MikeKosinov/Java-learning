package lz6;

public abstract class Closet  implements Furniture{
    private String material;
    private int numberOfShelves;

    public Closet(){}
    public Closet(String material, int numberOfShelves) {
        this.material = material;
        this.numberOfShelves = numberOfShelves;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getNumberOfShelves() {
        return numberOfShelves;
    }

    public void setNumberOfShelves(int numberOfShelves) {
        this.numberOfShelves = numberOfShelves;
    }
    @Override
    public void assemble() {
        System.out.println("Шафа відкривається...");
    }

    @Override
    public void disassemble() {
        System.out.println("Шафа закривається...");
    }

    // Додаткові методи абстрактного класу

    @Override
    public String toString() {
        return "Шафа вироблена з " + material + " з " + numberOfShelves + " поличками";
    }
}
