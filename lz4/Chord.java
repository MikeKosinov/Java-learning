package lz4;

import java.util.Objects;

public class Chord {
    //поля класу
    private int chordNumber;
    private String chordMaterial;
    //конструктори
    public Chord(){}
    public Chord(int chordNumber, String chordMaterial) {
        this.chordNumber = chordNumber;
        this.chordMaterial = chordMaterial;
    }
//геттери і сеттери
    public int getChordNumber() {
        return chordNumber;
    }

    public void setChordNumber(int chordNumber) {
        this.chordNumber = chordNumber;
    }

    public String getChordMaterial() {
        return chordMaterial;
    }

    public void setChordMaterial(String chordMaterial) {
        this.chordMaterial = chordMaterial;
    }
//equals для порівняння обʼєктів класу Chord
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chord chord = (Chord) o;
        return chordNumber == chord.chordNumber && Objects.equals(chordMaterial, chord.chordMaterial);
    }
//метод hashCode класу Chord
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (Integer.valueOf(chordNumber).hashCode());
        hash = 31 * hash + (chordMaterial == null ? 0 : chordMaterial.hashCode());
        return hash;
    }
//метод toString класу Chord
    @Override
    public String toString() {
        return "номер струни " + chordNumber +
                ", матеріал струни='" + chordMaterial;
    }
}
