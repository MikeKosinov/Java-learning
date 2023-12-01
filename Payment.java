import java.util.ArrayList;
import java.util.List;

public class Payment {
    private List<Item> items;

    public Payment() {
        items = new ArrayList<>();
    }

    // Додавання товару до списку покупок
    public void addItem(String name, double price, int quantity) {
        Item newItem = new Item(name, price, quantity);
        items.add(newItem);
    }

    // Внутрішній клас для представлення товарів
    private class Item {
        private String name;
        private double price;
        private int quantity;

        public Item(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public double getTotalPrice() {
            return price * quantity;
        }

        @Override
        public String toString() {
            return "Товар: " + name + ", з ціною за 1: $" + price + ", Кількість: " + quantity;
        }
    }

    // Отримання загальної вартості покупки
    public double getTotalPayment() {
        double totalPayment = 0;
        for (Item item : items) {
            totalPayment += item.getTotalPrice();
        }
        return totalPayment;
    }

    // Вивід всіх товарів у списку покупок
    public void displayItems() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        // Створення об'єкту Payment
        Payment payment = new Payment();

        // Додавання товарів до покупки
        payment.addItem("Телефон", 500.0, 1);
        payment.addItem("Навушники", 100.0, 2);
        payment.addItem("Зарядка", 20.0, 3);

        // Вивід всіх товарів та загальної вартості покупки
        payment.displayItems();
        System.out.println("Чек вартістю: $" + payment.getTotalPayment());
    }
}
