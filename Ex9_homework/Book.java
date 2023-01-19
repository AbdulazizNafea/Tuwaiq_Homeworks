package Ex9_homework;

public class Book extends Product{
    private String author;

    public Book(String author) {
        this.author = author;
    }

    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    @Override
    public double getDiscount() {
        double newPrice = (getPrice() * 5) / 100;
        newPrice = getPrice()-newPrice;
        return newPrice;
    }
}
