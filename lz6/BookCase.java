package lz6;

public class BookCase extends Closet{
    private int numberOfBooks;
    //конструктори
public BookCase(){}
    public BookCase(String material, int numberOfShelves, int numberOfBooks) {
        super(material, numberOfShelves);
        this.numberOfBooks = numberOfBooks;
    }
    public BookCase(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    //геттери і сеттери
    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }
    public void displayContents() {
        System.out.println("Демонстрація книг у відкритій шафі...");
    }

    public static void main(String[] args) {

        BookCase bookCase = new BookCase("Wood",4,12);
        bookCase.assemble();
        bookCase.displayContents();
        bookCase.disassemble();
        //Поліморфізм
        System.out.println("");
        Furniture furniture = bookCase;
        furniture.assemble();
        furniture.disassemble();
    }
}
