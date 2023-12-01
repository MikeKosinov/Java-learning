
package stonesApp;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class GemstoneApp {
    public static void main(String[] args) {
        // Створення об'єктів каменів
        NecklaceStone diamond = new NecklaceStone("Diamond", 2.5, 5000, 0.3, true);
        NecklaceStone ruby = new NecklaceStone("Ruby", 1.8, 3000, 0.5, true);
        NecklaceStone quartz = new NecklaceStone("Quartz", 1.0, 200, 0.8, false);
        // Додавання каменів до намиста
        List<NecklaceStone> necklaceStones = new ArrayList<>();
        necklaceStones.add(diamond);
        necklaceStones.add(ruby);
        necklaceStones.add(quartz);
        // Сортування каменів за вартістю
        Collections.sort(necklaceStones, (s1, s2) -> Double.compare(s2.getCost(), s1.getCost()));
        // Виведення інформації про намисто
        for (NecklaceStone stone : necklaceStones) {
            System.out.println(stone);
        }
        // Знаходження каменів в намисті відповідно до заданого діапазону прозорості
        double minTransparency = 0.5;
        double maxTransparency = 0.9;
        System.out.println("Stones in the specified transparency range:");
        for (NecklaceStone stone : necklaceStones) {
            if (stone.getTransparency() >= minTransparency && stone.getTransparency() <= maxTransparency) {
                System.out.println(stone);
            }
        }
    }
}
