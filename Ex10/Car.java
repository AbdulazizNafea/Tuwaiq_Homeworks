package Ex10;

import java.text.ParseException;

public class Car extends Trip {
    public Car(String tripNumber, double distance, double speed, String startTime) {
        super(tripNumber, distance, speed, startTime);
    }

    @Override
    public double calculateDuration() {
        double starttime = convertTimeToDecimal(getStartTime());
        double arrive = convertTimeToDecimal(calculateArrivalTime());
        return arrive - starttime;
    }

    public String printTrip() throws ParseException {
        return "======Car trip======\nTrip code: " + getTripNumber() + "\nStart Time: " + formatTime(getStartTime()) + "\nArrive time: " + formatTime(calculateArrivalTime()) + "\nDuration time: " + convertDecimalToTime(calculateDuration()) + "\n";
    }
}
