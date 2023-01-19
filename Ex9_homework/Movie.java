package Ex9_homework;

public class Movie extends Product {
    private String director;

    public Movie() {

    }

    public Movie(String name, double price, String director) {
        super(name, price);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public double getDiscount() {
        double newPrice = (getPrice() * 5) / 100;
        newPrice = getPrice()-newPrice;
        return newPrice;
    }
}
