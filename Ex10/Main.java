package Ex10;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {

        try {
            Train train = new Train("ef67", 1350, 100, "10:00");
            System.out.println(train.printTrip());
            Car car = new Car("1HV56", 500, 155, "1:0");
            System.out.println(car.printTrip());

            Airplane airplane = new Airplane("df3", 855, 550, "18:45");
            System.out.println(airplane.printTrip());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
