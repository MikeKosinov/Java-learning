package lz4;

import java.util.Arrays;
import java.util.Objects;

public class Guitar {
    private String brand;
    private String model;
    private String color;
    private GuitarBody body;
    private Chord[] chords; // Масив струн

    public Guitar(String brand, String model, String color, GuitarBody body,int numOfStrings, String chordMaterial) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.body = body;
        this.chords = new Chord[numOfStrings];
        // Ініціалізуємо струни
        for (int i = 0; i < numOfStrings; i++) {
            this.chords[i] = new Chord(i + 1, chordMaterial);
        }
    }
//геттери та сеттери
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public GuitarBody getBody() {
        return body;
    }

    public void setBody(GuitarBody body) {
        this.body = body;
    }

    public Chord[] getChords() {
        return chords;
    }

    public void setChords(Chord[] chords) {
        this.chords = chords;
    }
    //метод play
    public void play() {

        System.out.println("Гітара грає...");
    }

    public void tune() {

        System.out.println("Гітара налаштовується...");
    }
    public void changeTune(int chordNumber, Chord newChord){
        if (chordNumber >= 0 && chordNumber <chords.length) {
            chords[chordNumber] = newChord;
            System.out.println("Струна  " + (chordNumber ) + " з властивостями " + newChord.toString()+ " замінена");
        } else {
            System.out.println("Invalid chord number");
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guitar guitar = (Guitar) o;
        return Objects.equals(brand, guitar.brand) && Objects.equals(model, guitar.model) && Objects.equals(color, guitar.color) && Objects.equals(body, guitar.body) && Arrays.equals(chords, guitar.chords);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(brand, model, color, body);
        result = 31 * result + Arrays.hashCode(chords);
        return result;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", body=" + body +
                ", chords=" + Arrays.toString(chords) +
                '}';
    }

    public static void main(String[] args) {
        // Створення об'єкту гітари з об'єктами струн і корпусу
        GuitarBody guitarBody = new GuitarBody("Wood", "Dreadnought");
        Guitar guitar = new Guitar("Gibson","Len Payl","blue",guitarBody,6,"Neylon");
        guitar.play();
        guitar.tune();
        guitar.changeTune(2, new Chord(2,"Neylon"));
    }
}
